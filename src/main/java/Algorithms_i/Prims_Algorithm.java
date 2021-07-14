package Algorithms_i;

/**
 * Name:Durjoy Acharjya
 * Id:1925102002
 * Batch:51
 */
public class Prims_Algorithm extends Graph {
    int Cost;
    int[] Key;
    int[] Included;
    public Prims_Algorithm(int v)
    {
        super(v);
        Cost=0;
        Key=new int[v];
        for (int i = 0; i < v; i++)
            Key[i]=Integer.MAX_VALUE;
        Included=new int[v];
    }
    public void Prims(int[][] weight,int start) { // This is Main Engine
        Key[start]=0;
        vertex[start].parent=null;
        int u=MinValueVertex();
        while(u!=-1){
            Cost+=Key[u];
            for(Vertex ver:vertex[u].adj)
            {
                if(Included[ver.data]==0 && weight[u][ver.data]<Key[ver.data]){
                    ver.parent=vertex[u];
                    Key[ver.data]=weight[u][ver.data];
                }
            }
            Included[u]=1;
            u=MinValueVertex();

        }
        System.out.println("Minimum Cost: "+Cost);
    }
    public int MinValueVertex()
    {
        var min=Integer.MAX_VALUE;
        var index=-1;
        for(int i=0;i< Key.length;i++)
        {
            if(Included[i]==0 && Key[i]<min){
                min=Key[i];
                index=i;
            }
        }
        return index;
    }
        public static void main(String[] args) {
        java.util.Scanner sc=new java.util.Scanner(System.in);
            int v=sc.nextInt();
            int e=sc.nextInt();
            int[][] weight=new int[v][v];
            Prims_Algorithm PA=new Prims_Algorithm(v);
            for (int i = 0; i < e; i++) {
                int a = sc.nextInt(), b = sc.nextInt(), w = sc.nextInt();
                weight[a][b]=w;
                weight[b][a]=w;
                PA.addEdge(a,b);
            }
            var start=1;
            PA.Prims(weight,start);
            sc.close();
        }
}
/**
 * 5 8
 * 0 1 1
 * 0 2 4
 * 0 4 2
 * 2 4 3
 * 1 4 3
 * 3 1 3
 * 3 2 1
 * 3 4 2
 */
/**
 * 8 9
 * 1 2 28
 * 1 6 10
 * 5 6 25
 * 4 5 22
 * 3 4 12
 * 2 3 16
 * 5 7 24
 * 2 7 14
 * 4 7 18
 */
