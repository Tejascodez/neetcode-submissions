class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxarea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<=n; i++){
            int currHeight = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() &&  currHeight < heights[stack.peek()]){
                int height = heights[stack.pop()];

            int width = 0;
            if(stack.isEmpty()){
                width = i;
            }else{
             width = i - stack.peek() - 1;
            }

                int area = height * width;
                maxarea = Math.max(area,maxarea);
            }

            stack.push(i);
        }

        return maxarea;
    }
}
