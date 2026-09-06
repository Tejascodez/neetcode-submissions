class Solution {
    public int helper(int[] nums,int start, int end ){
        int n = nums.length;

        int dp[] = new int[n];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start + 1]);

        for(int i = start + 2; i<n; i++){
            dp[i] = Math.max(nums[i] + dp[i-2],dp[i-1]);
        }

        return dp[end];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);

        int state1 = helper(nums,0,n-2);
        int state2 = helper(nums,1,n-1);

        return Math.max(state1,state2);
    }
}
