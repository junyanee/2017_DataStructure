package linkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DLinkedList {

	private class Node {
		private int data;
		private Node next;
		public int getData() {return data;}
		public void setData(int data) {this.data = data;}
		public Node getNext() {return next;}
		public void setNext(Node next) {this.next = next;}
		
		public Node() {
			this.data = 0;
			this.next = null;
		}
	}
	
	private Node startNode;
	
	private void readData1() {
		try {
			File file = new File("data/linkedList.txt");
			Scanner scanner = new Scanner(file);
			
			this.startNode = new Node();
			Node node = this.startNode;
			while(scanner.hasNext()){
				node.setNext(new Node());
				node.getNext().setData(scanner.nextInt());
				System.out.println(node.getNext().getData());
				node = node.getNext();
			}
			this.startNode = this.startNode.getNext();
			
			scanner.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	private Node makeNode(Scanner scanner) {
		if (!scanner.hasNext()) {
			return null;
		}
		Node node = new Node();
		node.setData(scanner.nextInt());
		node.setNext(makeNode(scanner));
		return node;
	}
	private void readData2() {
		try {
			File file = new File("data/linkedList.txt");
			Scanner scanner = new Scanner(file);
			
			this.startNode = makeNode(scanner);
			
			scanner.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	private void printData1() {
					
			for (Node node = this.startNode;
					node!= null;
					node = node.getNext()) {
				System.out.println(node.getData());
			}
		}
		
	public void run() {
		
	this.readData2();
	this.printData2(this.startNode);
	}
	// printData1 을 recursion으로 바꾸기
	private void printData2(Node node) {
		
		if (node == null)
		      return;
		    else {
		      
		      System.out.println(node.data);
		      printData2(node.next);
		    };
				
	}

}
