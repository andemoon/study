# day3学习笔记
---
### 今日总结：力扣还是不会，数学学得瞌睡。


---
### 目录
1. 力扣题
2. 数学学习
3. html和css学习笔记（补全)
4. python
---

#### 力扣题


83.删除排序链表中的重复元素
  这道题，一开始看到只给了头节点还懵了一会，过半天才反应过来可以用递归。。。然后写递归时又卡了半天。。重新去查了一下怎么写递归：
  1. 确定终止条件
  2. 确定第一级递归要返回什么内容
  3. 确定每一级要返回给上一级的内容

  ```java
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
```
---
382. 链表随机节点

这道题看半天没思路，去评论区瞟了一眼看到是蓄水池抽样算法，学习了一下：
有这么一种情况：“给出一个数据流，这个数据流的长度很大或者未知。并且对该数据流中数据只能访问一次。请写出一个随机选择算法，使得数据流中所有数据被选中的概率相等。”

先假设需要采样的数量为k，首先构建一个可容纳k个元素的数组，将序列的前k个元素放入数组中。然后对于第j（j>k）个元素开始，以k/j的概率来决定该元素是否被替换到数组中（数组中的 k k k个元素被替换的概率是相同的）。 当遍历完所有元素之后，数组中剩下的元素即为所需采取的样本。

```java
public class ReservoirSamplingTest {//代码来自csdn

    private int[] pool; // 所有数据
    private final int N = 100000; // 数据规模
    private Random random = new Random();

    @Before
    public void setUp() throws Exception {
        // 初始化
        pool = new int[N];
        for (int i = 0; i < N; i++) {
            pool[i] = i;
        }
    }

    private int[] sampling(int K) {
        int[] result = new int[K];
        for (int i = 0; i < K; i++) { // 前 K 个元素直接放入数组中
            result[i] = pool[i];
        }

        for (int i = K; i < N; i++) { // K + 1 个元素开始进行概率采样
            int r = random.nextInt(i + 1);
            // 这里其实就是k/j的体现
            if (r < K) {
                result[r] = pool[i];
            }
        }

        return result;
    }

    @Test
    public void test() throws Exception {
        for (int i : sampling(100)) {
            System.out.println(i);
        }
    }
}
```
至于题目吗，没写完emm

---

1185. 一周中的第几天
还没写完，明天补上。。
---

#### 数学学习
  今天主要看了矩阵一块的内容，矩阵在我的理解中，可以类比为是一种空间变化，拿最简单的2*2矩阵举例,其就是由变换后的xy平面直角坐标系基坐标组成，矩阵可以很清晰地刻画线性变换。

  ---
#### html和css学习笔记补全

	• 图像标签：在 HTML 中，图像由<img> 标签定义。
	○ <img> 是空标签，它只包含属性，并且没有闭合标签。
	• 源属性（Src）：要在页面上显示图像，需要使用源属性。src 指 "source"。源属性的值是图像的 URL 地址。
    定义图像的语法是：<img src="url " alt="some_text ">
    浏览器将图像显示在文档中图像标签出现的地方。如果你将图像标签置于两个段落之间，那么浏览器会首先显示第一个段落，然后显示图片，最后显示第二段。


	• Alt属性：alt 属性用来为图像定义一串预备的可替换的文本。
	如<img src="boat.gif" alt="xxx">
	• 高度与宽度属性：height（高度） 与 width（宽度）属性用于设置图像的高度与宽度。属性值默认单位为像素。
     如<img src="pulpit.jpg" alt="Pulpit rock" width="304" height="228">

     	• HTML 表格：表格由 <table> 标签来定义。每个表格均有若干行（由 <tr> 标签定义），每行被分割为若干单元格（由 <td> 标签定义）。字母 td 指表格数据（table data），即数据单元格的内容。
	○ 数据单元格可以包含文本、图片、列表、段落、表单、水平线、表格等等。
	○ 如
	<table border="1"> 
	<tr> 
	<td>Row 1, cell 1</td> 
	<td>Row 1, cell 2</td> 
	</tr> 
	</table>

	• HTML 表格和边框属性：使用边框属性来显示一个带有边框的表格，
	○ <table border=#> #=边框粗度
	
	· 表格边框的色彩 
	○ <table bordercolor=#>

	· 宽度高度属性：设置表格宽度和高度
	○ <table border width=# height=#>width：宽度，height：高度,#＝象素

	· 表元间隙设置
	○ <table border cellspacing=#> #=象素

	· 设置表格在网页中的布局位置：左边右边中间
	○ <table align=#> #=left,right,center

	· 表格的标题
	○ <caption align="" > 标题内容</caption> ,align=left,right,center valign=bottom,top

	· 跨多列的表 <td colspan=#>
	· 跨多行的表 <td rowspan=#>
	
	· HTML 表格表头：表格的表头使用 <th> 标签进行定义。
	
	· 表格单元格的背景色和添加背景图片：bg属性控制单元格背景色，background添加背景图片。

    	· HTML无序列表：无序列表是一个项目的列表，此列项目使用粗体圆点（典型的小黑圆圈）进行标记。无序列表使用 <ul> 标签。每个列表项始于 <li> 标签。

	• HTML 有序列表：同样，有序列表也是一列项目，列表项目使用数字进行标记。 有序列表始于 <ol> 标签。每个列表项始于 <li> 标签。列表项使用数字来标记。

	· HTML 自定义列表：自定义列表不仅仅是一列项目，而是项目及其注释的组合。
	自定义列表以 <dl> 标签开始。每个自定义列表项以 <dt> 开始。每个自定义列表项的定义以 <dd> 开始。

	• <div> 和<span>：HTML 可以通过 <div> 和 <span>将元素组合起来。

	• HTML 区块元素：大多数 HTML 元素被定义为块级元素或内联元素。
	○ 块级元素在浏览器显示时，通常会以新行来开始（和结束）。如 <h1>, <p>, <ul>, <table>

	· HTML 内联元素：内联元素在显示时通常不会以新行开始。如:<b>, <td>, <a>, <img>

	· <div> 元素：HTML <div> 元素是块级元素，它可用于组合其他 HTML 元素的容器。
	○ <div> 元素没有特定的含义。除此之外，由于它属于块级元素，浏览器会在其前后显示折行。如果与 CSS 一同使用，<div> 元素可用于对大的内容块设置样式属性。
	○ <div> 元素的另一个常见的用途是文档布局。它取代了使用表格定义布局的老式方法。使用 <table> 元素进行文档布局不是表格的正确用法。<table> 元素的作用是显示表格化的数据。

	· HTML <span> 元素：HTML <span> 元素是内联元素，可用作文本的容器<span> 元素也没有特定的含义。当与 CSS 一同使用时，<span> 元素可用于为部分文本设置样式属性。

    	• HTML 表单：表单是一个包含表单元素的区域。表单元素是允许用户在表单中输入内容,比如：文本域(textarea)、下拉列表、单选框(radio-buttons)、复选框(checkboxes)等等。
	○ 表单使用表单标签 <form> 来设置，
	<form>
	.
	input 元素
	.
	</form>

	• 输入元素：多数情况下被用到的表单标签是输入标签（<input>）。输入类型是由类型属性（type）定义的。
	○ 文本域：文本域通过<input type="text"> 标签来设定，当用户要在表单中键入字母、数字等内容时，就会用到文本域。

	○ 密码字段：密码字段通过标签<input type="password"> 来定义:

	○ 单选按钮：<input type="radio"> 标签定义了表单单选框选项
	
	○ 复选框：<input type="checkbox"> 定义了复选框. 用户需要从若干给定的选择中选取一个或若干选项。
	○ 提交按钮：<input type="submit"> 定义了提交按钮。当用户单击确认按钮时，表单的内容会被传送到另一个文件。表单的动作属性定义了目的文件的文件名。由动作属性定义的这个文件通常会对接收到的输入数据进行相关的处理。

	• HTML 框架：通过使用框架，可以在同一个浏览器窗口中显示不止一个页面。
	○ iframe语法:<iframe src="URL"></iframe>
	该URL指向不同的网页。

	• 设置高度与宽度：height 和 width 属性用来定义iframe标签的高度与宽度。
	属性默认以像素为单位, 但是你可以指定其按比例显示 (如："80%")。

	· 移除边框：frameborder 属性用于定义iframe表示是否显示边框。
	设置属性值为 "0" 移除iframe的边框:

	· 使用 iframe 来显示目标链接页面：iframe 可以显示一个目标链接的页面，目标链接的属性必须使用 iframe 的属性，

    • HTML 脚本：JavaScript 使 HTML 页面具有更强的动态和交互性。
	○ <script> 标签：<script> 标签用于定义客户端脚本，比如 JavaScript。
	<script> 元素既可包含脚本语句，也可通过 src 属性指向外部脚本文件。
	JavaScript 最常用于图片操作、表单验证以及内容动态更新。、

<noscript> 标签：<noscript> 标签提供无法使用脚本时的替代内容，比方在浏览器禁用脚本时，或浏览器不支持客户端脚本时。<noscript>元素可包含普通 HTML 页面的 body 元素中能够找到的所有元素。只有在浏览器不支持脚本或者禁用脚本时，才会显示 <noscript> 元素中的内容。

---

#### python

python之前学过基础语法，今天主要是复习了一下numpy和panda，然后就发现切片操作啥的忘记得差不多了，重新看了一下。。。





