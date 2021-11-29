package com.leetcode.imarket;

// imarket
public class test {
	public static void main(String[] args) {
		String input = "qyyigoptvfb";
		String key = "abcdefghijk";
		int ro = 3;

		String a = restore(input, ro);
		String ans = decrypta(a, key);

		System.out.println(ans);
	}

	private static String decrypta(String a, String key) {
		String ans = "";

		for (int i = 0; i < key.length(); i ++) {
			int diff = ((int)key.charAt(i)) - 96;

			char word = a.charAt(i);
			int wordAscii = (int)word;

			int originAs = wordAscii - diff;
			if (originAs < 97) {
				originAs += 26;
			}

			ans += Character.toString((char)originAs);

		}
		return ans;
	}

	private static String restore(String input, int ro) {
		String origin ="";

		origin = input.substring(ro, input.length());
		origin += input.substring(0,ro);

		return origin;
	}
}
