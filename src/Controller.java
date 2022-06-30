import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Joueur joueur;
    private Pion pion;
    private Case aCase;
    private FenetreConfiguration vueConfig;
    private Jeu vueJeu;
    private List<Case> possibiliteDeplacement = new ArrayList<Case>();

    public Controller(final Model model){this.model = model;}

    public void setVueConfig(FenetreConfiguration vueConfig){
        this.vueConfig=vueConfig;
    }

    public void setVueJeu(Jeu vueJeu){
        this.vueJeu=vueJeu;
    }

    public List<Pion> getPionsCouleur(int couleur){
        return this.model.getPionsCouleur(couleur);
    }

    public List<Case> getCasePossDep(){
        return this.model.getCasePossDep();
    }

    public String getPseudoJoueur1() {
        return this.model.getPseudoJoueur1();
    }

    public String getPseudoJoueur2() {
        return this.model.getPseudoJoueur2();
    }

    public int nbrPionCouleur(int couleur){
        return this.model.nbrPionCouleur(couleur);
    }

    public void setPseudoJoueur1(String pseudo) {
        this.model.setPseudoJoueur1(pseudo);
    }

    public void setPseudoJoueur2(String pseudo) {
        this.model.setPseudoJoueur2(pseudo);
    }

    public void saveJoueur(Joueur joueur1, Joueur joueur2){
        model.setPseudoJoueur1(joueur1.getPseudo());
        model.setPseudoJoueur2(joueur2.getPseudo());
        this.vueConfig.dispose();
    }

    public void afficherPossibilites(Pion pion) {

        possibiliteDeplacement = model.resetCasePossDep();
        possibiliteDeplacement = model.getCasePossDep();
        System.out.println("Coordonnées : \n");
        System.out.println("colonne : " + pion.getColonne());
        System.out.println("ligne : " + pion.getLigne());

        if(pion.isDame() == true){
            //TODO gerer le cas de la dame
        } else{
            if(pion.getCouleur() == 1){
                // On regarde si il y a des pions bleus en diagonale
                boolean indispoDiago1 = false;
                boolean indispoDiago2 = false;
                List<Pion> pionsBleus = model.getPionsCouleur(1);
                for(Pion p: pionsBleus) {
                    // SI LE TABLEAU possibiliteDeplacement est VIDE, cela veut dire qu'il y a des pions bleus en diagonale


                    if(pion.getColonne()-1 == p.getColonne() && pion.getLigne()+1 == p.getLigne()) {
                        indispoDiago1 = true;
                        System.out.println("oui1");
                    } else if (pion.getColonne()+1 == p.getColonne() && pion.getLigne()+1 == p.getLigne()) {
                        indispoDiago2 = true;
                        System.out.println("oui2");
                    }
                }
                if(indispoDiago1 == false){
                    possibiliteDeplacement.add(new Case(1, pion.getLigne()+1, pion.getColonne()-1));
                    indispoDiago1 = true;
                }
                if(indispoDiago2 == false){
                    possibiliteDeplacement.add(new Case(1, pion.getLigne()+1, pion.getColonne()+1));
                    indispoDiago2 = true;
                }
/*
                List<Pion> pionsRouges= model.getPionsCouleur(2);
                for (Pion pr: pionsRouges){
                    //TODO faire le cas ou il y a plusieurs "saut" possible
                    // On regarde si il y a un pions rouges en diagonale
                    if(pion.getColonne()-1 == pr.getColonne() && pion.getLigne()+1 == pr.getLigne()) {
                        // On regarde si il n'y a pas de pions derrières
                        List<Pion> pionsList = model.getPionList();
                        for(Pion p : pionsList){
                            if(pion.getColonne()-2 == p.getColonne() && pion.getLigne()+2 == p.getLigne()){
                                indispoDiago1 = true;
                            } else if (pion.getColonne() == p.getColonne() && pion.getLigne()+2 == p.getLigne()) {
                                indispoDiago2 = true;
                            }
                        }
                        if(indispoDiago1 == false){
                            possibiliteDeplacement.add(new Case(1, pion.getLigne()+2, pion.getColonne()-2));
                            indispoDiago1 = true;
                        }
                        if(indispoDiago2 == false){
                            possibiliteDeplacement.add(new Case(1, pion.getLigne()+2, pion.getColonne()));
                            indispoDiago2 = true;
                        }

                    } else if (pion.getColonne()+1 == pr.getColonne() && pion.getLigne()+1 == pr.getLigne()) {
                        // On regarde si il n'y a pas de pions derrières
                        List<Pion> pionsList = model.getPionList();
                        for(Pion p : pionsList){
                            if(pion.getColonne()+2 == p.getColonne() && pion.getLigne()+2 == p.getLigne()){
                                indispoDiago1 = true;
                            } else if (pion.getColonne() == p.getColonne() && pion.getLigne()+2 == p.getLigne()) {
                                indispoDiago2 = true;
                            }
                        }
                        if(indispoDiago1 == false){
                            possibiliteDeplacement.add(new Case(1, pion.getLigne()+2, pion.getColonne()+2));
                            indispoDiago1 = true;
                        }
                        if(indispoDiago2 == false){
                            possibiliteDeplacement.add(new Case(1, pion.getLigne()+2, pion.getColonne()));
                            indispoDiago2 = true;
                        }
                    }
                }*/

            } else{
             /*   // On regarde si il y a des pions rouges en diagonale
                boolean indispoDiago1 = false;
                boolean indispoDiago2 = false;
                List<Pion> pionsRouges = model.getPionsCouleur(2);
                for(Pion p: pionsRouges) {
                    // SI LE TABLEAU possibiliteDeplacement est VIDE, cela veut dire qu'il y a des pions rouges en diagonale


                    if(pion.getColonne()-1 == p.getColonne() && pion.getLigne()-1 == p.getLigne()) {
                        indispoDiago1 = true;
                    } else if (pion.getColonne()+1 == p.getColonne() && pion.getLigne()-1 == p.getLigne()) {
                        indispoDiago2 = true;
                    }
                }
                if(indispoDiago1 == false){
                    possibiliteDeplacement.add(new Case(1, pion.getLigne()-1, pion.getColonne()-1));
                    indispoDiago1 = true;
                }
                if(indispoDiago2 == false){
                    possibiliteDeplacement.add(new Case(1, pion.getLigne()-1, pion.getColonne()+1));
                    indispoDiago2 = true;
                }

                List<Pion> pionsBleus= model.getPionsCouleur(1);
                for (Pion pb: pionsBleus){
                    // On regarde si il y a un pions bleus en diagonale
                    if(pion.getColonne()-1 == pb.getColonne() && pion.getLigne()-1 == pb.getLigne()) {
                        // On regarde si il n'y a pas de pions derrières
                        List<Pion> pionsList = model.getPionList();
                        for(Pion p : pionsList){
                            if(pion.getColonne()-2 == p.getColonne() && pion.getLigne()-2 == p.getLigne()){
                                indispoDiago1 = true;
                            } else if (pion.getColonne() == p.getColonne() && pion.getLigne()-2 == p.getLigne()) {
                                indispoDiago2 = true;
                            }
                        }
                        if(indispoDiago1 == false){
                            possibiliteDeplacement.add(new Case(1, pion.getLigne()-2, pion.getColonne()-2));
                            indispoDiago1 = true;
                        }
                        if(indispoDiago2 == false){
                            possibiliteDeplacement.add(new Case(1, pion.getLigne()-2, pion.getColonne()));
                            indispoDiago2 = true;
                        }

                    } else if (pion.getColonne()+1 == pb.getColonne() && pion.getLigne()-1 == pb.getLigne()) {
                        // On regarde si il n'y a pas de pions derrières
                        List<Pion> pionsList = model.getPionList();
                        for(Pion p : pionsList){
                            if(pion.getColonne()+2 == p.getColonne() && pion.getLigne()-2 == p.getLigne()){
                                indispoDiago1 = true;
                            } else if (pion.getColonne() == p.getColonne() && pion.getLigne()-2 == p.getLigne()) {
                                indispoDiago2 = true;
                            }
                        }
                        if(indispoDiago1 == false){
                            possibiliteDeplacement.add(new Case(1, pion.getLigne()-2, pion.getColonne()+2));
                            indispoDiago1 = true;
                        }
                        if(indispoDiago2 == false){
                            possibiliteDeplacement.add(new Case(1, pion.getLigne()-2, pion.getColonne()));
                            indispoDiago2 = true;
                        }
                    }
                } */
            }
            model.setCasePossDep(possibiliteDeplacement);
/*
            if(model.getCasePossDep().size()==0){
                System.out.print("deplacement pas possible :");
            } else {
                System.out.print("deplacement possible :");
                for(Case c: model.getCasePossDep()) {
                    System.out.println("ligne : " + c.getLigne());
                    System.out.println("colonne : " + c.getColonne());
                }
            }*/
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
