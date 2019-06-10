import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class depthFirstTraversal {
    static void DFS(Graphs.adjacencyList graph, int node, boolean visited[]){
        visited[node] = true;
        System.out.print(node+"+");

        // an iterator to print the linked nodes
        Iterator<Integer> i = graph.adjListarray[node].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFS(graph,n, visited);
        }
    }

    public static void main(String args[]){
        // create the graph given in above figure
        int V = 5;
        Graphs.adjacencyList graph = new Graphs.adjacencyList(V);
        Graphs.adjacencyList.addEdge(graph, 0, 1);
        Graphs.adjacencyList.addEdge(graph, 0, 4);
        Graphs.adjacencyList.addEdge(graph, 1, 2);
        Graphs.adjacencyList.addEdge(graph, 1, 3);
        Graphs.adjacencyList.addEdge(graph, 1, 4);
        Graphs.adjacencyList.addEdge(graph, 2, 3);
        Graphs.adjacencyList.addEdge(graph, 3, 4);

        // print the adjacency list representation of
        // the above graph
        Graphs.adjacencyList.viewGraph(graph);

        //The node from which traversal starts
        //An array to keep track of visited values
        //A queue to store the current node to be visited
        int node = 2;
        boolean visited[] = new boolean[graph.V];
        Queue<Integer> queue1 = new LinkedList<>();

        DFS(graph,node,visited);
    }

}
