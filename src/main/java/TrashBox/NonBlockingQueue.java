package TrashBox;


//ClassCastException
//IllegalStateException
//NullPointerException
//ref https://www.geeksforgeeks.org/queue-offer-method-in-java/

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

public class NonBlockingQueue {
    public static void main(String[] args) {

       // var queue=new LinkedBlockingQueue<Character>(3);
        var queue=new LinkedList<Character>();
        if (queue.offer('A'))
            System.out.println("Queue is not full "+" 'A' is Inserted");
        else
            System.out.println("Queue is Full!");

        if (queue.offer('B'))
            System.out.println("Queue is not full "+" 'B' is Inserted");
            else
                 System.out.println("Queue is Full!");

        if (queue.offer('C'))
            System.out.println("Queue is not full "+" 'C' is Inserted");
            else
                System.out.println("Queue is Full!");

          if (queue.offer('A'))
                System.out.println("Queue is not full "+" 'A' is Inserted");
            else
                System.out.println("Queue is Full!");
        System.out.println("------------------------------------");
        System.out.println("Queue: "+queue);
    }
}
