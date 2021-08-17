package Trees;

public class Node {
    public int key;
    public Node left = null ;
    public Node right = null ;

    public Node(int n){
        this.key = n;
    }

    public static Node Nadd(Node nd,int i){
        if (nd == null){
            return new Node(i);
        }
        else{
            if (i > nd.key){
                if (nd.right == null){
                    nd.right = new Node(i);
                }
                else nd.right = Nadd(nd.right,i);
            }
            else{
                if (nd.left == null){
                    nd.left = new Node(i);
                }
                else nd.left = Nadd(nd.left,i);
            }
        }
        return nd;
    }

    public static boolean chercher(Node nd,int target){
        if (nd == null) return false;
        else {
            //System.out.println(nd.key+" : "+target);
            if (nd.key == target) {
                return true;
            }
            else {
                return (chercher(nd.left, target)
                        || chercher(nd.right, target));
            }
        }
    }
    public static void afficher(Node nd){
        if (nd != null) {
            afficher(nd.left);
            System.out.print(nd.key);
            afficher(nd.right);
        }
    }
}
