class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int c1 = 0;
        int c2 = 0;


        for(int num : nums){
            if(num == c1) count1++;
           else if(num == c2) count2++;

            
            else if(count1 == 0){
                c1 = num;
                count1 = 1;
            }else if(count2 == 0){
                c2 = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int n : nums){
            if(c1 == n) count1++;
            else if(c2 == n) count2++;

        }

        if(count1 > nums.length/3) result.add(c1);
        if(count2 > nums.length/3) result.add(c2);


        return result;
    }
}