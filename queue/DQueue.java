package queue;

import queue.DConstant;

public class DQueue<ELEMENT_TYPE> {
	
	private int front, back;
	private int aData[];
	

	// constructor
	public DQueue() {
		this.aData = new int[DConstant.QUEUE_SIZE];
		this.front = 0;
		this.back = 0;
	}
	// private functions
	private boolean isEmpty() {
		if (front == back)
			return true;
		return false;
	}
	private boolean isFull() {
		if (back == DConstant.QUEUE_SIZE)
			return true;
		return false;
	}
	
	// getters & setters
	public int getSize() {
		return (this.back - this.front);
	}
	
	// public functions
	public void enqueue(int value) throws Exception {
		// check precondition : input parameter, action의 대상상태 확인
		if(this.isFull()) {
			throw new Exception("Queue Full");
		} 		
		// action
		this.aData[this.back] = value;
		this.back++;		
		// process postcondition
	}
	public int dequeue() throws Exception {
		// check precondition
		if (this.isEmpty()){
			throw new Exception("Queue Empty");
		} 
		// action
		int value = this.aData[this.front];
		this.front++;
		return value;
		// process postcondition
		
	}
	
}
