
//笨方法，但实用
//考虑分治法，该阶段暂不考虑
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> resultData = new ArrayList<>();
        //偏向于不破坏输入的合并
        //记录k个链表当前遍历的位置
        ListNode[] positions = new ListNode[lists.length];
        boolean isNull = true;
        for(int index = 0; index < lists.length; index++){
            if(lists[index]!=null){
                isNull = false;
            }
            positions [index] = lists[index];
        }
        if(isNull) return null;
        boolean travelNotFinished = true;
        while(travelNotFinished){
            ListNode minNode = null;
            int minIndex=0;
            //初始化最小的那个节点
            for (int i = 0; i < positions.length; i++){
                if(positions[i]!=null){
                    minNode = positions[i];
                    minIndex = i;
                    break;
                }
            }
            for (int i = minIndex+1; i < positions.length; i++){
                if(positions[i]!=null && positions[i].val < minNode.val){
                    minNode = positions[i];
                    minIndex = i;
                }
            }
            resultData.add(minNode.val);
            positions[minIndex] = minNode.next;
            travelNotFinished = false;
            for(int i = 0; i < positions.length; i++){
                if(positions[i]!=null){
                    travelNotFinished = true;
                }
            }
        }
        
        ListNode head = new ListNode(resultData.get(0));
        ListNode tail = head;
        for (int i = 1; i < resultData.size(); i++){
            ListNode node = new ListNode(resultData.get(i));
            tail.next = node;
            tail = tail.next;
        }
        return head;
    }

}