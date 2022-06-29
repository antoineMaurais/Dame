import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

// Vue
public class Jeu extends JFrame implements MouseListener {

    Model plateauState;
    Controller controller;
    boolean jeuEnCours;

    List<Pion> pionsBleu = new ArrayList<Pion>();
    List<Pion> pionsRouge = new ArrayList<Pion>();
    List<Case> possibiliteDeplacement = new ArrayList<Case>();
    int joueurCourant;
    JLabel infosTour, nomJoueur1, nomJoueur2, nbrPionJoueur1, nbrPionJoueur2, titre;

    /*
    public Jeu(Controller controller){
        this.controller = controller;
        this.setTitle("Jeu de dames");
        this.setSize(500, 600);
        this.setResizable(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.construireJeu();
    }

    private void construireJeu(){
        JFrame jeu = new JFrame("Dames");

        GridLayout grid = new GridLayout(10, 10);
        JPanel plateau = new JPanel();
        plateau.setLayout(grid);
        plateau.setSize(50, 50);
        plateau.setLocation(0, 100);

        plateauState = new Model();

        possibiliteDeplacement = controller.getCasePossDep();
        pionsBleu = controller.getPionsCouleur(1);
        pionsRouge = controller.getPionsCouleur(2);

        for(int ligne=1; ligne<11;ligne++) {
            for(int colonne=1; colonne<11;colonne++){
                if((colonne%2 == 0 && ligne%2 == 0) || (colonne%2 != 0 && ligne%2 != 0)) {
                    Case c = new Case(1, ligne, colonne);

                    for (Pion p: pionsBleu) {
                        if(p.getLigne() == ligne && p.getColonne() == colonne) {
                            JButton button = ajouterPion(Color.blue, p);
                            c.add(button);
                        }
                    }

                    for (Pion p: pionsRouge) {
                        if(p.getLigne() == ligne && p.getColonne() == colonne) {
                            JButton button = ajouterPion(Color.red, p);
                            c.add(button);
                        }
                    }
                    for (Case cPossDep : possibiliteDeplacement){

                        Case cDispo = new Case(3, cPossDep.ligne, cPossDep.colonne);
                        cDispo.addMouseListener(new EcouteurCase(cDispo, this.controller));
                        plateau.add(cDispo);
                    }
                    //c.add(new Button("Test"));

                    c.addMouseListener(new EcouteurCase(c, this.controller));
                    plateau.add(c);

                } else{

                    Case c = new Case(2, ligne, colonne);
                    c.addMouseListener(new EcouteurCase(c, this.controller));
                    plateau.add(c);
                }
            }
        }

        GridLayout gridHeader = new GridLayout(1, 10);
        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(gridHeader);
        panelHeader.setVisible(true);
        panelHeader.setSize(500, 100);

        nomJoueur1 = new JLabel(controller.getPseudoJoueur1());
        nomJoueur1.setLocation(10, 10);
        nomJoueur1.setBackground(Color.BLUE);
        nomJoueur1.setForeground(Color.BLUE);
        panelHeader.add(nomJoueur1);

        nbrPionJoueur1 = new JLabel(String.valueOf(controller.nbrPionCouleur(1))+" pions");
        nbrPionJoueur1.setLocation(50, 10);
        nbrPionJoueur1.setBackground(Color.BLUE);
        nbrPionJoueur1.setForeground(Color.BLUE);
        panelHeader.add(nbrPionJoueur1);

        titre = new JLabel("Jeu de dames");
        titre.setForeground(Color.BLACK);
        panelHeader.add(titre);

        nomJoueur2 = new JLabel(controller.getPseudoJoueur2());
        nomJoueur2.setLocation(400, 10);
        nomJoueur2.setBackground(Color.red);
        nomJoueur2.setForeground(Color.red);
        panelHeader.add(nomJoueur2);

        nbrPionJoueur2 = new JLabel(String.valueOf(controller.nbrPionCouleur(2))+" pions");
        nbrPionJoueur2.setLocation(450, 10);
        nbrPionJoueur2.setBackground(Color.red);
        nbrPionJoueur2.setForeground(Color.red);
        panelHeader.add(nbrPionJoueur2);
        panelHeader.setBackground(Color.YELLOW);




        JPanel panelFooter = new JPanel();
        panelFooter.setVisible(true);
        panelFooter.setSize(500, 100);


        if(joueurCourant == 6){
            infosTour = new JLabel("C'est au joueur bleu de jouer");
        }
        else{
            infosTour = new JLabel("C'est au joueur rouge de jouer");
        }
        panelFooter.add(infosTour);
        panelFooter.setBackground(Color.YELLOW);

        BorderLayout page = new BorderLayout();
        jeu.setLayout(page);
        jeu.add(panelHeader, BorderLayout.PAGE_START);
        jeu.add(plateau, BorderLayout.CENTER);
        jeu.add(panelFooter,BorderLayout.PAGE_END);


        demarrage();


    }


     */

    public Jeu(Model model) {

        plateauState = model;
        controller = new Controller(plateauState);
        possibiliteDeplacement = controller.getCasePossDep();

        GridLayout grid = new GridLayout(10, 10);
        JPanel plateau = new JPanel();
        plateau.setLayout(grid);
        plateau.setSize(50, 50);
        plateau.setLocation(0, 100);

        pionsBleu = controller.getPionsCouleur(1);
        pionsRouge = controller.getPionsCouleur(2);


        for(int ligne=1; ligne<11;ligne++) {
            for(int colonne=1; colonne<11;colonne++){
                if((colonne%2 == 0 && ligne%2 == 0) || (colonne%2 != 0 && ligne%2 != 0)) {
                    Case c = new Case(1, ligne, colonne);

                    for (Pion p: pionsBleu) {
                        if(p.getLigne() == ligne && p.getColonne() == colonne) {
                            JButton button = ajouterPion(Color.blue, p);
                            c.add(button);
                        }
                    }

                    for (Pion p: pionsRouge) {
                        if(p.getLigne() == ligne && p.getColonne() == colonne) {
                            JButton button = ajouterPion(Color.red, p);
                            c.add(button);
                        }
                    }
                    for (Case cPossDep : possibiliteDeplacement){

                        Case cDispo = new Case(3, cPossDep.ligne, cPossDep.colonne);
                        cDispo.addMouseListener(new EcouteurCase(cDispo, this.controller));
                        plateau.add(cDispo);
                    }
                    //c.add(new Button("Test"));

                    c.addMouseListener(new EcouteurCase(c, this.controller));
                    plateau.add(c);

                } else{

                    Case c = new Case(2, ligne, colonne);
                    c.addMouseListener(new EcouteurCase(c, this.controller));
                    plateau.add(c);
                }
            }
        }



        JFrame jeu = new JFrame("Dames");
        jeu.setTitle("Jeu de dames");
        jeu.setSize(500, 600);


        GridLayout gridHeader = new GridLayout(1, 10);
        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(gridHeader);
        panelHeader.setVisible(true);
        panelHeader.setSize(500, 100);

        nomJoueur1 = new JLabel(controller.getPseudoJoueur1());
        nomJoueur1.setLocation(10, 10);
        nomJoueur1.setBackground(Color.BLUE);
        nomJoueur1.setForeground(Color.BLUE);
        panelHeader.add(nomJoueur1);

        nbrPionJoueur1 = new JLabel(String.valueOf(controller.nbrPionCouleur(1))+" pions");
        nbrPionJoueur1.setLocation(50, 10);
        nbrPionJoueur1.setBackground(Color.BLUE);
        nbrPionJoueur1.setForeground(Color.BLUE);
        panelHeader.add(nbrPionJoueur1);

        titre = new JLabel("Jeu de dames");
        titre.setForeground(Color.BLACK);
        panelHeader.add(titre);

        nomJoueur2 = new JLabel(controller.getPseudoJoueur2());
        nomJoueur2.setLocation(400, 10);
        nomJoueur2.setBackground(Color.red);
        nomJoueur2.setForeground(Color.red);
        panelHeader.add(nomJoueur2);

        nbrPionJoueur2 = new JLabel(String.valueOf(controller.nbrPionCouleur(2))+" pions");
        nbrPionJoueur2.setLocation(450, 10);
        nbrPionJoueur2.setBackground(Color.red);
        nbrPionJoueur2.setForeground(Color.red);
        panelHeader.add(nbrPionJoueur2);
        panelHeader.setBackground(Color.YELLOW);




        JPanel panelFooter = new JPanel();
        panelFooter.setVisible(true);
        panelFooter.setSize(500, 100);


        if(joueurCourant == 6){
            infosTour = new JLabel("C'est au joueur bleu de jouer");
        }
        else{
            infosTour = new JLabel("C'est au joueur rouge de jouer");
        }
        panelFooter.add(infosTour);
        panelFooter.setBackground(Color.YELLOW);

        BorderLayout page = new BorderLayout();
        jeu.setLayout(page);
        jeu.add(panelHeader, BorderLayout.PAGE_START);
        jeu.add(plateau, BorderLayout.CENTER);
        jeu.add(panelFooter,BorderLayout.PAGE_END);




        jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jeu.setVisible(true);

        demarrage();

    }







    private JButton ajouterPion(Color couleur, Pion pion){
        JButton button = new RoundButton();
        button.setBackground(couleur);
        button.addMouseListener(new EcouteurPion(pion, this.controller));
        return button;
    }

    public void demarrage() {
        jeuEnCours = true;
        joueurCourant = Model.ROUGE;
    }

    public Case getCase(int index){
        return (Case) getComponent(index);
    }

    public void ajoutPionBleu(){
        this.plateauState.getPionsCouleur(1);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
