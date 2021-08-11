package INF3612019.Pile;

import INF3612019.Pile.Pile;

public class TestPile {
    public static void TesterPile(Pile p){
        for (int n= 0; n<10; n++)
            p.empiler(n);
        while(! p.estVide())
            System.out.println(p.depiler());
    }
}
