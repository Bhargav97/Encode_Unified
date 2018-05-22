package encoders.encode;


import android.content.Context;
import android.widget.Toast;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph
{
    StringBuilder traversal;

    int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
    private LinkedList<WeightedEdge> weightAdj[]; //For Dijkstra
    boolean weighted;
    PriorityQueue<Integer> q;
    boolean[] visited;
    int[] parent;
    int[] dist;
    int shortestDist;
    String shortestPath;
    // Constructor
    Graph(int v)
    {
        V = v;
        traversal = new StringBuilder("");
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
        weighted=false;
    }
    Graph(int v, boolean weighted){
        this.V = v;
        traversal = new StringBuilder("");
        weightAdj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            weightAdj[i] = new LinkedList<WeightedEdge>();
        }
        this.weighted=weighted;
        q = new PriorityQueue<Integer>(/*V,Collections.reverseOrder()*/);
        visited = new boolean[v];
        dist = new int[v];
        parent = new int[v];
        shortestDist=0;
    }
    // Function to add an edge into the graph
    boolean addEdge(int x,int y, int weight)
    {
        try {
            WeightedEdge we = new WeightedEdge(y,weight);
            weightAdj[x].add(we);
            return true;
        }
        catch (ArrayIndexOutOfBoundsException e){
            return false;
        }

    }
    boolean addEdge(int v,int w)
    {
        try {
            adj[v].add(w);
            return true;
        }
        catch (ArrayIndexOutOfBoundsException e){
            return false;
        }

    }
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        traversal.append(" => " + v);

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
    void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            traversal.append(" => " + s);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void dijkstra(int src, int dest, Context ctx){
        dist[src]=0;
        for(int i=0;i<V;i++){
            if(i!=src)
                dist[i]=999; //infinity
            q.add(i);
        }
        int v,alt;
        Iterator itr = q.iterator();
        while(itr.hasNext()){
            v=q.poll();

            visited[v]=true;
            for(int u=0;u<weightAdj[v].size();u++){
                alt = dist[v] + weightAdj[v].get(u).weight;
                if(alt<dist[weightAdj[v].get(u).dest]){

                    dist[weightAdj[v].get(u).dest]=alt;
                    parent[weightAdj[v].get(u).dest]=v;
                }
            }
        }
        shortestDist=dist[dest];
        int i = dest;
       // Toast.makeText(ctx,"parent[dest] is" + dest+ "and"+Integer.toString(parent[dest]),Toast.LENGTH_LONG).show();
        shortestPath=Integer.toString(dest);
        while(parent[i]!=src){
            shortestPath = Integer.toString(parent[i]) + " > " + shortestPath;
            i=parent[i];
        }
        shortestPath = Integer.toString(parent[i]) + " > " + shortestPath;

    }
}
