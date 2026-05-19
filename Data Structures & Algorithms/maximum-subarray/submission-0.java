class Solution {
    public int maxSubArray(int[] nums) {
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE;

        for(int n : nums){
            currsum = Math.max(n , currsum+n );
            maxsum = Math.max(currsum,maxsum);
        }

        return maxsum;
    }
}
