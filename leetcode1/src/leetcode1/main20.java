package leetcode1;

import java.util.Stack;

public class main20 {
	
	String word;//��������
	
	
	
	
	
	
	
	public boolean isValid(String s) {
	    Stack<Character>stack = new Stack<Character>();//����ջ
	    for(char c: s.toCharArray()){//foreachѭ����ͬʱ���ַ���װ��Ϊ�����Ա���
	    	//�ֱ��ж����� �������������
	        if(c=='(') {
	        	stack.push(')');
	        	}
	        else if(c=='[') {
	        	stack.push(']');
	        	}
	        else if(c=='{') {
	        	stack.push('}');
	        	}
	        else if(stack.isEmpty()||c!=stack.pop()) {//���ջΪ�ջ��ʱ����Ԫ�ز���ջ��Ԫ��ʱ����������ƥ�������ʱ������false
	        	
	        return false;
	        }
	    }
	    return stack.isEmpty();//����ж�ջ�Ƿ�Ϊ�ա�

}


}
