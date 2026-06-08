class Solution {
    public void findsubsets(int[] nums, int index , List<Integer> currsum, List<List<Integer>> result){
        if(index== nums.length){
            result.add(new ArrayList<>(currsum));
            return;
        }
        
        currsum.add(nums[index]);
        findsubsets(nums,index+1,currsum,result);

        currsum.remove(currsum.size() - 1);
        findsubsets(nums,index+1,currsum,result);
    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        findsubsets(nums,0,new ArrayList<>(),result);

        return result;
        
    }
}
