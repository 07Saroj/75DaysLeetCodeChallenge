class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        if(n==1){
            return false;
        }
        char[] arr=new char[s.length()];
        int top=-1;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                top++;
                arr[top]=ch;
            }else{
                if(top==-1) return false;
                if(ch==')' && arr[top]!='(' || ch=='}' && arr[top]!='{' || ch==']' && arr[top]!='['){
                    return false;
                }
                top--;
            }
        }
        

        

        return top==-1;
    }
}