class Solution {
    public void backtrack(int[] nums,int target, int index ,int currsum, List<Integer> currcombination, List<List<Integer>> result){
        if(currsum == target){
            result.add(new ArrayList<>(currcombination));
            return;
        }

        if(currsum > target || index >= nums.length) return;

        currcombination.add(nums[index]);

        backtrack(nums,target, index, currsum + nums[index] , currcombination, result);
        currcombination.remove(currcombination.size() - 1);
        backtrack(nums,target, index + 1, currsum, currcombination, result);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums,target,0,0,new ArrayList<>(),result);

        return result;
    }
}
