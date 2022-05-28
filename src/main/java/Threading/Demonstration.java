package Threading;

import java.util.UUID;

//ref educative.io
//Testing sum of 0 to Int_max via single thread and multiple thread
public class Demonstration {
    public static void main(String[] args) throws InterruptedException {
        SumUpExample.runTest();//for two thread
    }
}
class SumUpExample
{
    long startRange;
    long endRange;
    long sumValue;
    static long MAX_NUM=Integer.MAX_VALUE;

    public SumUpExample(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public static void runTest() throws InterruptedException {
        //sumViaTwoThread();
        sumViaOneThread();

    }

    public void sum()
    {
        for (long i = startRange; i <=endRange; i++)
            sumValue+=i;
    }
    public static void sumViaTwoThread() throws InterruptedException
    {
        long startMillSec=System.currentTimeMillis();
        var sum1=new SumUpExample(1,Integer.MAX_VALUE/2);
        var sum2=new SumUpExample((1+Integer.MAX_VALUE/2),Integer.MAX_VALUE);
        var t1=new Thread(sum1::sum);
        var t2=new Thread(sum2::sum);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long finalSum=sum1.sumValue+ sum2.sumValue;
        long endMillSec=System.currentTimeMillis();
        System.out.println("Sum Value is "+finalSum+" takes time via two thread: "+(endMillSec-startMillSec)+"ms");
    }
    public static void sumViaOneThread()
    {
        long startMillSec=System.currentTimeMillis();
        var sum=new SumUpExample(1,Integer.MAX_VALUE);
        sum.sum();
        long endMillSec=System.currentTimeMillis();
        System.out.println("Sum value is "+sum.sumValue+" takes time via single thread "+(endMillSec-startMillSec)+"ms");
    }
}

