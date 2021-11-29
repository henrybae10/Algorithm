package com.leetcode.problem9;/*
- Remove Duplicates from Sorted Array II
- https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
- Time Complexity : O(n)
- Ranking : faster than 70%
- Key Point
*/

public class Solution9_1 {
	public int removeDuplicates(int[] nums) {
		int lengOfdefinedArray = 1;
		int currentIndex = 0;

		for (int currentValue : nums) {
			if (currentIndex < 2 || currentValue > nums[currentIndex - 2]) {
				nums[currentIndex++] = currentValue;
				lengOfdefinedArray = currentIndex;
			}
		}

		return lengOfdefinedArray;
	}

	public static void main(String[] args) {
		Solution9_1 sol = new Solution9_1();
		// 1,1,1
		// 0,0,1,1,1,1,2,3,3,3
		int[] a = {0,0,1,1,1,1,2,3,3,3};
		int result = sol.removeDuplicates(a);

		for (int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + " ");
		}

		System.out.println();

		for (int i = 0; i < result; i ++) {
			System.out.print(a[i] + " ");
		}
	}
}
