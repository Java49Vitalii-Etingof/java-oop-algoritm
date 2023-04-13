package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import telran.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListTest {
	List<Integer> list;
	Integer[] numbers = { 10, -20, 7, 50, 100, 30 };

	@BeforeEach
	void setUp() {
		list = new ArrayList<>(1);
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
	}

	@Test
	void testAdd() {
		assertTrue(list.add(numbers[0]));
		assertEquals(numbers.length + 1, list.size());
	}

	@Test
	void testAddIndex() {
		Integer[] expected0_500 = { 500, 10, -20, 7, 50, 100, 30 };
		Integer[] expected0_500_3_700 = { 500, 10, -20, 700, 7, 50, 100, 30 };
		Integer[] expected0_500_3_700_8_300 = { 500, 10, -20, 700, 7, 50, 100, 30, 300 };
		list.add(0, 500);
		runTest(expected0_500);
		list.add(3, 700);
		runTest(expected0_500_3_700);
		list.add(8, 300);
		runTest(expected0_500_3_700_8_300);
	}

	@Test
	void testRemoveIndex() {
		Integer[] expectedNo10 = { -20, 7, 50, 100, 30 };
		Integer[] expectedNo10_50 = { -20, 7, 100, 30 };
		Integer[] expectedNo10_50_30 = { -20, 7, 100 };
		assertEquals(10, list.remove(0));
		runTest(expectedNo10);
		assertEquals(50, list.remove(2));
		runTest(expectedNo10_50);
		assertEquals(30, list.remove(3));
		runTest(expectedNo10_50_30);
	}

	@Test
	void testGetIndex() {
		assertEquals(10, list.get(0));
	}
	@Test
	void testIndexOf() {
		list.add(3, 10);
		list.add(50);
		list.add(0, 30);
		assertEquals(1, list.indexOf(10));
		assertEquals(-1, list.indexOf(null));
		assertEquals(5, list.indexOf(50));
		assertEquals(0, list.indexOf(30));
	}
	//*********************HW#4************************************************************************
	@Test
	void testLastIndexOf() {
		list.add(3, 10);
		list.add(50);
		list.add(0, 30);
		assertEquals(4, list.LastIndexOf(10));
		assertEquals(-1, list.indexOf(null));
		assertEquals(8, list.LastIndexOf(50));
		assertEquals(7, list.LastIndexOf(30));
	}
	@Test
      void testRemovePattern() {
		Integer pattern = 10;
		Integer pattern1 = null;
		assertEquals(true, list.remove(pattern));
		assertEquals(false, list.remove(pattern1));
		assertEquals(-20, list.get(0));	
	}
	@Test
	void testToArray() {
		
		Integer[] arrayListSize = new Integer[list.size()];
		Integer[] arrayLessSize = new Integer[list.size()-1];
		Integer[] arrayMoreSize = new Integer[list.size()+2];
		Integer[] expectedList = {10, -20, 7, 50, 100, 30};
		Integer[] expectedMoreList = {10, -20, 7, 50, 100, 30, null, null};
		
		assertArrayEquals(expectedList, list.toArray(arrayListSize));
		assertArrayEquals(expectedList, list.toArray(arrayLessSize));
		assertArrayEquals(expectedMoreList, list.toArray(arrayMoreSize));
	}

	private void runTest(Integer[] expected) {
		int size = list.size();
		Integer[] actual = new Integer[expected.length];
		for (int i = 0; i < size; i++) {
			actual[i] = list.get(i);
		}
		assertArrayEquals(expected, actual);

		/*
		 * @Test
		 * 
		 * void testAddIndex() { ArrayList<Integer> numbers = new ArrayList<>(); for
		 * (int i = 0; i < 15; i++) { numbers.add(i); } numbers.add(0, 50);
		 * numbers.add(8, 74); numbers.add(17, 13); assertEquals(18, numbers.size());
		 * assertEquals(50, numbers.get(0)); assertEquals(74, numbers.get(8));
		 * assertEquals(13, numbers.get(17)); }
		 */

		/*
		 * @Test void TestRemove() { ArrayList<Integer> numbers = new ArrayList<>();
		 * numbers.add(50); numbers.add(100); numbers.add(150); numbers.add(200);
		 * numbers.add(250); numbers.add(300); numbers.add(350); assertEquals(350,
		 * numbers.remove(6)); assertEquals(200, numbers.remove(3)); assertEquals(50,
		 * numbers.remove(0)); assertEquals(4, numbers.size()); assertEquals(100,
		 * numbers.get(0)); assertEquals(250, numbers.get(2)); assertEquals(300,
		 * numbers.get(3));
		 */ }

}
