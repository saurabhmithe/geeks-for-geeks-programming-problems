package Arrays;

import java.util.Scanner;

public class MissingNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int numberOfElements = scanner.nextInt();
			int[] array = new int[numberOfElements];
			scanner.nextLine();
			String string = null;
			string = scanner.nextLine();
			String[] stringArray = string.split(" ");
			for (int j = 0; j < stringArray.length; j++) {
				array[j] = Integer.parseInt(stringArray[j]);
			}
			sort(array);

			for (int j = 0; j < numberOfElements - 1; j++) {
				if (array[j + 1] != array[j] + 1) {
					System.out.println(array[j] + 1);
					break;
				}
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
