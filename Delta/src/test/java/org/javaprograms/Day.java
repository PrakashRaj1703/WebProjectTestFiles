package org.javaprograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day {
	
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
		int a = 100;
		int b = 50;
		int c = 0;
		c = a;
		a = b;
		b = c;
		System.out.println(a);
		System.out.println(b);

	}

	private void revInt() {
		int a = 1001;
		int b = 0;
		int c = 0;
		while (a != 0) {
			b = a % 10;
			c = c * 10 + b;
			a = a / 10;
		}
		System.out.println(c);
	}

	private void revString() {
		String s = "PrakashRajendran";
		String lw = s.toLowerCase();
		String s1 = "";
		for (int i = lw.length() - 1; i >= 0; i--) {
			char ch = lw.charAt(i);
			s1 += ch;
		}
		System.out.println(s1);
	}

	private void revSt() {
		String s = "PrakashRajendran";
		String lw = s.toLowerCase();
		StringBuilder s1 = new StringBuilder(lw);
		System.out.println(s1.reverse());
	}

	private void extracter() {
		String s = "PrakashRajendran@123$%^&(456)";
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		StringBuilder s3 = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (Character.isLetter(ch)) {
				s1.append(ch);
			} else if (Character.isDigit(ch)) {
				s2.append(ch);
			} else {
				s3.append(ch);
			}
		}
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

	private void intMap() {
		String s = "PrakashRajendranKavithaRajkumar";
		String lw = s.toLowerCase().replace(" ", "");
		Map<Character, Integer> mp = new HashMap<Character, Integer>();
		for (char ch : lw.toCharArray()) {
			if (mp.containsKey(ch)) {
				mp.put(ch, mp.get(ch) + 1);
			} else {
				mp.put(ch, 1);
			}
		}
		for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
			System.err.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	private void sorttc3() {
		String s = "prakashRajendran";
		String lw = s.toLowerCase();
		char[] ch = lw.toCharArray();
		Arrays.sort(ch);
		String s1 = new String(ch);
		System.out.println(s1);
	}

	private void pattern1() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 6; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println("");
		}
		for (int i = 4; i >= 0; i--) {
			for (int j = 6; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println(" ");
		}
	}
	

	public static void main(String[] args) {
		Day d = new Day();
		d.pattern1();
	}

}
