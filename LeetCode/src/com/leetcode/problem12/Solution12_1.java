/*
- Subarray Product Less Than K
- https://leetcode.com/problems/subarray-product-less-than-k/
- Time Complexity : O(n2)
- Ranking : faster than %
- Key Point
*/

// Time Limit Exceeded
package com.leetcode.problem12;

public class Solution12_1 {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int satisfiedCombination = 0;
		int lengOfInput = nums.length;
		int[] productResult = new int[lengOfInput];

		// 1개의 원소
		for (int i = 0; i < lengOfInput; i ++) {
			int currentValue = nums[i];
			productResult[i] = currentValue;

			if (currentValue < k) {
				satisfiedCombination ++;
			}
		}

		for (int i = lengOfInput - 2; i > -1; i --) {
			for (int j = i + 1; j < lengOfInput; j ++) {
				int operandA = nums[i];
				int operandB = productResult[j];
				int result = operandA * operandB;
				productResult[j] = result;

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
		Solution12_1 sol = new Solution12_1();

		// 10, 5, 2, 6 /100 > 8 / (10,2)는 연속되지 않아서 조건에 어긋난다.
		// 1,1,1 /1 > 0
		int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
		int k = 19;

		System.out.println(sol.numSubarrayProductLessThanK(nums, k));
	}
}
