package graph;

import java.util.ArrayList;
import java.util.*;
import java.util.LinkedList;
//import Heap.*;

import java.util.Queue;
//import java.util.LinkedHashSet;
/**
 * @author vi
 *
 */
public class Graph<E> implements IGraph<E>{
	private int sz=0;
	private ArrayList<Node<E>> nodeList = new ArrayList<Node<E>>();
	private ArrayList<Edge<E>> edgeList = new ArrayList<Edge<E>>();
	int parent[];
	//public Node<E>[] dfsanc;
	//public Graph(int sz1){
	//	sz=sz1;
	//	dfsanc = (Node<E>[]) new Object[sz];
	//}
	public int size() {
		// TODO Auto-generated method stub
		return sz;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size()==0);
	}

	public ArrayList<Node<E>> getNodes() {
		// TODO Auto-generated method stub
		return nodeList;
	}

	public ArrayList<Edge<E>> getEdges(){
		return edgeList;
	}

	public void addNode(Node<E> curnode) {
		// TODO Auto-generated method stub
		nodeList.add(curnode);
		sz++;
	}

	public int totalDegree() {
		// TODO Auto-generated method stub
		int totdeg=0;
		for(int i=0;i<nodeList.size();i++)
		{
			totdeg+=nodeList.get(i).getNeighbors().size();
		}
		return totdeg;
	}

	public void DFS(Node<E> start) {
		// TODO Auto-generated method stub
		start.visited=true;
		System.out.print(start.getId()+":");
		for(int i=0;i<start.getNeighbors().size();i++)
		{
			if(start.getNeighbors().get(i).visited==false)
			{
				DFS(start.getNeighbors().get(i));
			}
		}
	}
	public void reset(){
		for (int i=0;i<nodeList.size();i++){
			nodeList.get(i).visited=false;
		}
		for (int i=0;i<edgeList.size();i++){
			edgeList.get(i).visited=false;
		}
	}

	public void BFS(Node<E> start) {
		// TODO Auto-generated method stub
		reset();
		Queue<Node<E>>q=new LinkedList<Node<E>>();
		q.add(start);
		while(!q.isEmpty())
		{
			Node<E>temp=q.poll();
			if(temp.visited==false)
			{
			temp.visited=true;
			System.out.print(temp.getId()+":");
			for(int i=0;i<temp.getNeighbors().size();i++)
			{
				
				q.add(temp.getNeighbors().get(i));
			}
			}
		}
	}

	public boolean adjacent(Node<E> n1, Node<E> n2){
		return (n1.getNeighbors().contains(n2));
	}

	public int[][] getAdjMatrix() {
		// TODO Auto-generated method stub
		int[][] adjMatrix = new int[sz][sz];
		for (int i=0;i<nodeList.size();i++){
			for (int j=0;j<nodeList.size();j++){
				if (adjacent(nodeList.get(i),nodeList.get(j)))
					adjMatrix[i][j]=1;
			}
		}
		return adjMatrix;
	}

	public void printGraph() {
		// TODO Auto-generated method stub
		for (int i=0;i<nodeList.size();i++){
			System.out.println("Node"+nodeList.get(i).getId());
			nodeList.get(i).printNeighbors();
		}

	}

	public void addEdge(Node<E> st, Node<E> dest, double wt) {
		// TODO Auto-generated method stub
		int pos1 = nodeList.indexOf(st);
		int pos2 = nodeList.indexOf(dest);
		nodeList.get(pos1).addNeighbor(dest);
		nodeList.get(pos2).addNeighbor(st);
		Edge<E> e1 = new Edge<E>(edgeList.size()+1,st,dest);
		e1.setWt(wt);
		edgeList.add(e1);
	}

	public Node<E> getNode(int id) {
		// TODO Auto-generated method stub
		for (int i=0;i<nodeList.size();i++){
			if (nodeList.get(i).getId()==id) return nodeList.get(i);
		}
		return null;

	}

	public void init_parent()
	{
		parent=new int[nodeList.size()+1];
		for(int i=0;i<nodeList.size()+1;i++)
			parent[i]=i;
	}
	public int getParent(int u)
	{
		//System.out.println(u);
		if(parent[u]==u)
			return u;
		return parent[u]=getParent(parent[u]);
		//return parent[u];
	}
	public void Union(int x,int y)
	{
		int x1=getParent(x);
		int x2=getParent(y);
		parent[x1]=parent[x2];
	}
	public void printparent()
	{
	for(int j=0;j<nodeList.size()+1;j++)
		System.out.println(parent[j]+" ");
	}
	public void MSTKruskal() {
		init_parent();
			 PriorityQueue <Edge<E>>pq=new PriorityQueue<Edge<E>>(
					 (Object ob1,Object ob2)-> {
				 Edge<E>e1=(Edge)ob1;
				 Edge<E>e2=(Edge)ob2;
				 if(e1.getWt()>e2.getWt())
					 return 1;
				 else if(e1.getWt()==e2.getWt()) return 0;
				 else return -1;
			 });
			 for(int i=0;i<edgeList.size();i++)
			 {
				 pq.add(edgeList.get(i));
			 }
			 for(int i=0;i<edgeList.size();i++)
			 {
				 Edge<E>temp=pq.poll();
				 Node<E>start=temp.getStart();
				 Node<E>end=temp.getDest();
				 int par1=getParent(start.getId());
				 int par2=getParent(end.getId());
				// System.out.println(par1+" "+par2);
				 if(par1!=par2)
				 {
					Union(start.getId(),end.getId());
					 //parent[end.getId()]=start.getId();
					System.out.println(start.getId()+":"+end.getId());
					//printparent();
				 }
			 }
	}




	public boolean hasCycleUtil(Node<E>start,Node<E>parent)
	{
		start.visited=true;
		for(int i=0;i<start.getNeighbors().size();i++)
		{
			if(start.getNeighbors().get(i).visited==false)
			{
				if(hasCycleUtil(start.getNeighbors().get(i),start))
						return true;
			}
			else if(start.getNeighbors().get(i)!=parent)
			{
				return true;
			}
		}
		return false;
	}
	public boolean hasCycle(){
		reset();
		for(int i=0;i<nodeList.size();i++)
		{
			if(nodeList.get(i).visited==false)
				if(hasCycleUtil(nodeList.get(i),null))
					return true;
		}
		return false;
	}

	public Edge<E> getEdge(Node<E> s, Node<E> d) {
		// TODO Auto-generated method stub
		//Edge<E> temp;
		for (int i=0;i<edgeList.size();i++)
		{
			if ((edgeList.get(i).getStart().getId()==s.getId() && edgeList.get(i).getDest().getId()==d.getId()) ||
					(edgeList.get(i).getStart().getId()==d.getId() && edgeList.get(i).getDest().getId()==s.getId())){
				return edgeList.get(i);
			}
		}
		return null;
	}


}
