package com.leetcode.problem4;

/*
- Median of Two Sorted Arrays
- Time Complexity : O(n)
- Ranking : faster than 99.97%
 */
public class Solution4 {
	public static void main(String []args){
		int[] nums1 = {1, 2};
		int[] nums2 = {3};

		int lengOf1 = nums1.length;
		int lengOf2 = nums2.length;
		int totalLeng = (lengOf1 + lengOf2);
		int[] mergeArray = new int[totalLeng];

		int mergeArrayIndex = 0;
		for (int i = 0, j = 0; ;) {
			if (i > lengOf1 - 1 && j <= lengOf2 - 1) {
				while(j <= lengOf2 - 1) {
					mergeArray[mergeArrayIndex++] = nums2[j++];
				}

				break;
			}
			else if (i <= lengOf1 - 1 && j > lengOf2 - 1) {
				while (i <= lengOf1 - 1) {
					mergeArray[mergeArrayIndex++] = nums1[i++];
				}

				break;
			}
			else {
				if (nums1[i] > nums2[j]) {
					mergeArray[mergeArrayIndex++] = nums2[j++];
				}
				else {
					mergeArray[mergeArrayIndex++] = nums1[i++];
				}
			}
		}

		int medianIndex = mergeArray.length / 2;
		if (mergeArray.length % 2 == 0) {
			int num1 = mergeArray[medianIndex];
			int num2 = mergeArray[medianIndex - 1];

			System.out.println(((float)(num1 + num2) / 2));
		}
		else {
			System.out.println(mergeArray[medianIndex]);
		}
	}
}