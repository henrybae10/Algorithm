package com.leetcode.problem5;

/*
- Longest Palindromic Substring
- Time Complexity : O(n2)
- Ranking : faster than 7.74%.
- Test Case : a, aa, aab, abb, baba, cababaa, babad, acbcbcc, abcdbbfcba, abcbad, aabcbaaad
(1) "tattarrattat" 이런 것도 가능... > output > "tattarrattat" > "tattar rattat" 이렇게 분리.
(2) tarrat, tabbbbbbat
- Golden Rule
(1) str[i] == str[j] && array[i+1][j-1] == true. >> 이전 sub str이 palidromic이라는 뜻임.
(2) i+1, j-1 에 대한 검색이 이미 돼있어야 함. array로 따지면 대각선. 즉, 저 단계부터 시작해서 올라가자.
(3) leng 1일 때와 2일 때는 다른 룰이 필요하다. 2일 때는 대각선 아래로 갈 수가 없기 때
 */
public class Solution5_1 {
	public static void main(String[] args) {
		String input = "acbcbcc";

		System.out.println(getLongestPalindromicSubstring(input));
	}

	public static String getLongestPalindromicSubstring(String input) {
		int lengOfInput = input.length();
		if (lengOfInput < 1 || input == null) return "";

		Boolean[][] palidromicInfo = new Boolean[lengOfInput][lengOfInput];
		String longestPalindromicSubstring = Character.toString(input.charAt(0));

		for (int i = 0; i < lengOfInput; i ++) {
			palidromicInfo[i][i] = true;
		}

		for (int i = 0; i < lengOfInput - 1; i ++) {
				String firstChar = Character.toString(input.charAt(i));
				String lastChar = Character.toString(input.charAt(i + 1));

				if (firstChar.equals(lastChar)) {
					palidromicInfo[i][i + 1] = true;

					if (input.substring(i, i + 2).length() > longestPalindromicSubstring.length()) {
						longestPalindromicSubstring = input.substring(i, i + 2);
					}
				}
				else {
					palidromicInfo[i][i + 1] = false;
				}
		}

		for (int lengOfSubStr = 3; lengOfSubStr < lengOfInput + 1; lengOfSubStr ++) {
			for (int firstIndex = 0; firstIndex < lengOfInput; firstIndex ++) {
				int lastIndex = firstIndex + lengOfSubStr - 1;

				if (lastIndex > lengOfInput - 1) {
					break;
				}

				String firstChar = Character.toString(input.charAt(firstIndex));
				String lastChar = Character.toString(input.charAt(lastIndex));

				if (firstChar.equals(lastChar) && palidromicInfo[firstIndex + 1][lastIndex - 1]) {
					palidromicInfo[firstIndex][lastIndex] = true;

					if (input.substring(firstIndex, lastIndex + 1).length() > longestPalindromicSubstring.length()){
						longestPalindromicSubstring = input.substring(firstIndex, lastIndex + 1);
					}
				}
				else {
					palidromicInfo[firstIndex][lastIndex] = false;
				}
			}
		}

		return longestPalindromicSubstring;
	}
}
