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
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        
        StringBuffer sb = new StringBuffer();
        StringBuffer s = new StringBuffer();
      
        while(l1 != null){
                sb.append(l1.val);
            l1 = l1.next;

        }
        while(l2 != null){
            s.append(l2.val);
            l2 = l2.next;
        }
        sb.reverse();
        s.reverse();
        
        BigInteger first = new BigInteger(sb.toString());
        BigInteger second = new BigInteger(s.toString());

        BigInteger su = first.add(second);
        String string = su.toString();
        StringBuffer sbr = new StringBuffer(string);
        sbr.reverse();
        String sum = sbr.toString();
       
        ListNode node = null;
        ListNode head = null;
        
        for(char i: sum.toCharArray()){
            int num = Integer.parseInt(String.valueOf(i));
            ListNode temp =  new ListNode(num,null);
            if(node == null){
                node = temp;
                head = node;

            }else{
                node.next = temp;
                node = temp;
            }
        }
        return head;

    }
}