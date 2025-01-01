class Solution {
    ListNode start;

    public boolean isPalindrome(ListNode head) {
        if (start == null) {
            start = head;
        }
        return isPalindromeHelper(head);
    }

    private boolean isPalindromeHelper(ListNode head) {
        if (head == null)
            return true;

        boolean palindrome = isPalindromeHelper(head.next) && this.start.val == head.val;

        this.start = this.start.next;

        return palindrome;
    }
}