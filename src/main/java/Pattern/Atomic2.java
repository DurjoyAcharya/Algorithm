package Pattern;

import java.util.concurrent.atomic.AtomicInteger;

//
public class Atomic2 {
//    volatile static int value=1;
    public static void main(String[] args) {
            var value= new AtomicInteger(1);
        AtomicInteger finalValue = value;
        Thread t1=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                if (i%2==0)
                    finalValue.incrementAndGet();
            }
            System.out.println("Value In Thread 1: "+ finalValue);
        });
        t1.start();
        System.out.println(value);
        Thread t2=new Thread(()->{
            for (int i = 0; i < 5; i++) {
            //value++;
                finalValue.incrementAndGet();
            }
            System.out.println("Value In Thread 2: "+finalValue);
        });
        t2.start();
        //value++;
        finalValue.compareAndSet(1,5);
        System.out.println("End of the code: "+value);
    }
}
