/**借助一个Pre节点，判断链表是否有k个节点，找区间翻转，贪心思想
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
		
        while(this.hasKNodes(pre.next,k)){//判断从该节点开始是否有K个节点
            ListNode start = pre.next;
            ListNode end = null;
            int count = 0;
            ListNode travel = pre.next;
			//找到翻转区间
            while (travel != null && ++count < k){
                travel = travel.next;
            }
            if(count == k){
                end = travel;
            }
            ListNode preNode = travel.next;
            ListNode curr = start;
            ListNode endNext = end.next;
            while(curr != endNext){
                ListNode temp = curr.next;
                curr.next = preNode;
                preNode = curr;
                curr = temp;
            }
            pre.next = end;
            pre = start;
        }
        return dummy.next;
        
    }
    public boolean hasKNodes(ListNode node, int k){
        boolean result = false;
        ListNode curr = node;
        int count = 0;
		//注意边界
        while (curr != null && ++count < k){
            curr = curr.next;
        }
        if (count == k){
            result = true;
        }
        return result;
    }
}