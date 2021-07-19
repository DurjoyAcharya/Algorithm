package Pattern;

import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserServices {

    private static ExecutorService ePool= Executors.newFixedThreadPool(5);
    public static void main(String...args) throws InterruptedException {

        for (int i = 0; i <10 ; i++) {
//            new Thread(()->{
//                System.out.println(dateBirth()+" "+Thread.currentThread().getName());
//            }).start();
//            Thread.sleep(1000);
            ePool.submit(()->{
                System.out.println(dateBirth()+" "+Thread.currentThread().getName());
            });
         //
        }
        Thread.sleep(500);
        System.out.println(Locale.CHINESE.getDisplayLanguage());
       Thread.interrupted();

    }
    public static String dateBirth()
    {
        return new Date().toString();
    }
}
