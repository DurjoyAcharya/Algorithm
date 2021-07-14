package Algorithms_i;



import java.util.Map;
import java.util.PriorityQueue;

class Node{
    Character ch;
    Integer frequency;
    Node left=null,right=null;
    public Node(Character ch,Integer frequency)
    {
        this.ch=ch;
        this.frequency=frequency;
    }
    public Node(Character ch, Integer frequency, Node left, Node right){
        this.ch = ch;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}

public class HuffmanCoding {
    private static Boolean isLeaf(Node root)
    {
        return root.right==null && root.left==null;
    }
    private static void Encode(Node root, String str, Map<Character,String>Hcode)
    {

    }
    public static void main(String[] args) {

    }
}
