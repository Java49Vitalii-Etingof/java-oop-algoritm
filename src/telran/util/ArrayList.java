package telran.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 16;
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
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(index);
		}
		if (size == array.length)
			reallocate();
		
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;

	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
		T remove = array[index];
		System.arraycopy(array, index + 1, array, index, size - 1 - index);
		size--;
		T res = remove;
		return res;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
		T res = array[index];
		return res;
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
	public T[] toArray(T[] array) {
		if (array.length < size) {
			array = Arrays.copyOf(array, size);
		}
		System.arraycopy(this.array, 0, array, 0, size);
		if (array.length > size) {
			array[size] = null;
		}

		return array;
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

	@Override
	public void sort() {
		sort((Comparator<T>) Comparator.naturalOrder());

	}

//*******************HW#5*********************************
	@Override
	public void sort(Comparator<T> comp) {
		int n = size;
		boolean flUnSort = true;
		do {
			flUnSort = false;
			n--;
			for (int i = 0; i < n; i++) {
				if (comp.compare(array[i], array[i + 1]) > 0) {
					swap(i);
					flUnSort = true;
				}
			}
		} while (flUnSort);

	}

	private void swap(int i) {
		T tmp = array[i];
		array[i] = array[i + 1];
		array[i + 1] = tmp;

	}

	@Override
	public int indexOf(Predicate<T> predicate) {
		int res = -1;
		int index = 0;
		while (index < size && res == -1) {
			if (predicate.test(array[index])) {
				res = index;
			}
			index++;
		}
		return res;
	}

	// *********************HW#6************************************
	@Override
	public int LastIndexOf(Predicate<T> predicate) {
		int res = -1;
		int index = size - 1;
		while (index >= 0 && res == -1) {
			if (predicate.test(array[index])) {
				res = index;
			}
			index--;
		}
		return res;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		boolean res = false;
		int initialSize = size;
		int index = 0, i = 0;
		while (i < initialSize) {
			if (!predicate.test(array[i])) {
				array[index] = array[i];
				index++;
			}
			i++;
		}
		size = index;
		if (initialSize != size)
			res = true;
		return res;
	}

}
