public class Pion {
    private int id;
    private int couleur;
    private int colonne;
    private int ligne;
    private boolean vivant;
    private boolean dame;

    public Pion(final int couleur, final int colonne, final int ligne){
        this.couleur = couleur;
        this.colonne = colonne;
        this.ligne = ligne;
        this.dame = false;
        this.vivant = true;
    }

    public int getId() {
        return id;
    }

    public int getCouleur(){
        return this.couleur;
    }

    public int getColonne(){
        return this.colonne;
    }

    public int getLigne(){
        return this.ligne;
    }

    public boolean isDame() {
        return dame;
    }

    public boolean isVivant() {
        return vivant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setDame(boolean dame) {
        this.dame = dame;
    }

    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }
}
