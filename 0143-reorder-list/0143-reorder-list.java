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
        if(head==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode prev=null;
        ListNode curr=slow.next;
        slow.next=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        ListNode pt1=head;
        ListNode pt2=prev;

        while(pt2!=null){
            ListNode temp1=pt1.next;
            ListNode temp2=pt2.next;
            pt1.next=pt2;
            pt2.next=temp1;

            pt1=temp1;
            pt2=temp2;

        }

    }
}