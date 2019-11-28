/**快慢指针找到相遇点；快指针指回链表头部，慢指针指向相遇点，每次将它们向前移动一步，直到再次相遇，相遇点就是环的入口。
说明：
设链表头部到环的入口长度为a，环的长度为b，环的入口到相遇点的长度为c：则f=2s=s+nb，s=nb=a+c+(n-1)b，b=a+c，即慢指针从相遇点继续前进a步就是环的入口。
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
    public ListNode detectCycle(ListNode head) {
        ListNode faster = head;
        ListNode lower = head;
        while(true){
            if(faster == null || faster.next == null){
                return null;
            }
            faster = faster.next.next;
            lower = lower.next;
            if(faster == lower){
                //慢指针再走a步，就到入口
                //从链表头走a，也到入口
                //将快指针移到链表头，再次相遇便是入口
                faster = head;
                while(faster != lower){
                    faster = faster.next;
                    lower = lower.next;
                }
                return faster;
            }
        }
    }
}