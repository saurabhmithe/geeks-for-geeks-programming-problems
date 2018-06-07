package Arrays;

import java.util.Scanner;

public class KeyPair {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int numberOfElementsInArray = scanner.nextInt();
			int sum = scanner.nextInt();
			int[] array = new int[numberOfElementsInArray];

			for (int j = 0; j < numberOfElementsInArray; j++) {
				array[j] = scanner.nextInt();
			}

			sort(array);
			if(isPairPresent(array, sum)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}

		scanner.close();
	}

	private static boolean isPairPresent(int[] array, int sum) {
		int arrayLength = array.length;
		int first = 0;
		int last = arrayLength - 1;
		while (first < last) {
			if (array[first] + array[last] == sum) {
				return true;
			} else if (array[first] + array[last] < sum) {
				first++;
			} else if (array[first] + array[last] > sum) {
				last--;
			}
		}
		return false;
	}

	private static void sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
}
