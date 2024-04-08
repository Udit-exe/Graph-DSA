import java.util.*;

public class KosarajuAlgorithm{
  static class Edge{
    int src;
    int dest;

    Edge(int c, int d){
      this.src = c;
      this.dest = d;
    }
  }

  public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
    vis[curr] = true;
    System.out.print(curr+" ");

    for(int i=0;i<graph[curr].size();i++){
      Edge e = graph[curr].get(i);
      if(!vis[e.dest]){
        dfs(graph,e.dest,vis);
      }
    }
  }

  public static void createGraph(ArrayList<Edge> graph[]) {
  for(int i=0; i<graph.length; i++) {
    graph[i] = new ArrayList<Edge>();
  }
    graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));

    graph[1].add(new Edge(1, 0));
    graph[2].add(new Edge(2, 1));
    graph[3].add(new Edge(3, 4));
  }

  public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[] , Stack<Integer> s){
    vis[curr] = true;
    for(int i=0;i < graph[curr].size(); i++){
      Edge e = graph[curr].get(i);
      if(!vis[e.dest]){
        topSort(graph,e.dest,vis,s);
      }
    }
    s.push(curr);
    }

  public static void kosarajuAlgo(ArrayList<Edge> graph[], int v){
    Stack<Integer> s = new Stack<>();
    boolean vis[] = new boolean[v];

    for(int i=0; i<v ;i++){
      if(!vis[i]){
        topSort(graph,i,vis,s);
      }
    }

    ArrayList<Edge> transpose[] = new ArrayList[v];
    for(int i=0 ;i<graph.length ;i++){
      vis[i] = false;
      transpose[i] = new ArrayList<Edge>();
    }

    for(int i=0; i<v ;i++){
      for(int j=0; j<graph[i].size() ; j++){
        Edge e  = graph[i].get(j);
        transpose[e.dest].add(new Edge(e.dest, e.src));
      }
    }

    while(!s.isEmpty()){
      int curr = s.pop();
      if(!vis[curr]){
        dfs(transpose , curr, vis);
        System.out.println();
      }
    }

  }

  public static void main(String args[]){
    int V = 5;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    kosarajuAlgo(graph, V);
  }
}