import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EcouteurCase implements MouseListener {

    private Case caseJeu;
    private Controller controller;

    public EcouteurCase(Case caseJeu, Controller controller) {
        this.caseJeu = caseJeu;
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
       // if(caseJeu.isSelectionnee()){
            controller.deplacerCase(caseJeu);
       // }
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
