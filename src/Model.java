import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Pion> pionList;
    private Joueur joueur1, joueur2;

    public static final int VIDE = 0,
                            NOIR = 1,
                            DAME_NOIRE = 2,
                            BLANC = 3,
                            DAME_BLANCHE = 4;

    public int[][] plateau; // le plateau est un tableau à 2 dimensions plateau[ligne][colonne]

    public Model(){

        plateau = new int[10][10];
        creationPlateau();

        pionList = new ArrayList<Pion>();

        //Pion blanc
        Pion p = new Pion(1, 1, 1);
        this.pionList.add(p);
        p = new Pion(1, 3 , 1);
        this.pionList.add(p);
        p = new Pion(1, 5 , 1);
        this.pionList.add(p);
        p = new Pion(1, 7 , 1);
        this.pionList.add(p);
        p = new Pion(1, 9 , 1);
        this.pionList.add(p);
        p = new Pion(1, 2 , 2);
        this.pionList.add(p);
        p = new Pion(1, 4 , 2);
        this.pionList.add(p);
        p = new Pion(1, 6 , 2);
        this.pionList.add(p);
        p = new Pion(1, 8 , 2);
        this.pionList.add(p);
        p = new Pion(1, 10 , 2);
        this.pionList.add(p);
        p = new Pion(1, 1, 3);
        this.pionList.add(p);
        p = new Pion(1, 3 , 3);
        this.pionList.add(p);
        p = new Pion(1, 5 , 3);
        this.pionList.add(p);
        p = new Pion(1, 7 , 3);
        this.pionList.add(p);
        p = new Pion(1, 9 , 3);
        this.pionList.add(p);
        p = new Pion(1, 2 , 4);
        this.pionList.add(p);
        p = new Pion(1, 4 , 4);
        this.pionList.add(p);
        p = new Pion(1, 6 , 4);
        this.pionList.add(p);
        p = new Pion(1, 8 , 4);
        this.pionList.add(p);
        p = new Pion(1, 10 , 4);
        this.pionList.add(p);

        //Pion noir
        p = new Pion(2, 1, 7);
        this.pionList.add(p);
        p = new Pion(2, 3 , 7);
        this.pionList.add(p);
        p = new Pion(2, 5 , 7);
        this.pionList.add(p);
        p = new Pion(2, 7 , 7);
        this.pionList.add(p);
        p = new Pion(2, 9 , 7);
        this.pionList.add(p);
        p = new Pion(2, 2 , 8);
        this.pionList.add(p);
        p = new Pion(2, 4 , 8);
        this.pionList.add(p);
        p = new Pion(2, 6 , 8);
        this.pionList.add(p);
        p = new Pion(2, 8 , 8);
        this.pionList.add(p);
        p = new Pion(2, 10 , 8);
        this.pionList.add(p);
        p = new Pion(2, 1, 9);
        this.pionList.add(p);
        p = new Pion(2, 3 , 9);
        this.pionList.add(p);
        p = new Pion(2, 5 , 9);
        this.pionList.add(p);
        p = new Pion(2, 7 , 9);
        this.pionList.add(p);
        p = new Pion(2, 9 , 10);
        this.pionList.add(p);
        p = new Pion(2, 2 , 10);
        this.pionList.add(p);
        p = new Pion(2, 4 , 10);
        this.pionList.add(p);
        p = new Pion(2, 6 , 10);
        this.pionList.add(p);
        p = new Pion(2, 8 , 10);
        this.pionList.add(p);
        p = new Pion(2, 10 , 10);
        this.pionList.add(p);

        //Joueurs
        joueur1 = new Joueur(1, "pseudo 1");
        joueur2 = new Joueur(2, "pseudo 2");
    }

    public void creationPlateau() {
        for (int ligne = 0; ligne < 8; ligne++) {
            for(int colonne = 0; colonne < 8; colonne++) {
                if(ligne % 2 == colonne % 2) {
                    if (ligne < 3)
                        plateau[ligne][colonne] = NOIR;
                    else if(ligne >  4)
                        plateau[ligne][colonne] = BLANC;
                    else
                        plateau[ligne][colonne] = VIDE;

                } else {
                    plateau[ligne][colonne] = VIDE;
                }
            }
        }
    }

    public String getPseudoJoueur1() {
        return joueur1.getPseudo();
    }

    public String getPseudoJoueur2() {
        return joueur2.getPseudo();
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setPseudoJoueur1(String pseudo) {
        getJoueur1().setPseudo(pseudo);
    }

    public void setPseudoJoueur2(String pseudo) {
        getJoueur2().setPseudo(pseudo);
    }

    public int pieceCourante(int ligne, int colonne) {
        return plateau[ligne][colonne];
    }

    public List<Pion> getPionList(){
        return this.pionList;
    }

    public Pion getPion(int index){
        return (Pion)this.pionList.get(index);
    }
/*
    public List<Joueur> getJoueurList() {
        return joueurList;
    }
*/

}
