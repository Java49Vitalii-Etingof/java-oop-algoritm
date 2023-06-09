package telran.algorithm;

import java.util.Comparator;

public class InitialAlgorithms {
	public static void sortShortPositive(short[] array) {
		int[] helper = new int[Short.MAX_VALUE];
		for (int i = 0; i < array.length; i++) {
			helper[array[i]]++;
		}
		int ind = 0;
		for (int i = 0; i < helper.length; i++) {
			for (int j = 0; j < helper[i]; j++) {
				array[ind++] = (short) i;
			}
		}
	}

	public static boolean isSum2(short[] array, short sum) {
		// returns true if there are two numbers in the given array,
		// sum of which equals the given sum value
		// otherwise false

		int helperSize = sum < 0 ? Short.MAX_VALUE + 1 : sum + 1;
		boolean[] helper = new boolean[helperSize];
		boolean res = false;
		int index = 0;
		while (index < array.length && !res) {
			short value = array[index];
			short secondValue = (short) (sum - value);
			if (secondValue >= 0) {
				if (helper[secondValue]) {
					res = true;
				} else {
					helper[value] = true;
				}
			}
			index++;
		}
		return res;
	}

	public static short getMaxPositiveWithNegativeReflect(short[] array) {
		// returns maximal positive number, for which there is the negative image
		// If there are not such numbers at all the method returns -1
		short res = -1;
		byte[] helper = new byte[Short.MAX_VALUE];
		short candidate = -1;
		for (int i = 0; i < array.length; i++) {
			candidate = (short) Math.abs(array[i]);
			if (array[i] < 0) {

				if (helper[candidate] == 1 && candidate > res) {
					res = candidate;
				} else if (helper[candidate] == 0) {
					helper[candidate] = -1;
				}
			} else {
				if (helper[candidate] == -1 && candidate > res) {
					res = candidate;
				} else if (helper[candidate] == 0) {
					helper[candidate] = 1;
				}
			}
		}

		return res;
	}

	public static void bubbleSort(short[] array) {
		// sorting with bubble sort algorithm
		int size = array.length;
		boolean flUnsorted = false;
		do {
			size--;
			flUnsorted = false;
			for (int i = 0; i < size; i++) {
				if (array[i] > array[i + 1]) {
					short tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					flUnsorted = true;
				}
			}
		} while (flUnsorted);

	}

	public static <T> int binarySearch(T[] array, T key, Comparator<T> comp) {
		int left = 0;
		int right = array.length - 1;
		int middle = right / 2;
		while (left <= right && comp.compare(key, array[left])!= 0) {
			if (comp.compare(key, array[middle]) <= 0) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (right + left) / 2;
		}
		return left < array.length && comp.compare(key, array[left])== 0 ?
				left : -left - 1;
	}
}
