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
        int sumDigit;
        int carry = 0;
        Stack<Integer> stack = new Stack<>();

        while (!(l1 == null && l2 == null) || carry > 0) {
            if (l1 != null && l2 != null) {
                sumDigit = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                sumDigit = l1.val + carry;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                sumDigit = l2.val + carry;
                l2 = l2.next;
            } else {sumDigit = carry;}
            
            stack.push(sumDigit % 10);
            carry = sumDigit / 10;
        }

        ListNode result = null;
        while (!stack.isEmpty()) {
            result = new ListNode(stack.pop(), result);
        }

        return result;
    }
}