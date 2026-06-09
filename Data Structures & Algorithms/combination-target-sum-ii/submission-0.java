class Solution {
    public void backtrack(int nums[], int target, int index, int currsum, List<Integer> combinations, List<List<Integer>> result){
        if(currsum == target){
            result.add(new ArrayList<>(combinations));
            return;
        }


        for(int i = index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue;

            if(currsum + nums[i] > target) break;

            combinations.add(nums[i]);
            backtrack(nums,target,i+1,currsum+nums[i],combinations,result);
            combinations.remove(combinations.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,0,new ArrayList<>(),result);
        return result;
    }
}
