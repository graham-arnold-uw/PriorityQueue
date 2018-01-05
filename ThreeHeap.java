/*
 * Graham Arnold
 * 1/27/17
 * CSE373 HW 2
 * 
 * This class implements a priority queue using a three heap
 * The three heap follows the structure and priority characteristics of a heap
 * and also implements all the required methods of the provided prioritQueue interface
 */

import java.util.List;

public class ThreeHeap implements PriorityQueue {
	
	private double[] storage;
	private int dataCount;
	private static int minElement;
	
	//This constructor initializes a new empty priority queue
	public ThreeHeap() {
		storage = new double[10];
		dataCount = 0;
		minElement = 1;
	}

	@Override
	//returns whether the priority queue is empty
	public boolean isEmpty() {
		
		return dataCount == 0;
	}

	@Override
	//returns the number of element in the priority queue
	public int size() {
		return dataCount;
	}

	@Override
	//returns the minimum data element in the priority queue
	//throws an EmptyHeapException if the queue is empty
	public double findMin() {
		if (dataCount == 0) {
			String message = "Invalid request, queue is empty.";
			throw new EmptyHeapException(message);
		}
		return storage[minElement];
	}

	@Override
	//inserts a new value into the priority queue
	//at the correct location according to the elements
	//priority in relation to the current elements in the queue
	//The queue will automatically resize to twice its current size 
	//if it is full
	public void insert(double x) {
		if (dataCount == storage.length-1) {
			resize();
		}
		dataCount = dataCount + 1;
		int index;
		index = percolateUp(dataCount, x);
		storage[index] = x;

	}
	
	//this private method is used by the insert method
	//to reshuffle the queue such the the priority property of the heap
	//is maintained
	private int percolateUp(int hole, double val) {
		int parent = findParent(hole);
		while(hole > 1 && val < storage[parent]) {
			storage[hole] = storage[parent];
			hole = parent;
			parent = findParent(hole);
		}
		return hole;
	}
	
	//helper method for the percolateUp method
	//to find the parent of the current node in question
	//due to the three heap structure
	//parent node calculations change depending on the 
	//node index
	private int findParent(int hole) {
		int parent;
		if (hole % 3 == 2) {
			parent = hole/3 + 1;
		} else {
			parent = hole/3;
		}
		return parent;
	}
	
	//helper method to resize the queue to twice its current
	//size when it is full
	private void resize() {
		double[] temp =  new double[storage.length * 2];
		for (int i=0; i < storage.length; i++) {
			temp[i] = storage[i];
		}
		storage = temp;
	}
	
	//helper method that functions to maintain the priority 
	//property of the heap when the deleteMin method is called
	//chooses the last leaf node and percolates its down the queue
	//until the priority property is restored
	private int percolateDown(int hole, double val) {
		int leftChild;
		int middleChild;
		int rightChild;
		int target;
		while(3*hole <= dataCount) {
			leftChild = 3*hole - 1;
			middleChild = 3*hole;
			rightChild = 3*hole + 1;
			target = findMinChild(leftChild, middleChild, rightChild);
			if(storage[target] < val) {
				storage[hole] = storage[target];
				hole = target;
			} else {
				break;
			}
		}
		return hole;
	}
	
	//helper method for the percolateDown method
	//serves to find the minimum child of a nodes children
	//handles three different cases when a node has one child only
	//two children only and all three children
	private int findMinChild(int leftChild, int middleChild, int rightChild) {
		if (middleChild > dataCount && rightChild > dataCount) {
			return leftChild;
		}
		if(rightChild > dataCount) {
			if(storage[leftChild] < storage[middleChild]) {
				return leftChild;
			} else {
				return middleChild;
			}
		}
		if (storage[leftChild] < storage[middleChild] && storage[leftChild] < storage[rightChild]) {
			return leftChild;
		} else if(storage[middleChild] < storage[leftChild] && storage[middleChild] < storage[rightChild]) {
			return middleChild;
		} else {
			return rightChild;
		}	
	}
	@Override
	//deletes and returns the minimum priority element in the
	//priority queue, automatically restores the priority and structure
	//properties of the three heap
	public double deleteMin() {
		if (this.isEmpty()) {
			String message = "Invalid request, queue is empty.";
			throw new EmptyHeapException(message);
		}
		double answer = storage[minElement];
		int index;
		index = percolateDown(minElement, storage[dataCount]);
		storage[index] = storage[dataCount];
		dataCount = dataCount - 1;
		return answer;
	}

	@Override
	//deletes the current priority queue
	//and populates a new priority queue with the
	//elements in the provided list parameter
	public void buildQueue(List<Double> list) {
		storage = new double[10];
		dataCount = 0;
		double node;
		for (int i = 0; i < list.size(); i++) {
			node = list.get(i);
			this.insert(node);
		}
	}

	@Override
	//deletes the current priority queue
	public void makeEmpty() {
		storage = new double[10];
		dataCount = 0;
	}
	
	//this method is used by my client program
	//for testing. It has been commented out so that
	//there is no concern that it will conflict with any
	//testing performed by the grader of this assignment
	/*
	public void printQueue() {
		for(int i = 1; i <= dataCount; i++) {
			System.out.println(storage[i]);
		}
	}*/

}
