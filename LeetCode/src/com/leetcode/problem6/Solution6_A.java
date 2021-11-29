package com.leetcode.problem6;

/*
- ZigZag Conversion
- Time Complexity : O(n)
- Ranking : faster than %
- Golden Rule
 */
public class Solution6_A {
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

		return result;
	}
}
