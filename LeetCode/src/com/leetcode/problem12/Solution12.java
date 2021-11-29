/*
- Subarray Product Less Than K
- https://leetcode.com/problems/subarray-product-less-than-k/
- Time Complexity : O(n2)
- Ranking : faster than %
- Key Point
*/

// Memory Limit Exceeded가 발생해서 안 돌아간다. (nums leng은 5만까지 가능)
package com.leetcode.problem12;

public class Solution12 {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int satisfiedCombination = 0;
		int lengOfInput = nums.length;
		int[][] productResult = new int[lengOfInput][lengOfInput];

		// 1개의 원소
		for (int i = 0; i < lengOfInput; i ++) {
			productResult[i][i] = nums[i];

			if (nums[i] < k) {
				satisfiedCombination ++;
			}
		}

		for (int i = lengOfInput - 2; i > -1; i --) {
			for (int j = i + 1; j < lengOfInput; j ++) {
				int operandA = nums[i];
				int operandB = productResult[i+1][j];
				int result = operandA * operandB;
				productResult[i][j] = result;

				if (result >= k || result == 0) {
					break;
				}
				else {
					satisfiedCombination ++;
				}
			}
		}

		return satisfiedCombination;
	}

	public static void main(String[] args) {
		Solution12 sol = new Solution12();

		// 10, 5, 2, 6 /100 > 8 / (10,2)는 연속되지 않아서 조건에 어긋난다.
		// 1,1,1 /1 > 0
		int[] nums = {10, 5, 2, 6};
		int k = 10;

		System.out.println(sol.numSubarrayProductLessThanK(nums, k));
	}
}
