class Solution {
    public void backtrack(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> result){

            if(curr.size() == nums.length){
                result.add(new ArrayList<>(curr));
                return;
            }

            for(int i = 0; i<nums.length; i++){
                if(visited[i]) continue;

                visited[i] = true;
                curr.add(nums[i]);
                backtrack(nums,visited,curr,result);
                curr.remove(curr.size() - 1);
                visited[i] =false;
            }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] arr = new boolean[nums.length];

        backtrack(nums,arr,new ArrayList<>(),result);
        return result;
    }
}
