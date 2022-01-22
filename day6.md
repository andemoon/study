# day6学习笔记
---
### 今日总结：装虚拟机蓝屏，虚拟机中装linux蓝屏，学着用linux时蓝屏，反正就是各种蓝屏。。。。蓝屏的钙，好喝的钙。


---
### 目录
1. 力扣题
2. linux
---
#### 力扣题

9.回文数

  简单题，用/和%分别控制数字减一位和数字最后一位,将数字倒过来看是不是和原数字一样。

  感觉就算用api去写时间复杂度可能也差不了多少。。。
  ```java
public static boolean isPalindrome(int x) {
		if(x<0) {
			return false;
		}
		else {
			int rs=0;
			int y=0;
			int z=x;
			while(z!=0) {
				rs=z%10;//rs记录余数
				y=y*10+rs;//y记录倒过来后的x
				z=z/10;//z是每次循环后x减一位后的数字
				
			}
			
		if(y==x) {
			return true;
			
		}
		else {
			return false;
		}
			
			
		}

  ```
  ---
  21.合并两个有序链表
\
    链表现在还是比较熟悉了,这道题就先合并再排序来写。


  ```java
 public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	        ListNode Head = new ListNode(0);
	        ListNode cur = Head;
	        while (list1 != null && list2 != null) {//如果两个链表都不为空
	            if (list1.val < list2.val) {//因为链表都是递增的，所以比较list1和list2的头节点的值哪一个小，再合并排序。
	                cur.next = list1;//此时 cur 和 list1的值相同，都是存着 0 节点的引用（或者说 cur 和 list1 都指向 0 节点）
	                cur = cur.next;
	                list1 = list1.next;
	            } else {
	                cur.next = list2;
	                cur = cur.next;
	                list2 = list2.next;
	            }
	        }
	        
	        if (list2 == null) {//如果有链表为空，那将其直接合并就好。
	            cur.next = list2;
	        } else {
	            cur.next = list1;
	        }
	        return Head.next;
    }

  ```

  ---

  35. 搜索插入位置

  这道题题目要求时间复杂度为o（logn），直接用二分查找搞定，不过要注意二分查找的边界关系。

  ```java
	 public int searchInsert(int[] nums, int target) {
		 
		 int temp = 0;//索引
	        for(int i = 0; i < nums.length; i++) {
	            if (nums[i] == target) {
	                temp = i;
	                break;
	            } else if (nums[nums.length - 1] < target) {
	                temp = nums.length;
	                break;
	            } else if (nums[0] > target) {
	                temp = 0;
	            } else if(nums[i] > target) {
	                temp = i;
	                break;
	            }
	        }
	        return temp;

}



  ```

  ---

  #### linux

   简单来说，装虚拟机和装linux系统用了我百分之80的时间。。。


   记一些觉得蛮重要的知识点。

ssh的简单使用：
ssh [-p port] user@remote
、
user 是在远程机器上的用户名，如果不指定的话默认为当前用户
remote 是远程机器的地址，可以是 IP／域名，或者是 后面会提到的别名
port 是 SSH Server 监听的端口，默认值 22。

---

局部变量：shell也有自定义函数，函数里面的变量为局部变量，但是它也是相当于全局变量，函数中的变量，在函数外调用也是可以的，如果要仅限函数使用，需要在函数变量前加个关键字：local

全局变量：每打开一个终端就是一个shell会话，在这个shell会话（终端）定义的变量就是全局变量，它在这个shell会话有效，当你打开另一个终端就是另一个shell会话，这个变量在另一个终端就失效了。

环境变量：在全局变量前加 export ，如：export a=1  那么这个变量就是环境变量了。创建这个变量的shell成为父shell，这个shell中，在创建一个shell叫做子shell，环境变量可以由父shell往下一级一级传，而不能逆转往上传递。当shell会话销毁时，这个环境变量也会随之销毁。想要永久保存就得环境变量写到启动文件中去。

---

从结果看出不加引号和加双引号的结果是相同的，而单引号是原样输出变量后面赋值的内容。

shell特殊变量：
$0当前脚本的文件名或者解释器。

$n（n≥1）传递给脚本或函数的参数。n 是一个数字，表示第几个参数。例如，第一个参数是 $1，第二个参数是 $2。

$#传递给脚本或函数的参数个数。

$*传递给脚本或函数的所有参数。


$?上个命令的退出状态，或函数的返回值

---

bash shell 中只支持一维，而不支持二维，定义的形式：array=(n1 n2 n3) ,数组名等号两边不能有空格，数组变量的值用空格隔开表示不同的值，一个数组变量的值可以用数字或者字符串不同的形式组成：array=(1 2 ab) 。

Shell 数组的长度不是固定的，定义之后还可以增加元素，如：array[3]=cd ；就在最后增加了一个元素。

---


