package com.company;
import IHM.AppliGraphique;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() { // obligatoire  pour faire une interface graphique
            public void run(){
                try{
                    AppliGraphique monAppli = new AppliGraphique();
                    monAppli.setVisible(true); // pour voir la fenetre graphique
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("L'application a détecté une erreur de type "+ e.getMessage());
                }
            }
        });
    }
}
