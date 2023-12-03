package lab11_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

//	Task 1: Basic Operations with BST
	// Add element e into BST
	public void add(E e) {
		if (root == null) {
			root = new BNode<E>(e);
		} else {
			root.add(e, root);
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}

	}

	// compute the depth of a node in BST
	public int depth(E node) {

		return root.depth(node, root);
	}

	// compute the height of BST
	public int height() {
		return root.height(root);
	}

	// Compute total nodes in BST
	public int size() {

		return root.size(root);
	}

	// Check whether element e is in BST
	public boolean contains(E e) {

		return root.contains(e, root);
	}

	// Find the minimum element in BST
	public E findMin() {
		if (root == null) {
			return null;
		}
		return root.findMin(root);
	}

	// Find the maximum element in BST
	public E findMax() {
		return root.findMax(root);

	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (!contains(e)) {
			return false;
		} else {
			root.remove(e, root);
			return true;
		}
	}

	// get the descendants of a node
	public List<E> descendants(E data) {

			return root.descendants(data);
	
	}

	// get the ancestors of a node
	public List<E> ancestors(E e) {

		return root.ancestors(e);
	}

//	Task 2: Tree Traversal Algorithms
	// display BST using inorder approach
	public void inorder() {// L-N-R
		root.inorder(root);
	}
	public void preorder() {
		root.preorder(root);
	}
	public void postorder() {
		root.postorder(root);
	}
}