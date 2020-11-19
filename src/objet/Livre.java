package objet;

    public class Livre {
        private String titre;
        private String auteur;
        private int annee;
        private String editeur;
        private String langue;
        private int indiceRef;


        public Livre(String titre, String auteur, int annee, String editeur, String langue, int indiceRef) {
            this.titre = titre;
            this.auteur = auteur;
            this.annee = annee;
            this.editeur = editeur;
            this.langue = langue;
            this.indiceRef = indiceRef;
        }

        public String getTitre() {
            return titre;
        }

        public String getAuteur() {
            return auteur;
        }

        public int getAnnee() {
            return annee;
        }

        public String getEditeur() {
            return editeur;
        }

        public String getLangue() {
            return langue;
        }

        public int getIndiceRef() {
            return indiceRef;

        }
    }


