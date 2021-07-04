package Algorithms_i;

/**
 * Name:Durjoy Acharjya
 * Id:1925102002
 * Batch:51
 */

import java.util.Arrays;
import java.util.Comparator;

class Checker implements Comparator<int[]> {
    public int compare(int[] o1, int[] o2)
    {
        return Integer.compare(o1[2], o2[2]);
    }
}
public class Kruskal_Algorithm extends Graph{
        int cost;
        boolean cycle;
        int v;
        public Kruskal_Algorithm(int v)
        {
            super(v);
            cost = 0;
            cycle = false;
        }
    void Kruskal(int[][] edges){
        for(int i = 0; i<edges.length; i++){
            int a = edges[i][0], b = edges[i][1], w = edges[i][2];
           // if(a==b) continue; //loop
            addEdge(a, b);
            if(!isCycle()){
                System.out.println(a+" "+b+" "+w+" added");
                cost+=w;
            }else{
                vertex[a].adj.removeLast();
                vertex[b].adj.removeLast();
            }
        }
        System.out.println("Minimum Cost: "+cost);
    }
    void reset(){
        for(int i = 0; i<v; i++)
            vertex[i].color = 0;
        cycle = false;
    }

    boolean isCycle(){
        reset();
        for(int i=0; i<v && !cycle;i++){
            if(vertex[i].color==0)
                DFSVisit(i);
        }
        return cycle;
    }

    void DFSVisit(int u){
        vertex[u].color=1;
        for(Vertex v: vertex[u].adj){
            if(cycle)	break;
            if(v.color==2){//cycle
                cycle = true;
                return;
            }
            if(v.color==0){
                DFSVisit(v.data);
            }
        }
        vertex[u].color=2;
    }
    public static void main(String[] args) {
       java.util.Scanner sc = new java.util.Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][3];
        //edge from a[0] to a[1] with weight a[2]
        for(int i = 0; i<e; i++){
            int a = sc.nextInt(), b = sc.nextInt(), w = sc.nextInt();
            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = w;
        }
        Arrays.sort(edges,new Checker());
        Kruskal_Algorithm KA = new Kruskal_Algorithm(v);
        KA.Kruskal(edges);
        sc.close();
    }
}
