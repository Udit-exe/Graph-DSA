import java.util.*;

public class PrismAlgo{
	static class Edge{
		int src,dest,wt;

		public Edge(int s, int d, int w){
			this.src = s;
			this.dest = d;
			this.wt = w;
		}
	}

	public static void createGraph(ArrayList<Edge> graph[] , int V){
		for(int i=0; i< V ;	i++){
			graph[i]= new ArrayList<Edge>();
		}

		graph[0].add(new Edge(0,1,10));
		graph[0].add(new Edge(0,3,30));
		graph[0].add(new Edge(0,2,15));

		graph[1].add(new Edge(1,3,40));
		
		graph[2].add(new Edge(2,3,50));

	}

	static class Pair implements Comparable<Pair>{
		int n;
		int cost;

		Pair(int n, int p){
			this.n = n;
			this.cost = p;
		}

		@Override
		public int compareTo(Pair p2){
			return this.cost - p2.cost;
		}
	}


	public static void prismAlgo(ArrayList<Edge> graph[] , int V){
		boolean vis[] = new boolean[V];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int mstCost = 0;

		pq.add(new Pair(0,0));

		while(!pq.isEmpty()){
			Pair curr = pq.remove();
			if(!vis[curr.n]){
				vis[curr.n] = true;
				mstCost += curr.cost;				

				for(int i=0; i< graph[curr.n].size(); i++){
					Edge e = graph[curr.n].get(i);
					if(!vis[e.dest]){
						pq.add(new Pair(e.dest, e.wt));
					}
				}	
			}
		}
		System.out.println("min cost of mst  = "+ mstCost);

	}

	public static void main(String args[]){
		int V =4;
		ArrayList<Edge> graph[] = new ArrayList[V];

		createGraph(graph, V);
		prismAlgo(graph,V);

	}

}
