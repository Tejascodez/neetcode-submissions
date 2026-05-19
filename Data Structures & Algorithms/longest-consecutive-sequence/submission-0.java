class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n  = nums.length;
        int longest = 1;
        if(n == 0) return 0;
        int lastSmaller = Integer.MAX_VALUE;
        int count = 1;
        Arrays.sort(nums);
        for(int i = 1; i<n; i++){

            if(nums[i]  == nums[i - 1] + 1){
                count++;
                // lastSmaller = nums[i];
            }

            else if(nums[i] != nums[i - 1]){
                count = 1;
                // lastSmaller = nums[i];
            }

            longest = Math.max(longest,count);
        }

        return longest;
    }
}
