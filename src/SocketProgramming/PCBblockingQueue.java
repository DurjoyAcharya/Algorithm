package SocketProgramming;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
class Producer{
    void Hotel(BlockingQueue BQ)
    {
        while (!BQ.isEmpty())
        {
            try {
                Thread thread=new Thread(()->{
                    System.out.println(BQ.poll());
                });
                thread.sleep(500);
                thread.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer{

}
public class PCBblockingQueue {
    public static void main(String[] args) {
        var q =new ArrayBlockingQueue<String>(4);
        q.add("Fuck");q.add("Pussy");q.add("OOPS");q.add("Bangladesh");
        Thread thread=new Thread(()->{
            new Producer().Hotel(q);
        });
        try {
            thread.sleep(500);
            thread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
