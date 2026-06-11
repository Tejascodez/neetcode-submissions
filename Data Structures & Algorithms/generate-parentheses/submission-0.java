class Solution {
    public void backtrack(int open, int close, int n, StringBuilder curr, List<String> result){
        if(curr.length() == 2*n){
            result.add(curr.toString());
            return;
        }


        if(open < n){
            curr.append('(');
            backtrack(open+1,close,n,curr,result);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(close < open){
            curr.append(')');
            backtrack(open,close+1,n,curr,result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(0,0,n,new StringBuilder(),result);
        return result;
    }
}
