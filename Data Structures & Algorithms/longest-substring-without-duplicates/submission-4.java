class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen =0;
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                left = Math.max(left, map.getOrDefault(ch,0)+1);
            }
            map.put(ch,i);

            maxLen  = Math.max(i - left + 1, maxLen);
        }

        return maxLen;
        
    }
}
