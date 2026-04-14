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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0|| head==null|| head.next==null) return head;
        ListNode temp=head;
        int length=1;
        while(temp.next!=null){
            length++;
            temp=temp.next;
        }
        k=k%length;
        if(k==0) return head;
        temp.next=head;
        k=length-k;
        ListNode curr=head;
        for(int i=1;i<k;i++){
            curr=curr.next;
        }
        head=curr.next;
        curr.next=null;

        return head;


    }
}