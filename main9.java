package leetcode1;

public class main9 {

	public static void main(String[] args) {//9.回文数
		int num =121;//测试用例
	
	

	}
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
		 
		
		

    }

}
