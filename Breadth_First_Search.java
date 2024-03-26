import java.util.*;

public class Breadth_First_Search{

	static class Edge{
		int src;
		int dest;

		public Edge(int s, int d){
			this.src = s;
			this.dest = d;
		}
	}

	public static void createGraph(ArrayList<Edge> graph[]){
		for(int i=0; i< graph.length ;i++){
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,2));

		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,3));

		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,4));

		graph[3].add(new Edge(3,2));
		graph[3].add(new Edge(3,4));
		graph[3].add(new Edge(3,5));

		graph[4].add(new Edge(4,2));
		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));

		graph[5].add(new Edge(5,3));
		graph[5].add(new Edge(5,4));
		graph[5].add(new Edge(5,6));

		graph[6].add(new Edge(6,5));
	}

	public static void BFS(ArrayList<Edge> graph[], int V, boolean vis[], int start){
		Queue<Integer> Q= new LinkedList();		//Queue to perform operations
		Q.add(start);		//starting index

		while(!Q.isEmpty()){
			int curr = Q.remove();
			if(vis[curr] == false){		//if element has not been visited
				System.out.print(curr + " "); 	//printing element
				vis[curr] = true;		//ensuring that the element is visited.......
				//adding neighbours to the Queue
				for(int i=0; i < graph[curr].size() ;i++){
					Edge e = graph[curr].get(i);	//getting ArrayList of edges at that source element.
					Q.add(e.dest);	//neighbours of that element(source)
				}

			}

		}

	} 

	public static void main(String args[]){		//O(V+E)......
		int V= 7;
		
		/*
						1 - 3
					/			|	\
				0				|		5	-	6
					\			|	/
						2	-	4 
		*/

		ArrayList<Edge> graph[] = new ArrayList[V];
		boolean vis[] = new boolean[V];	//	vis array to store visited or not
		createGraph(graph);
		for(int i=0; i< vis.length ; i++){	//used in case of discconnected componenets.....
			if(vis[i] == false){	//if element has not been visited
				BFS(graph, V ,vis ,i);
			}
		}
	
		System.out.println();
	}
}
