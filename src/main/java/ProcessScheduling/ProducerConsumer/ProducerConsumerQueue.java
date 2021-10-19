package ProcessScheduling.ProducerConsumer;

public interface ProducerConsumerQueue<M>{
    public void put(M value);
    public M get();
}
