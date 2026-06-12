class Solution {
    private Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public void  backtrack(int index,StringBuilder curr, List<String> result, String digits){
        if(index == digits.length()){
            result.add(curr.toString());
            return;
        }

        // 2. Setup for the current digit
        char currentDigit = digits.charAt(index);
        String letters = map.get(currentDigit);


        for(char letter : letters.toCharArray()){
            curr.append(letter);
            backtrack(index+1,curr,result,digits);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0) return  result;

        StringBuilder curr = new StringBuilder();
        backtrack(0,curr,result,digits);

        return result;

    }
}
