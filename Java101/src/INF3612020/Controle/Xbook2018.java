package INF3612020.Controle;

import java.util.LinkedList;

public class Xbook2018 {
    private final int n;
    private LinkedList[] t;

    public Xbook2018(int n,LinkedList[] t){
        this.n = n;
        this.t = new LinkedList[0];
    }

    public String toString(){
        int len  = this.t.length;
        String res = "";
        for (int i = 0; i <len;i++){
            res += "t["+i+"]"+t[i].toString();
            res += "\n";
        }
        return res;
    }


}
