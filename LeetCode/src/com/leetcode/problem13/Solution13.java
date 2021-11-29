/*
- Longest Mountain in Array
- https://leetcode.com/problems/longest-mountain-in-array/
- Time Complexity : O(n)
- Ranking : faster than 99.35%
- Key Point
1. 시작 다음 값이 바로 작아지면 산이 아님.
2. mountain은 대칭이 아니여도 된다.
3. 0[12310] 같은 경우도 있다
*/

package com.leetcode.problem13;

public class Solution13 {
	public int longestMountain(int[] A) {
		if (A.length < 3) return 0;

		int lengOflongestMountain = 0;
		int startIndex = 0;
		boolean up = false;
		boolean down = false;

		for (int i = 0; i < A.length; i ++) {
			if (up) {
				if (A[i] < A[i - 1] && startIndex != i - 1) {
					up = false;
					down = true;

					if (i == A.length - 1) {
						int leng = i - startIndex + 1;

						if (leng > lengOflongestMountain) {
							lengOflongestMountain = leng;
						}

						break;
					}
				}
				else if (A[i] == A[i - 1] || (A[i] < A[i - 1])) {
					startIndex = i;
				}
			}
			else if (down) {
				if (A[i] >= A[i - 1]) {
					int leng = i - startIndex;

					if (leng > lengOflongestMountain) {
						lengOflongestMountain = leng;
					}

					if (A[i] == A[i - 1]) {
						startIndex = i;
					}
					else {
						startIndex = i - 1;
					}

					up = true;
					down = false;
				}
				else if (i == A.length - 1) {
					int leng = i - startIndex + 1;

					if (leng > lengOflongestMountain) {
						lengOflongestMountain = leng;
					}

					break;
				}
			}
			else {
				up = true;
				startIndex = i;
			}
		}

		return lengOflongestMountain;
	}

	public static void main(String[] args) {
		Solution13 sol = new Solution13();

		// 2,1,4,7,3,2,5 > 5
		// 2,2,2 >> 0
		// 0,1,2,3,4,5,4,3,2,1,0 >> 11
		// 0,1,2,3,1,0 >> 6
		// 0,1,0 >> 3
		// 3,3,1 >> 0
		// 0,1,0,1 >> 3
		// 9,8,7,6,5,4,3,2,1,0 >> 0
		// 4,2,9,8,0 >> 4
		// 875,884,239,731,723,685 >> 4
		int[] input = {875,884,239,731,723,685};
		System.out.println(sol.longestMountain(input));
	}
}
