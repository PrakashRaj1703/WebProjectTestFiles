package org.javaprograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Day17 {
	private void tc1() {
		int a = 100;
		int b = 50;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a);
		System.out.println(b);
	}

	private void tc2() {
		int a = 500;
		int b = 100;
		int c = 0;
		c = a;
		a = b;
		b = c;
		System.out.println(a);
		System.out.println(b);
	}

	private void fibbonaci() {
		int a = 0;
		int b = 0;
		int c = 1;
		for (int i = 0; i < 7; i++) {
			System.out.println(a);
			a = b + c;
			b = c;
			c = a;
		}
	}

	private void stringRev() {
		String s = "testOneDay";
		String s1 = "";
		int le = s.length();
		for (int i = le - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			s1 += ch;
		}
		System.out.println(s1);
	}

	private void stringBuilderRev() {
		String s = "testOneDay";
		StringBuilder s1 = new StringBuilder(s);
		System.out.println(s1.reverse());

	}

	private void stringExtracter() {
		String s = "Prakash Rajendran@123!#$";
		String lw = s.toLowerCase().replace(" ", "");
		String s1 = "";
		String s2 = "";
		String s3 = "";
		for (char ch : lw.toCharArray()) {
			if (Character.isLetter(ch)) {
				s1 += ch;
			} else if (Character.isDigit(ch)) {
				s2 += ch;
			} else {
				s3 += ch;
			}
		}
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

	}

	private void letterCountChecker() {
		String s = "prakashRajendraKavithaRajkumar";
		String lw = s.toLowerCase();
		Map<Character, Integer> mp = new TreeMap<Character, Integer>();
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

	private void sortChat() {
		String s = "prakashRajendraKavithaRajkumar";
		String lw = s.toLowerCase();
		char[] ch = lw.toCharArray();
		Arrays.sort(ch);
		String s1 = new String(ch);
		System.out.println(s1);
	}

	private void duplicateCOunt() {
		int[] a = { 10, 10, 20, 30, 40, 50, 90, 90, 50, 20 };
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int mp : a) {
			map.put(mp, map.getOrDefault(mp, 0) + 1);

		}
		for (int num : map.keySet()) {
			Integer count = map.get(num);
			if (count > 1) {
				for (int i = 0; i < count; i++) {
					System.out.println(num);
				}
			}
		}

	}

	public static void main(String[] args) {
		Day17 d = new Day17();
		d.letterCountChecker();
	}

}
