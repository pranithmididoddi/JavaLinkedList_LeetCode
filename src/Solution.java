import java.util.*;
public class Solution {

    /**code to reverse a list*/
    public ListNode reverseList(ListNode head) {

        ListNode current=head;
        ListNode previous=null;
        ListNode next=null;

        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
    }

    /**Insertion of an element in the first position(beginning of the list)*/

    ListNode Insert(ListNode head,int val) {

        ListNode current=head;

        while(current.next!=null){
            current=current.next;
        }
        current.next=new ListNode();
        current.next.val=val;

        return head;
/*This is a "method-only" submission.
You only need to complete this method. */

    }

    //find the cycle in the list

    public boolean hasCycle(ListNode head) {

        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
                return true;
        }

        return false;

    }
 /**
  */

 /** LinkedList palindrome check naive approach
  * 14/25 cases passed on leetcode*/

 public boolean isPalindrome(ListNode head) {
     ListNode current=head;
     ListNode check=reverseList(head);

     while(current!=null){
         if(current.val!=check.val)
             return false;

         current=current.next;
         check=check.next;
     }
     return true;
 }

 /** LinkedList palindrome with Stack*/

 public boolean isaPalindrome(ListNode head) {
     ListNode current=head;
     ListNode fast=head;
     Stack<Integer> stack=new Stack<Integer>();

     while(fast!=null && fast.next!=null){
         stack.push(current.val);
         current=current.next;
         fast=fast.next.next;
     }

     if(fast!=null) current=current.next;

     while(current!=null){
         if(stack.pop().intValue() != current.val) return false;
         current=current.next;
     }
     return true;
 }




}
