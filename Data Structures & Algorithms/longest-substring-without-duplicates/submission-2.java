class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxlen = 0;
        int n = s.length();

        HashMap<Character,Integer> map = new HashMap<>();

        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);

            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch)+1);
            }
            map.put(ch,right);

            maxlen = Math.max(right - left + 1, maxlen);
        }

    return maxlen;

    }
}
