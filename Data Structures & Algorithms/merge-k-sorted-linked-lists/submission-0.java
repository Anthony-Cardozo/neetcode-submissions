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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>((x, y) -> Integer.compare(x.val, y.val));
        ListNode node = new ListNode();
        ListNode res = node;

        for(ListNode x: lists)
        {
            if(x != null)
                q.add(x);
        }

        while(q.size()>0)
        {
            node.next = q.poll();
            ListNode temp = node.next.next;
            if(temp != null) {
                q.add(temp);
            }
            node = node.next;
        }
        return res.next;
    }
}