package Planetes;

import eduPrinceton.Draw;

import java.awt.*;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class planete {

    private static final Color COULEUR_PAR_DEFAULT = new Color(0,0,0);

    //Attributs
    //Planete
    private double x;
    private double y;
    private final double rayon;
    private final double constAngleRotation;
    private double angleRotation;
    private final Color couleur;

    //Cercle Orbite
    private final double xCercle;
    private final double yCercle;
    private final double rayonRevolution;

    //Construtor

    public planete(double x, double y, double rayon, double angleRotation, Color couleur) {
        this.x = x;
        this.y = y;
        this.rayon = rayon;
        this.constAngleRotation = angleRotation;
        this.angleRotation = constAngleRotation;
        this.couleur = (couleur != null) ? couleur:COULEUR_PAR_DEFAULT;

        this.xCercle = 0.5;
        this.yCercle = 0.5;
        this.rayonRevolution = this.x - xCercle;
    }

    public planete(double x, double y, double rayon, double angleRotation, int r, int g, int b) {
        this(x, y, rayon, angleRotation, new Color(r, g, b));
    }

    public planete() {
        this(0.5, 0.5, 0.05, 0, COULEUR_PAR_DEFAULT);
    }

    public planete(Color couleur) {
        this(0.5, 0.5, 0.05, 0, couleur);
    }

    public planete(int r, int g, int b) {
        this(0.5, 0.5, 0.05, 0, new Color(r, g, b));
    }

    //Affichage
    @Override
    public String toString() {
        return "planete{" +
                "x=" + x +
                ", y=" + y +
                ", rayon=" + rayon +
                ", constAngleRotation=" + constAngleRotation +
                ", angleRotation=" + angleRotation +
                ", couleur=" + couleur +
                ", xCercle=" + xCercle +
                ", yCercle=" + yCercle +
                ", rayonRevolution=" + rayonRevolution +
                '}';
    }

    //Getter
    public double getX() { return x; }

    public double getY() { return y; }

    public double getRayon() { return rayon; }

    public Color getCouleur() { return couleur; }

    public double getxCercle() { return xCercle; }

    public double getyCercle() { return yCercle; }

    public double getRayonRevolution() { return rayonRevolution; }

    //Méthode
    public void deplacerPlanete(){
        if(angleRotation >= 360){
            angleRotation -= 360;
        }

        this.x = xCercle + rayonRevolution * cos(angleRotation);
        this.y = yCercle + rayonRevolution * -sin(angleRotation);

        this.angleRotation += constAngleRotation;
    }


}
