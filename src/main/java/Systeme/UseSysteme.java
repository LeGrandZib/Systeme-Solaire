package Systeme;

import Planetes.planete;
import Fenetre.Fenetre;
import horloge.HorlogeUniverselle;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class UseSysteme {
    public static void main(String[] args) {

        //Création fenetre

        Fenetre f = new Fenetre();


        HorlogeUniverselle horloge = new HorlogeUniverselle(10);
        Thread threadHorloge = new Thread(horloge);



        //Constante rotationTerre (toutes les autres planètes se déplacent autour du soleil en fonction de la période de révolution de la Terre)
        final double rotationTerre = 0.0015;

        //Création des planetes

        planete soleil = new planete(Color.orange);

        planete mercure = new planete(0.6, 0.5, 0.005, 4.147 * rotationTerre, 191,179,164); //88 jours
        planete venus = new planete(0.65, 0.5, 0.01, 1.629 * rotationTerre, 221,216,212);// 224 jours
        planete terre = new planete(0.70, 0.5, 0.02, rotationTerre, Color.blue); // 365 jours
        planete mars = new planete(0.75, 0.5, 0.007, 0.531 * rotationTerre, 178, 46, 32); // 687 jours
        planete jupiter = new planete(0.8, 0.5, 0.03, 0.084 * rotationTerre, 235, 160, 116); // 4 332 jours
        planete saturne = new planete(0.86, 0.5, 0.028, 0.033 * rotationTerre, 214, 182, 117); // 10 759 jours
        planete uranus = new planete(0.92, 0.5, 0.023, 0.011 * rotationTerre, 190,225,229); // 30 685 jours
        planete neptune = new planete(0.97, 0.5, 0.0235, 0.006 * rotationTerre, 84,138,232); // 60 216 jours

        List<planete> planetes;
        planetes = Arrays.asList(soleil, mercure, venus, terre, mars, jupiter, saturne, uranus, neptune);

        //Affichage des planetes + évolution
        // 's' pour arrêter

        f.setPlanetes(planetes);

        threadHorloge.start();

        while(f.isContinu()){
            f.affiche(planetes, horloge);
        }
    }
}
