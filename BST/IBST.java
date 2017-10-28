package BST;


public interface IBST<E> {
	int size();
	boolean isEmpty();
	Object getRoot();
	void setRoot(Node<E> node);
	Object findNode(int val);
	void insertNode(int k1, E val);
	void printTree();
	void inorderTraverse(Node<E> node);
	void preorderTraverse(Node<E> node);
	void postorderTraverse(Node<E> node);
	void levelorderTraverse(Node<E> node);
	int getDepth(Node<E> node);
	int getHeight(Node<E> node);
	//void topView();
	

}
