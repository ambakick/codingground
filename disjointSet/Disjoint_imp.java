package disjointSet;
import java.util.*;
import disjointSet.*;
public class Disjoint_imp implements DisjointSet{
	private Map<Long,node> map=new HashMap<>();

	public void makeSet(long data)
	{
		node newnode=new node();
		newnode.data=data;
		newnode.rank=0;
		newnode.parent=newnode;
		map.put(data,newnode);
	}
	public node findSet(node Node)
	{

		node Parent=Node.parent;
		if(Parent==Node)
		{
			return Parent;
		}
		Node.parent=findSet(Node.parent);
		return Node.parent;
	}
	public long findSet(long data)
	{
		return findSet(map.get(data)).data;
	}
	public void Union(long data1,long data2)
	{
		node node1=map.get(data1);
		node node2=map.get(data2);
		
		node parent1=findSet(node1);
		node parent2=findSet(node2);
		//System.out.println(parent1.data+" "+parent2.data);
		if(parent1==parent2)
			return;
		else
		{
			
			if(parent1.rank>=parent2.rank)
			{
				//System.out.println("hi");
				parent1.rank=(parent1.rank==parent2.rank)?parent1.rank+1:parent1.rank;
				parent2.parent=parent1;
			}
			else
				parent1.parent=parent2;
		}
	}
	
}
