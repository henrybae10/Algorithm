package com.leetcode.problem5;

/*
- Longest Palindromic Substring
- Time Complexity : O(n3)
- Ranking : 시간이 오래 걸려서 안 돌아감.
- Test Case : a, aa, aab, abb, baba, cababaa, babad, acbcbcc, abcdbbfcba, abcbad, aabcbaaad
(1) "tattarrattat" 이런 것도 가능... > output > "tattarrattat" > "tattar rattat" 이렇게 분리.
(2) tarrat, tabbbbbbat
 */
public class Solution5 {
	public static void main(String[] args) {
		String input = "tabbbbbbat";

		System.out.println(getLongestPalindromicSubstring(input));
	}

	public static String getLongestPalindromicSubstring(String input) {
		int lengOfInput = input.length();
		if (lengOfInput < 1 || input == null) return "";

		String logestPalindromicSubstring = Character.toString(input.charAt(0));

		for (int i = 0; i < input.length(); i ++) {
			for (int j = i + 1; j < input.length(); j ++) {
				String subStr = input.substring(i, j + 1);
				if (isPalidromic(subStr)) {
					if (subStr.length() > logestPalindromicSubstring.length()) {
						logestPalindromicSubstring = subStr;
					}
				}
			}
		}

		return logestPalindromicSubstring;
	}

	private static boolean isPalidromic(String input) {
		// Palidromic인 것을 판단하려면 중간까지만 확인하면 된다.
		// 홀수일 경우라도 가장 중간 값은 볼 필요 없이 대칭되는 나머지 요소들만 같은지 확인하면 된다.
		for (int i = 0; i < input.length()/2; i ++) {
			String leftSideStr = Character.toString(input.charAt(i));

			int rightSideIndex = input.length() - 1 - i;
			String rightSideStr = Character.toString(input.charAt(rightSideIndex));

			if (!leftSideStr.equals(rightSideStr)) {
				return false;
			}
		}

		return true;
	}

}
