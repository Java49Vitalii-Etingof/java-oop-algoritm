package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import telran.util.Set;
import telran.util.SortedSet;

public abstract class SortedSetTest extends SetTest {

	@Override
	protected Integer[] getActual(Integer[] array, int size) {
		//System.out.println("Sorted test");
		return array;
	}
	@Test
	void firstTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(-20, sortedSet.first());
		collection.clear();
		assertThrowsExactly(NoSuchElementException.class, () -> sortedSet.first());
	}
	@Test
	void lastTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(100, sortedSet.last());
		collection.clear();
		assertThrowsExactly(NoSuchElementException.class, () -> sortedSet.last());
	}
	//{ 10, -20, 7, 50, 100, 30 };
	@Test
	void ceilingTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertThrowsExactly(NullPointerException.class, () -> sortedSet.ceiling(null));
		assertEquals(100, sortedSet.ceiling(99));
		assertEquals(null, sortedSet.ceiling(105));
		assertEquals(-20, sortedSet.ceiling(-30));
		assertEquals(50, sortedSet.ceiling(49));
	}
	@Test
	void floorTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertThrowsExactly(NullPointerException.class, () -> sortedSet.ceiling(null));
		assertEquals(50, sortedSet.floor(99));
		assertEquals(100, sortedSet.floor(105));
		assertEquals(null, sortedSet.floor(-30));
		assertEquals(30, sortedSet.floor(49));
	}

}