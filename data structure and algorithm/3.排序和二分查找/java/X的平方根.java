class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        if (x < 2){
            return x;
        }
        while (low <= high){
            int mid = (high-low)/2 + low;
            if (x/mid  == mid || (x / mid > mid  && x / (mid+1) < (mid+1))){
                return mid;
            }else if ( x/mid < mid){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}