 package leetcode1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main { //1.两数之和

	public static void main(String[] args) {
		
		List<Integer> numitems = new ArrayList<>();
		
		Scanner text = new Scanner(System.in);
		int numtext;
		int target;
		
		while (true) {//由集合添加元素
			numtext = text.nextInt();
			if(numtext ==0)
			{
				break;	
			}
			numitems.add(numtext);
			
		}
		
		System.out.println(numitems.toString());
		int[] nums = new int[numitems.size()];//集合转数组
		for(int i = 0;i<numitems.size();i++)
		{
			nums[i] = numitems.get(i);
		}
		
	target =text.nextInt();
//	System.out.println(target);
	
	
	int[]item = twoSum1(nums, target);
		for (int i : item) {
			System.out.print(i+",");
		}
		
		
	}
	
	
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
 
 public static int[] twoSum2(int[] nums, int target) {
	 
	 

 	

return null;
 }
}





