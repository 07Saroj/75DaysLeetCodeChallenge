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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ls = new ArrayList<>();
        
        ListNode curr=head;
        while(curr!=null){
            int m=curr.val;
            ListNode t=curr.next;
            while(t!=null){
                if(t.val>m){
                    m=t.val;
                    break;
                }
                t=t.next;
            }
            if(m==curr.val){
                ls.add(0);
            }
            else{
                ls.add(m);
            }
            curr=curr.next;
        }
        int[] array = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            array[i] = ls.get(i);
        }

        return array;


    }
}