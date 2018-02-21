/**
 * 
 */
package algrithom;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zsli
 *
 */
public class SortTestCase {
	
	private static SortTest test = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass................");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass................");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.test = new SortTest();
		System.out.println("setUp................");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.test = null;
		System.out.println("tearDown................");
	}

	/**
	 * Test method for {@link algrithom.SortTest#insertSort(int[])}.
	 */
	@Test
	public void testInsertSort() {
		int[] a = {8,3,2,5,9,3,6};
		test.insertSort(a);
		int[] expected = {2,3,3,5,6,8,9};
		for(int i=0;i<a.length;i++){
			assertEquals(expected[i], a[i]);
		}
	}
	
	@Test
	public void testInsertSortRandomArray(){
		int array[] = new int[100];
		LinkedList<Integer> list = new LinkedList<Integer>();
		int next = 0;
		for(int i=0;i<100;i++){
			Random rand = new Random();
			next = rand.nextInt(1000);
			array[i] = next;
			list.add(next);
		}
		Collections.sort(list);
		test.insertSort(array);
		for(int i=0;i<100;i++){
			assertEquals(list.get(i).intValue(), array[i]);
		}
	}

	/**
	 * Test method for {@link algrithom.SortTest#BubbleSort(int[])}.
	 */
	@Test
	public void testBubbleSort() {
	}

	/**
	 * Test method for {@link algrithom.SortTest#QuickSort(int[], int, int)}.
	 */
	@Test
	public void testQuickSort() {
	}

	/**
	 * Test method for {@link algrithom.SortTest#selectSort(int[])}.
	 */
	@Test
	public void testSelectSort() {
	}

	/**
	 * Test method for {@link algrithom.SortTest#heapSort(int[])}.
	 */
	@Test
	public void testHeapSort() {
	}

	/**
	 * Test method for {@link algrithom.SortTest#topK(int[], int)}.
	 */
	@Test
	public void testTopK() {
	}

	/**
	 * Test method for {@link algrithom.SortTest#mergeSort(int[])}.
	 */
	@Test
	public void testMergeSort() {
	}

	/**
	 * Test method for {@link algrithom.SortTest#bucketSort(int[], int)}.
	 */
	@Test
	public void testBucketSort() {
	}

	/**
	 * Test method for {@link algrithom.SortTest#radixSort(int[])}.
	 */
	@Test
	public void testRadixSort() {
	}

}
