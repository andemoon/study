package leetcode1;

import java.util.Arrays;
import java.util.HashSet;

public class main349 {

	public static void main(String[] args) {//349.��������Ľ���
		int nums1[]= {1,1,2,2};
		int nums2[]= {2,2};//��������
		
		intersection(nums1, nums2);
		}

	}
	
    public static int[] intersection(int[] nums1, int[] nums2) {
    	
    	HashSet<Integer> nums = new HashSet<>();//new hashset
    	
    	int num1[];
    	int num2[];
    	
    	if(nums1.length>nums2.length) //�Ƚ��������鳤�ȣ��ҳ�����С���Ǹ�������Ϊforѭ������㡣
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
   
    	
    	int num[] = new int[nums.size()];//new��hashset����һ�µ�����
    	int j =0;
    	for (int i : nums) {//foreachѭ����hashset��Ԫ�طŵ����ص�������ȥ��
			num[j++]=i;
			
		}
    	return num;
		}
    	
    

}
