package EncryptionDecryption;

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










    public static void main(String[] args) {

    }
}
