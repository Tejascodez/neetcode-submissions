class Solution {
    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public void backtrack(String s, int start, List<String> parts, List<List<String>> result){
        if(start == s.length()) {
            result.add(new ArrayList<>(parts));
            return;
        }

        for(int i = start; i<s.length(); i++){

            if(isPalindrome(s,start,i)){
                parts.add(s.substring(start, i+1));

                backtrack(s,i+1,parts,result);
                parts.remove(parts.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        backtrack(s,0,new ArrayList<>(), result);
        return result;
    }
}
