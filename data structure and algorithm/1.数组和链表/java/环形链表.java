/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode faster = head.next;
        ListNode lower = head;
        while (faster!=lower){
            //直接走完了，无环
            if(faster == null || faster.next == null){
                return false;
            }
            faster = faster.next.next;
            lower = lower.next;
        }
        return true;
    }
}