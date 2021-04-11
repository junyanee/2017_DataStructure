package balancedBST;

import java.util.Scanner;

public class DTree {
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
      public Node getLeft() {   return left;}
      public void setLeft(Node left) {this.left = left;}
      public char getToken() {return token;}
      public void setToken(char token) {this.token = token;}
      public Node getRight() {return right;}
      public void setRight(Node right) {this.right = right;}
      public int getHeight() {return height;}
   };
   
   private Node root;
   private String expression = "dshuecownecnoin";
   private int position = 0;
   
   private int computeHeight(Node node) {
      if (node==null) {
         return -1;
      }
      node.height = Math.max(
            computeHeight(node.getLeft()), 
            computeHeight(node.getRight())
            ) + 1;
      return node.height;      
   }
   private int computeDiff(Node node) {
      int leftHeight = -1;
      int rightHeight = -1;
      if (node.getLeft()!=null) {
         leftHeight = node.getLeft().getHeight();
      }
      if (node.getRight()!=null) {
         rightHeight = node.getRight().getHeight();
      }
      return Math.abs(leftHeight-rightHeight);
   }
   private Node LLRotation(Node node) {
	  System.out.println("LL Rotation:"+node.getToken());
      Node newNode = node.getRight();
      node.setRight(newNode.getLeft());
      newNode.setLeft(node);
      // recompute height
      this.computeHeight(node);
      this.computeHeight(newNode);
      return newNode;
   }
   private Node RLRotation(Node node) {
	   System.out.println("RL Rotation:"+node.getToken());
	   Node rNode = RRRotation(node.getRight());
	   node.setRight(rNode);
	return this.LLRotation(node);
	   
   }
   private Node RRRotation(Node node) {
	  System.out.println("RR Rotation:"+node.getToken());
      Node newNode = node.getLeft();
      node.setLeft(newNode.getRight());
      newNode.setRight(node);
      // recompute height
      this.computeHeight(node);
      this.computeHeight(newNode);
      return newNode;
   }
   private Node LRRotation(Node node) {
	   System.out.println("LR Rotation:"+node.getToken());
	   Node lNode = LLRotation(node.getLeft());
	   node.setLeft(lNode);
	return this.RRRotation(node);
	   
   }
   
   
   
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
         node = new Node();
         node.setToken(expression.charAt(position++));
         System.out.println("MakeNode:"+node.getToken());
         System.out.println(node.getHeight());
         
      }else {
      
      if (node.getToken()>expression.charAt(position)) {
         //insert
      
         Node lNode = addNode(node.getLeft());
         node.setLeft(lNode);
         this.computeHeight(node);
         System.out.println("Go left:"+node.getToken());
         System.out.println(node.getHeight());
         //rotate
         if (this.computeDiff(node) > 1) {
        	 if (node.getLeft().getLeft() != null) {
        		 node =  RRRotation(node);
        	 } else {
        		 node =  LRRotation(node);
        	 }
                  
         }
         
         
      } else {
         //insert
          Node rNode = addNode(node.getRight());
         node.setRight(rNode);      
         this.computeHeight(node);
         System.out.println("Go right:"+node.getToken());
         System.out.println(node.getHeight());
         //rotate
         if (this.computeDiff(node) > 1) {
        	 if (node.getRight().getRight() != null) {
        		 node = LLRotation(node);
        	 } else {
        		 node = RLRotation(node);
        	 }
         }
      
      }
      }
      return node;
   }
   
   private void find(char c, Node node) {
      if (node == null) {
         System.out.println("Not found!");
         return;
      }
      
      if (node.getToken() == c) {
         System.out.println("Found: "+ c);
         return;
      } else if (node.getToken() > c) {
         System.out.println("Going Left: "+node.getToken());
         find(c, node.getLeft());
      } else {
         System.out.println("Going Right: "+node.getToken());
         find(c, node.getRight());
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