package leetcode1;

import java.util.Arrays;
import java.util.HashSet;

public class main349 {

	public static void main(String[] args) {//349.两个数组的交集
		int nums1[]= {1,1,2,2};
		int nums2[]= {2,2};//测试数组
		
		intersection(nums1, nums2);
		}

	}
	
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
    	
    

}
