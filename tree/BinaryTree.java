package tree;

import java.util.Queue;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.LinkedList;
/**
 * @author vi
 *
 */
public class BinaryTree<E> implements IBinaryTree<E>{
	int depthval=0;
	private Node<E> root;
	private int sz;
	private Node<E> nodelist[] = new Node[20];
	public BinaryTree(){
		root = null;
		sz=0;
	}
	
	
	public Node<E> getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

	public void setRoot(Node<E> node) {
		// TODO Auto-generated method stub
		root = node;
		sz++;
	}
	
	public Node<E> findNode(E val){
		return null;
	}
	
	public Node<E> getNode(int pos){
		return nodelist[pos];
	}
	//inserts a node whose value is elt as a child of curnode
	
	public void insertChild(Node<E> curnode, E elt, char type) {
		// TODO Auto-generated method stub
		if(root==null)
		{
			{Node <E> temp=new Node<E>(elt,null);
			if(type=='l')
			{
				curnode.setLeft(temp);
			}
			else
			{
				curnode.setRight(temp);
			}
		}
		}
		else
		{Node <E> temp=new Node<E>(elt,curnode);
		if(type=='l')
		{
			curnode.setLeft(temp);
		}
		else
		{
			curnode.setRight(temp);
		}
		}
	}

	public void constructTree(E[] eltArray) {
		// TODO Auto-generated method stub
		Node<E> newnode = new Node<E>(eltArray[1],null);
		root = newnode;
		nodelist[0]=null;
		nodelist[1]=root;
		for (int i=2; i<eltArray.length;i++){
			if (eltArray[i]!=null){
				
				if(i%2==0){
					System.out.println(nodelist[i/2]);
					insertChild(nodelist[i/2],eltArray[i],'l');
					nodelist[i]=nodelist[i/2].getlChild();
				}
				else{
					insertChild(nodelist[i/2],eltArray[i],'r');
					nodelist[i]=nodelist[i/2].getrChild();
				}
			}
			else nodelist[i]=null;
		}
	}

	public void printTree() {
		// TODO Auto-generated method stub
		for (int i=0;i<nodelist.length;i++)
		{
			if (nodelist[i]!=null){

				System.out.println("Elt-> "+nodelist[i].getElement() + " Pos->"+i);
			}
			else System.out.println("Null");
		}
		
	}

	public void inorderTraverse(Node<E> node) {
		// TODO Auto-generated method stub
		if(node.getlChild()!=null)
		inorderTraverse(node.getlChild());
		System.out.print(node.getElement()+" -> ");
		if(node.getrChild()!=null)
		inorderTraverse(node.getrChild());
	}

	public void preorderTraverse(Node<E> node) {
		// TODO Auto-generated method stub
		System.out.print(node.getElement()+" -> ");
		if(node.getlChild()!=null)
		preorderTraverse(node.getlChild());
		if(node.getrChild()!=null)
		preorderTraverse(node.getrChild());
	}

	public void postorderTraverse(Node<E> node) {
		// TODO Auto-generated method stub
		if(node.getlChild()!=null)
		postorderTraverse(node.getlChild());
		if(node.getrChild()!=null)
		postorderTraverse(node.getrChild());
		System.out.print(node.getElement()+" -> ");
	}

	public void levelorderTraverse(Node<E> node) {
		// TODO Use the queue to do the traversal. You can also use the inbuilt Queue
		Queue <Node<E>>Elements=new LinkedList<Node<E>>();
		Elements.add(getRoot());
		while(!Elements.isEmpty())
		{
			Node <E> temp=Elements.poll();
			System.out.print(temp.getElement()+" -> ");
			if(temp.getlChild()!=null)
			{
				Elements.add(temp.getlChild());
			}
			if(temp.getrChild()!=null)
			{
				Elements.add(temp.getrChild());
			}
		}
	}

	public int getDepth(Node<E> node) {
		// TODO Auto-generated method stub
		int depth=0;
		while(node!=root)
		{
			depth++;
			node=node.getParent();
		}
		return depth;
	}

	public int getHeight(Node<E> node) {
		// TODO Auto-generated method stub
		int tot=maxDepth(root);
		int d=getDepth(node);
		//System.out.println(node.getElement()+" ");
		return tot-d;

	}
	public int  getLevel(Node<E>node,E ele)
	{
		
		if(node==null)
			return -1;
		if (node.getElement()==ele)
			return depthval;
		else
		{
			int depthleft=getLevel(node.getlChild(),ele);
			int depthright=getLevel(node.getrChild(),ele);
			depthval=1+(depthleft>depthright?depthleft:depthright);
		}		
		return depthval;
	}
	public int size() {
		// TODO Auto-generated method stub
		return sz;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (sz==0);
	}


	public boolean isProper() {
		// TODO Auto-generated method stub
		Queue <Node<E>> q=new  LinkedList <Node<E>> ();
		int flag=0;
		q.add(root);
		while(!q.isEmpty())
		{
			Node<E> temp=q.poll();
			if(temp!=null)
			{
				if((temp.getlChild()==null&&temp.getrChild()!=null)&&(temp.getlChild()!=null&&temp.getrChild()==null))
				{
					flag=1;
					break;
				}
				else
				{
					q.add(temp.getlChild());
					q.add(temp.getrChild());
				}
			}
		}
		return flag==0;
	}


	public void printExternal() {
		// TODO Auto-generated method stub
		// TODO Use the queue to do the traversal. You can also use the inbuilt Queue
		Queue <Node<E>> q=new  LinkedList <Node<E>> ();
		//int flag=0;
		q.add(root);
		while(!q.isEmpty())
		{
			Node<E> temp=q.poll();
			if(temp!=null)
			{
				if((temp.getlChild()==null&&temp.getrChild()==null))
				{
					System.out.println(temp.getElement());
				}
				else
				{
					q.add(temp.getlChild());
					q.add(temp.getrChild());
				}
			}
		}

	}
	public int maxDepth(Node<E> node)
	{
		if(node==null)
			return 0;
		int lDepth=maxDepth(node.getlChild());
		int rDepth=maxDepth(node.getrChild());
		if(lDepth>rDepth)
			return lDepth+1;
		else
			return rDepth+1;
	}

	
	public void topV()
	{
		Node<E> temp=root;
		while(temp.getlChild()!=null)
		{
			temp=temp.getlChild();
		}
		while(temp!=root)
		{
			System.out.print(temp.getElement()+" -> ");
			temp=temp.getParent();
		}
		System.out.print(root.getElement()+" -> ");
		while(temp.getrChild()!=null)
		{
			temp=temp.getrChild();
		}
		while(temp!=root)
		{
			System.out.print(temp.getElement()+" -> ");
			temp=temp.getParent();
		}
	}
	public Node<E> common(Node<E> v1,Node<E> v2)
	{
		Node <E>temp;
		int d1=getDepth(v1);
		int d2=getDepth(v2);
		//System.out.println(d1+" "+d2);
		if(d1>d2)
		{
			while(d1!=d2)
			{
				v1=v1.getParent();
				d1--;
			}
		}
		else if(d1<d2)
		{
			while(d1!=d2)
			{
				v2=v2.getParent();
				d2--;
			}
		}
		while(v1.getParent()!=v2.getParent())
		{
			v1=v1.getParent();
			v2=v2.getParent();
		}
		v1=v1.getParent();
		System.out.println("\n"+v1.getElement());
		return v1;
	}
}