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
    public ListNode middleNode(ListNode head) {
        ListNode p1=head;
        int length=0;
        while(p1!=null){
            length++;
            p1=p1.next;
        }
        ListNode p2=head;
        int count=0;
        while(count<(length/2)){
            p2=p2.next;
            count++;
        }
        return p2;

    }
}