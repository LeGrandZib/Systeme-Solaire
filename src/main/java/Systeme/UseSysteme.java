package Systeme;

import eduPrinceton.Draw;
import Planetes.planete;
import Fenetre.Fenetre;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class UseSysteme {
    public static void main(String[] args) {

        //Création fenetre

        Fenetre f = new Fenetre();

        //Constante rotationTerre (toutes les autres planètes se déplacent autour du soleil en fonction de la période de révolution de la Terre)
        final double rotationTerre = 0.05;

        //Création des planetes

        planete soleil = new planete(Color.orange);

        planete mercure = new planete(0.6, 0.5, 0.01, 4.147 * rotationTerre, Color.gray); //88 jours
        planete venus = new planete(0.65, 0.5, 0.01, 1.629 * rotationTerre, Color.pink);// 224 jours
        planete terre = new planete(0.70, 0.5, 0.02, rotationTerre, Color.green); // 365 jours
        planete mars = new planete(0.75, 0.5, 0.01, 0.531 * rotationTerre, 247, 111, 82); // 687 jours
        planete jupiter = new planete(0.8, 0.5, 0.01, 0.084 * rotationTerre, 217, 174, 81); // 4 332 jours
        planete saturne = new planete(0.85, 0.5, 0.01, 0.033 * rotationTerre, 225, 199, 117); // 10 759 jours
        planete uranus = new planete(0.90, 0.5, 0.01, 0.011 * rotationTerre, Color.white); // 30 685 jours
        planete neptune = new planete(0.95, 0.5, 0.01, 0.006 * rotationTerre, Color.blue); // 60 216 jours

        List<planete> planetes;
        planetes = Arrays.asList(soleil, mercure, venus, terre, mars, jupiter, saturne, uranus, neptune);

        //Affichage des planetes + évolution
        // 's' pour arrêter
        while(f.isContinu()){
            f.affiche(planetes);
        }

    }
}
