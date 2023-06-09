package telran.algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

import static telran.algorithm.InitialAlgorithms.*;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class InitialAlgorithmsTest<T> {
	int N_NUMBERS = 100000;
	 short[] array;
	private int T;
void setUpBigArray() {
	array = new short[N_NUMBERS];
	 for(int i = 0; i < N_NUMBERS; i++) {
		 array[i] = (short) (Math.random() * Short.MAX_VALUE);
	 }
}
@Test
@Disabled
void bubbleSortTest() {
	setUpBigArray();
	bubbleSort(array);
	runTest();
}
	
	@Test
	void testSortPositiveShort() {
		setUpBigArray();
		sortShortPositive(array);
		runTest();
	}

	


	private void runTest() {
		for(int i = 1; i < N_NUMBERS; i++) {
			assertTrue(array[i - 1] <= array[i]);
		}
	}
		
		@Test
		void isSum2Test() {
			short[] array = {30000, 1, 5, 2, 10000, 0, 500,0};
			short[] array1 = {30000, 1, 5, 2, 10000, 0, 500,0, Short.MAX_VALUE};
//			assertTrue(isSum2(array, (short)30000));
//			assertTrue(isSum2(array, (short)7));
//			assertFalse(isSum2(array, (short)30003));
//			assertFalse(isSum2(array, (short)8));
			assertTrue(isSum2(array1, Short.MIN_VALUE));
			
		}
		@Test
		void getMaxPositiveWithNegativeTest() {
			short[] array = {1, 1, 1, -1, 20, 100,200, 100 -100, -100, -20, -40, 80};
			short[] array1 = {-40, 1, -40, -6, 2, 3, 40};
			short[] array2 = {40, 1, 2, 3, 40, -30};
			assertEquals(100,
					getMaxPositiveWithNegativeReflect(array));
			assertEquals(40,
					getMaxPositiveWithNegativeReflect(array1));
			assertEquals(-1,
					getMaxPositiveWithNegativeReflect(array2));
		}
		@Test
		@Disabled
		void maxValueComplexityNTest() {
			assertEquals(Long.MAX_VALUE, getMaxValueComplexityN());
		}
		@Test
		void maxValueComplexityLogNTest() {
			assertEquals(Long.MAX_VALUE, getMaxValueComplexityLogN());
		}
		private Long getMaxValueComplexityN() {
			long res = 1;
			while(res > 0) {
				res++;
			}
			return res - 1;
		}
		private Long getMaxValueComplexityLogN() {
			long res = 1;
			while(res > 0) {
				res *= 2;
			}
			return res - 1;
		}
		@Test
		void binarySearchTest() {
			Integer ar[] = { 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 20, 40 };
			assertEquals(-14, binarySearch(ar, 3, Integer::compare));
			assertEquals(3, binarySearch(ar, 2, Integer::compare ));
			assertEquals(-1, binarySearch(ar, 0, Integer::compare));
			assertEquals(13, binarySearch(ar, 4, Integer::compare));
			assertEquals(0, binarySearch(ar, 1, Integer::compare));
			assertEquals(-16, binarySearch(ar, 25, Integer::compare));
			assertEquals(-17, binarySearch(ar, 45, Integer::compare));
		}
		
}

	

		
	
	 
	




