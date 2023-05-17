public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof BinaryTree) {
			BinaryTree a = (BinaryTree)o;
			return this.getRoot().equals(a.getRoot());
		}else {
			return false;
		}
	}

	public BinaryTree<T> deepCopy() {
		//returns a deep copy of the calling object
		BinaryTree<T> why = new BinaryTree<T>();
		 why.setRoot(this.getRoot().deepCopy());
		 return why;

	}

	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t,boolean left) {
		// returns a new tree combining the calling tree (the "this" tree when writing the method)
		//and the parameter t as subtrees of a new BinaryTree with the parameter root as the root of the new tree.
		//The last parameter determines the order in which to attach the subtrees.
		BinaryTreeNode <T> root = new BinaryTreeNode<T>();
		BinaryTree <T> com = new BinaryTree<T>();
	    
		//copy of the input tree
		BinaryTree <T> newT = new BinaryTree<T>();
		newT = t.deepCopy();
		
		//copy of this tree
		BinaryTree <T> newTr = new BinaryTree<T>();
		newTr = this.deepCopy();
		
		//copy of the root
		BinaryTreeNode <T> newTn = new BinaryTreeNode<T>();
		newTn = newRoot.deepCopy();
		
		com.setRoot(root);
		
		 if(left) {
			newTn.setLeft(newTr.getRoot());
			newTn.setRight(newT.getRoot());
		}if(!left) {
			newTn.setLeft(newT.getRoot());
			newTn.setRight(newTr.getRoot());
		}return new BinaryTree<T>(newTn);
		
	}
	
	public int size(){
		//returns (an int) the number of nodes in the tree.
		 if (this.getRoot() == null) {
             return 0;
		 }else {
			 return this.getRoot().size();
		 }
	}
	
	public int height(){
		//returns an int that represents the height of the total tree.
		  if (this.getRoot() == null) {
			  return 0;
		  }else {
			  return this.getRoot().height();
		  }
	}
	
	public boolean full(){
		//returns true if the binary tree is full and complete and false otherwise. 
		  return this.getRoot().getLeft().full() && this.getRoot().getRight().full();
	}
	
	public void mirror(){
		//takes the binary tree and changes the tree to its mirror.
		//changing the calling tree not returning a new one.
		 if (this.getRoot() != null) {
             this.getRoot().mirror();
     }

	}
	
	public String inOrder(){ 
		//returns a string that represents the data held at each node starting with all the nodes
       //of the left child followed by the root then finally all the nodes of the right child. 
		   if (this.getRoot() != null) {
			   return this.getRoot().inOrder();
		   }else {
			   return null;
		   }
	}
}
