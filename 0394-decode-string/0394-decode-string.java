class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the multiplier (handles multi-digit numbers like 100)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current multiplier and current string to their stacks
                countStack.push(k);
                stringStack.push(currentString);
                // Reset for the content inside the brackets
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Pop the multiplier and the previous string context
                StringBuilder decodedString = stringStack.pop();
                int repeatTimes = countStack.pop();
                
                // Append the current inner string 'repeatTimes' times
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                // The newly built string becomes our current working string
                currentString = decodedString;
            } else {
                // It's a regular character, just append it
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}