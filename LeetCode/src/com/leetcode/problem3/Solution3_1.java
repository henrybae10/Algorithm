package com.leetcode.problem3;

import java.util.HashMap;

class Solution3_1 {
	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		int stringLength = s.length();
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0,  j = 0; j < stringLength; j ++ ) {
			Character character = s.charAt(j);
			if (map.containsKey(character)) {
				int previousIndex = map.get(character);
				// 현재 i가 중복 index 보다 크면 이미 여기에 대한 중복은 체크했으므로 index는 그대로 사용하면 된다.
				// 중복 index가 i보다 큰 경우는 중복 index 다음부터 길이를 계산해야 하는게 맞기에 +1. 왜냐하면 j와 i 사이에 어떤 중복도 없었다는 뜻이라서 중복 index 다음부터 j까지가 sub string의 길이다.
				if (i <= previousIndex) i = previousIndex + 1;
			}

			map.put(character, j);
			// 처음은 0, 0이니깐 +1 해줘야 한다.
			result = Math.max(result, j - i + 1);
		}

		return result;
	}
}
