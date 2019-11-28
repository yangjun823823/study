class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            int count = map.getOrDefault(num,0)+1;
            map.put(num,count);
        }
        for (Integer num : map.keySet()){
            if(map.get(num) > nums.length/2){
                return num;
            }
        }
        throw new RuntimeException();
    }
}