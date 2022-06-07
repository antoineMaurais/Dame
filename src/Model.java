import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Pion> liste;

    public Model(){
        //Pion blanc
        Pion p = new Pion(1, 1, 1);
        this.liste.add(p);
        p = new Pion(1, 3 , 1);
        this.liste.add(p);
        p = new Pion(1, 5 , 1);
        this.liste.add(p);
        p = new Pion(1, 7 , 1);
        this.liste.add(p);
        p = new Pion(1, 9 , 1);
        this.liste.add(p);
        p = new Pion(1, 2 , 2);
        this.liste.add(p);
        p = new Pion(1, 4 , 2);
        this.liste.add(p);
        p = new Pion(1, 6 , 2);
        this.liste.add(p);
        p = new Pion(1, 8 , 2);
        this.liste.add(p);
        p = new Pion(1, 10 , 2);
        this.liste.add(p);
        p = new Pion(1, 1, 3);
        this.liste.add(p);
        p = new Pion(1, 3 , 3);
        this.liste.add(p);
        p = new Pion(1, 5 , 3);
        this.liste.add(p);
        p = new Pion(1, 7 , 3);
        this.liste.add(p);
        p = new Pion(1, 9 , 3);
        this.liste.add(p);
        p = new Pion(1, 2 , 4);
        this.liste.add(p);
        p = new Pion(1, 4 , 4);
        this.liste.add(p);
        p = new Pion(1, 6 , 4);
        this.liste.add(p);
        p = new Pion(1, 8 , 4);
        this.liste.add(p);
        p = new Pion(1, 10 , 4);
        this.liste.add(p);

        //Pion noir
        p = new Pion(2, 1, 7);
        this.liste.add(p);
        p = new Pion(2, 3 , 7);
        this.liste.add(p);
        p = new Pion(2, 5 , 7);
        this.liste.add(p);
        p = new Pion(2, 7 , 7);
        this.liste.add(p);
        p = new Pion(2, 9 , 7);
        this.liste.add(p);
        p = new Pion(2, 2 , 8);
        this.liste.add(p);
        p = new Pion(2, 4 , 8);
        this.liste.add(p);
        p = new Pion(2, 6 , 8);
        this.liste.add(p);
        p = new Pion(2, 8 , 8);
        this.liste.add(p);
        p = new Pion(2, 10 , 8);
        this.liste.add(p);
        p = new Pion(2, 1, 9);
        this.liste.add(p);
        p = new Pion(2, 3 , 9);
        this.liste.add(p);
        p = new Pion(2, 5 , 9);
        this.liste.add(p);
        p = new Pion(2, 7 , 9);
        this.liste.add(p);
        p = new Pion(2, 9 , 10);
        this.liste.add(p);
        p = new Pion(2, 2 , 10);
        this.liste.add(p);
        p = new Pion(2, 4 , 10);
        this.liste.add(p);
        p = new Pion(2, 6 , 10);
        this.liste.add(p);
        p = new Pion(2, 8 , 10);
        this.liste.add(p);
        p = new Pion(2, 10 , 10);
        this.liste.add(p);
    }

    public List<Pion> getListe(){
        return this.liste;
    }

    public Pion getEmployee(int index){
        return (Pion)this.liste.get(index);
    }
}
