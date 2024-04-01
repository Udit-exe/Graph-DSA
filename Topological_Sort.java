


import java.util.*;

public class Topological_Sort{

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
			graph[i] = new ArrayList<>();	//adding empyt array list so that we can add Edges in it.
		}

		graph[5].add(new Edge(5,0));
		graph[5].add(new Edge(5,2));
		
		graph[4].add(new Edge(4,0));
		graph[4].add(new Edge(4,1));
		
		graph[2].add(new Edge(2,3));
		graph[3].add(new Edge(3,1));

		// graph[0].add(new Edge(0,1));
		// graph[0].add(new Edge(0,2));

		// graph[1].add(new Edge(1,0));
		// graph[1].add(new Edge(1,3));

		// graph[2].add(new Edge(2,0));
		// graph[2].add(new Edge(2,4));

		// graph[3].add(new Edge(3,4));
		// graph[3].add(new Edge(3,5));

		// graph[4].add(new Edge(4,2));
		// graph[4].add(new Edge(4,3));
		// graph[4].add(new Edge(4,5));

		// graph[5].add(new Edge(5,3));
		// graph[5].add(new Edge(5,4));
		// graph[5].add(new Edge(5,6));

		// graph[6].add(new Edge(6,5));
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

	public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
		System.out.print(curr + " ");
		vis[curr] = true;

		for(int i=0; i < graph[curr].size() ;i++){
			Edge e = graph[curr].get(i);
			if(vis[e.dest] == false){
				dfs(graph, e.dest , vis);
			}
		}

	}

  public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean vis[] , int curr, int par){
    vis[curr] = true;

    for(int i=0; i< graph[curr].size() ;i++){
      Edge e = graph[curr].get(i);

      if(vis[e.dest] && par != e.dest){ //agar hamara neighbour exist krta h aur hamara neighbour parent nhi hai
        return true;    //to cycle exist krti hai.
      }

      if(!vis[e.dest]){
        return isCycleUndirected(graph , vis, e.dest, curr);
      }
    } 
    return false;
  }

	//Topological Sorting...
	public static void topoSortUtil(ArrayList<Edge> graph[], boolean vis[] ,int curr, Stack<Integer> stack){
		vis[curr] = true;

		for(int i=0; i< graph[curr].size(); i++){
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]){
				topoSortUtil(graph, vis, e.dest, stack);
			}
		}
		stack.push(curr);
	}

	public static void topoSort(ArrayList<Edge> graph[], int V){
		Stack<Integer> stack = new Stack();
		boolean vis[] = new boolean[V];

		for(int i=0; i< V; i++){
			if(!vis[i]){
				topoSortUtil(graph, vis, i,stack);
			}
		}

		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}

	}

	public static void main(String args[]){		//O(V+E)......
		int V= 6;
		
		/*
			set V=7 to use below graph. also remove comments from above createGraph function.
						1 - 3
					/			|	\
				0				|		5	-	6
					\			|	/
						2	-	4 
		*/

		ArrayList<Edge> graph[] = new ArrayList[V];
		// boolean vis[] = new boolean[V];	//	vis array to store visited or not
		createGraph(graph);

		// System.out.print("BFS: ");
		// for(int i=0; i< vis.length ; i++){	//used in case of discconnected componenets.....
		// 	if(vis[i] == false){	//if element has not been visited
		// 		BFS(graph, V ,vis ,i);
		// 	}
		// }
		// System.out.println();

		// System.out.print("DFS: ");
		// for(int i=0; i< vis.length ; i++){	//used in case of discconnected componenets.....
		// 	if(vis[i] == false){	//if element has not been visited
		// 		dfs(graph, i ,vis);
		// 	}
		// }
    // System.out.println( isCycleUndirected(graph, vis, 0, -1));
		topoSort(graph, V);		
		


		System.out.println();
	}
}
