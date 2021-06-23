package Algorithms_i;

import java.util.LinkedList;
public class Graph {
    int vertices;//No of vertices
    Vertex[] vertex;
    public Graph(int v){
        this.vertices=v;
        vertex=new Vertex[v];
        for(int i=0;i<v;i++)
            vertex[i]=new Vertex(i);
    }
    public void addEdge(int src, int dest)
    {
        vertex[src].adj.add(vertex[dest]);
        if(src!=dest)
            vertex[dest].adj.add(vertex[src]);//remove this line for directed Graph
    }
    public void printList(LinkedList<Vertex> l)
    {
        for(Vertex v:l)
        {
            System.out.print(v.data+", ");
        }
        System.out.println();
    }
public void printAdjacencyList()
{
    for(Vertex v:vertex)
    {
        System.out.print("Vertex "+v.data+"--> ");
        printList(v.adj);
    }
}
    public static void main(String...r) {
        Graph g=new Graph(27);
        g.addEdge(12,15);
        g.addEdge(15,16);
        g.addEdge(16,17);
        g.addEdge(16,23);
        g.addEdge(17,25);
        g.addEdge(23,25);
        g.printAdjacencyList();
    }

}
