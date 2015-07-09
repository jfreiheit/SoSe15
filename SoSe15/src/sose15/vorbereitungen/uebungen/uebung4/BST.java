package sose15.vorbereitungen.uebungen.uebung4;

public class BST {

	private Node root;
	private class Node
	{
		private Character key;
		private Integer value;
		private Node left, right;
		private int N; 				// number of nodes in subtree starting here

		public Node(final Character key, final Integer value, int N)
		{
			this.key = key;
			this.value = value;
			this.N=N;
		}
	}

	public int size()
	{
		return size(root);
	}

	private int size(Node x)
	{
		if (x==null) return 0;
		else return x.N;
	}
	
	// search for a node
	/**
	 * 
	 * @param key
	 * @return value of the Node having given key
	 */
	private Integer get(Character key)
	{
		return get(root, key);
	}
	
	/**
	 * 
	 * @param Node x
	 * @param key
	 * @return the value of the Node requested or null
	 */
	private Integer get(Node x, Character key)
	{
		if (x==null) 		return null;
		int cmp = key.compareTo(x.key);
		if 		(cmp<0) 	return get(x.left, key);
		else if (cmp >0) 	return get(x.right, key);
		else 				return x.value;
	}
	
	// insert a node
	
	/**
	 * searches for key
	 * if key in tree update value
	 * if key not in tree insert new node
	 * @param key
	 * @param value
	 */
	public void put(Character key, Integer value)
	{
		root = put(root, key, value);
	}
	
	private Node put(Node x, Character key, Integer value)
	{
		if(x==null) return new Node(key, value, 1);
		int cmp = key.compareTo(x.key);
		if (cmp<0) x.left = put(x.left, key, value);
		else if (cmp>0) x.right = put(x.right, key, value);
		else x.value = value;
		x.N = size(x.left) + size(x.right) +1;
		return x;
	}
	
	  /**
	   * Print a representation of this BST on System.out.
	   */
	  public void print() {
	    print(root, "");
	  }

	  /**
	   * Print the BST rooted at root, with indent preceding all output lines.
	   * The nodes are printed in in-order.
	   * @param root The root of the tree to be printed.
	   * @param indent The string to go before output lines.
	   */
	  private void print(Node root, String indent) {
	    if (root == null) {
	      System.out.println(indent + "null");
	      return;
	    }

	    // Pick a pretty indent.
	    String newIndent;
	    if (indent.equals("")) {
	      newIndent = ".. ";
	    }
	    else {
	      newIndent = "..." + indent;
	    }

	    print(root.left, newIndent);
	    System.out.println(indent + root.value);
	    print(root.right, newIndent);
	  }
}
