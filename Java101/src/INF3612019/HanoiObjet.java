package INF3612019;
import java.util.NoSuchElementException;

class rondelle{
    public Node first;
    public class Node{
        private int value;
        private Node next;
        public Node(){
            next = null;
        }
        public Node(int n){
            this.value = n;
            this.next = null;
        }
    }
    public rondelle(){
        first = null;
    }
    public rondelle(int n){
        first = new Node(1);
        Node current = first;
        for (int i = 2; i < n+1 ; i++ ){
            Node newNode = new Node(i);
            current.next = newNode;
            current = current.next;
        }
    }
    public void push(int disque) {
        rondelle.Node oldfirst = first;
        first = new rondelle.Node();
        first.value = disque;
        first.next = oldfirst;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        int disque = first.value;
        first = first.next;
        return disque;
    }
    public void affiche() {
        Node current = first;
        if (current == null) return;
        else System.out.print(current.value+" ");
        while(current.next!= null){
            current = current.next;
            System.out.print(current.value+" ");
        }
        return;
    }
    public void afficher(Node current){
        if (current == null) return;
        else {
            afficher(current.next);
            System.out.print(current.value+" ");
        }
    }
}
class poteaux{
    public rondelle D;
    public rondelle M;
    public rondelle A;

    public poteaux(int n){
        this.D = new rondelle(n);
        this.M = new rondelle();
        this.A = new rondelle();
    }
    public void affiche(){
        System.out.print("D : ");
        D.afficher(D.first);
        System.out.println();
        System.out.print("M : ");
        M.afficher(M.first);
        System.out.println();
        System.out.print("A : ");
        A.afficher(A.first);
        System.out.println();
        System.out.println();
    }
    public void move(rondelle From, rondelle To){
        if (From.isEmpty()) return;
        else {
            int temp = From.pop();
            To.push(temp);
        }
    }
}
public class HanoiObjet {
    poteaux base;
    public void jeu(int n){
        base = new poteaux(n);
        base.affiche();
        rearrange(n, base.D, base.M,base.A);
    }
    public void rearrange(int n,rondelle rD,rondelle rM,rondelle rA){
        if (n>0){
            rearrange(n-1,rD,rA,rM);
            base.move(rD, rA);
            base.affiche();
            rearrange(n-1,rM,rD,rA);
        }
    }
    public static void main(String[] args){
        HanoiObjet Hanoi = new HanoiObjet();
        for (int j = 3; j<6; j++){
            System.out.println("Hanoi " + j);
            Hanoi.jeu(j);
        }
    }
}
