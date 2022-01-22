package leetcode1;

public class main21 {

	public static void main(String[] args) {//21. 合并两个有序链表
		

	}
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	
	 public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		 
	        // 类似归并排序中的合并过程
	        ListNode Head = new ListNode(0);
	        ListNode cur = Head;
	        while (list1 != null && list2 != null) {
	            if (list1.val < list2.val) {
	                cur.next = list1;
	                cur = cur.next;
	                list1 = list1.next;
	            } else {
	                cur.next = list2;
	                cur = cur.next;
	                list2 = list2.next;
	            }
	        }
	        // 任一为空，直接连接另一条链表
	        if (list2 == null) {
	            cur.next = list2;
	        } else {
	            cur.next = list1;
	        }
	        return Head.next;
	    
		 
		 
		
		 

	    }
}

 