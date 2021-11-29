/*
- Subarray Product Less Than K
- https://leetcode.com/problems/subarray-product-less-than-k/
- Time Complexity : O(n2)
- Ranking : faster than 100%
- Key Point
1. 배열에 결과를 저장하는 방식을 사용하면 배열에 결과 값을 채워줘야해서 o(n)이 무조건 추가로 소요된다.
그래서 10*5*2가 k보다 작음을 알아내도 값이 5인 row로 바로 넘어가지 못 하는 문제가 있다. > 이 방법은 피한다.
2. 곱셈 결과값이 int를 초과할 수 있다. 이래서 Index 0부터 올라가는게 낫다.
*/

package com.leetcode.problem12;

public class Solution12_2 {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int lengOfInput = nums.length;
		if (lengOfInput == 0 || k <= 1) {
			return 0;
		}

		int left = 0;
		int right = 0;

		int satifiedCount = 0;
		int currVal = 1;

		while (right < lengOfInput){
			currVal *= nums[right];
			right++;

			while (left < lengOfInput && currVal >= k) {
				currVal /= nums[left];
				left++;
			}

			satifiedCount += right - left;
		}

		return satifiedCount;
	}

	public static void main(String[] args) {
		Solution12_2 sol = new Solution12_2();

		// 10, 5, 2, 6 /100 > 8 / (10,2)는 연속되지 않아서 조건에 어긋난다.
		// 1,1,1 /1 > 0
		// 10,9,10,4,3,8,3,3,6,2,10,10,9,3  19 > 18
		int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
		int k = 19;

		System.out.println(sol.numSubarrayProductLessThanK(nums, k));
	}
}
