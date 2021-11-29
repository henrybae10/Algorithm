package com.leetcode.problem10;/*
- Merge Sorted Array
- https://leetcode.com/problems/merge-sorted-array/
- Time Complexity : O(n)
- Ranking : faster than 100%
- Key Point
*/

public class Solution10 {
	public static void main(String[] args) {
		Solution10 sol = new Solution10();

		// m, n은 array에서 실제로 의미있는 값.
		// nums1은 nums2가 들어와야해서 여유롭게 잡아둔 상태. 그래서 쓰레기값이 있음.
		// 1,2,3,0,0,0	2,5,6
		// 1	nothing
		// 2,0	1
		int[] nums1 = {2,0};
		int m = 1;
		int[] nums2 = {1};
		int n = 1;

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

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0) {
			return;
		}

		int indexA = 0;
		int indexB = 0;
		int indexC = 0;
		int[] mergedArray = new int[nums1.length];

		while (indexA < m && indexB < n) {
			if (nums1[indexA] > nums2[indexB]) {
				mergedArray[indexC] = nums2[indexB];
				indexB ++;
				indexC ++;
			}
			else if (nums1[indexA] <= nums2[indexB]) {
				mergedArray[indexC] = nums1[indexA];
				indexA ++;
				indexC ++;
			}
		}

		if (indexB < n) {
			for (int i = indexB; i < n; i ++) {
				mergedArray[indexC] = nums2[i];
				indexC ++;
			}
		}
		else if (indexA < m) {
			for (int i = indexA; i < m; i ++) {
				mergedArray[indexC] = nums1[i];
				indexC ++;
			}
		}

		int index = 0;
		for (int num : mergedArray) {
			nums1[index++] = num;
		}
	}
}
