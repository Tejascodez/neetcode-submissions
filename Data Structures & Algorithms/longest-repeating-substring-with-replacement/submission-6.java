class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int maxfreq = 0;
        int n = s.length();
        int[] freq = new int[26];
        int left = 0;
        int start = 0;

    
        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            maxfreq = Math.max(maxfreq,freq[ch - 'A']);


            if((right-left+1) - maxfreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

        maxLen = right - left + 1;
        }

        return maxLen;
    }
}
