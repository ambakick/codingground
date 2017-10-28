package kruskal;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.*;
import kruskal.*;

import java.util.Queue;

import disjointSet.*;
//import disjointSet.Disjoint_imp;
//import java.util.LinkedHashSet;
/**
 * @author vi
 *
 */
public class Graph<E> implements IGraph<E>{
	private int sz=0;
	private ArrayList<Node<E>> nodeList = new ArrayList<Node<E>>();
	private ArrayList<Edge<E>> edgeList = new ArrayList<Edge<E>>();
	int pa[];
	
	private ArrayList<Edge<E>> MST=new ArrayList<Edge<E>>();
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
		System.out.print(start.getId()+"::");
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
		Queue <Node<E>>q =new LinkedList<Node<E>>();
		q.add(start);
		while(!q.isEmpty())
		{
			Node<E> temp=q.poll();
			if(temp.visited==false)
			{
			System.out.print(temp.getId()+"::");
			temp.visited=true;
			for(int i=0;i<temp.getNeighbors().size();i++)
			{
				if(temp.getNeighbors().get(i).visited!=true)
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

/*   //Using disjoint sets data structures
	public void MSTKruska() {
		List<Edge<E>> allEdge=new ArrayList<Edge<E>>();
		allEdge=edgeList;
		//allEdge.sort(tocompare);
		//Collections.sort(allEdge,);
		List<Edge<E>> minspan=new ArrayList<Edge<E>>();
		PriorityQueue<Edge<E>> pq = new PriorityQueue<Edge<E>>(
		(Object o1, Object o2) -> {
            Edge<E> first = (Edge<E>)o1;
            Edge<E> second = (Edge<E>)o2;
            
            if(first.getWt()<second.getWt())return -1;
            else if(first.getWt()>second.getWt())return 1;
            else return 0;
        });
		for(int i=0;i<edgeList.size();i++) {
			pq.add(edgeList.get(i));		}
		DisjointSet dis=new Disjoint_imp();
		for(int i=0;i<nodeList.size();i++)
		{
			dis.makeSet(nodeList.get(i).getId());
		}
		for(int i=0;i<allEdge.size();i++)
		{
			node start=new node();
			start.data=allEdge.get(i).getStart().getId();
			node end=new node();
			end.data=allEdge.get(i).getDest().getId();
			node par1=dis.findSet(start);
			node par2=dis.findSet(end);
			if(par1==par2)
				continue;
			else
			{
				System.out.println(par1.data+"-->"+par2.data);
				dis.Union(par1.data, par2.data);
				minspan.add(allEdge.get(i));
			}
			
		}
			 
	}
*/
	
	private void resetParent()
	{
		pa=new int[nodeList.size()+1];
		//System.out.println(parent.);
		//System.out.println(nodeList.size());
		for(int i=0;i<nodeList.size()+1;i++)
		{
			pa[i]=i;
			//System.out.print("hi ");
		}
	}
	private int getParent(int u) {
		if(pa[u] == u) {
			return u;
		}
		
		else
			return pa[u] = getParent(pa[u]);
	}

	private void printEdge(Edge<E>t)
	{
		System.out.println(t.getStart().getId()+"::"+t.getDest().getId());
	}
	public void MSTKruskal()

	{
		resetParent();
		PriorityQueue <Edge<E>>pq=new PriorityQueue<Edge<E>>(
					(Object o1,Object o2)->
					{
						Edge<E>start=(Edge<E>)o1;
						Edge<E>end=(Edge<E>)o2;
						if(start.getWt()>end.getWt()) return 1;
						else if(start.getWt()<end.getWt())return -1;
						else return 0;
					}
				);
		for(int i=0;i<edgeList.size();i++)
		{
			pq.add(edgeList.get(i));
		}
		System.out.println("EdgeList size: "+edgeList.size()+" PQSize()"+pq.size());
		System.out.println();
		for(int i=0;i<pq.size();i++)
		{
			Edge<E>temp=pq.poll();
			//System.out.println("ih");
			printEdge(temp);
			Node<E>one=temp.getStart();
			Node<E>two=temp.getDest();
			int par1=getParent(one.getId());
			int par2=getParent(two.getId());
			if(par1==par2)
				continue;
			else
			{
				pa[two.getId()]=one.getId();
				MST.add(temp);
				//System.out.println("ih");
			}
		}
		
			printMST();	
	}
	public void printMST()
	{
		
		for(int i=0;i<MST.size();i++)
		{
			//System.out.println("ih");
			System.out.print(MST.get(i).getStart().getId()+" :: "+MST.get(i).getDest().getId()+" ");
		}
	}
	public boolean hasCycleUtil(Node <E> start,Node<E>Parent)
	{
		start.visited=true;
		for(int i=0;i<start.getNeighbors().size();i++)
		{
			if(start.getNeighbors().get(i).visited==false)
			{
				if(hasCycleUtil(start.getNeighbors().get(i),start))
				{
					return true;
				}
			}
			else if(start.getNeighbors().get(i)!=Parent)
				return true;
		}
		return false;
	}
	public boolean hasCycle(){
		     //Set<Node<E>> a=new HashSet<Node<E>>();
		    reset();
		    for(int i=0;i<nodeList.size();i++)
		    {
		    	if(nodeList.get(i).visited==false)
		    	{
		    		if(hasCycleUtil(getNode(nodeList.get(i).getId()),null))
		    			return true;
		    		
		    	}
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
