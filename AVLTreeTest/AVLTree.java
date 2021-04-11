package AVLTreeTest;

import java.io.IOException;

import balancedBST.DTree.Node;

public class AVLTree {
	private String data = "dshuecownecnoin";
	private Node root;

	public AVLTree() {
		this.root = null;
	}
	public void run() {
		char c;
		for (int i=0; i<this.data.length(); i++) {
			c = this.data.charAt(i);
			System.out.println("==insert: "+c);
			root = insert(root, c);
		}
		
		try {
			c = (char) System.in.read();
			System.out.println("**search: "+c);
			search(c, root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private int height(Node node) {
		if (node == null) return -1;
		return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
		
	}
	private Node insert(Node node, char c) {
		if (node == null) {
			Node newNode = new Node();
			newNode.setToken(c);
			System.out.println("newNode: "+c);
			System.out.println("-height: "+ newNode.getHeight());
			return newNode;
		}
		if (node.getToken() > c) {
			System.out.println(node.getToken()+":goLeft: "+c);
			node.setLeft(insert(node.getLeft(), c));
			node.setHeight(this.height(node));
			System.out.println(node.getToken()+"-height: "+ node.getHeight());
			if ((this.height(node.getLeft()) - this.height(node.getRight())) == 2) {
				if (node.getLeft().getToken() > c) {
					node = singleRotateLeft(node);
				} else {
					node = doubleRotateLeft(node);
				}
			}
		} else if (node.getToken() < c) {
			System.out.println(node.getToken()+":goRight: "+c);
			node.setRight(insert(node.getRight(), c));
			node.setHeight(this.height(node));
			System.out.println(node.getToken()+"-height: "+ node.getHeight());
			if ((this.height(node.getRight()) - this.height(node.getLeft())) == 2) {
				if (node.getRight().getToken() > c) {
					node = singleRotateRight(node);
				} else {
					node = doubleRotateRight(node);
				}
			}
		}
		return node;
	}
	private Node doubleRotateRight(Node node) {
		System.out.println("doubleRotateRight: "+node.getToken());
		node.setRight(this.singleRotateLeft(node.getRight()));
		return this.singleRotateRight(node);
	}
	private Node singleRotateRight(Node node) {
		System.out.println("singleRotateRight: "+node.getToken());
		Node rNode = node.getRight();		//			B = A.right;
		node.setRight(rNode.getLeft());		//			A.right = B.left;
		rNode.setLeft(node);				//			B.left = A;
		node.setHeight(this.height(node));
		rNode.setHeight(this.height(rNode));
		return rNode;						//			return B;




	}
	private Node doubleRotateLeft(Node node) {
		System.out.println("doubleRotateLeft: "+node.getToken());
		node.setLeft(this.singleRotateRight(node.getLeft()));
		return this.singleRotateLeft(node);
	}
	private Node singleRotateLeft(Node node) {
		System.out.println("singleRotateLeft: "+node.getToken());
		Node lNode = node.getLeft();
		node.setLeft(lNode.getRight());
		lNode.setRight(node);
		node.setHeight(this.height(node));
		lNode.setHeight(this.height(lNode));
		return lNode;
	}
	
	public boolean search(char c, Node node) {
		if (node == null) {
			System.out.println("Not found: "+c);
			return false;
		}
	
		if (node.getToken() == c) {
			System.out.println(node.getHeight()+"found: "+c);
			return true;
		} else if (node.getToken() > c) {
			System.out.println(node.getHeight()+"left: "+ node.getToken());
			return search(c, node.getLeft());
		} else {
			System.out.println(node.getHeight()+"right: "+ node.getToken());
			return search(c, node.getRight());
		}
	}
	
	public class Node {
		private Node left;
		private char token;
		private Node right;
		private int height;
		
		public Node() {
			this.left = null;
			this.token = '\0';
			this.right = null;
			this.height = 0;
		}
		public Node getLeft() {	return left;}
		public void setLeft(Node left) {this.left = left;}
		public char getToken() {return token;}
		public void setToken(char token) {this.token = token;}
		public Node getRight() {return right;}
		public void setRight(Node right) {this.right = right;}
		public int getHeight() { return this.height; }
		public void setHeight(int height) { this.height = height; }
	};
}
