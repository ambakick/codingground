package BST;

public class testTree<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBST<Integer> btree1 = new BinarySearchTree<Integer>();
		
		btree1.insertNode(10, 10);
		//System.out.println(btree1.getRoot());
		btree1.insertNode(20, 20);
		//System.out.println(btree1.getRoot());
		btree1.insertNode(15, 15);
		btree1.insertNode(3,3);
		btree1.insertNode(6, 6);
		btree1.insertNode(5, 5);
		btree1.insertNode(8, 8);
		System.out.println("--------");
		btree1.printTree();
		System.out.println("\n--------");
		btree1.inorderTraverse((Node<Integer>)btree1.getRoot());
		Node<Integer> temp =(Node<Integer>) btree1.findNode(6);
		System.out.println("Depth"+btree1.getDepth(temp));
		//btree1.topView();
	}

}
