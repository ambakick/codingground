package disjointSet;

//import disjointSet.Disjoint_imp.node;

public interface DisjointSet {
	public void makeSet(long data);
	public node findSet(node Node);
	public long findSet(long data);
	public void Union(long data1,long data2);
}
