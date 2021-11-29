package com.leetcode.problem3;/*
3. Longest Substring Without Repeating Characters
아주 느림. (하위 8%)S
 */

import java.util.HashMap;

public class Solution3 {
	public static void main(String []args){
		String s = " ";
		int startPoint = 0;
		HashMap<String, Integer> map = new HashMap<>();
		int longestLength = 0;

		for (int i = startPoint ; i < s.length() ; i ++) {
			String charFromString = s.substring(i, i + 1);
			if (map.containsKey(charFromString)) {
				i = startPoint ++;
				map.clear();

				continue;
			}

			map.put(charFromString, i);

			int mapSize = map.size();
			if (mapSize > longestLength) {
				longestLength = mapSize;
			}
		}

		int result = longestLength;
	}
}
