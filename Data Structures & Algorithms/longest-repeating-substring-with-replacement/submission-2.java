class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxfreq= 0;
        int freq[] = new int[26];
        int maxLen = 0;
        int left = 0;

        HashMap<Integer,Integer> map  = new HashMap<>();

        for(int right = 0 ;right < n; right++){
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            maxfreq = Math.max(maxfreq,freq[ch - 'A']);

            int len = right - left +1;
            if(len - maxfreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = right - left + 1;
        }

        return maxLen;
    }
}
