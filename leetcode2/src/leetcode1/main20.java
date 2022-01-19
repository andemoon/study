package leetcode1;

import java.util.Stack;

public class main20 {
	
	String word;//测试用例
	
	
	
	
	
	
	
	public boolean isValid(String s) {
	    Stack<Character>stack = new Stack<Character>();//构建栈
	    for(char c: s.toCharArray()){//foreach循环，同时将字符串装换为数组以遍历
	    	//分别判断括号 ，如果存在括号
	        if(c=='(') {
	        	stack.push(')');
	        	}
	        else if(c=='[') {
	        	stack.push(']');
	        	}
	        else if(c=='{') {
	        	stack.push('}');
	        	}
	        else if(stack.isEmpty()||c!=stack.pop()) {//如果栈为空或此时数组元素不是栈顶元素时，即不存在匹配的括号时，返回false
	        	
	        return false;
	        }
	    }
	    return stack.isEmpty();//最后判断栈是否为空。

}


}
