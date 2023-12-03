package lab11_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.add(5);
		bst.add(1);
		bst.add(0);
		bst.add(3);
		bst.add(8);
		bst.add(9);
		bst.add(6);
		bst.add(2);
		bst.add(7);
		List<Integer> list = new ArrayList<>(Arrays.asList(3,1,2,5,4,6,7,0));
		bst.add(list);
		System.out.println(bst.depth(1));
		System.out.println(bst.depth(5));
		System.out.println(bst.depth(9));
		System.out.println(bst.depth(2));
		System.out.println(bst.depth(10));
		System.out.println(bst.height());
		System.out.println(bst.size());
		System.out.println(bst.contains(2));
		System.out.println(bst.contains(10));
		System.out.println(bst.findMin());
		System.out.println(bst.findMax());
		System.out.println(bst.remove(2));
		System.out.println(bst.remove(6));
		System.out.println(bst.remove(5));
		System.out.println(bst.remove(10));
		System.out.println(bst.descendants(2));
		System.out.println(bst.descendants(1));
		System.out.println(bst.descendants(5));
		System.out.println(bst.descendants(6));
		System.out.println(bst.descendants(8));
		System.out.println(bst.ancestors(5));
		System.out.println(bst.ancestors(3));
		System.out.println(bst.ancestors(7));
		System.out.println("Inorder:");
		bst.inorder();
		System.out.println( "\n"+ "Preorder:" );
		bst.preorder();
		System.out.println( "\n"+"Postorder:");
		bst.postorder();
		
	}
}
