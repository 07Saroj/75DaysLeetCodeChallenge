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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(0);
        ListNode pt1=l1;
        ListNode pt2=l2;
        
        
        ListNode temp=res;
        int rem=0;
        while(pt1!=null && pt2!=null){
            int sum=pt1.val+pt2.val+rem;
            ListNode nN=new ListNode(sum%10);
            rem =sum/10;
            temp.next=nN;
            temp=temp.next;
            pt1=pt1.next;
            pt2=pt2.next;
        }
        while(pt1!=null){
            int sum=pt1.val+rem;
            ListNode nN=new ListNode(sum%10);
            rem =sum/10;
            temp.next=nN;
            temp=temp.next;
            pt1=pt1.next;
        }
        while(pt2!=null){
            int sum=pt2.val+rem;
            ListNode nN=new ListNode(sum%10);
            rem =sum/10;
            temp.next=nN;
            temp=temp.next;
            pt2=pt2.next;
        }
        if(rem>0){
            int sum=rem;
            ListNode nN=new ListNode(sum%10);
            rem =sum/10;
            temp.next=nN;
            temp=temp.next;
        }

        return res.next;
    }
}