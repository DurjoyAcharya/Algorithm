package EncryptionDecryption;
//ref Javapoint
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Home <T>{
    private Map<T, List<T>> map=new HashMap<>();
    public void addVertex(T node)
    {
        map.put(node,new LinkedList<T>());
    }
    public void addNode(T source,T destination,boolean bidirectional)
    {
        if (!map.containsKey(source))
            addVertex(source);
        if (!map.containsKey(destination))
            addVertex(destination);
        map.get(source).add(destination);
        if (bidirectional)
            map.get(destination).add(source);
    }
    public int countNode()
    {
        return map.keySet().size();
    }
    public void countEdge(boolean bidirectional)
    {
        int count=0;
        for (T v:map.keySet())
            count+=map.get(v).size();
        if (bidirectional)
            count/=2;

        System.out.println("Total Number Of Edge: "+count);
    }
    public void containVertex(T vertex)
    {
        if (map.containsKey(vertex))
            System.out.println("This Graph Contains: "+vertex+" Vertex");
        System.out.println("This Graph Doesn't Contains: "+vertex+" Vertex");

    }
    public void containEdge()
    {

    }











    public static void main(String[] args) {

    }
}
