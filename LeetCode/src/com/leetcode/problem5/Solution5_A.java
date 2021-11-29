package com.leetcode.problem5;/*
- Longest Palindromic Substring
- Time Complexity : O(n2)
- Ranking : 상위 %
- Test Case : a, aa, aab, abb, baba, cababaa, babad, acbcbcc, abcdbbfcba, abcbad, aabcbaaad
(1) "tattarrattat" 이런 것도 가능... > output > "tattarrattat" > "tattar rattat" 이렇게 분리.
(2) tarrat, tabbbbbbat
 */

public class Solution5_A {
	public static void main(String[] args) {
		String input = "cababaa";

		System.out.println(longestPalindrome(input));
	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1) return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
}
