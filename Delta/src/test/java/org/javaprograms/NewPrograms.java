package org.javaprograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class NewPrograms {
	private void tc1() {

		String s = "PrakashRajendran Tester";
		String tt = s.toLowerCase().replace(" ", "");
		Map<Character, Integer> mp = new TreeMap<Character, Integer>();
		for (Character ch : tt.toCharArray()) {
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
		String s = "PrakashRajendran123@123!#$%^&*";
		String s1 = "";
		String s2 = "";
		String s3 = "";
		for (Character ch : s.toCharArray()) {
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

	private void tc3() {
		String s = "reverse Testing";
		int le = s.length();
		String s1 = "";
		for (int i = le - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			s1 += ch;
		}
		System.out.println(s1);
	}

	private void tc4() {
		String s = "reverse testing";
		StringBuilder s1 = new StringBuilder(s);
		System.out.println(s1.reverse());
	}

	private void tc5() {
		int a = 1221;
		int b = 0;
		int c = 0;
		while (a != 0) {
			b = a % 10;
			c = c * 10 + b;
			a = a / 10;
		}
		System.out.println(c);
	}

	private void tc6() {
		int a = 0;
		int b = 0;
		int c = 1;
		for (int i = 0; i <= 7; i++) {
			System.out.println(a);
			a = b + c;
			b = c;
			c = a;

		}
	}

	private void tc7() {
		int[] a = { 10, 20, 30, 40, 50, 60, 70 };
		int le = a.length;
		int temp = 0;

		for (int i = le - 1; i >= 0; i--) {
			temp += a[i];
		}
		System.out.println(temp);
	}

	private void findmin() {
		int[] a = { 10, 20, 30, 40, 50, 60, 70 };
		int min = a[0];
		int le = a.length;
		for (int i = 0; i <= le - 1; i++) {
			if (min > a[i]) {
				min = a[i];
			}
		}
		System.out.println(min);

	}

	private void findMax() {
		int[] a = { 10, 20, 30, 40, 50, 60, 70 };
		int max = 0;
		int le = a.length;
		for (int i = 0; i <= le - 1; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		System.out.println(max);
	}

	private void minAndMax() {
		int[] a = { 10, 20, 30, 40, 50, 60, 70 };
		int max = 0;
		int min = a[0];
		int le = a.length;
		for (int i = 0; i <= le - 1; i++) {
			if (max < a[i]) {
				min = max;
				max = a[i];
			}
		}
		System.out.println(min);
		System.out.println(max);
	}

	private void removingDuplicate() {
		List<Integer> l = new ArrayList<>();

		l.add(13);
		l.add(15);
		l.add(12);
		l.add(10);
		l.add(25);
		l.add(30);
		l.add(13);
		l.add(15);
		l.add(12);
		l.add(10);
		l.add(25);
		l.add(30);
		System.out.println(l);
		int size = l.size();
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (l.get(i) == l.get(j)) {
					l.remove(i);
					i = 0;
					j = 0;
					size = size - 1;
				}
			}
		}
		System.out.println(l);

	}

	private void removingDuplicate1() {
		
		List<Object> l = new ArrayList<>();

		l.add(13);
		l.add(15);
		l.add(12);
		l.add(10);
		l.add(25);
		l.add(30);
		l.add(13);
		l.add(15);
		l.add(12);
		l.add(10);
		l.add(25);
		l.add(30);
		l.add("test");
		l.add("test");
		l.add("One Test");
		System.out.println(l);
		Set<Object> se = new HashSet<Object>(l);
		System.out.println("Set " + se);
	}

	public static void main(String[] args) {
		NewPrograms n = new NewPrograms();
		n.removingDuplicate1();

	}

}
