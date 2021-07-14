package CodingChallenge;

class MyTask implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <=1000; i++) {
            System.out.print("R");
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <=1000; i++) {
            System.out.print("T");
        }
    }
}
public class ThreadClassTask {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
        Thread thread=new Thread(new MyTask());
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.print("M");
        }
    }
}
