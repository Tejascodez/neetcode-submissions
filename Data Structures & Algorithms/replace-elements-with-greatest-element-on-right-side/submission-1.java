class Solution {
    public int[] replaceElements(int[] arr) {
        int rightmax = -1;

        for(int i = arr.length - 1; i>=0; i--){
            int current = arr[i];
            arr[i] = rightmax;
            rightmax =  Math.max(rightmax,current);
        }

        return arr;
    }
}