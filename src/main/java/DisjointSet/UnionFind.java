package DisjointSet;
//ref LeetCode
public class UnionFind {
    private int[] root;

    public UnionFind(int size) {
        this.root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i]=i;
        }
    }
    public int find(int x)
    {
        return root[x];
    }
    public void Union(int x,int y)
    {
        int rootX=find(x);
        int rootY=find(y);
        if (rootX!=rootY)
            for (int i = 0; i < root.length; i++) {
                if (root[i]==rootY)
                    root[i]=rootX;
            }
    }
    public boolean isconnected(int x,int y)
    {
        return find(x)==find(y);
    }

    public static void main(String[] args) {
        var obj=new UnionFind(10);
        obj.Union(0,1);
        obj.Union(0,2);
        obj.Union(1,3);
        System.out.println(obj.isconnected(0,1));
        System.out.println(obj.isconnected(1,3));
        System.out.println(obj.isconnected(4,5));
    }
}
