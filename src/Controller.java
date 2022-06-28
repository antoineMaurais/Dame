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

    // A modifier (ne fonctionne pas)
    public void afficherPossibilites(Pion pion) {

        // pions bleu
        if(pion.getCouleur() == 1) {

            List<Pion> pionsBleu = new ArrayList<Pion>();

            pionsBleu = model.getPionsCouleur(1);
            for(Pion p: pionsBleu) {
                if(pion.getColonne()-1 == p.getColonne() && pion.getLigne()-1 == p.getLigne()) {
                    possibiliteDeplacement.add(new Case(1, p.getLigne(), p.getColonne()));
                } else if (pion.getColonne()+1 == p.getColonne() && pion.getLigne()+1 == p.getLigne()) {
                    possibiliteDeplacement.add(new Case(1, p.getLigne(), p.getColonne()));
                } else if (pion.getColonne()-1 == p.getColonne() && pion.getLigne()+1 == p.getLigne()) {
                    possibiliteDeplacement.add(new Case(1, p.getLigne(), p.getColonne()));
                } else if (pion.getColonne()+1 == p.getColonne() && pion.getLigne()-1 == p.getLigne()) {
                    possibiliteDeplacement.add(new Case(1, p.getLigne(), p.getColonne()));
                }
            }
            pion.getColonne();
            pion.getLigne();
        } else {

        }

        // Ne fonctionne pas
        System.out.print("deplacement possible :");
        for(Case c: possibiliteDeplacement) {
            System.out.println("ligne : " + c.getLigne());
            System.out.println("colonne : " + c.getColonne());
        }


       /* if((pion.getCouleur().equals(Couleur.NOIR) && tourNoir) || (p.getCouleur().equals(Couleur.BLANC) && !tourNoir)){
            int i=0;
            int j=0;
            for(int k=0; k<TAILLE*TAILLE; k++){
                getCase(k).setSelectionnee(false);
                if(getCase(k).getComponentCount()!=0 && getCase(k).getComponent(0).equals(p)){
                    caseActive=getCase(k);
                    i=k/TAILLE;
                    j=k%TAILLE;

                }
            }
            selectionnerCases(i, j, pion.getCouleur());
        }*/
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
