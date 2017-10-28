package kruskal;
import java.util.ArrayList;
public class Node<E> {
	private E element; 
	private int id;
	//private Map<Node,Integer> neighbors = new HashMap<Node,Integer>();
	private ArrayList<Node> neighbors = new ArrayList<Node>();
		
	public boolean visited= false;
	
	public Node(int id1){
		id = id1;
		
	}
	
	public int getId(){
		return id;
	}
	public E getElement(){
		return element;
	}
	public void setElement(E val){
		element = val;
	}
	public ArrayList<Node> getNeighbors(){
		return neighbors;
	}
	public void addNeighbor(Node cur){
		neighbors.add(cur);
	}
	
	public void removeNeighbor(Node cur){
		neighbors.remove(cur);
	}
	
	public int getDegree(){
		return neighbors.size();
	}
	
	public void printNeighbors(){
		for (int i=0;i<neighbors.size();i++){
			System.out.print(neighbors.get(i).getId()+": ");
		}
	}
	
}
