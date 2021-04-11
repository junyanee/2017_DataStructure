package tree;

public class DTree {

	private class Node {
		private Node left;
		private char token;
		private Node right;
		
		public Node() {
			this.left = null;
			this.token = '\0';
			this.right = null;
		}
		public Node getLeft() {return left;}
		public void setLeft(Node left) {this.left = left;}
		public char getToken() {return token;}
		public void setToken(char token) {this.token = token;}
		public Node getRight() {return right;}
		public void setRight(Node right) {this.right = right;}
		
	}
	private Node root;
	String expression = "+-+abc*df";
	int position = 0;
	
	private boolean isOperator(char c) {
		if(c == '+' | c == '-'| c == '*' | c =='/'){
			return true;
			}
		return false;
	}
	private Node makeTree() {
		Node node = new Node();
		char token = expression.charAt(position);
		node.setToken(token);
		position++;
		if (isOperator(token)) {
			node.setLeft(makeTree());
			node.setRight(makeTree());
		}
		return node;
		
//		char token = expression.charAt(position);
//		position++;
//		node.token = token;
//		
//		System.out.println(token);
//		if(token == '+' | token == '-'| token == '*' | token =='/'){
//		node.left = makeTree();
//		node.right = makeTree();
//		}
//		return node;
	}
		private void traverse(Node node) {
			if (node == null) return;
			// preOrder : System.out.println(node.getToken());
			
			traverse(node.getLeft());
			// inOrder : System.out.println(node.getToken()); (하지만 괄호없음)
			System.out.println(node.getToken());
			traverse(node.getRight());
			
			// postOrder : System.out.println(node.getToken());
		}
		public void build() {
			root = makeTree();
			traverse(root);
		}
	}
	
//		class Node {
//			public Node left = null;
//			public char c;
//			public Node right = null;
//			int size = 0;
//		
//		}
//		private Node root;
//		private String expression = "=x-*+abcd";
//		public void build() {
//			root = parseExpression(this.expression);
//	}
//		private Node parseExpression(String expression) {
//			Node node = new Node();
//			node.c = expression.charAt(0);
//			// if node size = 1 밑에 두문장 실행 x
//			if(!(node.size == 1))
//			node.left = parseExpression(expression);
//			node.right = parseExpression(expression);
//			return node;
//		}
//
//}
