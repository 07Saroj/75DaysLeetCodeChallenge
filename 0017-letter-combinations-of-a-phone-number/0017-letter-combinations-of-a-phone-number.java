class Solution {
    // Changed 'c' from String to StringBuilder to allow modification
    private void dial(String digits, StringBuilder c, List<String> result, String[] keypad){
        if(digits.length() == 0){
            result.add(c.toString());
            return;
        }
        
        // Note: Your keypad array starts "abc" at index 2, 
        // so digits.charAt(0) - '0' is the correct index.
        String key = keypad[digits.charAt(0) - '0'];
        
        for(int i = 0; i < key.length(); i++){
            c.append(key.charAt(i));
            // Fixed typo: changed 'digit' to 'digits'
            dial(digits.substring(1), c, result, keypad);
            c.deleteCharAt(c.length() - 1); // undo (backtrack)
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // Edge case: LeetCode expects an empty list for empty input
        if (digits.length() == 0) return result;

        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        // Pass a new StringBuilder instead of an empty String
        dial(digits, new StringBuilder(), result, keypad);
        return result;
    }
}