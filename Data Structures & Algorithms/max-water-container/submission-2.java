class Solution {
    public int maxArea(int[] heights) {
        int left = 0; 
        int right = heights.length - 1;
        int water = 0;

        while(left < right){
            int w = right - left;   
            int hyt = Math.min(heights[left],heights[right]);
            int area = w * hyt;

            water = Math.max(area,water);


            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return water;
    }
}
