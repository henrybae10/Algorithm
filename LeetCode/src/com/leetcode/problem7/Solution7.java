package com.leetcode.problem7;/*
- Reverse Integer
- Time Complexity : O(n)
- Ranking : faster than 100%
- Key Point
(1) Modulo 연산을 활용하여 끝자리부터 reversed int를 만든다.
(2) overflow를 고려해야 한다.
*/

public class Solution7 {
	public static void main(String[] args) {
		//int input = 1534236469;
		int input = -2121232129;

		Solution7 sol = new Solution7();
		System.out.println(sol.reverse(input));
	}

	public int reverse(int x) {
		int reversedInt = 0;
		int baseValue = x;

		while (baseValue != 0) {
			int lastDigitsNum = baseValue % 10;
			baseValue = baseValue / 10;

			if (willBeOverFlowInt(reversedInt, lastDigitsNum)) {
				return 0;
			}

			reversedInt = reversedInt * 10 + lastDigitsNum;
		}

		return reversedInt;
	}

	private boolean willBeOverFlowInt(int reversedInt, int lastDigitsNum) {
		if (reversedInt > (Integer.MAX_VALUE / 10)) {
			return true;
		}
		else if (reversedInt < (Integer.MIN_VALUE / 10)) {
			return true;
		}
		else if (reversedInt == (Integer.MAX_VALUE / 10)) {
			if (lastDigitsNum > (Integer.MAX_VALUE % 10)) {
				return true;
			}
		}
		else if (reversedInt == (Integer.MIN_VALUE / 10)) {
			if (lastDigitsNum < (Integer.MIN_VALUE % 10)) {
				return true;
			}
		}

		return false;
	}
}
