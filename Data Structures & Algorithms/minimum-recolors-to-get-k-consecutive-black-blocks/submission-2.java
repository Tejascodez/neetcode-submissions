class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int white = 0;
        for(int right = 0; right<n; right++){
            char ch = blocks.charAt(right);
            if(ch == 'W'){
                white++;   
            }

            if(right - left + 1 == k){
                minLen = Math.min(minLen,white);
                 if(blocks.charAt(left) == 'W') {
                white--;
            }
            

           
            left++;
            }

        }

        return minLen;
    }
}