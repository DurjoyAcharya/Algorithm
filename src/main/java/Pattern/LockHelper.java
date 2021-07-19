package Pattern;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

public class LockHelper {
    public static void WithLock(Lock lock,Runnable runnable) {
        lock.lock();
        try {
            runnable.run();
        } finally {
            lock.unlock();
        }
    }
    public static <T> T WithLock(Lock lock, Supplier<T> supplier)
    {
        lock.lock();
        try
        {
            return supplier.get();
        }finally {
            lock.unlock();
        }
    }
}
