package Algorithms_i;

import java.util.LinkedList;
public class Vertex {
    LinkedList<Vertex> adj;
    int data;
    int color;//0=yellow, 1=green, 2=red
    int distance;//from start vertex
    Vertex parent;
    int discoveryTime;
    int finishTime;
    boolean extracted;

    public Vertex(int data){
        this.data=data;
        color=0;
        distance=-1;
        parent=null;
        adj=new LinkedList<>();
        discoveryTime=0;
        finishTime=0;
    }
}
