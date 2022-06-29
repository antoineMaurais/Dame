import javax.swing.*;
import java.awt.*;

public class Case extends JPanel {

    private int couleur;
    public int ligne;
    public int colonne;

    public Case(int couleur, int ligne, int colonne){
        this.couleur=couleur;
        this.ligne = ligne;
        this.colonne = colonne;
        setLayout(new GridLayout(1,0));
        initBackground(couleur);
    }

    private void initBackground(int couleur){
        if(couleur == 1){
            setBackground(Color.WHITE);
        } else if(couleur ==2 ) {
            setBackground(Color.BLACK);
        } else {
            setBackground(Color.LIGHT_GRAY);
        }
    }

    public int getColonne() {
        return this.colonne;
    }

    public int getLigne() {
        return this.ligne;
    }


}
