package ArtificialIntelligence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
        private int vertices;
        private List<Integer> adjacency[];
        private int edge;
        public Graph(int v)
        {
            this.vertices=v;
            this.adjacency=new ArrayList[v];
            for (int i = 0; i < v; i++)
                adjacency[i]=new ArrayList<Integer>();
        }
        public void addEdge(int source,int destination)
        {
            //For both directional
            adjacency[source].add(destination);
            adjacency[destination].add(source);
        }
        public void PrintGraph()
        {
            for (int i = 1; i < adjacency.length; i++) {
                System.out.print(i+" -> ");
                adjacency[i].forEach(e->{
                    System.out.print(e+" ");
                });
                System.out.println();
            }
        }

    public int getVertices() {
        return vertices;
    }

    public List<Integer> getAdjacency(Integer vertices) {
        return adjacency[vertices];
    }

    public static void main(String[] args) {
        var graph=new Graph(5);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.PrintGraph();
        System.out.println(graph.getAdjacency(1));
    }
}
