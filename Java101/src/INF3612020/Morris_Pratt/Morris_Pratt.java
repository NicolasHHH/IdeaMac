package INF3612020.Morris_Pratt;

public class Morris_Pratt {
    public static int nb_cmp;



    public static void reconnaitre1(char[] T, char[] M) {
        int iT = 0, iM = 0, etat = 0;
        while (iT <= T.length - M.length) {
            nb_cmp++;
            if (T[iT + iM] == M[iM]) {
                etat++;
                iM++;
                if (etat == M.length) {
                    System.out.println("occurrence " + iT + " => etat=0");
                    etat = 0;
                    iM = 0;
                    iT++;
                }
            } else {
                etat = 0;
                iM = 0;
                iT++;
            }
        }
    }


}
