package leetcode1;

import java.security.DrbgParameters.NextBytes;
import java.util.LinkedList;
import java.util.Stack;

public class main83 {

	public static void main(String[] args) {//83.删除排序链表中的重复元素


	}

}

class ListNode 
{
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	

}

class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head.next==null||head==null){//如果头节点的nex指向null或头节点指向null直接返回其本身。是递归的终止条件
          return head;
        }
        
        if (head.val == head.next.val) {//如果head的val=head.next的val，就去掉head节点
            head = deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);//如果head的val！=head.next的val,就把第二个节点作为头节点去递归，最后返回的链表是没有重复值的链表，再将其作为head.next
        }
        return head;


    }
  
}





