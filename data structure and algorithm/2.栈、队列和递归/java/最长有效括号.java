class Solution {
    //思路：如何记录当前状态，又能计算合法数。若直接两两相消，会忽略掉()()情况。需要一个记录最新的不合法的位置，每次扫到右括号更新最值和不合法位置
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLong = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                    stack.pop();
                    if(stack.isEmpty()){//代表上一个有括号不是最新的不合法位置
                        stack.push(i);
                    }else{
                        maxLong = Math.max(maxLong,i-stack.peek());
                    }
            }
        }
        return maxLong;
    }
}