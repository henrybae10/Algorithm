package com.leetcode.problem6;

import java.util.Base64;

/*
- ZigZag Conversion
- Time Complexity : O(n)
- Ranking : faster than 38.56%
- Golden Rule
(1) 양 끝은 2 * (row - 1) 만큼의 index 간격이 생긴다.
(2) 양 끝을 제외하면 일정한 규칙이 있다.
(3) (1)의 간격 - (2 * currentRowNum)과 (1)의 간격 - (3)의 간격이 반복적으로 간격으로 적용된다.
 */
public class Solution6 {
	public static void main(String[] args) {
		String input = "PAYPALISHIRING";
		int numRows = 3;
		String expectedOutput = "PAHNAPLSIIGYIR";

		System.out.println("-Input \t\t\t: " + input);
		System.out.println("-ExpectedOutput : " + expectedOutput);
		String result = convert(input, numRows);
		System.out.println("-Result \t\t: " + result);
		System.out.println(expectedOutput.equals(result));
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1) return s;

		String result = "";
		int baseGap = 2 * (numRows - 1);

		for (int i = 0; i < numRows; i ++) {
			int index = i;
			boolean isOddElementOfTmp = true;
			int gap = baseGap - 2 * i;

			while (index < s.length()) {
				String tmpStr = Character.toString(s.charAt(index));
				result = result + tmpStr;

				if (i != 0 && i != (numRows - 1)) {
					if (isOddElementOfTmp) {
						index = index + gap;
						isOddElementOfTmp = false;
					}
					else {
						index = index + baseGap - gap ;
						isOddElementOfTmp = true;
					}
				}
				else {
					index = index + baseGap;
				}

			}
		}

		return result;
	}
}
