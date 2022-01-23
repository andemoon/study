package leetcode1;

public class main3 {

	public static void main(String[] args) {//3. 无重复字符的最长子串
	

	}
	
	 public int lengthOfLongestSubstring(String s) {
		 char[] arr=s.toCharArray();
		        int start=0;
		        int end=0;
		        int max=0;
		        Map map=new HashMap();
		        for(int i=0;i<arr.length;i++){
		            end++;
		            if(map.get(arr[i])!=null) {
		                start = Math.max((int) map.get(arr[i]) + 1, start);
		            }
		            max=Math.max(end-start,max);
		            map.put(arr[i],i);
		        }
		        return max;
		    }

}
