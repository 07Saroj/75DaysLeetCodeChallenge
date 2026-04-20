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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        ListNode ptr1=head;
        ListNode ptr2=head;

        for(int i=0;i<k-1;i++){
            ptr1=ptr1.next;
        }

        for(int i=0;i<len-k;i++){
            ptr2=ptr2.next;
        }

        int t=ptr1.val;
        ptr1.val=ptr2.val;
        ptr2.val=t;
        return head;
    }
}