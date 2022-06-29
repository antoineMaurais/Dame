import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EcouteurPion implements MouseListener {

    private Controller controller;
    private Pion pion;

    public EcouteurPion(Pion pion, Controller controller){
        this.controller = controller;
        this.pion = pion;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(pion.getCouleur());
        controller.afficherPossibilites(pion);
        // TODO je pense faut rappeler pour reconstruire la fenetre avec les nouveaux composants
        //controller.setVueJeu(controller.);
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
