package INF4112021;


import java.util.Vector;

public class HashTable {
    private Bucket[] buckets;
    private final  static int M = 5003;
    HashTable(){
        this.buckets = new Bucket[M];
    }
    void put(Pair key, Vector<String> value){
        int i = key.hash()&(M-1);
        this.buckets[i] = new Bucket(key,value,this.buckets[i]);
    }
    Vector<String> get(Pair key){
        int i = (key.hash() & 0x7fffffff) % M;
        return Bucket.get(this.buckets[i],key);
    }
    public static void main(String[] args){

    }
}


