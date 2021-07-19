package Pattern;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ConcurrentStack<T> {
    private static Lock lock=new ReentrantLock();
    private T[] element;
    private int size=-1;
    public ConcurrentStack()
    {
        this(10);
    }
    public ConcurrentStack(int initialCapacity)
    {
        this.element=(T[]) new Object[initialCapacity];
    }
    public void Push(T value)
    {
        lock.lock();
        try
        {
            growIfNeeded();
            element[size]=value;
        }
        finally {
            lock.unlock();
        }
    }
    public T Pop()
    {
        lock.lock();
        try{
            if (size==-1)
                throw new  NoSuchElementException();
            TrimToSizeIfNeeded();
            var value=element[size];
            element[size]=null;
            size--;
            return value;
        }finally {
            lock.unlock();
        }
    }
    private void growIfNeeded()
    {
        if (++size==element.length)
            grow();
    }

    private void grow() {
        int newCapacity= element.length*2;
        element= Arrays.copyOf(element,newCapacity);
    }
    private void TrimToSizeIfNeeded()
    {
        if (size<element.length)
            element=Arrays.copyOf(element,size+1);
    }

    public static void main(String...args) {
        var stack=new ConcurrentStack<String>(5);
        stack.Push("Bangladesh");
        stack.Push("China");
        stack.Push("India");
        System.out.println(stack.Pop());
    }

}
