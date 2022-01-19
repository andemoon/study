package leetcode1;

import java.util.Arrays;

public class main88 {

	public static void main(String[] args) {//88.合并两个有序数组
		int nums1[]=new int[6];//创建实例
		for(int i =0;i<3;i++) {
			nums1[i]=i+1;
		}
		int nums2[]= {2,5,6};
		int m = nums1.length;
		int n = nums2.length;
	
		merge(nums1, m, nums2, n);
	}
	
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
		 
		 int j=0;
		
		 for (int i : nums2) //将nums2导入nums1
		 {
			 nums1[m+j]=nums2[j];
			 j++;
		 }
		 
		Arrays.sort(nums1);// api,yyds

		 for (int i : nums1) {
			System.out.print(i);
		}
		 
		 
		
	    }

}
