
public class BinaryTreeNode<T> {

	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;

	public BinaryTreeNode() {
		this(null, null, null);
	}

	public BinaryTreeNode(T theData) {
		this(theData, null, null);
	}

	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	public int size() {
		int size = 0; // the size of the tree

		// The size of the tree rooted at this node is one more than the
		// sum of the sizes of its children.
		if (left != null) {
			size = size + left.size();
		}
		if (right != null) {
			size = size + right.size();
		}
		return size + 1; // add one to account for the current node
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> deepCopy() {
		//returns a deep copy of the calling object
		 BinaryTreeNode<T> copy = new BinaryTreeNode<T>();
		 copy.left = null;
		 copy.right = null;
         copy.data = null;
          if (this.getLeft() != null){
        	 copy.left = this.getLeft().deepCopy();
         }if (this.getRight() != null){
        	 copy.right = this.getRight().deepCopy();
         }if (this.getData() != null) {
        	 copy.data = this.getData();
         }
         	return copy;

		 
	}

	
	@Override
	public boolean equals(Object o){
	//two BinaryTreeNodes are equal if their data are equal 
	//AND their subtrees are equal (this is recursive!)
	  if( o instanceof BinaryTreeNode) {
		  BinaryTreeNode a = (BinaryTreeNode) o;
		   if ((left == null) && (right != null)) {
			 return (this.getRight().equals(a.getRight()) &&
					   this.getData().equals(a.getData()));
		   } else if ((left != null) && (right == null)) {
			 return (this.getLeft().equals(a.getLeft()) && this.getData().equals(a.getData()));

		   } else if ((left == null) && (right == null)) {
			 return this.getData().equals(a.getData());  
		   } else {
			   return this.getData().equals(a.getData()) && this.getLeft().equals(a.getLeft())
                       && this.getRight().equals(a.getRight());
		   } 


	 } else {
		 return false;
	 }
	}

	public int height() {
		//return the height of the subtree with this current node as the "root".
		 if (this.left != null && this.right == null) {
            return 1 + this.getLeft().height();
		}else if (this.right != null && this.left == null){
			return 1 + this.getRight().height();
		}else if (this.right != null && this.left != null) {
			return 1 + Math.max(this.getRight().height(), this.getLeft().height());
		}else if (this.right == null && this.left == null) {
			return 1;
		}else {
			return 0;
		}
	}

	public boolean full() {
		//returns true if the binary tree is full and complete and false otherwise.
		boolean ans = false;
		 if ((this.left != null) && (this.right != null)) {
			 ans = true;
		 }
		 return ans;
	}

	public void mirror() {
		//takes the binary tree and changes the tree to its mirror.
		//changing the calling tree not returning a new one.
		   BinaryTreeNode<T> mirror = new BinaryTreeNode<T>();
		   if (this.left == null && this.right != null) {
               mirror = this.getRight().deepCopy();
               this.setLeft(mirror);
               this.setRight(null);
               this.left.mirror();

		   } else if (this.left != null && this.right == null) {
			   mirror = this.getLeft().deepCopy();
               this.setLeft(null);
               this.setRight(mirror);
               this.right.mirror();
		   }else if (this.left != null && this.right != null) {
			   mirror = this.getLeft().deepCopy();
               this.setLeft(this.getRight().deepCopy());
               this.setRight(mirror);
               this.right.mirror();
               this.left.mirror();

		   }
	}

	public String inOrder() {
		//returns a string that represents the data held at each node starting with all the nodes
	    //of the left child followed by the root then finally all the nodes of the right child.
		// left, root, right
		  String str = "";
		  if (this.left != null) {
			  str = str + this.getLeft().inOrder();
		  } 
		  str = str + "(" + this.getData() + ")";
		  
		  if(this.right != null) {
			  str = str + this.getRight().inOrder();
		  }return str;
	}

}
