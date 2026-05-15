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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pt1=head;
        while(pt1!=null && pt1.next!=null){
            ListNode temp=pt1.next;
            if(pt1.val==temp.val){
                pt1.next=temp.next;
                temp.next=null;
                
            }else{
                pt1=pt1.next;
            }
            
            
        }

        return head;
    }
}