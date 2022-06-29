import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

// Vue
public class Jeu extends JPanel implements MouseListener {

    Model plateauState;
    Controller controller;
    boolean jeuEnCours;

    List<Pion> pionsBleu = new ArrayList<Pion>();
    List<Pion> pionsRouge = new ArrayList<Pion>();
    List<Case> possibiliteDeplacement = new ArrayList<Case>();
    int joueurCourant;
    JLabel infosTour, nomJoueur1, nomJoueur2, nbrPionJoueur1, nbrPionJoueur2;

    public Jeu(Model model) {

        plateauState = model;
        controller = new Controller(plateauState);
        possibiliteDeplacement = plateauState.getCasePossDep();

        GridLayout grid = new GridLayout(10, 10);
        JPanel plateau = new JPanel();
        plateau.setLayout(grid);
        plateau.setSize(50, 50);
        plateau.setLocation(0, 100);

        pionsBleu = plateauState.getPionsCouleur(1);
        pionsRouge = plateauState.getPionsCouleur(2);


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

        nomJoueur1 = new JLabel(plateauState.getPseudoJoueur1());
        nomJoueur1.setLocation(10, 10);
        nomJoueur1.setBackground(Color.cyan);
        panelHeader.add(nomJoueur1);

        nbrPionJoueur1 = new JLabel(String.valueOf(plateauState.nbrPionCouleur(1))+" pions");
        nbrPionJoueur1.setLocation(50, 10);
        nbrPionJoueur1.setBackground(Color.cyan);
        panelHeader.add(nbrPionJoueur1);

        nomJoueur2 = new JLabel(plateauState.getPseudoJoueur2());
        nomJoueur2.setLocation(400, 10);
        nomJoueur2.setBackground(Color.red);
        panelHeader.add(nomJoueur2);

        nbrPionJoueur2 = new JLabel(String.valueOf(plateauState.nbrPionCouleur(2))+" pions");
        nbrPionJoueur2.setLocation(450, 10);
        nbrPionJoueur2.setBackground(Color.red);
        panelHeader.add(nbrPionJoueur2);


        BorderLayout page = new BorderLayout();
        jeu.setLayout(page);
        jeu.add(panelHeader, BorderLayout.PAGE_START);
        jeu.add(plateau, BorderLayout.CENTER);




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
        joueurCourant = Model.BLANC;
    }

    public Case getCase(int index){
        return (Case) getComponent(index);
    }

    public void ajoutPionBleu(){
        this.plateauState.getPionsCouleur(1);
    }
    /*
    JLabel infos;
    Model plateauState;

    GridLayout grid = new GridLayout(10, 10);

    boolean jeuEnCours;
    int joueurCourant;

    private JLabel nomJoueur1, nomJoueur2, nbrPionJoueur1, nbrPionJoueur2;

    int ligneCourante, colonneCourante;

    public Jeu(Model model) {


        plateauState = model;


        addMouseListener(this);
        JFrame game = new JFrame("Checkers");

        nomJoueur1 = new JLabel(plateauState.getPseudoJoueur1());
        nomJoueur2 = new JLabel(plateauState.getPseudoJoueur2());

        nbrPionJoueur1 = new JLabel(String.valueOf(plateauState.nbrPionCouleur(1)));
        nbrPionJoueur2 = new JLabel(String.valueOf(plateauState.nbrPionCouleur(2)));

        JPanel plateau = new JPanel();
        plateau.setLayout(grid);


        // test ajout de boutons dans la grid
        plateau.add(new JButton("1"));
        plateau.add(new JButton("2"));
        plateau.add(new JButton("3"));
        plateau.add(new JButton("4"));
        plateau.add(new JButton("1"));
        plateau.add(new JButton("2"));
        plateau.add(new JButton("3"));
        plateau.add(new JButton("4"));

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        game.setTitle("Jeu de dame");
        game.setSize(700, 900);
        this.setBackground(Color.decode("#400400"));
        this.setBounds(20, 20, 244, 244);

        JPanel panelHeader = new JPanel();
        nomJoueur1.setLocation(10, 10);
        panelHeader.add(nomJoueur1);
        nbrPionJoueur1.setLocation(50, 10);
        panelHeader.add(nbrPionJoueur1);
        nomJoueur2.setLocation(400, 10);
        panelHeader.add(nomJoueur2);
        nbrPionJoueur2.setLocation(450, 10);
        panelHeader.add(nbrPionJoueur2);

        panelPrincipal.add(panelHeader);
        panelPrincipal.add(this);

        infos = new JLabel("C'est au joueur blanc de commencer");
        panelPrincipal.add(infos);

        // Ajout de la grid dans la fenetre mais ne fonctionne pas
        //panelPrincipal.add(plateau);


        game.add(panelPrincipal);



        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);


        demarrage();

        //System.out.println(plateauState.getJoueur1());
    }

    public void demarrage() {
        plateauState.creationPlateau();
        jeuEnCours = true;
        joueurCourant = Model.BLANC;

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.drawRect(0,0,getSize().width-1,getSize().height-1);
        g.drawRect(1,1,getSize().width-3,getSize().height-3);


        for (int ligne = 0; ligne < 10; ligne++) {
            for (int colonne = 0; colonne < 10; colonne++) {
                if ( ligne % 2 == colonne % 2 )
                    g.setColor(Color.LIGHT_GRAY);
                else
                    g.setColor(Color.GRAY);
                g.fillRect(2 + colonne*30, 2 + ligne*30, 30, 30);
                switch (plateauState.pieceCourante(ligne,colonne)) {
                    case Model.BLANC:
                        g.setColor(Color.RED);
                        g.fillOval(4 + colonne*30, 4 + ligne*30, 25, 25);
                        break;
                    case Model.NOIR:
                        g.setColor(Color.BLACK);
                        g.fillOval(4 + colonne*30, 4 + colonne*30, 25, 25);
                        break;
                    case Model.DAME_BLANCHE:
                        g.setColor(Color.RED);
                        g.fillOval(4 + colonne*30, 4 + ligne*30, 25, 25);
                        g.setColor(Color.WHITE);
                        g.drawString("K", 7 + colonne*30, 16 + ligne*30);
                        break;
                    case Model.DAME_NOIRE:
                        g.setColor(Color.BLACK);
                        g.fillOval(4 + colonne*30, 4 + ligne*30, 25, 25);
                        g.setColor(Color.WHITE);
                        g.drawString("K", 7 + colonne*30, 16 + ligne*30);
                        break;
                }
            }
        }
        */

/*
        if(jeuEnCours) {
            g.setColor(Color.CYAN);
            for(int i = 0; i < possibleMoves.length; i++) {
                g.drawRect(2 + possibleMoves[i].fromCol*30, 2 + possibleMoves[i].fromRow*30, 29, 29);
                g.drawRect(3 + possibleMoves[i].fromCol*30,	3 + possibleMoves[i].fromRow*30, 27, 27);
            }

            if(currRow >= 0) {
                System.out.println("green tiles showing next move");
                g.setColor(Color.white);
                g.drawRect(2 + currCol*30, 2 + currRow*30, 29, 29);
                g.drawRect(3 + currCol*30, 3 + currRow*30, 27, 27);
                g.setColor(Color.green);
                for(int i = 0; i < possibleMoves.length; i++) {
                    if(possibleMoves[i].fromRow == currRow && possibleMoves[i].fromCol == currCol) {
                        g.drawRect(2 + possibleMoves[i].toCol*30, 2 + possibleMoves[i].toRow*30, 29, 29);
                        //g.drawRect(3 + possibleMoves[i].toCol*30, 3 + possibleMoves[i].toRow*30, 27, 27);
                    }
                }
            }
        }*/


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
