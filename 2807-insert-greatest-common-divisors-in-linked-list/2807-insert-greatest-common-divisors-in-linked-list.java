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
    int gcd(int a, int b){
        if(b==0)  return a;
        return gcd(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            int res=gcd(temp.val,temp.next.val);
            ListNode nn=new ListNode(res);
            nn.next=temp.next;
            temp.next=nn;
            temp=nn.next;        
        }
        return head;
    }
}