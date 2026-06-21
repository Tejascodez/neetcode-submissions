class Solution {
    public void backtrack(int[] nums, int index, List<Integer> subsets, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(subsets));
            return;
        }

        subsets.add(nums[index]);
        backtrack(nums,index+1,subsets,result);
        subsets.remove(subsets.size() - 1);
        backtrack(nums,index+1,subsets,result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),result);
        return result;
    }
}
