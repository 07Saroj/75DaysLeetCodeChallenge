class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l= new ArrayList<>();
        int top=0;
        int right= matrix[0].length-1;
        int buttom= matrix.length-1;
        int left=0;
        while(top<=buttom && left<=right){
            //top border
            for(int i=left;i<=right;i++){
                l.add(matrix[top][i]);
            }

            top++;
            //right
            for(int i=top;i<=buttom;i++){
                l.add(matrix[i][right]);
            }
            right--;
            //buttom
            if(top<=buttom){
                for(int i=right;i>=left;i--){
                    l.add(matrix[buttom][i]);
                }
                buttom--;
            }
            

            //left
            if(left<=right){
                for(int i=buttom;i>=top;i--){
                    l.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        
        
        return l;

    }
}