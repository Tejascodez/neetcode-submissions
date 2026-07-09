class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = nums[0];
        for(int n : nums){
            if(n == 1){
                count++;

                if(max < count){
                    max = count;
                }
            }else{
                count = 0;
               
            }
        }

        return max;
    }
}