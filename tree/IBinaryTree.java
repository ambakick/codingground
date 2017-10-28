package tree;

public interface IBinaryTree<E> {
	int size();
	boolean isEmpty();
	Object getRoot();
	void setRoot(Node<E> node);
	Object getNode(int pos);
	Object findNode(E val);
	void insertChild(Node<E> curnode, E elt, char type);
	void constructTree(E[] eltArray);
	void printTree();
	void inorderTraverse(Node<E> node);
	void preorderTraverse(Node<E> node);
	void postorderTraverse(Node<E> node);
	void levelorderTraverse(Node<E> node);
	int getDepth(Node<E> node);
	int getHeight(Node<E> node);
	boolean isProper(); //this method checks if the given tree is Proper or not
	void printExternal(); //it prints all the external nodes of a tree
	//void topView(Node<E> root, int level);
	void topV();
	Node<E> common(Node <E>v1,Node <E>v2);
}
