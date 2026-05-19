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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while(true){
            ListNode kth = prevGroup;
            int count = 0;
            while(count < k && kth != null){
                kth = kth.next;
                count++;
            }

            if(kth == null) break;

            ListNode start = prevGroup.next;
            ListNode nextGroup = kth.next;


            ListNode prev = null;
            ListNode curr = start;

            while(curr != nextGroup){
                ListNode tempcurr = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tempcurr;
            }

            prevGroup.next = kth;
            start.next = nextGroup;
            prevGroup = start;

        }
        return dummy.next;
    }
}
