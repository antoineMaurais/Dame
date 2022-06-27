import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Vue
public class Jeu extends JPanel implements MouseListener {

    JLabel infos;
    Model plateauState;

    GridLayout grid = new GridLayout(10, 10);

    boolean jeuEnCours;
    int joueurCourant;

    private JLabel joueur1, joueur2;

    int ligneCourante, colonneCourante;

    public Jeu(Model model) {


        plateauState = model;


        addMouseListener(this);
        JFrame game = new JFrame("Checkers");

        joueur1 = new JLabel(plateauState.getPseudoJoueur1());
        joueur2 = new JLabel(plateauState.getPseudoJoueur2());


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
        game.setSize(400, 400);
        this.setBackground(Color.decode("#049304"));
        this.setBounds(20, 20, 244, 244);

        panelPrincipal.add(this);

        panelPrincipal.add(joueur1);
        panelPrincipal.add(joueur2);
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
