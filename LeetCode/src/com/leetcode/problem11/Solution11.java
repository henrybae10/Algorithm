package com.leetcode.problem11;/*
- Circular Array Loop
- https://leetcode.com/problems/circular-array-loop/
- Time Complexity : O(n2)
- Ranking : faster than 60%
- Key Point
*/

import java.util.HashSet;

public class Solution11 {
	public boolean circularArrayLoop(int[] nums) {
		int lengOfInput = nums.length;
		if (lengOfInput < 2) return false;
		HashSet<Integer> totalVisited = new HashSet<>();

		for (int i = 0; i < lengOfInput; i ++) {
			if (totalVisited.contains((Integer) i)) {
				continue;
			}

			totalVisited.add(i);

			int previousIndex = 0;
			int currentIndex = i;
			int nextIndex = 0;
			boolean isSameDirection = true;
			HashSet<Integer> cycle = new HashSet<>();

			while (!cycle.contains((Integer) currentIndex)) {
				totalVisited.add(currentIndex);

				int currentValue = nums[currentIndex];
				cycle.add(currentIndex);
				previousIndex = currentIndex;

				nextIndex = getNextIndex(currentIndex, currentValue, lengOfInput);

				if (!isSameDirection(currentValue, nums[nextIndex])) {
					isSameDirection = false;
					break;
				}

				currentIndex = nextIndex;
			}

			if (isSameDirection && currentIndex != previousIndex && cycle.size() > 1) {
				return true;
			}
		}

		return false;
	}

	private boolean isSameDirection(int previousValue, int currentValue) {
		if (previousValue * currentValue > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	private int getNextIndex(int currentIndex, int value ,int lengOfArray) {
		int nextIndex = 0;

		int remainder = (currentIndex + value) % lengOfArray;
		nextIndex = (remainder + lengOfArray) % lengOfArray;

		return nextIndex;
	}

	public static void main(String[] args) {
		Solution11 sol = new Solution11();

		// 2,-1,1,2,2 (true) // -1,2 false // -2,1,-1,-2,-2 false // 2,1,1,2,2 // 3 1 2
		// 1,-1,1,-1,2,6,6 (true) // -1,-2,-3,-4,-5 false
		int[] nums = {-1,-2,-3,-4,-5};

		System.out.println(sol.circularArrayLoop(nums));
	}
}