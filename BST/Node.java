package BST;
//Modify this to include a key value pair, and add corresponding methods.

public class Node<E> {

	/**
	 * @param args
	 */
	private E element; 
	private int key;
	private Node<E> parent;
	private Node<E> leftchild;
	private Node<E> rightchild;
	public Node(){
		element = null;
		key = -1;
		parent = null;
		leftchild = null;
		rightchild = null;
	}
	public Node(int k, E e, Node curparent)
	{
		key = k;
		element = e;
		parent = curparent;
	}
	public E getElement(){
		return element;
	}
	public int getKey(){
		return key;
	}
	public Node<E> getParent(){
		return parent;
	}
	public Node<E> getlChild(){
		return leftchild;
	}
	public Node<E> getrChild(){
		return rightchild;
	}
	public void setKey(int k1){
		key = k1;
	}
	public void setElement(E e){
		element = e;
	}
	public void setParent(Node<E> parent1){
		parent = parent1;
	}
	public void setLeft(Node<E> lchild){
		leftchild = lchild;
		leftchild.setParent(this);
	}
	public void setRight(Node<E> rchild){
		rightchild = rchild;
		rightchild.setParent(this);
	}
	public boolean isInternal(){
		return (leftchild!=null || rightchild!=null);
	}
	public boolean isExternal(){
		return (leftchild==null && rightchild ==null);
	}
	public boolean isRoot(){
		return (parent == null);
	}
}



