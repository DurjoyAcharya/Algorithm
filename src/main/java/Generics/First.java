package Generics;

//All About Generics Java
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

interface Pair<K,V>
{
   public K key();
   public V Value();
}
class OrderPair<K,V> implements Pair<K,V>
{
    private K Keys;
    private V Values;

    public OrderPair(K keys, V values) {
        Keys = keys;
        Values = values;
    }

    @Override
    public K key() {
        return this.Keys;
    }
    @Override
    public V Value() {
        return this.Values;
    }
    public <N,M> void getName(N n,M m)
    {
        System.out.println(n+" "+m);
    }

    public K getKeys() {
        return Keys;
    }

    public V getValues() {
        return Values;
    }

    public void setKeys(K keys) {
        Keys = keys;
    }

    public void setValues(V values) {
        Values = values;
    }

    @Override
    public String toString() {
        return "OrderPair{" +
                "Keys=" + Keys +
                ", Values=" + Values +
                '}';
    }
}
class Util{
    public static <K,V> boolean compare(Pair<K,V> pair_1,Pair<K,V> pair_2)
    {
        return pair_1.key().equals(pair_2.key()) && pair_1.Value().equals(pair_2.Value());
    }
}
class Box<T>
{
    private T t;
    public Box(T t) {
        this.t = t;
    }
    public void setT(T t) {
        this.t = t;
    }
    public T getT() {
        return t;
    }
    public <U extends Number> void inspect(U u)//Bounded type parameter
    {
        System.out.println("T: "+t.getClass().getName());
        System.out.println("U: "+u.getClass().getName());
    }

}
public class First {
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        return  (int) Arrays.stream(anArray).filter(e -> e.compareTo(elem) == 0).count();
    }
    public static void main(String[] args) {
//       var orderA=new OrderPair<Integer,String>(1,"Apple");
//       var orderB=new OrderPair<Integer,String>(1,"Apple");
//       boolean flag=Util.compare(orderA,orderB);
//       System.out.println(flag);
          var box=new Box<Integer>(100);
          box.inspect(100L);
          System.out.println(countGreaterThan(new Integer[]{0,1,2,3,4,5},3));

    }
}
