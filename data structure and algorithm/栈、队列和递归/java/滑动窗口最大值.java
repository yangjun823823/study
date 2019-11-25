class Solution {
    //若队列不满，待入队元素 >= 队尾元素,队尾出队，循环...队尾入队
    //若队列不满，待入队元素 < 队尾元素,队尾入队
    //若队列满，队首出队,走队列不满逻辑
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<Integer>();
        if(nums.length == 0){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        int index = 0;
        int i = 0;
        for (; i < k; i++){
            while (queue.size() > 0 &&  nums[i] >= queue.element()){
                queue.poll();
            }
            queue.offer(nums[i]);
        }
        result[index++] = queue.element();
        for (; i < nums.length; i++){
            if(queue.size() < k){//队列不满
                while (queue.size() > 0 &&  nums[i] >= queue.element()){
                    queue.poll();
                }
            }else{//队列满了
                queue.poll();
                while (queue.size() > 0 &&  nums[i] >= queue.element()){
                    queue.poll();
                }
            }
            queue.offer(nums[i]);
            result[index++] = queue.element();
        }
        return result;
    }
}