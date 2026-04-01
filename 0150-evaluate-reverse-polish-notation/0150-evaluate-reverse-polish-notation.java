class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s= new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String ch=tokens[i];
            if(ch.equals("+")||ch.equals("-")||ch.equals("*")|| ch.equals("/")){
                int n1=s.pop();
                int n2=s.pop();
                if(ch.equals("+")){
                    s.push(n2+n1);
                }else if(ch.equals("-")){
                    s.push(n2-n1);
                }else if(ch.equals("*")){
                    s.push(n2*n1);
                }else{
                    s.push(n2/n1);
                }

            }else{
                s.push(Integer.parseInt(ch));
            }
            
        }
        return s.pop();
    }
}