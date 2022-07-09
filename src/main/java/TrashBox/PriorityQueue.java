package TrashBox;



//ref geeks for geeks
public class PriorityQueue {
    public static void Pqoperation_2()
    {
        java.util.PriorityQueue<String> pq = new java.util.PriorityQueue<>();

        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");

        System.out.println("Initial PriorityQueue " + pq);

        // using the method
        pq.remove("Geeks");

        System.out.println("After Remove - " + pq);

        System.out.println("Poll Method - " + pq.poll());

        System.out.println("Final PriorityQueue - " + pq);
    }
    public static void  Pqoperation()
    {
        java.util.PriorityQueue<Integer>priorityQueue=new java.util.PriorityQueue<Integer>(10);
        priorityQueue.add(1);
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(9);
        priorityQueue.add(4);
        System.out.println(priorityQueue);

    }

    public static void main(String[] args) {
       // Pqoperation();
       //qoperation_2();
        //int _=10;//use java 8 only
       // System.out.println(_); //use java 8 only
    }
}
