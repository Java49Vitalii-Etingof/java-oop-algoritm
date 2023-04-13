package telran.util;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 16;
	private static final String T = null;
	private T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public boolean add(T obj) {
		if (size == array.length) {
			reallocate();
		}
		array[size] = obj;
		size++;
		return true;
	}

	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);

	}

	@Override
	public void add(int index, T obj) {
		if (size == array.length)
			reallocate();
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;

	}

	@Override
	public T remove(int index) {
		T remove = array[index];
		System.arraycopy(array, index + 1, array, index, size - 1 - index);
		size--;
		return remove;
	}

	@Override
	public T get(int index) {
		return array[index];
	}

	@Override
	public int size() {
		return size;
	}
	// **************************HW#4********************************

	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		int index = indexOf(pattern);
		if (index >= 0) {
			remove(index);
			res = true;
		}
		return res;
	}

	@Override
	public T[] toArray(T[] newArray) {
		T[] res = newArray;
		if (newArray.length < size) {
			res = (T[]) Arrays.copyOf(array, size, newArray.getClass());
		} else {
			System.arraycopy(array, 0, res, 0, size);
			if (res.length > size) {
				res[size] = null;
			}
		}
		return res;
	}

	@Override
	public int indexOf(T pattern) {
		int res = -1;
		int index = 0;
		while (index < size && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index++;
		}
		return res;
	}

	private boolean isEqual(T object, T pattern) {

		return pattern == null ? object == pattern : pattern.equals(object);
	}

	@Override
	public int LastIndexOf(T pattern) {
		int res = -1;
		int index = size;
		do {
			index--;
			if (isEqual(array[index], pattern)) {
				res = index;
			}
		} while (index >= 0 && res == -1);

		return res;
	}

}
