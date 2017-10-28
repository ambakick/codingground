package BST;

import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree<E> implements IBST<E> {
	private Node<E> root;
	private int sz;
	private Node<E> nodelist[] = new Node[20];
	public BinarySearchTree(){
		root = null;
		sz=0;
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return sz;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return sz==0;
	}

	public Object getRoot() {
		// TODO Auto-generated method stub
		System.out.println(root.getElement()+" "+root.getKey()+" "+root.getlChild()+" "+root.getrChild());
		return root;
	}

	public void setRoot(Node<E> node) {
		// TODO Auto-generated method stub
		root = node;
		sz++;
	}

	public Object findNode(int val) {
		Node<E> temp= root;
		Queue<Node<E>> q=new LinkedList<Node<E>>();
		q.add(temp);
		while(!q.isEmpty())
		{
			
			Node<E> x=q.poll();
			if((int)x.getElement()==val)
				return x;
			else
			{
			q.add(temp.getlChild());
			q.add(temp.getrChild());
			}
		}
		return null;
	}

	public void insertNode(int k1, E val) {
		// TODO Auto-generated method stub
		Node<E> toadd = new Node<E>(k1,val,null);
		Node<E> temp=new Node<E>();
		temp=root;
		int flag=0;
		//Queue<Node<E>> q=new LinkedList<Node<E>>();
		if(root==null)
		{
			root =new Node<E>(k1,val,null);
		}
		else
		{
		while(flag==0)
		{
			
			if(temp.getKey()<=k1)
			{
				if(temp.getlChild()==null)
				{
					temp.setLeft(toadd);
					toadd.setParent(temp);
					flag=1;
				}
				else
				temp=temp.getlChild();
			}
			else
			{
				if(temp.getrChild()==null)
				{
					temp.setRight(toadd);
					toadd.setParent(temp);
					flag=1;
				}
				else
				temp=temp.getrChild();
			}
		}
		}
	}

	public void printTree() {
		// TODO Auto-generated method stub
		preorderTraverse(root);
	}

	public void inorderTraverse(Node<E> node) {
		// TODO Auto-generated method stub
		Node temp=root;
		Queue <Node<E>>q=new LinkedList<Node<E>>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node x=q.poll();
			if(x.getlChild()!=null)
			{
				q.add(x.getlChild());
			}
			System.out.println(x.getElement());
			if(x.getrChild()!=null)
			{
				q.add(x.getrChild());
			}
		}
	}

	public void preorderTraverse(Node<E> node) {
		// TODO Auto-generated method stub
		System.out.print(node.getElement()+":");
		if(node.isInternal()&&node.getlChild()!=null)
			preorderTraverse(node.getlChild());
		if(node.isInternal()&&node.getrChild()!=null)
			preorderTraverse(node.getrChild());
	}

	public void postorderTraverse(Node<E> node) {
		// TODO Auto-generated method stub
		Node temp=root;
		Queue <Node<E>>q=new LinkedList<Node<E>>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node x=q.poll();
			if(x.getlChild()!=null)
			{
				q.add(x.getlChild());
			}
			
			if(x.getrChild()!=null)
			{
				q.add(x.getrChild());
			}
			System.out.println(x.getElement());
		}
	}

	public void levelorderTraverse(Node<E> node) {
		// TODO Auto-generated method stub
		Queue <Node<E>>q=new LinkedList<Node<E>>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node x=q.poll();
			if(x.getlChild()!=null)
			{
				q.add(x.getlChild());
			}
			
			if(x.getrChild()!=null)
			{
				q.add(x.getrChild());
			}
			System.out.println(x.getElement());
		}
	}

	public int getDepth(Node<E> node) {
		// TODO Auto-generated method stub
		Node temp=node;
		int op=0;
		while(temp!=root)
		{
			op++;
			temp=temp.getParent();
		}
		return op;
	}

	public int getHeight(Node<E> node) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return 0;
		}
		else
		{
			int l=getHeight(node.getlChild());
			int r=getHeight(node.getrChild());
			return(1+Math.max(l,r));
		}
	}

	/**
	 * @param args
	 */
	 
	

}
