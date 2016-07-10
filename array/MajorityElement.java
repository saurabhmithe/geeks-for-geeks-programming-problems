package com.gfg.array;

import java.util.Scanner;

public class MajorityElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int sizeOfArray = scanner.nextInt();
			int[] array = new int[sizeOfArray];
			for (int j = 0; j < sizeOfArray; j++) {
				array[j] = scanner.nextInt();
			}
			int minCount = sizeOfArray / 2;
			boolean found = false;
			int finalNum = -1;
			for (int j = 0; j < sizeOfArray; j++) {
				int count = 0;
				int num = array[j];
				for (int k = 0; k < sizeOfArray; k++) {
					if (array[k] == num) {
						count++;
					}
				}
				if (count > minCount) {
					found = true;
					finalNum = num;
					break;
				}
			}
			if (found) {
				System.out.println(finalNum);
			} else {
				System.out.println("NONE");
			}

		}
		scanner.close();

	}
}
