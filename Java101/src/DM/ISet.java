package DM;

import java.util.ArrayList;
import java.util.Iterator;

class AVL {
    int key;
    boolean onleft;

    AVL left, right;

    // Question 2
    static AVL getPrev(AVL t, int i) {
        if( t == null )
            return null;
        if (t.key < i) {
            if(t.right == null)
                return t;
            else
                return getPrev(t.right,i);
        }
        else if (t.key == i)
            return t;
        else
            return getPrev(t.left,i);
    }

    // IMPLEMENTATION DES ARBRES AVL VUE EN COURS


    int height;

    AVL(int point, boolean type, AVL left, AVL right) {
        onleft = type;
        this.key = point;
        this.left = left;
        this.right = right;
        this.height = 1 + Math.max(height(left), height(right));
    }

    static AVL put(AVL b, int i, boolean onleft) {
        if (b == null)
            return new AVL(i, onleft, null, null);

        if (i < b.key)
            b.left = put(b.left, i, onleft);
        else if (i > b.key)
            b.right = put(b.right, i, onleft);
        else {
            b.onleft = onleft; //écrase la valeur précédente de on left
        }
        return balance(b);
    }

    static AVL removeRoot(AVL b) {

        if (b.right == null)
            return b.left;

        b.right = removeMin(b.right, b); //

        return balance(b);
    }

    static void copynode(AVL dst, AVL src) {
        dst.key = src.key;
        dst.onleft = src.onleft;
    }

    static AVL remove(AVL b, int x) {
        if (b == null)
            return null;
        if (x < b.key)
            b.left = remove(b.left, x);
        else if (x > b.key)
            b.right = remove(b.right, x);
        else
            return removeRoot(b);
        return balance(b);
    }

    static AVL removeMin(AVL b, AVL dst) {
        if (b.left == null) {
            copynode(dst, b);
            return b.right;
        }
        b.left = removeMin(b.left, dst);
        return balance(b);
    }

    static int height(AVL a) {
        return (a == null) ? 0 : a.height;
    }

    private static AVL rotateRight(AVL t) {
        assert t != null && t.left != null;
        AVL l = t.left;
        t.left = l.right;
        l.right = t;
        t.height = 1 + Math.max(height(t.left), height(t.right));
        l.height = 1 + Math.max(height(l.left), height(l.right));
        return l;
    }

    private static AVL rotateLeft(AVL t) {
        assert t != null && t.right != null;
        AVL r = t.right;
        t.right = r.left;
        r.left = t;
        t.height = 1 + Math.max(height(t.left), height(t.right));
        r.height = 1 + Math.max(height(r.left), height(r.right));
        return r;
    }

    private static AVL balance(AVL t) {
        assert t != null;
        AVL l = t.left, r = t.right;
        int hl = height(l), hr = height(r);
        if (hl > hr + 1) {
            AVL ll = l.left, lr = l.right;
            if (height(ll) >= height(lr))
                return rotateRight(t);
            else {
                t.left = rotateLeft(t.left);
                return rotateRight(t);
            }
        } else if (hr > hl + 1) {
            AVL rl = r.left, rr = r.right;
            if (height(rr) >= height(rl))
                return rotateLeft(t);
            else {
                t.right = rotateRight(t.right);
                return rotateLeft(t);
            }
        } else {
            t.height = 1 + Math.max(hl, hr);
            return t;
        }
    }

    static boolean isNormal(AVL b, boolean left, boolean right) {
        if (b == null)
            return left != right;
        return isNormal(b.left, left, !b.onleft) && isNormal(b.right, !b.onleft, right);
    }

    static boolean isNormal(AVL b) {
        return isNormal(b, true, false);
    }
    static void afficher ( AVL b){
        if(b != null){
            afficher(b.left);
            System.out.println(b.key +" "+ b.onleft);
            afficher(b.right);
        }
    }

    public static void main(String[] args){
        // test question 2
        AVL q1 = new AVL(5,false,
                new AVL(1,false,
                        new AVL(-3,true,null,null),new AVL(2,true,null,null)),
                new AVL(7,false,
                        new AVL(6,true,null,null),null));
        AVL.put(q1,0,true);
        AVL.afficher(q1);
        AVL.put(q1,5,true);
        AVL.afficher(q1);
    }
}

public class ISet {
    private AVL root;

    ISet() {
    }

    ISet(AVL b) {
        this.root = b;
    }

    // Représente l'intervalle [x, y[
    ISet(int x, int y) {
        root = null;
        root = AVL.put(root, x, true);
        root = AVL.put(root, y, false);
    }

    // testé, 2 lignes
    boolean contains(int i) {
        AVL res = AVL.getPrev(root,i);
        if (res == null) return false;
        else return (res.onleft == true);
    }

    void add(int x) {
        boolean self = contains(x);
        if (!self){
            boolean left = contains(x-1);
            boolean right = contains(x+1);
            if (left && right){
                root = AVL.remove(root,x);
                root = AVL.remove(root,x+1);
            }
            else if ( left ){
                root = AVL.remove(root,x);
                root = AVL.put(root,x+1,false);
            }
            else if ( right) {
                root = AVL.remove(root,x+1);
                root = AVL.put(root,x,true);
            }
            else {
                root = AVL.put(root,x,true);
                root = AVL.put(root,x+1,false);
            }
        }
    }

    void union(ISet a) {
        // étape 1 : dissocier tous les noeuds de AVL et les stocker dans un ArrayList
        ArrayList<Noeud> AN = new ArrayList<Noeud>();
        dissocier(this.root,AN);
        dissocier(a.root,AN);
        // complexité: O(n) -- proportionnel au nombre total de noeuds dans les arbres

        // étape 2 : trier Arraylist (critère les noeuds dont le key est plus petit sont placé devant,
        // en cas d'égalité, on compare onleft, celui dont onleft est true est placé devant).
        AN.sort(Noeud::compareTo);
        // complexité: O(nLog(n)) -- tri

        // étape 3 : traitement
        // -- suppression des intervalles qui sont inclus dans les autres,
        // -- concaténation des intervalles contigus
        int len = AN.size();
        int onStatus = 0, onCount = 0;
        Iterator<Noeud> it = AN.iterator();
        while(it.hasNext()){
            Noeud nd = it.next();
            System.out.println(" nd.key "+nd.key+ " onleft "+nd.onleft);
            if (onStatus == 0){
                if(nd.onleft==true) {
                    onStatus = 1;
                    onCount ++;
                }
                else {
                    onCount --;
                    if(onCount>0) {
                        System.out.println("0 remove "+nd.key+" "+nd.onleft);
                        it.remove();
                    }
                }
            }
            else{
                if(nd.onleft==false) {
                    onStatus = 0;
                    onCount --;
                }
                else  {
                    if(onCount>0) {
                        System.out.println("1 remove "+nd.key+" "+nd.onleft);
                        it.remove();
                    }
                    onCount ++;
                }
            }
            System.out.println(onStatus+" "+onCount);
        }
        // complexité: O(n) -- parcours une fois l'arraylist

        // étape 4 : reconstruction d'AVL
        Noeud first = AN.remove(0);
        this.root = new AVL(first.key,first.onleft,null,null);
        for(Noeud nd : AN){
            AVL.put(this.root,nd.key,nd.onleft);
            System.out.print(nd.key);
        }
        // complexité totale : O(nLogn)

    }

    static void dissocier (AVL b, ArrayList<Noeud> AN){
        if(b != null){
            dissocier(b.left,AN);
            AN.add(new Noeud(b.key,b.onleft));
            dissocier(b.right,AN);
        }
    }
    public static void main(String[] args){

        AVL q1 = new AVL(5,false,
                new AVL(1,false,
                        new AVL(-3,true,null,null),new AVL(2,true,null,null)),
                new AVL(7,false,
                        new AVL(6,true,null,null),null));
        AVL q2 = new AVL(5,false,
                new AVL(-2,true,null,null),
                new AVL(10,false,
                        new AVL(9,true,null,null),null));
        ISet s1 = new ISet(q1);
        ISet s2 = new ISet(q2);
        s1.union(s2);
        AVL.afficher(s1.root);

    }
}
class Noeud implements Comparable<Noeud> {
    int key;
    boolean onleft;
    Noeud(int k, boolean onl){
        this.key = k;
        this.onleft = onl;
    }
    @Override
    public int compareTo(Noeud nd){
        if (this.key>nd.key) return 1;
        else if (this.key < nd.key) return -1;
        else {
            if (this.onleft == nd.onleft) return 0;
            else if (this.onleft) return -1;
            else return 1;
        }
    }
}
