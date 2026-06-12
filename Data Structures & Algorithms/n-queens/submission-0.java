class Solution {
    public boolean isSafe(char board[][], int row, int col, int n){
           // row
    for(int j = 0; j < n; j++){
        if(board[row][j] == 'Q') return false;
    }

    // column
    for(int i = 0; i < n; i++){
        if(board[i][col] == 'Q') return false;
    }

    // ↘
    for(int i = row, j = col; i < n && j < n; i++, j++){
        if(board[i][j] == 'Q') return false;
    }

    // ↖
    for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
        if(board[i][j] == 'Q') return false;
    }

    // ↙
    for(int i = row, j = col; i < n && j >= 0; i++, j--){
        if(board[i][j] == 'Q') return false;
    }

    // ↗
    for(int i = row, j = col; i >= 0 && j < n; i--, j++){
        if(board[i][j] == 'Q') return false;
    }

        return true;

    }


    public void backtrack(char board[][], int row, int n, List<List<String>> result){
        if(row == n){
            List<String> solution = new ArrayList<>();
            for(int i = 0; i<n; i++){
                solution.add(new String(board[i]));
            }
            result.add(solution);
            return;
        }
        for(int col = 0; col < n; col++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 'Q';
                backtrack(board,row+1,n,result);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char board[][]  =  new char [n][n];

        for(int i = 0; i<n; i++){
            Arrays.fill(board[i] , '.');
        }

        backtrack(board,0,n,result);

        return result;
    }
}
