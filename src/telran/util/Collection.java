package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Predicate;

public interface Collection<T> extends Iterable<T> {
boolean add(T obj);
int size();
boolean remove(T pattern);

boolean removeIf(Predicate<T> predicate);
boolean contains(T pattern);
default boolean isEqual(T object, T pattern) {
	return pattern == null ? object == pattern : pattern.equals(object);
}
default T[] toArray(T[] array) {
	int size = size();
	if (array.length < size) {
		array = Arrays.copyOf(array, size);
	}
	int index = 0;
	Iterator<T> it = iterator();
	
	while(it.hasNext()) {	
		array[index++] = it.next();
	}
	if(array.length > size) {
		array[size] = null;
	}
	return array;	
		
}
}
