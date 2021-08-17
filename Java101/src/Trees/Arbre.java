package Trees;

public class Arbre {
    public Node racine = null;
    private int height = 0;

    public Arbre(int[] ls){
        for ( int x : ls)
            add(x);
    }
    public void add(int i){
        this.racine = Node.Nadd(this.racine,i);
    }

    public int getHeight(){
        return this.height;
    }

    public boolean chercher(int target) {
        return Node.chercher(this.racine, target);
    }
    public void afficher(){
        Node.afficher(this.racine);
        System.out.println();
    }


    public static void main(String[] args){
        int[] ls = {1,2,5,8,3,4,6};
        Arbre a = new Arbre(ls);
        a.afficher();
        System.out.println(a.chercher(3));
        System.out.println(a.chercher(0));

    }
}


