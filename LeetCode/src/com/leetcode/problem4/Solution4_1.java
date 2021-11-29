package com.leetcode.problem4;

import java.util.stream.IntStream;

/*
- Median of Two Sorted Arrays
- Time Complexity : O(log(n))
- Ranking : faster than 99.97%
 */
public class Solution4_1 {
	public static void main(String []args){
		int[] nums1 = {11,12};
		int[] nums2 = {8, 9,10};

		if (nums1.length > nums2.length) {
			printMedian(nums2, nums1);
		}

		printMedian(nums1, nums2);
	}

	public static void printMedian(int[] a, int[] b) {
		int totalCount = a.length + b.length;

		int aStart = 0;
		int aEnd = a.length;

		while (true) {
			// Current Index 부터는 Array 중간의 오른쪽 영역에 해당한다.
			int currentIndexA = (aStart + aEnd) / 2;
			int currentIndexB = ((totalCount + 1) / 2) - currentIndexA;

			// currentIndexA는 오른쪽 영역이므로 0인 경우 왼쪽 영역에는 값이 없다는 것을 의미한다.
			boolean hasLeftSideOfA = (currentIndexA != 0);
			// maxLeftSideOfA와 비교하는 대상은 minRightSideOfB이다.
			// A가 없다면 B가 항상 커야하므로 A는 -무한대 값.
			double maxLeftSideOfA = Double.NEGATIVE_INFINITY;

			if (hasLeftSideOfA) {
				maxLeftSideOfA = a[currentIndexA - 1];
			}

			// 오른쪽 영역의 Index인 currentIndexA가 a.length까지 올라가면 오른쪽이 존재하지 않는 것이다.
			boolean hasRightSideOfA = (currentIndexA != a.length);
			// minRightSideOfA와 비교하는 대상은 maxLeftSideOfB이다.
			// A가 없다면 B가 작아야하므로 A는 무한대 값.
			double minRightSideOfA = Double.POSITIVE_INFINITY;

			if (hasRightSideOfA) {
				minRightSideOfA = a[currentIndexA];
			}

			boolean hasLeftSideOfB = (currentIndexB != 0);
			double maxLeftSideOfB = Double.NEGATIVE_INFINITY;

			if (hasLeftSideOfB) {
				maxLeftSideOfB = b[currentIndexB - 1];
			}

			boolean hasRightSideOfB = (currentIndexB != b.length);
			double minRightSideOfB = Double.POSITIVE_INFINITY;

			if (hasRightSideOfB) {
				minRightSideOfB = b[currentIndexB];
			}

			if (maxLeftSideOfA <= minRightSideOfB && minRightSideOfA >= maxLeftSideOfB) {
				if (totalCount % 2 == 0) {
					double maxLeftSideOfMergedArray = Math.max(maxLeftSideOfA, maxLeftSideOfB);
					double minRightSideOfMergedArray = Math.min(minRightSideOfA, minRightSideOfB);
					double medianOfMergedArray = (maxLeftSideOfMergedArray + minRightSideOfMergedArray) / 2;

					System.out.println(medianOfMergedArray);
				}
				else {
					double medianOfMergedArray = Math.max(maxLeftSideOfA, maxLeftSideOfB);
					System.out.println(medianOfMergedArray);
				}
				break;
			}
			else if (maxLeftSideOfA > minRightSideOfB) {
				// Left의 A 값이 더 크므로 A가 오른쪽으로 이동해야한다. 그러기 위해 aEnd를 감소시킨다.
				// 여기서는 currentIndexA에 -1하나 안 하나 큰 차이 없음.
				aEnd = currentIndexA;
			}
			else {
				// currentIndexA가 0일 때를 막기 위해 +1을 해준다.
				aStart = currentIndexA + 1;
			}
		}
	}
}