/*
- Fruit Into Baskets
- https://leetcode.com/problems/fruit-into-baskets/
- Time Complexity : O(n2)
- Ranking : faster than 5.02%
- Key Point
1. 길이가 3 이상이고 마지막과 그 직전 값이 다르면 마지막 index부터 보면 된다.
*/

package com.leetcode.problem14;

public class Solution14 {
	public int totalFruit(int[] tree) {
		int totalCount = 0;
		int bucketA = -1;
		int bucketB = -1;

		for (int startIndex = 0; startIndex < tree.length; startIndex ++) {
			bucketA = tree[startIndex];
			int tmpCount = 1;

			for (int movingIndex = startIndex + 1; movingIndex < tree.length; movingIndex ++) {
				int newFruit = tree[movingIndex];

				if (newFruit == bucketA || newFruit == bucketB) {
					tmpCount ++;
				}
				else if (bucketB == -1) {
					bucketB = newFruit;
					tmpCount ++;
				}
				else {
					if (tmpCount > 2 && tree[movingIndex] == tree[movingIndex - 1]) {
						startIndex = movingIndex - 2;
					}

					break;
				}
			}

			if (tmpCount > totalCount) {
				totalCount = tmpCount;
			}

			bucketA = -1;
			bucketB = -1;
		}

		return totalCount;
	}

	public static void main(String[] args) {
		// 1,2,1 / 3
		// 0,1,2,2 / 3
		// 1,2,3,2,2 / 4
		// 3,3,3,1,2,1,1,2,3,3,4 /5
		int[] input = {3,3,3,1,2,1,1,2,3,3,4};

		Solution14 sol = new Solution14();
		System.out.println(sol.totalFruit(input));
	}
}
