package binarySearchTree;

import java.util.Scanner;

public class DTree {
	public class Node {
		private Node left;
		private char token;
		private Node right;
		
		public Node() {
			this.left = null;
			this.token = '\0';
			this.right = null;
		}
		public Node getLeft() {	return left;}
		public void setLeft(Node left) {this.left = left;}
		public char getToken() {return token;}
		public void setToken(char token) {this.token = token;}
		public Node getRight() {return right;}
		public void setRight(Node right) {this.right = right;}
	};
	
	private Node root;
	private String expression = "IDELXWLQNG";
	private int position = 0;
	
	private Node makeTree() {
		Node node = null;
		for (int i=0; i<expression.length(); i++) {
			System.out.println("==Start:"+expression.charAt(position));
			node = addNode(node);
		}
		return node;
	}
	private Node addNode(Node node) {
		if (node==null) {
			Node newNode = new Node();
			newNode.setToken(expression.charAt(position++));
			System.out.println("MakeNode:"+newNode.getToken());
			return newNode;
		}
		
		if (node.getToken()>expression.charAt(position)) {
			System.out.println("GoLeft:"+node.getToken());
			node.setLeft(addNode(node.getLeft()));
		} else {
			System.out.println("GoRight:"+node.getToken());
			node.setRight(addNode(node.getRight()));			
		}
		return node;
	}
	
	public boolean find(char c, Node node) {
		if (node == null) {
			System.out.println("Not found: "+c);
			return false;
		}
	
		if (node.getToken() == c) {
			System.out.println("found: "+c);
			return true;
		} else if (node.getToken() > c) {
			System.out.println("left: "+ node.getToken());
			return find(c, node.getLeft());
		} else {
			System.out.println("right: "+ node.getToken());
			return find(c, node.getRight());
		}
	   }
	
	public void build() {
		root = makeTree();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.next();
			find(string.charAt(0), root);
		}
		
		scanner.close();
	}
}
