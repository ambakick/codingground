package kruskal;

public class testGraph<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IGraph<Integer> g1 = new Graph<Integer>();
		g1.addNode(new Node<Integer>(1));
		g1.addNode(new Node<Integer>(2));
		g1.addNode(new Node<Integer>(3));
		g1.addNode(new Node<Integer>(4));
		g1.addNode(new Node<Integer>(5));
		g1.addNode(new Node<Integer>(6));
		g1.addNode(new Node<Integer>(7));
		g1.addNode(new Node<Integer>(8));
		g1.addEdge(g1.getNode(1),g1.getNode(2),5.0);
		g1.addEdge(g1.getNode(2),g1.getNode(3),2.0);
		g1.addEdge(g1.getNode(1),g1.getNode(6),4.0);
		g1.addEdge(g1.getNode(3),g1.getNode(4),3.0);
		g1.addEdge(g1.getNode(1), g1.getNode(3),2.0);
		g1.addEdge(g1.getNode(2), g1.getNode(5),7.0);
		g1.addEdge(g1.getNode(3), g1.getNode(8),4.0);
		g1.addEdge(g1.getNode(6), g1.getNode(8),6.0);
		g1.addEdge(g1.getNode(4), g1.getNode(6),2.0);
		g1.addEdge(g1.getNode(3), g1.getNode(7),5.0);
		g1.addEdge(g1.getNode(7), g1.getNode(4),3.0);
		g1.addEdge(g1.getNode(1), g1.getNode(7),5.0);
		g1.printGraph();
		
		//for testing has cycle for a graph
		/*
		g1.addEdge(g1.getNode(1),g1.getNode(2), 3.0);
		g1.addEdge(g1.getNode(2), g1.getNode(3), 5.0);
		g1.addEdge(g1.getNode(3), g1.getNode(4), 1.0);
		g1.addEdge(g1.getNode(3), g1.getNode(3), 4.0);
		*/
		System.out.println("Degree of node"+g1.getNode(1).getDegree());
		int[][] aMatrix = g1.getAdjMatrix();
		for (int i=0;i<aMatrix.length;i++){
			for (int j=0;j<aMatrix.length;j++){
				System.out.print(aMatrix[i][j]+":");
			}
			System.out.println(" ");
		}
		System.out.println();
		System.out.println("BFS");
		g1.BFS(g1.getNode(1));
		System.out.println();
		System.out.println("\nDFS");
		g1.reset();
		g1.DFS(g1.getNode(1));
		System.out.println();
		System.out.println("\nHas Cycle: "+g1.hasCycle());
		System.out.println("\nMST using Kruskal's:");
		g1.MSTKruskal();
		}

}
