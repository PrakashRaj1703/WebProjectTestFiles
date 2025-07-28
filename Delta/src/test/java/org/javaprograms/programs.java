package org.javaprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class programs {
	private void tc1() {
		String s = "Prakash Rajendran";
		String re = s.toLowerCase().replace(" ", "");
		Map<Character, Integer> mf = new HashMap<Character, Integer>();
		for (char ch : re.toCharArray()) {
			if (mf.containsKey(ch)) {
				mf.put(ch, mf.get(ch) + 1);
			} else {
				mf.put(ch, 1);
			}
		}
		for (Map.Entry<Character, Integer> entry : mf.entrySet()) {
			System.err.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	private void tc2() {
		String s = "Prakash Rajendra";
		String re = s.toLowerCase().replace(" ", "");
		char[] ch = re.toCharArray();
		Arrays.sort(ch);
		String s1 = new String(ch);
		System.out.println(s1);
	}

	private void stringtc3() {
		String s = "PrakashRajendranKavithaRajkumar@123-#1$%&";
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
		System.out.println(s1 + "\n" + "\t" + s2 + "\n" + "\t" + s3);
		/*
		 * System.out.println(s2); System.out.println(s3);
		 */
	}

	private void patterntc4() {
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
		for (int i = 4; i >= 1; i--) {
			for (int j = 6; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println("");
		}
	}

	private void pattern2() {
		for (int i = 5; i >= 1; i--) {
			for (int j = 6; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}
			System.out.println("");
		}
		for (int i = 2; i <= 5; i++) {
			for (int j = 6; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}
			System.out.println("");
		}
	}

	private void pattern3() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 6; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println(" ");
		}
		for (int i = 4; i >= 1; i--) {
			for (int j = 6; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}
			System.out.println(" ");
		}
	}

	private void tc10() {
		int[] a = { 10, 20, 40, 1, 5, 13, 15 };
		Set<Integer> in = new HashSet<Integer>();
		for (int i = a.length - 1; i >= 0; i--) {
			in.add(a[i]);
		}
		System.out.println(in);
	}

	private void tc11() {
		List<Integer> li = new ArrayList<Integer>();
		li.add(10);
		li.add(20);
		li.add(30);
		li.add(40);
		li.add(50);
		li.add(60);
		li.add(20);
		li.add(30);
		li.add(40);
		int le = li.size();
		for (int i = 0; i < le; i++) {
			for (int j = i + 1; j < le; j++) {
				if (li.get(i) == li.get(j)) {
					li.remove(i);
					i = 0;
					j = 0;
					le -= 1;
				}

			}
		}
		System.out.println(li);

	}

	public static void main(String[] args) {
		programs p = new programs();
		p.tc1();
	}
}
