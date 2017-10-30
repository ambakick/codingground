package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
//import Heap.*;

import java.util.Queue;
//import java.util.LinkedHashSet;
/**
 * @author vi
 *
 */
public class primgraph <E>implements PGraph<E>{
	private int sz=0;
	private ArrayList<Node<E>> nodeList = new ArrayList<Node<E>>();
	private ArrayList<Edge<E>> edgeList = new ArrayList<Edge<E>>();
	private int Key[];
	private boolean visited[];
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

	public int getMinKey()
	{
		int minKey=Integer.MAX_VALUE;
		int minId=0;
		for(int i=1;i<nodeList.size()+1;i++)
		{
			if(Key[i]<minKey&&visited[i]==false)
			{
				minKey=Key[i];
				minId=i;
			}
		}
		return minId;
	}
	public void MSTPrim() {
		Key=new int[nodeList.size()+1];
		int sum=0;
		visited=new boolean[nodeList.size()+1];
		for(int i=0;i<nodeList.size()+1;i++)
		{
			Key[i]=Integer.MAX_VALUE;
			visited[i]=false;
		}
		//visited[0]=true;
		Key[1]=0;
		for(int i=0;i<nodeList.size()-1;i++)
		{
			int u=getMinKey();
			visited[u]=true;
			//System.out.println(u+":");
			System.out.println(u+" ");
			Node<E>node1=nodeList.get(u-1);
			
			sum=sum+Key[u];
			// to check the neighbours
			/*for(int j=0;j<node1.getNeighbors().size();j++)
			{
				System.out.println(node1.getNeighbors().get(j).getId()+" ");
			}*/
			// this was wrong  nodeList.get(node1.getNeighbors().get(j).getId())
			for(int j=0;j<node1.getNeighbors().size();j++)
			{
				//System.out.println(node1.getId());
					Node<E>node2=node1.getNeighbors().get(j);
					System.out.print(node1.getId()+" "+node2.getId()+" ");
					Edge<E>e1=getEdge(node1,node2);
					if(visited[node2.getId()]==false)
					{
						System.out.println(e1.getWt());
						if(e1.getWt()<Key[node2.getId()])
						Key[node2.getId()]=(int) e1.getWt();
					}
			}
			// printing the weight array key
		}
		for(int i=0;i<nodeList.size()+1;i++)
		{
			System.out.print(Key[i]+" ");
		}
		System.out.println("Weight of the MST is : "+sum);
	}

	public boolean hasCycle(){
		return false;
	}

	public Edge<E> getEdge(Node<E> s, Node<E> d) {
		// TODO Auto-generated method stub
		//Edge<E> temp;
		for (int i=0;i<edgeList.size();i++)
		{
			//System.out.println("Hello");
			//System.out.println("\n"+s.getId()+" "+d.getId());
			if ((edgeList.get(i).getStart().getId()==s.getId() && edgeList.get(i).getDest().getId()==d.getId()) ||
					(edgeList.get(i).getStart().getId()==d.getId() && edgeList.get(i).getDest().getId()==s.getId())){
				System.out.println("HI");
				return edgeList.get(i);
			}
		}
		return null;
	}


}
