package Algorithms_ii;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;

class EDGE implements Comparable<EDGE> {
    public VERTEX SRC;
    public VERTEX DIST;
    public int WEIGHT;

    public EDGE (int src, int dst, int weight) {
        this.SRC = new VERTEX(src);
        this.DIST = new VERTEX(dst);
        this.WEIGHT = weight;
    }
    @Override
    public int compareTo (EDGE e) {
        return this.WEIGHT - e.WEIGHT;
    }
    @Override
    public String toString() {
        String str = "Source-> " + this.SRC.index +
                "-> Dest-> " + this.DIST.index +
                "-> Weight-> " + this.WEIGHT;
        return str;
    }
}

class VERTEX{
    public int index;

    public VERTEX (int index) {
        this.index = index;
    }
    @Override
    public boolean equals (Object obj) {
        if (obj == null) return false;

//        if (!VERTEX.class.isAssignableFrom(obj.getClass())) {
//            return false;
//        }
        final VERTEX v = (VERTEX) obj;
        return v.index == this.index;
    }
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 53 * hash + (new Integer(this.index).hashCode());
//        return hash;
//    }

}

class GRAPH{
    public EDGE[] edges;
    public VERTEX[] vertices;

    public GRAPH(EDGE[] edges,int v) {
        this.edges=edges;
        vertices=new VERTEX[v];
        for (int i = 0; i < v; i++)
            vertices[i]=new VERTEX(i+1);
    }
    public EDGE[] MST_kruskal()
    {
        var A=new LinkedList<EDGE>();
        DISJOINTSET Set=new DISJOINTSET(vertices.length);
        Arrays.sort(edges);
        for (EDGE e:edges)
        {
            if (Set.find(e.SRC.index)!= Set.find(e.DIST.index))
            {
                A.add(e);
                Set.union(e.SRC.index,e.DIST.index);
            }
        }
        EDGE[] MST = new EDGE[A.size()];
        return A.toArray(MST);
    }
}
class DISJOINTSET {
    private int[] SET;

    public DISJOINTSET(int N) {
        SET = new int[N + 1];
        for (int i = 1; i <= N; i++)
            SET[i] = i;
    }
    public int find(int p) {
                   return SET[p];
    }
    public void union(int p, int q) {
        int root = SET[q];
        for (int i = 1; i < SET.length; i++) {
            if (SET[i] == root) {
                SET[i] = SET[p];
            }
        }
    }
}
public class MST_Kruskal {
    private static final String FILE = "input.txt";
    public static void main(String[] args) {
        try {
            var scan=new java.util.Scanner(new File(FILE));
            int vertices= scan.nextInt();
            int edges= scan.nextInt();
            EDGE[] edges1=new EDGE[edges];
            for (int i = 0; i < edges; i++) {
                int src= scan.nextInt();
                int dest=scan.nextInt();
                int weight= scan.nextInt();
                edges1[i]=new EDGE(src,dest,weight);
            }
            GRAPH G=new GRAPH(edges1,vertices);
            EDGE[] E=G.MST_kruskal();
            int sum = 0;
            for (EDGE e : E) {
                System.out.println(e.toString());
                sum += e.WEIGHT;
            }
            System.out.println("Minimum weight cost: " + sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
