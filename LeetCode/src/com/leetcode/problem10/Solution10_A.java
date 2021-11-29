package com.leetcode.problem10;/*
- Merge Sorted Array
- https://leetcode.com/problems/merge-sorted-array/
- Time Complexity : O(n)
- Ranking : faster than 100%
- Key Point
*/

public class Solution10_A {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0) {
			return;
		}

		if (m == 0) {
			for (int i = 0; i < n; i ++) {
				nums1[m] = nums2[i];
				m ++;
			}
		}
		else {
			int indexA = m - 1;
			int indexB = n - 1;

			while (indexB > -1 && indexA > -1) {
				if (nums2[indexB] < nums1[indexA]) {
					nums1[indexA + indexB + 1] = nums1[indexA];
					indexA --;
				}
				else {
					nums1[indexA + indexB + 1] = nums2[indexB];
					indexB --;
				}
			}

			if (indexA < 0) {
				for (int i = 0; i < indexB + 1; i ++){
					nums1[i] = nums2[i];
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution10_A sol = new Solution10_A();

		// m, n은 array에서 실제로 의미있는 값.
		// nums1은 nums2가 들어와야해서 여유롭게 잡아둔 상태. 그래서 쓰레기값이 있음.
		// 1,2,3,0,0,0	2,5,6
		// 1	nothing
		// 2,0	1
		int[] nums1 = {11,21,31,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};
		int n = 3;

		System.out.print("nums1 : ");
		for (int num : nums1) {
			System.out.print(num + " ");
		}

		System.out.println();

		System.out.print("nums2 : ");
		for (int num : nums2) {
			System.out.print(num + " ");
		}

		System.out.println();

		sol.merge(nums1, m, nums2, n);
		System.out.print("merging : ");
		for (int num : nums1) {
			System.out.print(num + " ");
		}
	}
}
