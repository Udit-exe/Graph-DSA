import java.util.*;

public class Adjacent_List_Method_Undirected_and_Unweighted{

  //Edge Defination.
	static class Edge{
		int src;
		int dest;

		public Edge(int s, int d){
			this.src = s;
			this.dest = d;
		}
	}

  //Code for creating Gaph
	public static void createGraph(ArrayList<Edge> graph[]){
		for(int i=0; i< graph.length ;i++){
			graph[i] = new ArrayList<>();    //Assgning empty arrayLists to array containing null values or poniting to null values.
		}

		graph[0].add(new Edge(0,2));
		graph[1].add(new Edge(1,2));
		graph[1].add(new Edge(1,3));
		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,1));
		graph[2].add(new Edge(2,3));
		graph[3].add(new Edge(3,1));
		graph[3].add(new Edge(3,2));

	}

	public static void main(String args[]){
		int V= 4;
		ArrayList<Edge> graph[] = new ArrayList[V];

		createGraph(graph);

    //Printing Neighbors
		for(int i=0; i < graph[2].size() ;i++){  
			Edge e = graph[2].get(i);  //gets value from edge.....
			System.out.print(e.dest+ " ");  //Since destination is the point where edge ends so we can say it as connection or neighbors 
		}

	}
}
