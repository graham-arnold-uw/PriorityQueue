/*
 * Graham Arnold
 * 1/27/17
 * CSE373 HW2 
 * 
 * This client program provides a number of tests cases
 * to test the required functionality of the ThreeHeap
 * implementation of the priority queue we were tasked with creating in this homework
 * simply change the test case number in the main method to run the different test cases
 * provided in this testing suite
 * 
 * NOTE: TO USE THESE TEST CASES UNCOMMENT THE printQueue
 * METHOD IN THE THREE HEAP CLASS. I HAVE COMMENTED IT OUT JUST IN CASE IT COULD POSSIBLY
 * CONFLICT WITH ANY TESTING METHODS USED BY THE GRADERS OF THIS HOMEWORK.
 */
import java.util.*;

public class MyClient {
	public static void main(String[] args) {
		testCase8();
	}
	
	//tests isEmpty functionality
	//test basic insert functionality
	//tests size functionality 
	public static void testCase1() {
		PriorityQueue test = new ThreeHeap();
		System.out.println(test.isEmpty());
		test.insert(1.0);
		System.out.println(test.isEmpty());
		System.out.println(test.size());
	}
	
	//tests basic functionality of size and findMin methods
	//tests functionality of insert with duplicates
	public static void testCase2() {
		ThreeHeap test = new ThreeHeap();
		test.insert(3.0);
		test.insert(3.0);
		test.insert(6.0);
		test.insert(7.0);
		System.out.println(test.size());
		System.out.println(test.findMin());
		test.printQueue();
	}
	
	//tests basic functionality of deleteMin method
	//with duplicates
	public static void testCase3() {
		ThreeHeap test = new ThreeHeap();
		test.insert(3.0);
		test.insert(3.0);
		test.insert(6.0);
		test.insert(7.0);
		//test.printQueue();
		//System.out.println();
		double min = test.deleteMin();
		System.out.println(min);
		System.out.println();
		test.printQueue();
	}
	
	//tests for empty heap exception thrown
	public static void testCase4() {
		ThreeHeap test = new ThreeHeap();
		test.deleteMin();
	}
	
	//further tests functionality of insert
	public static void testCase5() {
		ThreeHeap test = new ThreeHeap();
		test.insert(15.0);
		test.insert(39.0);
		test.insert(2.0);
		test.insert(115.0);
		test.insert(75.0);
		test.insert(43.0);
		test.printQueue();
		System.out.println();
	}
	
	//further tests delete min functionality 
	public static void testCase6() {
		ThreeHeap test = new ThreeHeap();
		test.insert(15.0);
		test.insert(39.0);
		test.insert(2.0);
		test.insert(115.0);
		test.insert(75.0);
		test.insert(43.0);
		double min = test.deleteMin();
		System.out.println(min);
		System.out.println();
		test.printQueue();
		System.out.println();
		test.deleteMin();
		test.printQueue();
	}
	
	//Tests makeEmpty method functionality
	public static void testCase7() {
		ThreeHeap test = new ThreeHeap();
		test.insert(15.0);
		test.insert(39.0);
		test.insert(2.0);
		test.insert(115.0);
		test.insert(75.0);
		test.insert(43.0);
		test.makeEmpty();
		test.deleteMin();
	}
	
	//tests functionality of buildQueue method
	public static void testCase8() {
		ThreeHeap test = new ThreeHeap();
		List<Double> list = new ArrayList<Double>();
		list.add(15.0);
		list.add(39.0);
		list.add(2.0);
		list.add(115.0);
		list.add(75.0);
		list.add(43.0);
		test.buildQueue(list);
		test.printQueue();
	}
	
}
