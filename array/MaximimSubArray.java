package com.gfg.array;

import java.util.Scanner;

public class MaximimSubArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int sizeOfArray = scanner.nextInt();
			int[] array = new int[sizeOfArray];
			for (int j = 0; j < sizeOfArray; j++) {
				array[j] = scanner.nextInt();
			}

			int maxEndingHere = 0;
			int maxSoFar = Integer.MIN_VALUE;
			boolean allNegative = true;
			int maxNegative = Integer.MIN_VALUE;

			for (int j = 0; j < sizeOfArray; j++) {
				if (array[j] > 0) {
					allNegative = false;
				} else {
					if (array[j] > maxNegative) {
						maxNegative = array[j];
					}
				}
				maxEndingHere = maxEndingHere + array[j];
				if (maxEndingHere < 0) {
					maxEndingHere = 0;
				}
				if (maxSoFar < maxEndingHere) {
					maxSoFar = maxEndingHere;
				}
			}
			if (allNegative) {
				System.out.println(maxNegative);
			} else {
				System.out.println(maxSoFar);

			}
		}
		scanner.close();
	}
}
