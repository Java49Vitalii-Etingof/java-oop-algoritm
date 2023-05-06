package telran.algorithm;

public class MemoryService {
	public static int getMaxAvailableSize() {
		int right = Integer.MAX_VALUE;
		int left = 0;
		int size = right / 2;
		byte[] array = null;
		while (left <= right) {
			size = left / 2 + right / 2;
			try {
				array = new byte[size];
				left = size + 1;
			} catch (OutOfMemoryError e) {
				right = size - 1;
			}
			array = null;
		}
		return size;

	}
}