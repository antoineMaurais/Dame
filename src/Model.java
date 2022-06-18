import java.util.List;

public class Model {
    private List<Pion> pionList;
    private List<Joueur> joueurList;

    public Model(){
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
        Joueur j = new Joueur(1, "joueur 1");
        this.joueurList.add(j);
        j = new Joueur(2, "joueur 2");
        this.joueurList.add(j);
    }

    public List<Pion> getPionList(){
        return this.pionList;
    }

    public Pion getPion(int index){
        return (Pion)this.pionList.get(index);
    }

    public List<Joueur> getJoueurList() {
        return joueurList;
    }


}
