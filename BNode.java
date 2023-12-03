package lab11_tree;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}

	public BNode<E> add(E e, BNode<E> root) {

		if (root == null) {

			return new BNode<E>(e);
		}
		if (root.getData().compareTo(e) > 0) {

			root.left = add(e, root.getLeft());

		} else {

			root.right = add(e, root.getRight());

		}
		return root;
	}

	public int depth(E node, BNode<E> root) {
		if (root == null) {
			return -1;
		}

//		if (root.getData().compareTo(node) == 0)
//			return 0;
//		if (root.getData().compareTo(node) > 0) {
//			int leftDepth = depth(node, root.getLeft());
//			if (leftDepth >= 0) {
//				return leftDepth + 1;
//			}
//		} else if (root.getData().compareTo(node) < 0) {
//			int rightDepth = depth(node, root.getRight());
//			if (rightDepth >= 0) {
//				return rightDepth + 1;
//			}
//		}
		int i = -1;
		if (root.getData().compareTo(node) == 0 || (i = depth(node, root.getLeft())) >= 0
				|| (i = depth(node, root.getRight())) >= 0) {
			return i + 1;
		}

		return -1;

	}

	public int height(BNode<E> root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return 0;
		}
		int left = 1 + height(root.getLeft());
		int right = 1 + height(root.getRight());
		return Math.max(left, right);
	}

	public int size(BNode<E> root) {
		if (root == null) {
			return 0;
		}

		return 1 + size(root.getLeft()) + size(root.getRight());

	}

	public boolean contains(E e, BNode<E> root) {
		if (root == null) {
			return false;
		}
		if (root.getData().compareTo(e) == 0) {
			return true;
		} else if (root.getData().compareTo(e) > 0) {
			return contains(e, root.getLeft());
		} else if (root.getData().compareTo(e) < 0) {
			return contains(e, root.getRight());
		}

		return false;
	}

	public E findMin(BNode<E> root) {
		if (root.getLeft() == null) {
			return root.getData();
		} else {
			return findMin(root.getLeft());
		}
	}

	public E findMax(BNode<E> root) {
		if (root.getRight() == null) {
			return root.getData();
		} else {
			return findMax(root.getRight());
		}

	}

	public BNode<E> remove(E e, BNode<E> root) {
		if (root == null) {
			return null;
		} else if (root.getData().compareTo(e) > 0) {
			root.setLeft(remove(e, root.getLeft()));
			return root;
		} else if (root.getData().compareTo(e) < 0) {
			root.setRight(remove(e, root.getRight()));
			return root;
		} else {
			if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			} else {
				BNode<E> min = root.getRight();
				while (min.getLeft() != null) {
					min = min.getLeft();
				}
				root.setData(min.getData());
				remove(min.getData(), root.getLeft());
				return root;
			}
		}
	}

	public List<E> descendants(E e) {
		List<E> list = new ArrayList<>();

		if (data.compareTo(e) == 0) {
			if (left != null) {
				list.add(left.data);
				list.addAll(left.descendants(left.data));
			}
			if (right != null) {
				list.add(right.data);
				list.addAll(right.descendants(right.data));
			}
			

		} else {
			if (contains(e, left)) {
				return left.descendants(e);
			} else if (contains(e, right)) {
				return right.descendants(e);
			}
		}
		return list;

	}

	public List<E> ancestors(E e) {
		List<E> list = new ArrayList<>();
		if (data.compareTo(e) == 0) {
			return list;
		}
		if (left != null) {
			if (left.contains(e, left)) {
				list.addAll(left.ancestors(e));
				list.add(data);
			}
		}
		if (right != null) {
			if (right.contains(e, right)) {
				list.addAll(right.ancestors(e));
				list.add(data);
			}
		}
		return list;

	}

//	Task 2: Tree Traversal Algorithms
	// display BST using inorder approach
	public void inorder(BNode<E> root) {// L-N-R

		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data);
		inorder(root.right);
	}

	// display BST using preorder approach
	public void preorder(BNode<E> root) { // N-L-R
		if (root == null) {
			return;
		}
		System.out.print(root.data);
		preorder(root.left);
		preorder(root.right);
	}

	// display BST using postorder approach
	public void postorder(BNode<E> root) {// L-R-N
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data);
	}

}
