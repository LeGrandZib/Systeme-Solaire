package Fenetre;

import Planetes.planete;
import eduPrinceton.Draw;
import eduPrinceton.DrawListener;
import eduPrinceton.StdDraw;
import horloge.HorlogeUniverselle;

import java.util.List;

import java.awt.*;

public class Fenetre implements DrawListener {

    //Attributs
    private double mouseX;
    private double mouseY;
    private int longueur;
    private int hauteur;

    boolean continu = true;
    private Draw d = new Draw("Systeme Solaire");
    private Label labelJPS;

    private List<planete> planetes;

    private static HorlogeUniverselle horloge;
    private int JPS;

    //Constructeur

    public Fenetre(int x, int y, HorlogeUniverselle h) {
        this.hauteur = y;
        this.longueur = x;
        d.setCanvasSize(longueur,hauteur);
        d.addListener(this);
        d.enableDoubleBuffering();
        Fenetre.horloge = h;
    }

    public Fenetre(HorlogeUniverselle h) {
        this(800,800, h);
    }

    public boolean isContinu() { return continu; }

    public void setPlanetes(List<planete> planetes) {
        this.planetes = planetes;
    }

    //Méthode
    public void affiche(List<planete> planetes){
        d.clear(Color.black);

        for ( planete p : planetes ) {
            d.setPenColor(p.getCouleur());
            d.filledCircle(p.getX(), p.getY(), p.getRayon());
            //d.circle(p.getxCercle(), p.getyCercle(), p.getRayonRevolution());
            d.show();
            p.deplacerPlanete(horloge);
        }

        //Temps d'attendre pour permettre un affichage plus visuel
        d.pause(10);
    }


    @Override
    public void keyTyped(char c) {
        if (horloge.getJoursParSeconde()!=0)
            JPS = horloge.getJoursParSeconde();
        switch (c){
            case 'p':
                horloge.playPause(JPS);
                break;
            case '-' :
                horloge.decJPS();
                break;
            case '+' :
                horloge.incJPS();
                break;

            default:
                break;
        }
    }




    @Override
    public void mousePressed(double x, double y) {
        this.mouseX = x;
        this.mouseY = y;
    }
    @Override
    public void mouseDragged(double x, double y) {

        for ( planete p : planetes ) {
            p.deplacerPlanete(-(this.mouseX - x), -(this.mouseY - y));
        }

        this.mouseX = x;
        this.mouseY = y;

    }
    @Override
    public void mouseReleased(double x, double y) {}
    @Override
    public void mouseClicked(double x, double y) {}
    @Override
    public void keyPressed(int keycode) {}
    @Override
    public void keyReleased(int keycode) {}
}
