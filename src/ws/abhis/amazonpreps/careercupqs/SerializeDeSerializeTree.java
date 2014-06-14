/*
 * Serialize and deserialize a tree. 

Given a tree - not necessarily a binary tree - the serialize method should create a string for the tree. 
The deserialize method should be able to reproduce the same tree using the string derived from the serialize method. 

Basically, serialize() takes in a tree and returns a string, deserialize() takes in a string and returns the tree.
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.List;

import ws.abhis.amazonpreps.careercupqs.PerimterBinaryTree.Node;

public class SerializeDeSerializeTree {
	public class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	private List<Node> inOrderList = new ArrayList<Node>();
	private List<Node> preOrderList = new ArrayList<Node>();
	public String serialize(Node root) {
		inOrder(root);
		preOrder(root);
		String s = createString();
		return s;
	}
	private void inOrder(Node node) {
		if (node.left != null) {
			inOrder(node.left);
		}
		inOrderList.add(node);
		if (node.right != null) {
			inOrder(node.right);
		}
	}
	private void preOrder(Node node) {
		if (node.left != null) {
			preOrder(node.left);
		}
		if (node.right != null) {
			preOrder(node.right);
		}
		preOrderList.add(node);
	}
	private String createString() {
		StringBuffer buffer = new StringBuffer();
		for (int i=0; i<inOrderList.size(); i++) {
			buffer.append(inOrderList.get(i).value);
			buffer.append(":");
		}
		buffer.append("::");
		for (int i=0; i<preOrderList.size(); i++) {
			buffer.append(preOrderList.get(i).value);
			buffer.append(":");
		}
		return buffer.toString();
	}
	
	
	
	
	public void deSerialize() {
		
	}
	
	
	
	public void init() {
		Node one = new Node(1, new Node(2, null, null), new Node(3, null, null));
		String s = serialize(one);
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		SerializeDeSerializeTree obj = new SerializeDeSerializeTree();
		obj.init();
	}
}
