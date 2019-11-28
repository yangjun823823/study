/**
 * 第K大元素，维护一个小顶堆，注意javaAPI使用
 */
public class KthLargest {
    private PriorityQueue<Integer> lowHeap;
    private final int heapSize;
    public KthLargest(int k, int[] nums) {
        this.heapSize = k;
        lowHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        if(lowHeap.size() < heapSize){
            lowHeap.add(val);
        }else{
            if(val > lowHeap.peek()){
                lowHeap.poll();
                lowHeap.add(val);
            }
        }
        return lowHeap.peek();
    }
}