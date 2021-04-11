package circularQueue;

public class DTestMain {
	
	public void execute() {
		DCircularQueue queue = new DCircularQueue();
			try {
			queue.enqueue(3);
			queue.enqueue(4);
			queue.enqueue(5);
			
			int element = queue.dequeue();
			System.out.println(element);
			
			element = queue.dequeue();
			System.out.println(element);
			
			element = queue.dequeue();
			System.out.println(element);
			
		} catch (Exception e) {
			e.printStackTrace();
		}


}
}