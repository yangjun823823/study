/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static class ExistK{
        boolean exist;
        ListNode node;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // k == 1不需要翻转
        if (k == 1) {
            return head;
        }
        ListNode myHead = new ListNode();
        myHead.next = head;
        ListNode pre = myHead;
        ListNode p = pre.next;

        ExistK existK = existK(p,k);
        boolean enough = existK.exist;
        ListNode succ = existK.node;
        while (enough){
            pre.next = reverseSingleLink(p, k);
            pre = p;
            p = succ;
            existK = existK(succ,k);
            succ = existK.node;
            enough = existK.exist;
        }
        pre.next = p;
        return myHead.next;
    }
    // 翻转单链表并返回新的链表头
    private ListNode reverseSingleLink(ListNode head, int k){
        ListNode pre = head;
        ListNode cur = pre.next;
        for (int i = 0; i< k-1; i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    // 判断链表长度是否够K个,返回后继
    private ExistK existK(ListNode head, int k){
        ExistK result = new ExistK();
        int num = 0;
        ListNode node = head;
        while (num < k && node != null){
            node = node.next;
            num++;
        }
        if (num == k){
            result.exist = true;
            result.node = node;
        }
        return result;
    }
}
