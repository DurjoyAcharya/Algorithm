package Caching;


// Page Replacement Algorithm
//Least Recently Used (LRU) cache.

//class DoublyLinkedList{
//    class Node {
//        int item;
//        Node previous;
//        Node next;
//
//        public Node(int item) {
//            this.item = item;
//        }
//    }
//    private Node head,tail=null;
//    //add a new Node
//    public void addNode(int value)
//    {
//        var new_node=new Node(value);
//        if (head==null)
//        {
//            head=tail=new_node;
//            head.previous=null;
//            tail.next=null;
//        }
//    }
//
//}


import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node{
        int key;
        int value;
        Node previous,Next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public Node head=new Node(0,0);
    public Node tail=new Node(0,0);
    private int capacity;
    private Map<Integer,Node>map;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
    }
    public int get(int key) {
        if (map.containsKey(key))
        {
            var node=map.get(key);
            delete(node);
            insert(node);
            return node.value;
        }
        return 0;
    }
    private void insert(Node node)
    {
        map.put(node.key, node);
        Node headNext=head.Next;
        head.Next=node;
        node.previous=head;
        headNext.previous=node;
        node.Next=headNext;
    }
    private void delete(Node node){
        map.remove(node.key);
        node.previous.Next=node.Next;
        node.Next.previous=node.previous;
    }
    public void put(int key, int value) {
        if (map.containsKey(key))
            delete(map.get(key));
        if (map.size()==capacity)
            delete(tail.previous);
        insert(new Node(key,value));
    }
    public static void main(String[] args) {

    }
}
