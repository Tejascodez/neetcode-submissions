class Solution {
    public void transpose(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i<m; i++){
            for(int j = i; j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverse(int[] row){
        int left = 0;
        int right = row.length - 1;

        while(left < right){
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
        
        transpose(matrix);

        for(int i = 0; i<matrix.length; i++){
            reverse(matrix[i]);
        }
    }
}
