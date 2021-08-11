package INF3612019.ReseauSocial;

public class FB361 {
    public static void main(String[] args){
        ReseauSocial RS = new ReseauSocial("FB361");
        RS.creerMembre("Lisa");
        RS.creerMembre("Jisoo");
        RS.creerMembre("Rosé");
        RS.creerMembre("Jennie");
        RS.creerMembre("Irene");
        RS.creerMembre("Yoona");
        System.out.println("-------");
        RS.deNom("Lisa").afficherAmities();
        System.out.println("-------");

        RS.ajouterAmitie("Lisa","Jisoo" );
        RS.ajouterAmitie("Jennie","Jisoo" );
        RS.ajouterAmitie("Lisa","Rosé" );

        System.out.println("-------");
        RS.deNom("Lisa").afficherAmities();
        System.out.println("-------");

        RS.afficherMembres();

        System.out.println("------- relations -------------");

        RS.afficherAmities();
    }
}
