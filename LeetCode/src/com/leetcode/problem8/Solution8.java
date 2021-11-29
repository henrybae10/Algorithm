package com.leetcode.problem8;/*
- Sort Colors
- https://leetcode.com/problems/sort-colors/
- Time Complexity : O(n)
- Ranking : faster than 100%
- Key Point
*/

public class Solution8 {
	public void sortColors(int[] nums) {
		int numberOfColor = 3;
		// white(0)의 개수는 countOfColors[0]의 값이다.
		int[] countOfColors = new int[numberOfColor];

		for (int i = 0; i < nums.length; i ++) {
			int currentColor = nums[i];
			countOfColors[currentColor] ++;
		}

		// 각 숫자의 시작 Index를 저장한다.
		int[] indexOfColors = new int[numberOfColor];
		for (int i = 0; i < numberOfColor; i ++) {
			if (i + 1 < numberOfColor) {
				indexOfColors[i + 1] = indexOfColors[i] + countOfColors[i];
			}
		}

		for (int i = 0; i < numberOfColor; i ++) {
			int currentIndex = indexOfColors[i];

			if (i + 1 < numberOfColor) {
				int nextColorIndex = indexOfColors[i + 1];

				for (int j = currentIndex; j < nextColorIndex; j ++) {
					nums[j] = i;
				}
			}
			else {
				for (int j = currentIndex; j < nums.length; j ++) {
					nums[j] = i;
				}
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
