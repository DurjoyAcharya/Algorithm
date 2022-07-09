package TrashBox;

//Load Factor And Rehashing
//reff: https://www.geeksforgeeks.org/load-factor-and-rehashing/?ref=lbp

import java.util.ArrayList;

class Map<K,V>
{

    class MapNode<K,V>
    {
        K key;
        V value;
        MapNode<K,V> next;

        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next=null;
        }
    }
    //Its is the bucket array
    ///where the K-V pair are stored
    ArrayList<MapNode<K,V>> list;

    //No Of Pairs Stored -n
    int n;
    //No Of Buckets Arrays -b
    int numBuckets;

    //Here The Default Load Factor is 0.75
    final double defaultLoadFactor=0.75;
    public Map()
    {
        numBuckets=5;
        list=new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++)
            list.add(i,null);
        System.out.println("HashMap is Created");
        System.out.println("Number of pairs in the Map: " +n);
        System.out.println("Size Of Map: "+numBuckets);
        System.out.println("Default Load Factor: "+defaultLoadFactor);
    }
    private int getNumBucketsId(K key)
    {
        //using inbuilt function from Object class
        int hash=key.hashCode();
        //its actually returns index of array
        return(hash%numBuckets);
    }
    public void Insert(K key,V value)
    {
        //getting the index at which its needs to be inserted
        int bucketInd=getNumBucketsId(key);
        var head=list.get(bucketInd);
        // First, loop through all the nodes present at that index
        // to check if the key already exists
        while (head!=null)
        {
            if (head.key.equals(key))
            {
                head.value=value;
                return;
            }
            head=head.next;
        }
        ///new Node with key value
        var newNode=new MapNode<K,V>(key, value);
        head=list.get(bucketInd);
        //bujhar bisoy ache
    }
}
public class LoadFactorAndRehashing {


    public static void main(String[] args) {

    }
}
