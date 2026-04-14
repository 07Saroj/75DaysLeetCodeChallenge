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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prev=null,curr=slow,nextNode=null;
        while(curr!=null){
            nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }

        ListNode pt1=head;
        ListNode pt2=prev;

        while(pt1!=null && pt2!=null){
            if(pt1.val!=pt2.val) return false;
            pt1=pt1.next;
            pt2=pt2.next;
        }
        return true;

    }
}