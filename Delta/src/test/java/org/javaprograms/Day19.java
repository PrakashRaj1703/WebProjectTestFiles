package org.javaprograms;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Day19 {
	private void tc1() {
		String s = "prakashRajendranKavithaRajkumar";
		String lw = s.toLowerCase();
		Map<Character, Integer> mp = new HashMap<Character, Integer>();
		for (char ch : lw.toCharArray()) {
			if (mp.containsKey(ch)) {
				mp.put(ch, mp.get(ch) + 1);
			} else {
				mp.put(ch, 1);
			}
		}
		for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	private void tc2() {
		int[] a = { 10, 20, 30, 40, 50, 60, 50, 40, 10, 60, 10 };
		Map<Integer, Integer> mp = new TreeMap<Integer, Integer>();

		for (int in : a) {
			mp.put(in, mp.getOrDefault(in, 0) + 1);
		}
		for (int num : mp.keySet()) {
			Integer count = mp.get(num);
			if (count > 1) {
				for (int i = 0; i < count; i++) {
					System.out.println(num);
				}
			}
		}

	}

	public static void main(String[] args) {
		Day19 d = new Day19();
		d.tc2();

	}

}
