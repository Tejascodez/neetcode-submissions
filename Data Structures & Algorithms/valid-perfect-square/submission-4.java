class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 0;
        long  high = num/2;
        long square = 0;
        if(num == 1) return true;
        while(low <= high){
            long mid = low + (high-low)/2;
            square = mid * mid;

            if(square == num){
                return true;
            }else if(square < num){
                low = mid + 1;
            }else high = mid - 1;
        }

        return false;
    }
}