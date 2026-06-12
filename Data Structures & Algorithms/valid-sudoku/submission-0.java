class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];


        for(int i = 0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }


        for(int r = 0; r<9 ; r++){
            for(int c = 0; c<9; c++){
                char currval = board[r][c];

                if(currval == '.') continue;


                int boxidx = (r / 3) * 3 + (c / 3) ;


                if(rows[r].contains(currval) || cols[c].contains(currval) || boxes[boxidx].contains(currval)){
                    return false;
                }

                rows[r].add(currval);
                cols[c].add(currval);
                boxes[boxidx].add(currval);
            }
        }

        return true;
    }
}
