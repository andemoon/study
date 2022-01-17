# day1学习笔记
---
### 今日总结：
刚回老家，事情比想象中多，只整完了三道题的学习笔记，我反省。不过html之前学完了，css也学了一半，学习笔记明天补上。

---
### 目录
1. 力扣题

---

#### 力扣题

1. 两数之和：
  该题我第一个想到的解法是直接暴力解题，用两个for循环遍历数组找出目标数。
```java
 public static int[] twoSum(int[] nums, int target) {//方法一，暴力解法,时间复杂度o(n2)
        
    	for(int i=0;i<nums.length;i++)
    	{
    		for(int j =i+1;j<nums.length;j++)
    		{
    			if(nums[i]+nums[j]==target)
    			{
    				return new int[] {i,j};
    				
    			}
    		}
    		
    	}
    	
   return null;
    }
```
  写完执行后想到了第二个解法，构建中间数减少遍历的数量。

```java
 public static int[] twoSum1(int[] nums, int target) {//方法二,时间复杂度o(lnn)
        int temp;
        int[] res =new int[2];
    	for(int i=0;i<nums.length;i++)
    	{
    		temp = target-nums[i];
    		for(int j = i+1;j<nums.length;j++)
    		{
    			if(nums[j]==temp)
    			{
    				res[0]=i;
    				res[1] =j;
    				return res;  
    			}
    		}
    	}
    	
   return null;
    }
```

2. 有效括号：
  想这道题时第一个想法是用正则表达式去匹配，不过想了想还是要好好写题。
  思路是以栈为基础，使用栈后进后出的特点。
  如果存在有效括号，那么{}（）等便会成对出现，我们可以判断（{前符号，在存在这些符号时将对应的括号}）压于栈中，若此后出现括号}）时，便将栈中元素依次弹出，最后若栈中元素为空则表示所有的括号都是有效括号。
  代码如下：

  ```java
  public boolean isValid(String s) {
	    Stack<Character>word = new Stack<>();//构建栈
	    for(char c: s.toCharArray()){//foreach循环，同时将字符串装换为数组以遍历
	    	//分别判断括号 ，如果存在括号
	        if(c=='(') {
	        	word.push(')');
	        	}
	        else if(c=='[') {
	        	word.push(']');
	        	}
	        else if(c=='{') {
	        	word.push('}');
	        	}
	        else if(word.isEmpty()||c!=word.pop()) {//如果栈为空或此时数组元素不是栈顶元素时，即不存在匹配的括号时，返回false
	        	
	        return false;
	        }
	    }
	    return word.isEmpty();//最后判断栈是否为空。
  }
```

3. 装换成小写字母：
  
看这题时第一个思路也是暴力解法，直接匹配所有大写字母装换小写字母。第二个思路直接用api...

第三个思路是用asc2码，也是最后用的方法。
```java
	 public String toLowerCase(String s) {
	        char[] c = s.toCharArray();
	        
	        for(int i = 0; i < c.length; i++) {
	            if(c[i] >= 'A' && c[i] <= 'Z') {
	                c[i] = (char)(c[i] - 'A' + 'a');
	            }
	        }
	        return String.valueOf(c);
	    }
```
---

