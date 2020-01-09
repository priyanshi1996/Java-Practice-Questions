//https://practice.geeksforgeeks.org/problems/find-the-maximum-flow/0

package practice;
import java.util.*;
import java.lang.*;
import java.io.*;
class FordFulkerson
 {
	public static void main (String[] args)
	 {
	 Scanner s=new Scanner(System.in);
	 int T=s.nextInt();
	 while(T>0)
	 {
	    int N = s.nextInt();
	    int M = s.nextInt();
	    int[][] graph = new int[N+1][N+1];
	    
	    
	    for(int i=1;i<=M;i++){
	        int vertexA = s.nextInt();
	        int vertexB = s.nextInt();
	        int capacity = s.nextInt();
	        
	        graph[vertexA][vertexB]+=capacity;
	        graph[vertexB][vertexA]+=capacity;
	    }
	    System.out.println(ford(graph, N));
	    T--;
	 }
	 }
	 public static int ford(int graph[][], int N){
	     int ans = 0;
	    int[] parent = new int[N+1];
	    int[][] resGraph = new int[N+1][N+1];
	    for(int i=1;i<=N;i++)
	    	for(int j=1;j<=N;j++)
	    		resGraph[i][j] = graph[i][j];
	    
	     while(bfs(resGraph,parent, 1, N, N)){
	         int v = N;
	         int minCapacity = Integer.MAX_VALUE;
	         while(v!=1){
	             int u = parent[v];
	             minCapacity = Integer.min(minCapacity, resGraph[u][v]);
	             v = parent[v];
	         }
	         v = N;
	         while(v!=1){
	             int u = parent[v];
	             resGraph[u][v] -= minCapacity;
	             v = parent[v];
	         }
	         
	         ans = ans + minCapacity;
	     }
	     return ans;
	 }
	 
	 public static boolean bfs(int resGraph[][],int[] parent, int src, int dest, int N){
//		 System.out.println("dest "+ N);
	     Queue<Integer> queue = new LinkedList<>();
	     boolean[] visited = new boolean[N+1];
	     queue.add(src);
	     visited[src] = true;
	     while(!queue.isEmpty()){
	         int vertex = queue.remove();
	         
	         for(int i=1;i<=N;i++) {
	        	 if(!visited[i] && resGraph[vertex][i]>0) {
	        		 queue.add(i);
	        		 visited[i]=true;
	        		 parent[i]=vertex;
	        	 }
	         }
	     }
	     return visited[dest]==true;
	    	 
	 }
}
class Edge{
    int node;
    int capacity;
    int residualCap;
    Edge(int node, int capacity, int residualCap){
        this.node = node;
        this.capacity = capacity;
        this.residualCap = residualCap;
    }
}