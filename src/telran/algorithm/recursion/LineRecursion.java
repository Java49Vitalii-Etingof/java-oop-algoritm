package telran.algorithm.recursion;

import org.hamcrest.core.SubstringMatcher;

public class LineRecursion {
	public static long factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Cannot be negative value");
		}
		long res = 1;
		if (n > 1) {
			res = n * factorial(n - 1);
		}
		return res;
	}

	// --------------------------------------------------------------------
	public static long pow(int a, int b) {

		if (b < 0) {
			throw new IllegalArgumentException("Pow cannot be negative value");
		}
		int c = a;
		a = Math.abs(a);
		long res = 1;
		if (b > 0) {
			res = mult(a, (int) pow(a, b - 1));
		}
		if (c < 0 && b % 2 != 0) {
			res = -res;
		}
		return res;
	}

	public static long square(int a) {
		a = (a < 0) ? -a : a;
		// a = Math.abs(a);
		long res = 0;
		if (a > 0) {
			res = a + a - 1 + square(a - 1);
		}
		return res;
	}

	private static long mult(int a, int b) {
		long res = 0;
		if (b > 0) {
			res = a + mult(a, b - 1);
		}
		return res;
	}

	public static boolean isSubstring(String string, String substr) {

		boolean res = false;
		if (substr.length() == 0) {
			res = true;
		} else if (string.length() == 0 || string.length() < substr.length()) {
			res = false;
		} else if (string.charAt(0) == substr.charAt(0)) {
			res = isSubstring(string.substring(1), substr.substring(1));
		} else {
			res = isSubstring(string.substring(1), substr);
		}
		return res;
	}

	// --------------------------------------------------------------------

	public static long sum(int[] array) {
		return sum(0, array);
	}

	private static long sum(int firstIndex, int[] array) {
		long sum = 0;
		if (firstIndex < array.length) {
			sum = array[firstIndex] + sum(firstIndex + 1, array);
		}
		return sum;
	}

	public static int[] reverse(int[] array) {
		return reverse(array, 0, array.length - 1);
	}

	private static int[] reverse(int[] array, int left, int right) {

		if (left < right) {
			array[left] = array[left] + array[right];
			array[right] = array[left] - array[right];
			array[left] = array[left] - array[right];
			reverse(array, left + 1, right - 1);
		}
		return array;
	}

}