/**
 * @note leetcode-三数之和为0
 * @apiNote   思路为 先排序， 然后有两个指针 head和end。 要计算的第一个数一定是负数,所以只要后两个数相加等于
 *  0-第一个数 即可。
 * @since 19-3-18 10:27 by jdk 1.8
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2;i++){
            //第一位去重，要第一个，后面重复的不要
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                if(nums[i]+nums[left]+nums[right]==0){
                    //一个结果
                    List<Integer> oneAnswer = new ArrayList<>();
                    oneAnswer.add(nums[i]);
                    oneAnswer.add(nums[left]);
                    oneAnswer.add(nums[right]);
                    result.add(oneAnswer);
                    while (left < right && nums[left]== nums[left+1])left++;
                    while (left < right && nums[right-1] == nums[right])right--;
                    left++;
                    right--;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}