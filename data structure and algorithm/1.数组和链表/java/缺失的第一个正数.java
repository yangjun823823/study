class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int temp = nums[i];
            while(temp > 0 && temp <= nums.length && nums[temp-1] != temp){
               this.swap(nums,i,temp-1);
                temp = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++){
            if(nums[i]!=(i+1)){
                return i+1;
            }
        }
        return nums.length+1;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}