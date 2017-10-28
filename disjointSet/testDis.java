package disjointSet;

public class testDis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointSet dis=new Disjoint_imp();
		dis.makeSet(1);
		dis.makeSet(2);
		dis.makeSet(3);
		dis.makeSet(4);
		dis.makeSet(5);
		dis.makeSet(6);
		dis.makeSet(7);
		
		dis.Union(1, 2);
		dis.Union(2,3);
		dis.Union(4, 5);
		dis.Union(6,7);
		dis.Union(5,6);
		dis.Union(3,7);
		
		System.out.println(dis.findSet(1));
		System.out.println(dis.findSet(2));
		System.out.println(dis.findSet(3));
		System.out.println(dis.findSet(4));
		System.out.println(dis.findSet(5));
		System.out.println(dis.findSet(6));
		System.out.println(dis.findSet(7));
	}

}
