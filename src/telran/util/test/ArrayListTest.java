package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArrayListTest {

	@Test
	void testAddIndex() {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			numbers.add(i);
		}
		numbers.add(0, 50);
		numbers.add(8, 74);
		numbers.add(17, 13);
		assertEquals(18, numbers.size());
		assertEquals(50, numbers.get(0));
		assertEquals(74, numbers.get(8));
		assertEquals(13, numbers.get(17));
	}

	@Test
	void TestRemove() {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(50);
		numbers.add(100);
		numbers.add(150);
		numbers.add(200);
		numbers.add(250);
		numbers.add(300);
		numbers.add(350);
		assertEquals(350, numbers.remove(6));
		assertEquals(200, numbers.remove(3));
		assertEquals(50, numbers.remove(0));
		assertEquals(4, numbers.size());
		assertEquals(100, numbers.get(0));
		assertEquals(250, numbers.get(2));
		assertEquals(300, numbers.get(3));

	}
}
