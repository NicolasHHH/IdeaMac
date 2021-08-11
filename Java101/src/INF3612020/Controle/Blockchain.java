package INF3612020.Controle;

import java.util.LinkedList;
public class Blockchain{
        public static LinkedList<BlocBC> LB;
        public static void initialise(){
            LB = new LinkedList<BlocBC>();
        }
        public static long H(TransactionBC t, long hprev){
            return hprev+1;
        }
        public static void ajouteTransaction(TransactionBC t){
            t.executer();
            if(LB.isEmpty())
                LB.addLast(new BlocBC(t, H(t, 0)));
            else
                LB.addLast(new BlocBC(t, H(t, LB.getLast().hash)));
        }
        public static boolean estCorrecte(){
            long hash = 0;
            for(BlocBC B : LB){
                hash = H(B.t, hash);
                if(B.hash != hash){
                    System.out.println("Erreur");
                    return false;
                }
            }
            return true;
        }
        public static void main(String[] args){
            initialise();
            ClientBC c1 = new ClientBC("Alice", 20000);
            ClientBC c2 = new ClientBC("Bob", 10000);
            ajouteTransaction(new TransactionBC(c1, c2, 3000));
            ajouteTransaction(new TransactionBC(c2, c1, 400));
            System.out.println(estCorrecte());
        }

    }
