class Solution {
    public int arrangeCoins(int n) {
        if(n == 1) return 1;
        long low = 0;
        long high = n - 1;

        while(low <= high){
            long mid = low + (high - low)/2;
            long staircase = (int) mid * (mid + 1) / 2;

            if(staircase == n) return (int) mid;
            else if(staircase < n) low = mid + 1;
            else high = mid - 1;
        }

        return (int) high;
    }
}