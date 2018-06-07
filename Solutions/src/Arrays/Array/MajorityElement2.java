package Arrays.Array;

import java.util.Scanner;

public class MajorityElement2 {
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
			sort(array);

			for (int k = 0; k < minCount + 1; k++) {
				int numberCount = 0;
				int num = array[k];
				for (int l = 0; l < minCount + 1 && k + l < sizeOfArray; l++) {
					if (array[k + l] == num) {
						numberCount++;
						continue;
					} else {
						k = k + l - 1;
						break;
					}
				}
				if (numberCount > minCount) {
					found = true;
					finalNum = num;
					break;
				}
			}

			if (found) {
				System.out.println(finalNum);
			} else {
				System.out.println("NO Majority Element");
			}

		}
		scanner.close();

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
