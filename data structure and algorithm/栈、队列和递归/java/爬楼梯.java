class Solution {
    private Map<Integer,Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        //递归基
        if (n <= 1){
            return 1;
        }
        
        if(map.get(n-1) == null){
            map.put(n-1,climbStairs(n-1));
        }
        if(map.get(n-2) == null){
            map.put(n-2,climbStairs(n-2));
        }
        //优化重复计算项
        map.put(n,map.get(n-1) + map.get(n-2));
        return map.get(n);
    }
}