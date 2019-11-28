/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null){
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
        }
        curr.next = pre;
        return curr;
    }
	
	
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}
}

