import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
	//declared all my nodes and trees 
	BinaryTreeNode<Integer> node1;
	BinaryTreeNode<Integer> node2;
	BinaryTreeNode<Integer> node3;
	BinaryTreeNode<Integer> node4;
	BinaryTreeNode<Integer> node5;
	BinaryTreeNode<Integer> node6;
	BinaryTreeNode<Integer> node7;
	BinaryTreeNode<Integer> node8;
	//
	BinaryTreeNode<Integer> node11;
	BinaryTreeNode<Integer> node22;
	BinaryTreeNode<Integer> node33;
	BinaryTreeNode<Integer> node44;
	BinaryTreeNode<Integer> node55;
	BinaryTreeNode<Integer> node66;
	BinaryTreeNode<Integer> node77;
	BinaryTreeNode<Integer> node88;
	BinaryTreeNode<Integer> copy1;
	BinaryTreeNode<Integer> copy2;
	BinaryTreeNode<Integer> node12;
	BinaryTreeNode<Integer> node13;
	BinaryTreeNode<Integer> node14;

	
	//TREES
	BinaryTree<Integer> tree; 
	BinaryTree<Integer> tree1; 
	BinaryTree<Integer> combined; 




	@Before
	public void setUp() throws Exception {
		// this is what i use for my first tree (tree)
		node1 = new BinaryTreeNode<Integer>(1);
		node2 = new BinaryTreeNode<Integer>(2);
		node3 = new BinaryTreeNode<Integer>(3);
		node4 = new BinaryTreeNode<Integer>(4);
		node5 = new BinaryTreeNode<Integer>(5);
		node6 = new BinaryTreeNode<Integer>(6);
		node7 = new BinaryTreeNode<Integer>(7);
		node8 = new BinaryTreeNode<Integer>(8);
		// i use these nodes for my second tree (tree1)
		// has the same structure as tree but different values
		node11 = new BinaryTreeNode<Integer>(11);
		node22 = new BinaryTreeNode<Integer>(22);
		node33 = new BinaryTreeNode<Integer>(33);
		node44 = new BinaryTreeNode<Integer>(44);
		node55 = new BinaryTreeNode<Integer>(55);
		node66 = new BinaryTreeNode<Integer>(66);
		node77 = new BinaryTreeNode<Integer>(77);
		
		node13 = new BinaryTreeNode<Integer>(44);
		node14 = new BinaryTreeNode<Integer>(55);



		
		//tree 1
		node1.setLeft(node2);
		node1.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		node3.setRight(node7);
		// Tree 2
		node11.setLeft(node22);
		node11.setRight(node33);
		node22.setLeft(node44);
		node22.setRight(node55);
		node33.setLeft(node66);
		node33.setRight(node77);
		//node77.setRight(node88);
		
		node88 = new BinaryTreeNode<Integer>(99, node1, node11);
		// i made a legit copy of the combined tree which is copy1 and then one which was not the same (copy2)
		copy1 = new BinaryTreeNode<Integer>(99, node1, node11);
		copy2 = new BinaryTreeNode<Integer>(99, null, node11);
		node12 = new BinaryTreeNode<Integer>(22, node13, node14);

		
		tree = new BinaryTree<Integer>(node1);
		tree1 = new BinaryTree<Integer>(node11);
		// the combined tree has tree as its left subtree and tree1 as its right subtree 
		combined = new BinaryTree<Integer>(node88);

		
	}

	@Test
	public void treeTreeFullTest(){
		assertTrue(tree1.full());
	}
	@Test
	public void treeTreeFullTest2(){
		assertTrue(combined.full());
	}
	@Test
	public void fullTest(){
		assertTrue(node88.full());
	}
	@Test
	public void fullTest2(){
		assertFalse(copy2.full());
	}
	@Test
	public void inOrderNodeTest(){
		assertEquals(copy2.inOrder(),"(99)(44)(22)(55)(11)(66)(33)(77)");
	}
	@Test
	public void inOrderNodeTest2(){
		assertEquals(node88.inOrder(),"(4)(2)(5)(1)(6)(3)(7)(99)(44)(22)(55)(11)(66)(33)(77)");
	}
	@Test
	public void InOrderTreeTest(){
		assertEquals(tree.inOrder(),"(4)(2)(5)(1)(6)(3)(7)");
	}
	@Test
	public void InOrderTreeTest2(){
		assertEquals(tree1.inOrder(),"(44)(22)(55)(11)(66)(33)(77)");
	}
	@Test
	public void mirrorTest(){
		tree1.mirror();
		assertEquals(tree1.inOrder(),"(77)(33)(66)(11)(55)(22)(44)");

	}
	@Test
	public void mirrorTest2(){
		combined.mirror();
		assertEquals(node88.inOrder(),"(77)(33)(66)(11)(55)(22)(44)(99)(7)(3)(6)(1)(5)(2)(4)");
	}
	@Test
	public void sizeNodeTest(){
		assertEquals(node1.size(),7);
	}
	@Test
	public void sizeNodeTest2(){
		assertEquals(copy2.size(),8);
	}
	@Test
	public void SizeTreeTest(){
		assertEquals(tree1.size(),7);
	}
	@Test
	public void SizeTreeTest2(){
		assertEquals(combined.size(),15);
	}
	@Test
	public void equalsNodeTest(){
		assertTrue(node22.equals(node12));
	}
	@Test
	public void equalsNodeTest2(){
		assertFalse(node1.equals(node11));
	}
	@Test
	public void EqualsTreeTest(){
		BinaryTree<Integer> tempParent = tree.deepCopy();
		assertTrue(tree.equals(tempParent));
	}
	@Test
	public void EqualsTreeTest2(){
		assertFalse(tree.equals(tree1));
	}
	@Test
	public void deepCopyNodeTest(){
		BinaryTreeNode<Integer> tempCopy = node22.deepCopy();
		assertEquals(node22.inOrder(),tempCopy.inOrder());
	}
	@Test
	public void deepCopyNodeTest2(){
		BinaryTreeNode<Integer> tempCopy = node11.deepCopy();
		assertFalse(node1.inOrder()==tempCopy.inOrder());
	}
	@Test
	public void DeepCopyTreeTest(){
		BinaryTree<Integer> tempCopy = tree.deepCopy();
		assertEquals(tree.inOrder(),tempCopy.inOrder());
	}
	@Test
	public void DeepCopyTreeTest2(){
		BinaryTree<Integer> tempCopy = tree1.deepCopy();
		assertFalse(tree.inOrder()==tempCopy.inOrder());
	}
	@Test
	public void HeightTreeTest(){
		assertTrue(tree.height() == 3);
	}
	@Test
	public void HeightTreeTest2(){
		assertTrue(combined.height() == 4);
	}
	@Test
	public void heightNodeTest(){
		assertTrue(node1.height() == 3);
	}
	@Test
	public void heightNodeTest2(){
		assertTrue(node33.height()==2);
	}

	//Binary Tree tests
	
	
	@Test
	public void MirrorNodeTest(){
		node2.mirror();
		assertEquals(node2.inOrder(),"(5)(2)(4)");

	}
	@Test
	public void MirrorNodeTest2(){
		node33.mirror();
		assertEquals(node33.inOrder(),"(77)(33)(66)");
	}
	@Test
	public void treeCombineTest(){
		BinaryTreeNode<Integer> newnode = new BinaryTreeNode<Integer>(17);
		assertEquals("(44)(22)(55)(11)(66)(33)(77)(17)(4)(2)(5)(1)(6)(3)(7)",tree.combine(newnode, tree1, false).inOrder());
	}
	@Test
	public void treeCombineTest2(){
		BinaryTreeNode<Integer> newnode = new BinaryTreeNode<Integer>(18);
		tree1.mirror();
		assertEquals("(77)(33)(66)(11)(55)(22)(44)(18)(4)(2)(5)(1)(6)(3)(7)",tree1.combine(newnode, tree, true).inOrder());
	}

}
