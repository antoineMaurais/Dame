import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreConfiguration extends JFrame implements ActionListener {

    private Joueur joueur;

    private Controller controller;

    private Model model;

    private Jeu jeu;

    private JLabel labelPseudoJoueur1, labelPseudoJoueur2;

    private JTextField textFieldPseudoJoueur1, textFieldPseudoJoueur2;

    private JFrame frame;
    private JPanel panel;

    private String pseudo1;
    private String pseudo2;


    public FenetreConfiguration(String titre, Controller controller)
    {
        this.controller = controller;
        this.setTitle(titre);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        // Faire que la fenetre prenne tout l'écran
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.construireFenetre();
    }


    private void construireFenetre()
    {
        panel = new JPanel();

        frame = new JFrame("");

        panel.setLayout(new GridLayout(5, 0));

        JButton boutonSauver = new JButton("Démarrer");

        boutonSauver.addActionListener(this);

        model = new Model();

        labelPseudoJoueur1 = new JLabel("Pseudo joueur 1 :");
        textFieldPseudoJoueur1 = new JTextField(controller.getPseudoJoueur1());

        labelPseudoJoueur2 = new JLabel("Pseudo joueur 2 :");
        textFieldPseudoJoueur2 = new JTextField(controller.getPseudoJoueur2());


        panel.add(labelPseudoJoueur1);
        panel.add(textFieldPseudoJoueur1);
        panel.add(labelPseudoJoueur2);
        panel.add(textFieldPseudoJoueur2);
        panel.add(boutonSauver);

        this.setContentPane(panel);
    }



    public void actionPerformed(ActionEvent e) {

        model = new Model();
        controller = new Controller(model);

        System.out.println(textFieldPseudoJoueur1.getText());
        controller.setPseudoJoueur1(textFieldPseudoJoueur1.getText());
        controller.setPseudoJoueur2(textFieldPseudoJoueur2.getText());
        frame.dispose();
        /*
        Jeu jeu = new Jeu(controller);
        jeu.setVisible(true);
        controller.setVueJeu(jeu);

         */
        jeu = new Jeu(model);
    }
}
