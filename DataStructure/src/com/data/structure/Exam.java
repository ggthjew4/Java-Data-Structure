package com.data.structure;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Exam {
	// cache
	int[] f = new int[100];

	// 0, 2, 2, 4, 6, 10, 16, 26, 42
	public int calcFibonacci(int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1) {
			return 0;
		}
		if (i == 2) {
			return 2;
		}
		// speed up
		if (f[i] != 0) {
			return f[i];
		}
		f[i] = calcFibonacci(i - 1) + calcFibonacci(i - 2);
		return f[i];
	}

	public void test() {
		final String[] words = new String[] { "AA", "CC", "BB", "BB", "CC",
				"CC" };
		final Map<String, Integer> m = new TreeMap<String, Integer>(
				new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						return o2.compareTo(o1);
					}
				});
		for (int i = 0; i < words.length; i++) {
			Integer freq = m.get(words[i]);
			m.put(words[i], (freq == null) ? 1 : freq + 1);
		}
		for (String key : m.keySet()) {
			System.out.println(String.format("%s %s", key, m.get(key)));
		}

	}

	public final static void main(final String[] arg) {
		System.out.print(new Exam().calcFibonacci(6));
	}
}
