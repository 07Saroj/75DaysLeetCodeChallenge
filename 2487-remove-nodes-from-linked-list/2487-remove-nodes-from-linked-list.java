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
    public ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, fut = null;
        while (curr != null) {
            fut = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fut;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) return head; // Return the node, not null

        // 1. Reverse the list
        head = reverse(head);

        // 2. Traverse and remove nodes
        ListNode curr = head;
        int max = curr.val;
        
        while (curr.next != null) {
            if (curr.next.val < max) {
                // Remove the next node
                curr.next = curr.next.next;
            } else {
                // Update max and move forward
                max = curr.next.val;
                curr = curr.next;
            }
        }

        // 3. Reverse it back to original order
        return reverse(head);
    }
}