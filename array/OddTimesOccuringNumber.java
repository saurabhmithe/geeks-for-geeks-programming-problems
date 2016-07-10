package com.gfg.array;

import java.util.Hashtable;
import java.util.Scanner;

public class OddTimesOccuringNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int numberOfElements = scanner.nextInt();
			int[] array = new int[numberOfElements];
			for (int j = 0; j < numberOfElements; j++) {
				array[j] = scanner.nextInt();
			}

			Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
			for (int j = 0; j < numberOfElements; j++) {
				int num = array[j];
				if (hashtable.containsKey(num)) {
					hashtable.put(num, hashtable.get(num) + 1);
				} else {
					hashtable.put(num, 1);
				}
			}
			for (Integer integer : hashtable.keySet()) {
				if (hashtable.get(integer) % 2 != 0) {
					System.out.println(integer);
					break;
				}
			}
		}

		scanner.close();
	}
}
