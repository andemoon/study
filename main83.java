package leetcode1;

import java.security.DrbgParameters.NextBytes;
import java.util.LinkedList;
import java.util.Stack;

public class main83 {

	public static void main(String[] args) {//83.ɾ�����������е��ظ�Ԫ��


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
        if(head.next==null||head==null){//���ͷ�ڵ��nexָ��null��ͷ�ڵ�ָ��nullֱ�ӷ����䱾���ǵݹ����ֹ����
          return head;
        }
        
        if (head.val == head.next.val) {//���head��val=head.next��val����ȥ��head�ڵ�
            head = deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);//���head��val��=head.next��val,�Ͱѵڶ����ڵ���Ϊͷ�ڵ�ȥ�ݹ飬��󷵻ص�������û���ظ�ֵ�������ٽ�����Ϊhead.next
        }
        return head;


    }
  
}





