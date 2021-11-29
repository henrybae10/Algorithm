package com.leetcode.problem9;/*
- Remove Duplicates from Sorted Array II
- https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
- Time Complexity : O(n2)
- Ranking : faster than 6%
- Key Point
*/

public class Solution9 {
	public int removeDuplicates(int[] nums) {
		int currentValueCount = 1;
		int definedArrayLeng = nums.length;

		for (int i = 1; i < definedArrayLeng; i ++) {
			if (i == definedArrayLeng - 1 || nums[i] != nums[i - 1]) {
				if (i == definedArrayLeng -1 && nums[i] == nums[i - 1]) {
					currentValueCount ++;
				}

				if (currentValueCount > 2) {
					int duplicatedValue = nums[i - 1];

					for (int j = i; j < nums.length; j ++) {
						nums[j - currentValueCount + 2] = nums[j];
					}

					for (int j = 0; j < currentValueCount - 2; j ++) {
						int index = nums.length - 1 - j;
						nums[index] = duplicatedValue;
					}

					i = i - currentValueCount + 2;
					definedArrayLeng = definedArrayLeng - currentValueCount + 2;
				}

				currentValueCount = 1;
			}
			else if (nums[i] == nums[i - 1]) {
				currentValueCount ++;
			}
		}

		return definedArrayLeng;
	}

	public static void main(String[] args) {
		Solution9 sol = new Solution9();
		// 1,1,1
		// 0,0,1,1,1,1,2,3,3,3
		int[] a = {1,1,1};
		int result = sol.removeDuplicates(a);

		for (int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + " ");
		}

		System.out.println("");

		for (int i = 0; i < result; i ++) {
			System.out.print(a[i] + " ");
		}
	}
}
