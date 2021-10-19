package ProcessScheduling.ProducerConsumer;

public interface ProducerConsumerQueue<T>{
    public void put(T value);
    public T get();
}
