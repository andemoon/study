# day2学习笔记
---
### 今日总结：补了昨天html和css的一部分笔记，明天继续补，javascript看了一些，感叹一下真看不完，力扣题整了2道出来，最后一道回文链表迭代器出错了写笔记时还没搞定，总体来说，劳累。


---
### 目录
1. 力扣题
2. html和css（补昨天的，明天继续补）
3. javascript


---

#### 力扣题

1. 两个数组的交集
  这道题我第一个思路是用java集合中的hashset，散列表集无重复的特点可以在判断完两个数组存在相同的元素后直接去重复。而判断两个数组中的相同元素我只想到了暴力解法，先找到长度小的那个数组后用两个for循环。

  ```java
    public static int[] intersection(int[] nums1, int[] nums2) {
    	
    	HashSet<Integer> nums = new HashSet<>();//new hashset
    	
    	int num1[];
    	int num2[];
    	
    	if(nums1.length>nums2.length) //比较两个数组长度，找出长度小的那个数组作为for循环的外层。
    	{
    		num1=Arrays.copyOf(nums2, nums2.length);
    		num2=Arrays.copyOf(nums1, nums1.length);
    	}
    	else 
    	{
    		num2=Arrays.copyOf(nums2, nums2.length);
    		num1=Arrays.copyOf(nums1, nums1.length);
    	}
    	
    	
    	for(int i=0;i<num1.length;i++)
    	{
    		
    		for(int k =0;k<num2.length;k++) 
    		{
    			if(num1[i]==num2[k]) 
    			{
    				nums.add(num1[i]);
    			}
    			
    			
    		}
    	}
   
    	
    	int num[] = new int[nums.size()];//new和hashset长度一致的数组
    	int j =0;
    	for (int i : nums) {//foreach循环将hashset中元素放到返回的数组中去。
			num[j++]=i;
			
		}
    	return num;
		}
   ```

2. 合并两个有序数组
    这道题其实就是对数组排序，我的第一个想法是直接用Arrays的api。。。。之前写过c的数组排序题，算偷懒了。
    ```java
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
		 
		 int j=0;
		
		 for (int i : nums2) //将nums2导入nums1
		 {
			 nums1[m+j]=nums2[j];
			 j++;
		 }
		 
		Arrays.sort(nums1);// api,yyds

		 for (int i : nums1) {
			System.out.print(i);
		}
		 
		 
		
	    }

3. 回文链表
  第三道题，出了点我也不知道为什么会发生的bug。。。
  看了蛮久代码，发现是我迭代器后面的逻辑出了问题，因为用的双指针查找，我的迭代器在当前位置上判断元素的顺序整错了，到写这个笔记时还没解决，明天补上。


  ---

  #### html和css笔记
    · HTML 是用来描述网页的一种语言。
    • HTML 指的是超文本标记语言
    • HTML 不是一种编程语言，而是一种标记语言
    • 标记语言是一套标记标签
    • HTML 使用标记标签来描述网页
    • HTML 文档包含了HTML 标签及文本内容
    • HTML文档也叫做 web 页面


     · HTML 文档由 HTML 元素定义。HTML 标签和HTML 元素通常都是描述同样的意思.但是严格来讲, 一个 HTML 元素包含了开始标签与结束标签，及内容。如<p>这是一个段落</p>。
	○ HTML 标签是由尖括号包围的关键词，比如 <html>
	○ HTML 标签通常是成对出现的，比如 <b> 和 </b>
	○ 标签对中的第一个标签是开始标签，第二个标签是结束标签。开始和结束标签也被称为开放标签和闭合标签
	

	· HTML标签分为2种，一种是“一般标签”，另外一种是“自闭合标签”。一般标签有开始符号和结束符号，自闭合标签只有开始符号没有结束符号。
	○ 一般标签可以在开始符号和结束符号之间插入其他标签或文字。
	○ 自闭合标签由于没有结束符号，不能插入其他标签或文字，只能定义自身的属性。

	· 块元素和行内元素：HTML元素根据浏览器表现形式分为两类：①块元素；②行内元素；
	
	○ 块元素特点：
	® 独占一行，排斥其他元素跟其位于同一行，包括块元素和行内元素；
	® 块元素内部可以容纳其他块元素或行元素；
	® 常见块元素有：h1~h6、p、hr、div等。
	○ 行内元素特点：
	® 可以与其他行内元素位于同一行；
	® 行内内部可以容纳其他行内元素，但不可以容纳块元素，不然会出现无法预知的效果；
	® 常见行内元素有：strong、em、span等。

    · 属性是 HTML 元素提供的附加信息。
	○ HTML 元素可以设置属性，属性可以在元素中添加附加信息，用于描述于开始标签
	○ 属性总是以名称/值对的形式出现，比如：name="value"。属性值应该始终被包括在引号内。
	○ 双引号是最常用的，不过使用单引号也没有问题，在某些个别的情况下，比如属性值本身就含有双引号，那么您必须使用单引号，例如：name='John "ShotGun" Nelson'


	· HTML 标题：标题是通过 <h1> - <h6> 标签进行定义的。<h1> 定义最大的标题。 <h6> 定义最小的标题。
	○ 如：<h1>这是一个标题</h1>

	· HTML 水平线：<hr> 标签在 HTML 页面中创建水平线。hr 元素可用于分隔内容,是一个自闭和标签。

	• HTML 注释：可以将注释插入 HTML 代码中，这样可以提高其可读性，使代码更易被人理解。浏览器会忽略注释，也不会显示它们。
	○ 注释写法如下: <!-- 这是一个注释 -->

	· HTML 段落：段落是通过 <p> 标签定义的。<p>是一个块元素。

	· HTML 折行:如果要在不产生一个新段落的情况下进行换行（新行），可以使用 <br> 标签。


    链接
     · HTML 超链接（链接）：HTML使用标签 <a>来设置超文本链接。
     ○ 超链接可以是一个字，一个词，或者一组词，也可以是一幅图像，可以点击这些内容来跳转到新的文档或者当前文档中的某个部分。
     ○ 在标签<a> 中使用了href属性来描述链接的地址：<a href="url ">链接文本</a>
     ○ href 属性描述了链接的目标。.

	· target 属性：使用 target 属性，可以定义被链接的文档在何处显示。
	○ 如：<a href="url" target="_blank">链接文本</a>
	
	○ _blank：表示点击超链接后在一个新的页面窗口打开网址
	○ _self：表示点击超链接后在当前窗口打开（默认模式）
	○ _parent：表示点击超链接后在父窗口中打开（跟框架有关）
	○ _top：在当前浏览器中打开，而框架会消失（跟框架有关）

	· title属性为提示文字，即在鼠标放在超链接上时出现的提示信息

	· id 属性：id 属性可用于创建一个 HTML 文档书签。
	

	· 锚记链接
	○ 锚记链接的概念：锚记链接是可以将很长的页面划分为多个模块，给每个模块做一个标记记号，然后点击页面中对应的锚记标记就能够自动跳转到对应的模块上（在同一个网页页面中）
	○ 锚记链接的应用
	® 锚记链接可以应用于返回页面顶层，通过点击某个锚记标志后可以快速回到页面顶层，是大多数页面都在使用的一种方法，这种方式就是在href属性参数中给一个空链接‘#’
	® 第二、锚记链接给页面指定几个标记，通过点击标记来跳转到指定模块位置
	® 首先需要找到页面某个模块，添加一个锚记标记，可以自定义锚记标记名称，如:
	<a name="key">页面某个模块的某个页面要素</a>
	然后设定一个超链接标签，用来映射到锚记标记，点击此超  链接标签则可以跳转到设定锚记标记的模块部分，#key则是映射之前定义的锚记标记,如：
     <a href="# key">到锚记位置</a>


    · <head> 元素：<head> 元素包含了所有的头部标签元素。在 <head>元素中你可以插入脚本（scripts）, 样式文件（CSS），及各种meta信息。
	○ 可以添加在头部区域的元素标签为: <title>, <style>, <meta>, <link>, <script>, <noscript> 和 <base>。

    · <title> 元素：<title> 标签定义了不同文档的标题。其在 HTML/XHTML 文档中是必须的。其定义了浏览器工具栏的标题、当网页添加到收藏夹时，显示在收藏夹中的标题、显示在搜索引擎结果页面的标题。

	• <base> 元素：<base> 标签描述了基本的链接地址/链接目标，该标签作为HTML文档中所有的链接标签的默认链接。
	• 如：<head>
       <base href="url" target="_blank">
       </head>

	• <link> 元素：<link> 标签定义了文档与外部资源之间的关系。通常用于链接到样式表（css）。
	○ 如<head>
   <link rel="stylesheet" type="text/css" href="mystyle.css">
   </head>
	
	
	· <style> 元素：<style> 标签定义了HTML文档的样式文件引用地址，在<style> 元素中也可以直接添加样式来渲染 HTML 文档。
	○ 如<head>
   <style type="text/css">
   body {background-color:yellow}
   p {color:blue}
   </style>
   </head>
	
	· <meta> 元素：meta标签描述了一些基本的元数据，元数据也不显示在页面上，但会被浏览器解析。
	META 元素通常用于指定网页的描述，关键词，文件的最后修改时间，作者，和其他元数据。
	元数据可以使用于浏览器（如何显示内容或重新加载页面），搜索引擎（关键词），或其他Web服务。
	○ 如<meta http-equiv="refresh" content="30">每30秒刷新一次网页。
	○ 如<meta name="author" content="xxx">显示网页作者。
	
	

	• <script> 元素：<script>标签用于加载脚本文件，如： JavaScript。

    	• CSS (Cascading Style Sheets) 用于渲染HTML元素标签的样式。
	○ CSS 可以通过以下方式添加到HTML中:
	内联样式- 在HTML元素中使用"style" 属性
	内部样式表 -在HTML文档头部 <head> 区域使用<style> 元素 来包含CSS
	外部引用 - 使用外部 CSS 文件
	
	
	
	

	· 内联样式：当特殊的样式需要应用到个别元素时，就可以使用内联样式。 使用内联样式的方法是在相关的标签中使用样式属性。样式属性可以包含任何 CSS 属性。
	○ 如以下实例显示出如何改变段落的颜色和左外边距。
     <p style="color:blue;margin-left:20px;">这是一个段落。</p>
	
	
	• 背景颜色：背景色属性（background-color）定义一个元素的背景颜色：
	○ 如
	<body style="background-color:yellow;"> 
	<h2 style="background-color:red;">这是一个标题   </h2> 
	<p style="background-color:green;">这是一个段落。</p> 
	</body>
	
	· 字体, 字体颜色 ，字体大小：可以使用font-family（字体），color（颜色），和font-size（字体大小）属性来定义字体的样式:
	· 如
	<h1 style="font-family:verdana;">一个标题</h1>
	 <p style="font-family:arial;color:red;font-size:20px;">一个段落。</p>
	
	· 文本对齐方式：使用 text-align（文字对齐）属性指定文本的水平与垂直对齐方式：
	○ 如<h1 style="text-align:center;">居中对齐的标题</h1> 
	   <p>这是一个段落。</p>
	
	
	
	

	• 内部样式表：当单个文件需要特别样式时，就可以使用内部样式表。你可以在<head> 部分通过 <style>标签定义内部样式表:
	○ 如
	<head>
    <style type="text/css">
    body {background-color:yellow;}
    p {color:blue;}
    </style>
    </head>

	· 外部样式表：当样式需要被应用到很多页面的时候，外部样式表将是理想的选择。使用外部样式表，你就可以通过更改一个文件来改变整个站点的外观。
	○ 如
	<head>
    <link rel="stylesheet" type="text/css" href="mystyle.css">
    </head>
    

    
#### javascript
  
js语法看到对象，再感叹一句看不完。
js总体语法不难，但看教程时看到一个叫工厂方法的东西，然后又看到懒汉模式和饿汉模式，然后看着看着看偏了。。。


 ---









  




         

    
        
       

 

