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
    public ListNode doubleIt(ListNode head) {
        // Step 1: Calculate carry by traversing the list recursively
        int carry = solve(head);
        
        // Step 2: If there's a carry left after the head, add a new node
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            return newNode;
        }
        
        return head;
    }
    
    private int solve(ListNode node) {
        if (node == null) {
            return 0;
        }
        
        // Go deeper to the right
        int carry = solve(node.next);
        
        // Calculate new value for current node
        int newVal = node.val * 2 + carry;
        
        // Update current node with only the last digit (e.g., 14 becomes 4)
        node.val = newVal % 10;
        
        // Return the new carry to the previous level (e.g., 14 becomes 1)
        return newVal / 10;
    }
}

// class Solution {
//     public ListNode doubleIt(ListNode head) {
//         String s1="";
//         ListNode temp=head;
//         while(temp!=null){
//             s1+=temp.val;
//             temp=temp.next;
//         }

//         int num=Integer.parseInt(s1);
//         num=num*2;
//         s1=String.valueOf(num);
//         // System.out.println(s1);

//         ListNode dummy=new ListNode(0);
//         // dummy.next=head;
//         ListNode temp1=dummy;
//         head=dummy;
        
//         for(int i=0;i<s1.length();i++){
//             ListNode nn=new ListNode(s1.charAt(i)-'0');
//             temp1.next=nn;
//             temp1=temp1.next;
            
//         }
//         head=head.next;
        

//         return head;
//     }
// }