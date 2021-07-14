package Algorithms_ii;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Node {
    public int index;
    public List<Neighbour> neighbours;

    Node(int index)
    {
        this.index = index;
    }

    public void setNeighbours(Neighbour... neighbours) {
        this.neighbours = Arrays.stream(neighbours)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {

        return Integer.toString(index);
    }
}

class Neighbour {
    public Node node;
    public int weight;

    Neighbour(Node node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public String toString() {

        return node.toString();
    }
}

public class MultiStageGraph {
    public static int cost(Node v) {
        if (v.index == 12) {
            return 0;
        } else {
            return Collections.min(v.neighbours.stream()
                    .map(i -> cost(i.node) + i.weight)
                    .collect(Collectors.toList()));
        }
    }

    public static int cost(Node startingNode, Node destinationNode) {
        return cost(startingNode);
    }

    public static void main(String[] args) {
        Node v1  = new Node(1);
        Node v2  = new Node(2);
        Node v3  = new Node(3);
        Node v4  = new Node(4);
        Node v5  = new Node(5);
        Node v6  = new Node(6);
        Node v7  = new Node(7);
        Node v8  = new Node(8);
        Node v9  = new Node(9);
        Node v10 = new Node(10);
        Node v11 = new Node(11);
        Node v12 = new Node(12);


        v1.setNeighbours(
                new Neighbour(v2,9),
                new Neighbour(v3,7),
                new Neighbour(v4,3),
                new Neighbour(v5,2)
        );
        v2.setNeighbours(
                new Neighbour(v6,4),
                new Neighbour(v7,2),
                new Neighbour(v8,1)
        );
        v3.setNeighbours(
                new Neighbour(v6,2),
                new Neighbour(v7,7)
        );
        v4.setNeighbours(
                new Neighbour(v8,11)
          );
        v5.setNeighbours(
                new Neighbour(v7,11),
                new Neighbour(v8,8)
        );
        v6.setNeighbours(
                new Neighbour(v9,6),
                new Neighbour(v10,5)
        );

        v7.setNeighbours(
                new Neighbour(v9,4),
                new Neighbour(v10,3)
        );

        v8.setNeighbours(
                new Neighbour(v10,5),
                new Neighbour(v11,6)
        );
        v9.setNeighbours(
                new Neighbour(v12,4)
        );
        v10.setNeighbours(
                new Neighbour(v12,2)
        );
        v11.setNeighbours(
                new Neighbour(v12,5)
        );

        System.out.println(cost(v8,v12));
    }

}
