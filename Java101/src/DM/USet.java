package DM;

import java.util.HashSet;

// complémentaire triviale
// soit X fini, Y fini, alors X & Y fini; X U Y fini, en effet, card(X*Y) <= card(X)+ card(Y)
// soit X cofini, Y cofini, alors X & Y = Z\(Xc U Yc) cofini; X U Y = Z\(Xc ^ Yc) fini
// soit X fini, Y cofini, alors X & Y fini card <= card(X); X U Y = Z\(Xc ^ Yc) fini Z eventuellement,

class USet {

    private boolean finite;
    private HashSet<Integer> set;

    USet() {
        finite = true;
        set = new HashSet<Integer>();
    }

    USet(int[] a,boolean fini){
        set = new HashSet<Integer>();
        for (int ai : a){
            this.set.add(ai);
        }
        this.finite = fini;
    }

    boolean contains(int i) {
        if (finite){
            if(set.contains(i)) return true;
        }
        else{
            if(!set.contains(i)) return true;
        }
        return false;
    }

    void add(int i) {
        if (finite)
            set.add(i);
        else
            set.remove(i);
    }

    void union(USet a) {
        if (a.finite) {
            if (this.finite) {
                a.set.removeAll(this.set);
                this.set.addAll(a.set);
            } else {
                this.set.removeAll(a.set);
            }
        } else {
            if (this.finite) {
                a.set.removeAll(this.set);
                this.set = a.set;
                this.finite = false;
            } else {
                a.set.retainAll(this.set);
                this.set.retainAll(a.set);
            }
        }
    }

    void afficher(){
        if(!finite){
            System.out.print(" ----- ");
        }
        System.out.println(this.set.toString());
    }

    void complement() {
        this.finite = ! this.finite;
    }
    public static void main(String[] args){
        // test
        int[] a1 = {1,2,3};
        USet u1 = new USet(a1,true);
        u1.afficher();

        u1.add(6);
        u1.afficher();

        u1.complement();
        u1.afficher();

        u1.complement();
        u1.add(3);
        u1.afficher();

        System.out.println(u1.contains(4));
        System.out.println(u1.contains(2));

        u1.complement();
        u1.afficher();
        System.out.println(u1.contains(4));
        System.out.println(u1.contains(2));

        int[] a2 = {8,2,0,6};
        USet u2 = new USet(a2,true);
        u2.complement();
        u2.afficher();
        u2.union(u1);
        u1.afficher();
        u2.afficher();



    }
}
