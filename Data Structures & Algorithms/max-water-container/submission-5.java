class Solution {
    public int maxArea(int[] heights) {
        int left  = 0;
        int right = heights.length - 1;
        int water = 0;


        while(left < right){
            int w = right - left;
            int h = Math.min(heights[left], heights[right]);

            int area = w * h;

            water = Math.max(water,area);

            if(heights[left] < heights[right]) left++;
            else right--;
        }

        return water;
    }
}
