package tree;

public class testTree<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBinaryTree<Integer> btree1 = new BinaryTree<Integer>();
		
		Integer[] testlist = new Integer[16];
		testlist[0]=null;
		for (int i=1;i<10;i++){
			
			if(i==5)
				testlist[i]=null;
			else
			  testlist[i]=i;
		}
		testlist[7]=null;
		//for (int i=10;i<16;i++){
			//testlist[i]=null;
		//}
		btree1.constructTree(testlist);
		btree1.printTree();
		Node<Integer> temp = (Node<Integer>)btree1.getNode(4);
		System.out.println("Depth"+btree1.getDepth(temp));
		temp = (Node<Integer>)btree1.getNode(1);
		System.out.println("Height"+btree1.getHeight(temp));
		System.out.println("Inorder Traversal");
		btree1.inorderTraverse((Node<Integer>) btree1.getRoot());
		System.out.println();
		System.out.println("Preorder Traversal");
		btree1.preorderTraverse((Node<Integer>) btree1.getRoot());
		System.out.println();
		System.out.println("Postorder Traversal");
		btree1.postorderTraverse((Node<Integer>) btree1.getRoot());
		System.out.println("\nLevel order Traversal");
		btree1.levelorderTraverse((Node<Integer>) btree1.getRoot());
		System.out.print(btree1.isProper());
		System.out.println("\nExternal nodes are");
		btree1.printExternal();
		System.out.println("The top view for the tree is");
		btree1.topV();
		//btree1.topView((Node<Integer>)btree1.getRoot(), 0);
		temp = (Node<Integer>)btree1.getNode(8);
		Node<Integer> temp2 = (Node<Integer>)btree1.getNode(9);
		btree1.common(temp,temp2);
	}

}
