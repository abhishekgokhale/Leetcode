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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int length = 0;
        ListNode curr = head;
        while(curr != null){
            length++;
            curr = curr.next;
        }
        curr = head;
        int i = 0;
        int extras = length % k;
        while(curr != null){
            int elements = 1;
            ans[i] = curr;
            // System.out.println(curr.val);
            while(curr != null && elements < length / k){
                curr = curr.next;
                elements++;
            }
            // System.out.println(extras);
            if(curr != null && i < extras && length > k) curr = curr.next;
            if(curr != null){
                // System.out.println("curr = " + curr.val);
                ListNode prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            i++;
        }
        return ans;
    }
}