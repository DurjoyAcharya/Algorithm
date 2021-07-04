package Algorithms_i;
/**
 * Name:Durjoy Acharjya
 * Id:1925102002
 * Batch:51
 */

import java.util.LinkedList;
public class Vertex {
    LinkedList<Vertex> adj;
    int data;
    Vertex parent;
   // boolean extracted;
    int color;//i assume color 0=white,1=red,2=green

    public Vertex(int data){
        this.data=data;
        parent=null;
        adj=new LinkedList<>();
    }
}
