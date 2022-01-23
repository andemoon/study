package leetcode1;

public class main1332 {

	public static void main(String[] args) {//
		// TODO Auto-generated method stub

	}
	 public int removePalindromeSub(String s) {
		 
		 
		 
	        if (isPalindrome(s)) {
	            return 1;
	        } else {
	            return 2;
	        }
	    }

	    private boolean isPalindrome(String s) {
	        int l = 0;
	        int r = s.length()-1;
	        while (l <= r) {
	            if (s.charAt(l) != s.charAt(r)) {
	                return false;
	            }
	            l++;
	            r--;
	        }
	        return true;
	    }

}
