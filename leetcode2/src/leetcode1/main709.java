package leetcode1;

public class main709 {

	public static void main(String[] args) {
		
		String wordString;//≤‚ ‘”√¿˝

		
		
	}
	
	 public String toLowerCase(String s) {
	        char[] c = s.toCharArray();
	        
	        for(int i = 0; i < c.length; i++) {
	            if(c[i] >= 'A' && c[i] <= 'Z') {
	                c[i] = (char)(c[i] - 'A' + 'a');
	            }
	        }
	        return String.valueOf(c);
	    }

}
