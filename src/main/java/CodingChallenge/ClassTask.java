package CodingChallenge;

class A extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <=2000; i++) {
            System.out.print("A");
        }
    }
}
class B extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <=2000; i++) {
            System.out.print("B");
        }
    }
}
class C implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <=2000; i++) {
            System.out.print("C");
        }
    }
}
class D{//Hare I avoid Implement keyword because Later I use Runnable Interface Internally by using Lamda Expression
    public void run() {
        for (int i = 1; i <=2000; i++) {
            System.out.print("D");
        }
    }
}
public class ClassTask {
    public static void main(String[] args) {
        A obj=new A();
        B obj2=new B();
        Thread obj3=new Thread(new C());
        Thread obj4=new Thread(()->{
            new D().run();
        });
        obj.setPriority(Thread.MAX_PRIORITY);//Thread A chance first because A class Priority is maximum
        obj4.setPriority(Thread.MIN_PRIORITY);//Thread D chance very because A class Priority is minimum
        obj2.setPriority(Thread.NORM_PRIORITY+3);//Thread B get chance higher than C.
        obj3.setPriority(Thread.NORM_PRIORITY+1);
        obj.start();
        obj2.start();
        obj3.start();
        obj4.start();

    }
}
