public class MVCMain {
    public static void main(String [] args){
        final Model model = new Model();
        final Controller controller = new Controller(model);

        FenetreConfiguration f = new FenetreConfiguration("Fenetre de configuration", controller);
        f.setVisible(true);
        controller.setVueConfig(f);
    }
}
