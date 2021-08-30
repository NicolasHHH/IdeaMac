package INF4112021;

import java.util.Vector;

public class Bucket {
    Pair key;
    Vector<String> value;
    Bucket next;
    Bucket(Pair key,Vector<String> value, Bucket next){
        this.next = next;
        this.value = value;
        this.key = key;
    }
    static Vector<String> get(Bucket b,Pair k){
        while(b != null){
            if (b.key.equals(k)) return b.value;
            b = b.next;
        }
        return null;
    }
}
