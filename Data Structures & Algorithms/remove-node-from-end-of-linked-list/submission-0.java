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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode node = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        if (size == n) {
            return node.next;
        }
        n = size - n - 1;
        ListNode res = node;
        while (n > 0) {
            node = node.next;
            n--;
        }
        if (node.next != null) {
            node.next = node.next.next;
        }
        return res;
    }
}