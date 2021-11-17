package data_structures.interfaces;

public interface IQueue<T> {
    public boolean offer(T value);
    public T poll();
    public T peek();
    public boolean remove(T value);
    public void clear();
    public boolean contains(T value);
    public int size();
    public boolean validate();
    public java.util.Queue<T> toQueue();
    public java.util.Collection<T> toCollection();
}
