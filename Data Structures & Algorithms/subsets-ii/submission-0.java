class Solution {
    public void backtrack(int[] nums, int index, List<Integer> subset,List<List<Integer>> result){
        result.add(new ArrayList<>(subset));

        for(int i = index; i<nums.length; i++){

            if(i > index && nums[i] == nums[i-1]) continue;

            subset.add(nums[i]);
            backtrack(nums,i+1,subset,result);
            subset.remove(subset.size() - 1);
            
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>(),result);

        return result;
    }
}
