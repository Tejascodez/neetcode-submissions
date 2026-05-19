class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        int left = 0;

        for(char ch : s1.toCharArray()){
            freq1[ch - 'a']++;
        }

        for(int right = 0; right < s2.length(); right++){
            freq2[s2.charAt(right)-'a']++;

            if(right - left + 1 > s1.length()){
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }

            if(right - left + 1 == s1.length()){
                if(Arrays.equals(freq1,freq2)){
                    return true;
                }
            }

        }

        return false;
    }
}
