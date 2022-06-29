import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Joueur joueur;
    private Pion pion;
    private FenetreConfiguration vueConfig;
    private List<Case> possibiliteDeplacement = new ArrayList<Case>();

    public Controller(final Model model){this.model = model;}

    public void saveJoueur(){

    }

    public void afficherPossibilites(Pion pion) {

        // TODO : Verifier si les cases en diagonale sont vides ou non
        // Parcourir tous les pions et si il n'y en a pas aux coordonnées des diagonales alors on peut proposer au pion d'avancer sur les deux diagonales

        // pions bleu
        if(pion.getCouleur() == 1) {
            System.out.println("Coordonnées : \n");
            System.out.println("colonne : " + pion.getColonne());
            System.out.println("ligne : " + pion.getLigne());


            List<Pion> pionsBleu = new ArrayList<Pion>();

            pionsBleu = model.getPionsCouleur(1);
            for(Pion p: pionsBleu) {
                // SI LE TABLEAU possibiliteDeplacement est VIDE, cela veut dire qu'il n'y pas de pion bleu en diagonale
                if(pion.getColonne()-1 == p.getColonne() && pion.getLigne()+1 == p.getLigne()) {
                    possibiliteDeplacement.add(new Case(1, p.getLigne(), p.getColonne()));
                    System.out.println(" oui");
                } else if (pion.getColonne()+1 == p.getColonne() && pion.getLigne()+1 == p.getLigne()) {
                    possibiliteDeplacement.add(new Case(1, p.getLigne(), p.getColonne()));
                }
            }
            pion.getColonne();
            pion.getLigne();
        } else {
            // Faire pareil pour les pions rouge
        }

        // Si il n'y a rien dans le tableau c'est que le pion peut avancer normalement
        System.out.print("deplacement pas possible :");
        for(Case c: possibiliteDeplacement) {
            System.out.println("ligne : " + c.getLigne());
            System.out.println("colonne : " + c.getColonne());
        }

    }


    public void deplacerCase(Case caseJeu) {
          /*  caseJeu.add(caseActive.getComponent(0));
        for(int k=0; k<TAILLE*TAILLE; k++){
            getCase(k).setSelectionnee(false);
        }
        if(Math.abs(getLigne(caseJeu)-getLigne(caseActive))==2){
            int i = (getLigne(caseJeu)+getLigne(caseActive))/2;
            int j = (getColonne(caseJeu)+getColonne(caseActive))/2;
            getCase(i, j).removeAll();
            getCase(i, j).validate();
            getCase(i, j).repaint();
        }
        tourNoir=!tourNoir;
        caseActive.removeAll();
        caseActive.repaint();
        caseActive=null;
        caseJeu.repaint();
        if(getLigne(caseJeu)==0){
            Pion p=(Pion)(case1.getComponent(0));
            p.setMonte(false);
        }
        if(getLigne(caseJeu)==TAILLE-1){
            Pion p=(Pion)(caseJeu.getComponent(0));
            p.setMonte(true);
        }*/
    }
}
