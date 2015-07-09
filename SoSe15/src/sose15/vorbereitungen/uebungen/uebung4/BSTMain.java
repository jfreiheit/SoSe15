package sose15.vorbereitungen.uebungen.uebung4;

public class BSTMain {

	public static void main(String[] args) {
		BST tree = new BST();
		tree.put('S', 0);
		tree.put('E', 1);
		tree.put('A', 2);
		tree.put('R', 3);
		tree.put('C', 4);
		tree.put('H', 5);
		tree.put('E', 6);
		tree.put('X', 7);
		tree.put('A', 8);
		tree.put('M', 9);
		tree.put('P', 10);
		tree.put('L', 11);
		tree.put('E', 12);
		tree.print();
	}

}
