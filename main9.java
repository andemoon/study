package leetcode1;

public class main9 {

	public static void main(String[] args) {//9.������
		int num =121;//��������
	
	

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
				rs=z%10;//rs��¼����
				y=y*10+rs;//y��¼���������x
				z=z/10;//z��ÿ��ѭ����x��һλ�������
				
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
