public class Solution {
    public static void main(String[] args){
        int[] nums ={1,3,1,2,0,5};
        int k = 3;
		int[] result =  maxSlidingWindow(nums,k);
    }

    /**O(n)时间复杂度，维护一个双端队列，队首元素始终是最大值
     * 算法：对要进队列的数，从队尾开始，若该数>=队尾元素便删除队尾元素，循环，然后入队；若该数<队尾元素便直接入队
     * 注意：队列满时要移除队首元素；数组可能为空
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return new int[0];
        }
        Deque<Integer> dequeue = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if(!dequeue.isEmpty() && i - dequeue.getFirst() == k){
                dequeue.removeFirst();
            }
            while (!dequeue.isEmpty() && nums[i] >= nums[dequeue.getLast()]){
                dequeue.removeLast();
            }
            dequeue.addLast(i);
            if(i >= k - 1){
                result[index++] = nums[dequeue.getFirst()];
            }
        }
        return result;
    }
}
