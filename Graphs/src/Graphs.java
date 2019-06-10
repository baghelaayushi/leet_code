import java.util.LinkedList;

public class Graphs {
    //creating adjaceny matrix representation of graph
    static class adjacenyMatrix{
        int V;
        int adjMatrixArray[][];
        // constructor to generate a matrix based on number of edges
        adjacenyMatrix(int V){
            this.V = V;
            if(V>0) {
                adjMatrixArray = new int[V][V];
            }
            else
                adjMatrixArray = new int[0][0];
        }
        // function to add value of 1
        // if an edge is present from source to destination
        static void addEdge(adjacenyMatrix graph,int source, int destination){
           graph.adjMatrixArray[source][destination] = 1;
           graph.adjMatrixArray[destination][source] =1;
        }

        //to view the graph
        static void viewGraph(adjacenyMatrix graph){
             for(int i=0; i<graph.adjMatrixArray.length;i++) {
                 for (int j = 0; j < graph.adjMatrixArray[i].length; j++) {
                     System.out.print(graph.adjMatrixArray[i][j]);
                 }
                 System.out.println();
             }
        }
    }

    //creating adjacencly list representation of graph
    static class adjacencyList{
        int V;
        LinkedList<Integer> adjListarray[];

        adjacencyList(int V){
            this.V = V;
            //the size of array is number of vertices
            adjListarray = new LinkedList[V];

            // Create a new list for each vertex
            // such that adjacent nodes can be stored
            for(int i = 0; i < V ; i++){
                adjListarray[i] = new LinkedList<>();
            }

        }

        public static void addEdge(adjacencyList graph, int src, int dest)
        {
            // Add an edge from src to dest.
            graph.adjListarray[src].add(dest);

            // Since graph is undirected, add an edge from dest
            // to src also
            graph.adjListarray[dest].add(src);
        }

        static void viewGraph(adjacencyList graph){
            for(int v = 0; v < graph.V; v++)
            {
                System.out.println("Adjacency list of vertex "+ v);
                System.out.print("head");
                for(Integer pCrawl: graph.adjListarray[v]){
                    System.out.print(" -> "+pCrawl);
                }
                System.out.println("\n");
            }

        }

    }
}
