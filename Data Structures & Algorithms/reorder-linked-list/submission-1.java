/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode node = null;

        while(second!=null)
        {
            ListNode temp = second.next;
            second.next = node;
            node = second;
            second = temp;
        }


        while(node!=null)
        {
            ListNode temp1 = head.next, temp2 =  node.next;
            head.next = node;
            node.next = temp1;
            node = temp2;
            head = temp1;
        }


    }
}