package objet;

import java.util.ArrayList;
import java.util.HashMap;

public class Biblio {
    private ArrayList<Livre> listDeLivres = null;
    private HashMap<Integer, Livre> listDeLivresHashMap = null;


    public Biblio() {
        listDeLivres = new ArrayList<>();
        listDeLivresHashMap = new HashMap<>();
    }


    public ArrayList<Livre> getListDeLivres() {
        return listDeLivres;
    }


    // return Une ArrayList de Titre de livre commençant par la lettre A

    public ArrayList<String> getAllBooksWithNameStartByA(){
        ArrayList<String> maSousListe = new ArrayList<>();
        for (int i = 0; i<this.getListDeLivres().size(); i++){
            Livre monLivreATester = this.getListDeLivres().get(i);
            if (monLivreATester.getTitre().toLowerCase().startsWith("a")){
                maSousListe.add(monLivreATester.getTitre());
            }

        }
        return maSousListe;
    }


    public ArrayList<String> getAllBooksWhithIDSNOdd(){
        ArrayList<String> maSousListe = new ArrayList<>();
        for (int i = 0; i<this.getListDeLivres().size(); i++){
            Livre monLivreATester = this.getListDeLivres().get(i);
            if (monLivreATester.getIndiceRef() % 2 == 1){
                maSousListe.add(monLivreATester.getTitre() + " / " + monLivreATester.getIndiceRef());
            }

        }
        return maSousListe;
    }

}
