package circularQueue;

import queue.DConstant;

public class DCircularQueue<ELEMENT_TYPE> {
	
	private int front, back, size;
	private int aData[];
	

	// constructor
	public DCircularQueue() {
		this.aData = new int[DConstant.QUEUE_SIZE];
		this.front = 0;
		this.back = 0;
		this.size = 0;
	}
	// private functions
	private boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}
	private boolean isFull() {
		if (size == DConstant.QUEUE_SIZE)
			return true;
		return false;
	}
	
	// getters & setters
	public int getSize() {
		return this.size;
	}
	
	// public functions
	public void enqueue(int value) throws Exception {
		// check precondition : input parameter, action의 대상상태 확인
		if(this.isFull()) {
			throw new Exception("Queue Full");
		} 		
		// action
		this.aData[this.back] = value;
		this.size++;
		if ( this.back == DConstant.QUEUE_SIZE)
			this.back = 0;
		else {
			this.back++;
			}
		// process postcondition
	}
	public int dequeue() throws Exception {
		// check precondition
		if (this.isEmpty()){
			throw new Exception("Queue Empty");
		} 
		// action
		int value = this.aData[this.front];
		
		this.size--;		
		if ( this.front == DConstant.QUEUE_SIZE)
			this.front = 0;
		else {
			this.front++;
			}
		
		return value;
		// process postcondition
		
	}
	
}
