package ws.abhis.amazonpreps.datastructures;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void add(int value) {
		// check whether root exists
		if (root == null) {
			root = new Node(value);
		} else {
			root.add(value);
		}
	}

	public void inOrder() {
		root.inOrderTraversal(root);
	}

	public void preOrder() {
		root.preOrderTraversal(root);
	}

	public void postOrder() {
		root.postOrderTraversal(root);
	}
	
	public List<Integer> getInOrder() {
		return root.getInOrderOutput();
	}
	
	public List<Integer> getPreOrder() {
		return root.getPreOrderOutput();
	}
	
	public List<Integer> getPostOrder() {
		return root.getPostOrderOutput();
	}

	public boolean BFS(int value) {
		Stack s = new Stack();
		s.push(root);
		return root.BFS(value, s);
	}

	public boolean search(int value) {
		if (root == null) {
			return false;
		} else {
			return root.search(value);
		}
	}

	public class Stack {
		private List<Node> stack = new ArrayList<Node>();

		public void push(Node value) {
			stack.add(value);
		}

		public Node pop() {
			Node value = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			return value;
		}
	}

	public class Node {
		private int value;
		private Node leftChild;
		private Node rightChild;

		public Node(int value) {
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}

		public Node(int value, Node leftChild, Node rightChild) {
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		// Recursive method to add the value at the appropriate place in the
		// tree
		public void add(int value) {
			// check if value exists
			if (this.value == value) {
				return;
			} else if (value < this.value) {
				// lesser, so should be in the left sub-tree
				if (this.leftChild == null) {
					// no left child, found a position
					this.leftChild = new Node(value);
				} else {
					// search for an appropriate position recursively
					leftChild.add(value);
				}
			} else {
				// greater, so should be in the right sub-tree
				if (this.rightChild == null) {
					// no right child, found a position
					this.rightChild = new Node(value);
				} else {
					// search recursively
					rightChild.add(value);
				}
			}

		}

		// Recursive method to search for a value in the tree
		public boolean search(int value) {
			if (this.value == value) {
				// found value in this position
				return true;
			} else if (value < this.value) {
				if (this.leftChild == null) {
					// null left sub-tree, so value not present
					return false;
				} else {
					// lesser, search in the left sub-tree
					return leftChild.search(value);
				}
			} else {
				if (this.rightChild == null) {
					return false;
				} else {
					return rightChild.search(value);
				}
			}

		}

		// DFS traversals - Pre, post and in orders
		List<Integer> inOrderOutput = new ArrayList<Integer>();
		List<Integer> preOrderOutput = new ArrayList<Integer>();
		List<Integer> postOrderOutput = new ArrayList<Integer>();
		
		public List<Integer> getInOrderOutput() {
			return inOrderOutput;
		}
		
		public List<Integer> getPreOrderOutput() {
			return preOrderOutput;
		}
		
		public List<Integer> getPostOrderOutput() {
			return postOrderOutput;
		}
		
		// Left, root, right
		public void inOrderTraversal(Node root) {

			if (root == null) {
				return;
			}
			inOrderTraversal(root.leftChild);
			System.out.println(root.value);
			inOrderOutput.add(root.value);
			inOrderTraversal(root.rightChild);
		}

		// Root, left, right
		public void preOrderTraversal(Node root) {

			if (root == null) {
				return;
			}
			System.out.println(root.value);
			preOrderOutput.add(root.value);
			preOrderTraversal(root.leftChild);
			preOrderTraversal(root.rightChild);
		}

		// Left, right, root
		public void postOrderTraversal(Node root) {

			if (root == null) {
				return;
			}
			postOrderTraversal(root.leftChild);
			postOrderTraversal(root.rightChild);
			System.out.println(root.value);
			postOrderOutput.add(root.value);
		}

		// Check if root is value, else enqueue all nodes
		public boolean BFS(int value, Stack vals) {

			Node r = vals.pop();

			if (r == null) {
				return false;
			}
			if (r.value == value) {
				return true;
			}
			vals.push(r.leftChild);
			vals.push(r.rightChild);
			return BFS(value, vals);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree objBinarySearchTree = new BinarySearchTree();
		objBinarySearchTree.add(20);
		objBinarySearchTree.add(10);
		objBinarySearchTree.add(40);
		objBinarySearchTree.add(60);
		objBinarySearchTree.add(100);

		System.out.println(objBinarySearchTree.search(40));
		System.out.println(objBinarySearchTree.search(2));

		System.out.println("InOrder");
		objBinarySearchTree.inOrder();
		System.out.println("PreOrder");
		objBinarySearchTree.preOrder();
		System.out.println("PostOrder");
		objBinarySearchTree.postOrder();

		System.out.println("BFS");
		System.out.println(objBinarySearchTree.BFS(20));
		System.out.println(objBinarySearchTree.BFS(40));
		System.out.println(objBinarySearchTree.BFS(2000));
	}

}
