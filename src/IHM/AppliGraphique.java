package IHM;

import objet.Livre;
import objet.Biblio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class AppliGraphique extends JFrame {

    // Constructeur
    public AppliGraphique() {

        // JFrame (1re couche)
        super("Projet bibliothèque graphique");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// pour fermeture fenetre graphique
        this.setSize(600, 400);

        Biblio maBiblio = new Biblio();

        // JPanel (2e couche / "conteneur")
        JPanel container = (JPanel) this.getContentPane();// methode deJFrame castée sur (JPanel)

        // LES LAYOUTS (3e couche sur Panel)
        FlowLayout monLayout = new FlowLayout();// mise en page de gauche à droite
        container.setLayout(monLayout);

        // Composants ex : écrire texte sur l'interface, saisir texte, créer boutons etc ... (4e couche)
        // 6 LABELS  :
        JLabel labelTitre = new JLabel();
        labelTitre.setText("Titre: ");

        JLabel labelAuteur = new JLabel();
        labelAuteur.setText("Auteur: ");

        JLabel labelAnnee = new JLabel();
        labelAnnee.setText("Année: ");

        JLabel labelEditeur = new JLabel();
        labelEditeur.setText("Editeur: ");

        JLabel labelLangue = new JLabel();
        labelLangue.setText("Langue: ");

        JLabel labelIndiceRef = new JLabel();
        labelIndiceRef.setText("Indice réf. : ");

        JLabel labelCR = new JLabel();

        // 6 TEXTFIELD
        JTextField maJtextFieldTitre = new JTextField();
        maJtextFieldTitre.setPreferredSize(new Dimension(60, 25));
        maJtextFieldTitre.setText("");

        JTextField maJtextFieldAuteur = new JTextField();
        maJtextFieldAuteur.setPreferredSize(new Dimension(60, 25));
        maJtextFieldAuteur.setText("");

        JTextField maJtextFieldAnnee = new JTextField();
        maJtextFieldAnnee.setPreferredSize(new Dimension(60, 25));
        maJtextFieldAnnee.setText("");

        JTextField maJtextFieldEditeur = new JTextField();
        maJtextFieldEditeur.setPreferredSize(new Dimension(60, 25));
        maJtextFieldEditeur.setText("");

        JTextField maJtextFieldLangue = new JTextField();
        maJtextFieldLangue.setPreferredSize(new Dimension(60, 25));
        maJtextFieldLangue.setText("");

        JTextField maJtextFieldIndiceRef = new JTextField();
        maJtextFieldIndiceRef.setPreferredSize(new Dimension(60, 25));
        maJtextFieldIndiceRef.setText("");

        JTextArea crText = new JTextArea();
        crText.setText("");


        // BOUTONS
        JButton monPremierBouton = new JButton();
        monPremierBouton.setToolTipText("Veuillez valider votre choix");// affichage texte en survol du bouton
        monPremierBouton.setText("Valider");

        JButton monSecondBouton = new JButton();
        monSecondBouton.setText("CR Liste de tous les livres");

        JButton monTroisiemeBouton = new JButton();
        monTroisiemeBouton.setText("Liste de tous les livres commençant par A");

        JButton monQuatriemeBouton = new JButton();
        monQuatriemeBouton.setText("Liste de tous les livres à indice impair");


        JRadioButton roman = new JRadioButton("Roman");
        JRadioButton manga = new JRadioButton("Manga");
        JRadioButton magazine = new JRadioButton("Magazine");

        ButtonGroup group = new ButtonGroup();
        group.add(roman);
        group.add(manga);
        group.add(magazine);



        // AJOUTS SUR CONTAINER, layout déjà collé automatiquement sur le container
        // ajouts des labels et textfields et bouton valider sur container
        container.add(labelTitre); // Titre
        container.add(maJtextFieldTitre);
        container.add(labelAuteur); // Auteur
        container.add(maJtextFieldAuteur);
        container.add(labelAnnee); // Annee
        container.add(maJtextFieldAnnee);
        container.add(labelEditeur); // Editeur
        container.add(maJtextFieldEditeur);
        container.add(labelLangue); // langue
        container.add(maJtextFieldLangue);
        container.add(labelIndiceRef); // Indice réf.
        container.add(maJtextFieldIndiceRef);

        container.add(monPremierBouton); // bouton Valider
        container.add(monSecondBouton); // bouton CR
        container.add(monTroisiemeBouton); // bouton livres commençant par A
        container.add(monQuatriemeBouton); // bouton livres index impair

        container.add(labelCR);
        container.add(crText);


        container.add(roman);
        container.add(manga);
        container.add(magazine);


        // GESTION ACTIONS DE L'UTILISATEUR
        monPremierBouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int annee = Integer.parseInt(maJtextFieldAnnee.getText());
                Livre monLivre = createBook(maJtextFieldTitre.getText(), maJtextFieldAuteur.getText(), annee, maJtextFieldEditeur.getText(), maJtextFieldLangue.getText(), Integer.parseInt(maJtextFieldIndiceRef.getText()));

                boolean isExist = verifieIndiceDuLivre(maJtextFieldIndiceRef, maBiblio);
                if (isExist) {
                    System.out.println("Je suis désolé mais l'indiceRef de ce livre existe déjà");
                }else {

                    maBiblio.getListDeLivres().add(monLivre);
                }
            }
        });

        monSecondBouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherLivreBiblio(maBiblio, crText);
            }
        });

        monTroisiemeBouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherLivreCommencantParA(maBiblio, crText);
            }
        });

        monQuatriemeBouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherLivreIndiceRefImpair(maBiblio, crText);
            }
        });

        /*
        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherRoman(maBiblio, crText);
            }
        });*/


        // MENU DE L'APPLICATION
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);

        // Fichier dans la barre de menu
        JMenu menuFichier = new JMenu("Fichier");
        menu.add(menuFichier);

        JMenuItem subMenuExit = new JMenuItem("Exit");// sous-menu Exit
        JMenuItem subMenuNouveau = new JMenuItem("Nouveau"); // sous-menu Nouveau

        menuFichier.add(subMenuNouveau);
        menuFichier.add(subMenuExit);

        // Edition dans barre de menu
        JMenu menuEdition = new JMenu("Edition");
        menu.add(menuEdition);

        JMenuItem subMenuCopier = new JMenuItem("Copier");// sous-menu Copier
        JMenuItem subMenuColler = new JMenuItem("Coller"); // sous-menu Coller

        menuEdition.add(subMenuCopier);
        menuEdition.add(subMenuColler);

        // Gestion actions de l'utilisateur dans le menu
        subMenuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // quand on clic sur Exit dans sous menu, la fenetre se ferme
            }
        });
    }

    // METHODES
    /*private void changeTextValue(JTextField maJtextFieldTitre, JLabel labelTitre) {
        maJtextFieldTitre.setText("Valider");
        labelTitre.setText("Auteur");
    }*/

    private Livre createBook(String titre, String auteur, int annee, String editeur, String langue, int indiceRef) {
        Livre monLivre = new Livre(titre, auteur, annee, editeur, langue, indiceRef);
        System.out.println("titre" + monLivre.getTitre() + "auteur" + monLivre.getAuteur() + "annee" + monLivre.getAnnee() + "Editeur" + monLivre.getEditeur() + "langue" + monLivre.getLangue() + "indiceref" + monLivre.getIndiceRef());
        return monLivre;
        // maBiblio.getListDeLivres().add(monLivre);
    }

    private void afficherLivreBiblio(Biblio maBiblio, JTextArea crText) {
        String cr = "";
        for (int i = 0; i < maBiblio.getListDeLivres().size(); i++) {
            cr += maBiblio.getListDeLivres().get(i).getTitre() + " " + maBiblio.getListDeLivres().get(i).getAuteur() + " " + maBiblio.getListDeLivres().get(i).getAnnee() + " " + maBiblio.getListDeLivres().get(i).getEditeur() + " " + maBiblio.getListDeLivres().get(i).getLangue() + " " + maBiblio.getListDeLivres().get(i).getIndiceRef();
        }
        crText.setText(cr);
    }

    private void afficherLivreCommencantParA(Biblio maBiblio, JTextArea crText) {
        String cr ="";
        for (Livre livres : maBiblio.getListDeLivres()) {
            if (livres.getTitre().charAt(0) == 'a' || livres.getTitre().charAt(0) == 'A') {
                cr += livres.getTitre() + ", ";
            }
        }
        crText.setText(cr);
    }

    private void afficherLivreIndiceRefImpair(Biblio maBiblio, JTextArea crText) {
        String cr = "";
        for (Livre livres : maBiblio.getListDeLivres()) {
            if (livres.getIndiceRef() % 2 != 0) {
                cr += livres.getIndiceRef()+ ", ";
            }
        }
        crText.setText(cr);
    }


    private boolean verifieIndiceDuLivre(JTextField maJTextField, Biblio maBiblio) {
        boolean isAlredyExist = false;
            for (int i =0; i < maBiblio.getListDeLivres().size(); i++){
                Livre livreAVerifier = maBiblio.getListDeLivres().get(i);
                if (livreAVerifier.getIndiceRef() == Integer.parseInt(maJTextField.getText())){
                    isAlredyExist = true;
                    String popup;
                    popup = JOptionPane.showInputDialog("l'indice réf existe déjà");
                return isAlredyExist;
            }
        }
        return isAlredyExist;
    }
}

