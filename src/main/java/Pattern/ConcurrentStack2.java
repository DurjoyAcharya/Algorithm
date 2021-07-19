package Pattern;

//Stack using concurrent

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentStack2<T>
{
    private final Lock lock=new ReentrantLock();
    private T[] elements;
    private int size=-1;

    public ConcurrentStack2()
    {
        this(10);
    }
    public ConcurrentStack2(int initialCapacity)
    {
        elements=(T[])new Object[initialCapacity];
    }

    public void Push(T value)
    {
        LockHelper.WithLock(lock,()->{
            growIfNeeded();
            elements[size]=value;
        });
    }
    public T Pop()
    {
        return LockHelper.WithLock(lock,()->{
           if (size==-1)
               throw new NoSuchElementException("Stack is Empty");
           TrimSizeIfNeeded();

           var value=elements[size];
           elements[size]=null;
           size--;
           return value;
        });
    }
    public T Peek()
    {
        return LockHelper.WithLock(lock,()->elements[size]);
    }
    public T ExploreViaIndex(int index)
    {
        return LockHelper.WithLock(lock,()->{
            if (index>size||index<0)
                throw new IndexOutOfBoundsException();
            return elements[index];
        });
    }
    private void growIfNeeded() {
        if (++size== elements.length)
            Grow();
    }
    private void Grow() {
        int newCapacity= elements.length*2;
        elements= Arrays.copyOf(elements,newCapacity);
    }
    private void TrimSizeIfNeeded()
    {
        if (size< elements.length)
            elements=Arrays.copyOf(elements,size+1);
    }
    public static void main(String...args) {
        var stack=new ConcurrentStack2<String>();
        stack.Push("AAA");
        stack.Push("BBB");
        stack.Push("CCC");
        stack.Push("DDD");
        for (int i = 0; i <=stack.size; i++) {
            System.out.println(stack.ExploreViaIndex(i));
        }
    }
}
