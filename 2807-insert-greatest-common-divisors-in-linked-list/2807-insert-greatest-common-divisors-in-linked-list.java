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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node = head;
        while(node.next != null)
        {
            ListNode temp = node.next;
            node.next = new ListNode(gcd(node.val, node.next.val));
            node.next.next = temp;
            node = temp;
        }
        return head;
    }
    public int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }
}