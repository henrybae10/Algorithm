package com.leetcode.problem8;/*
- Sort Colors
- https://leetcode.com/problems/sort-colors/
- Time Complexity : O(n)
- Ranking : faster than 100%
- Key Point
*/

public class Solution8_A {
	public void sortColors(int[] nums) {
		if (nums.length == 0 || nums.length == 1) return;

		int start = 0;
		int end = nums.length - 1;
		int index = 0;

		while (index <= end && start < end) {
			if (nums[index] == 0) {
				nums[index] = nums[start];
				nums[start] = 0;

				start ++;
				index ++;
			}
			else if (nums[index] == 2) {
				nums[index] = nums[end];
				nums[end] = 2;
				end --;
			}
			else {
				index ++;
			}
		}
	}

	public static void main(String[] args) {
		int leng = 6;
		int[] nums = new int[leng];
		nums[0] = 2;
		nums[1] = 0;
		nums[2] = 2;
		nums[3] = 1;
		nums[4] = 1;
		nums[5] = 0;

		for (int i = 0; i < nums.length; i ++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println("\n--------------------------------------------------");

		Solution8 sol = new Solution8();
		sol.sortColors(nums);

		for (int i = 0; i < nums.length; i ++) {
			System.out.print(nums[i] + " ");
		}
	}
}
