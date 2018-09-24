package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class InterfaceJeu {

    private Torpilleur torpilleur;
    private ContreTorpilleur contreTorpilleur;
    private PorteAvion porteAvion;
    private SousMarin sousMarin;
    private Croiseur  croiseur;
    private String [][] champBataille;
    private Point pointTorpilleur;
    private int orientationTorpilleur;
    private Point pointContreTorpilleur;
    private int orientationContreTorpilleur;
    private Point pointPorteAvion;
    private int orientationPorteAvion;
    private Point pointCroiseur;
    private int orientationCroiseur;
    private Point pointSousMarin;
    private int orientationSousMarin;
    private Joueur joueur;
    private Menu menu;




    public InterfaceJeu(Joueur joueur){

        this.joueur = joueur;

        //Création de la grille

        int i,j,k=0;
        champBataille = new String[10][10];

        for (i=0;i < champBataille.length;i++){
            for(j=0;j< champBataille[i].length;j++){

                     champBataille[i][j]= "O";


            }

        }
       //*******************************************************

         menu = new Menu();

       // Choisir la position du torpilleur
        pointTorpilleur = menu.menuPositionBateau("Torpilleur");


        //Choisir l'orientation du torpilleur
        orientationTorpilleur = menu.menuOrientationBateau("Torpilleur");

        //Creation du torpilleur
        torpilleur = new Torpilleur("Torpilleur");
        torpilleur.setPosition(pointTorpilleur);
        torpilleur.setOrientation(orientationTorpilleur);
        //***************************************************

        //placement du torpilleur sur la grille
        joueur.ajouterBateau(torpilleur);
        placementBateau(torpilleur.getPosition(),torpilleur.getTaille(),torpilleur.getOrientation());
        menu.afficherChampBataille(champBataille);
        menu.logPositionsBateau(torpilleur);



        // Choisir la position du sousMarin
        sousMarin = new SousMarin("SousMarin");
        pointSousMarin = menu.menuPositionBateau(sousMarin.getNom());


        //Choisir l'orientation du SousMarin
        orientationSousMarin = menu.menuOrientationBateau(sousMarin.getNom());

        //Creation du SousMarin
        sousMarin.setPosition(pointSousMarin);
        sousMarin.setOrientation(orientationSousMarin);
        //***************************************************

        //placement du sousMarin sur la grille
        joueur.ajouterBateau(sousMarin);
        placementBateau(sousMarin.getPosition(),sousMarin.getTaille(),sousMarin.getOrientation());
        menu.afficherChampBataille(champBataille);
        menu.logPositionsBateau(sousMarin);



        // Choisir la position du contreTorpilleur
        contreTorpilleur = new ContreTorpilleur("contreTorpilleur");
        pointContreTorpilleur = menu.menuPositionBateau(contreTorpilleur.getNom());


        //Choisir l'orientation du contreTorpilleur
        orientationContreTorpilleur = menu.menuOrientationBateau(contreTorpilleur.getNom());

        //Creation du contreTorpilleur
        contreTorpilleur.setPosition(pointContreTorpilleur);
        contreTorpilleur.setOrientation(orientationContreTorpilleur);
        //***************************************************

        //placement du contreTorpilleur sur la grille
        joueur.ajouterBateau(contreTorpilleur);
        placementBateau(contreTorpilleur.getPosition(),contreTorpilleur.getTaille(),contreTorpilleur.getOrientation());
        menu.afficherChampBataille(champBataille);
        menu.logPositionsBateau(contreTorpilleur);



        // Choisir la position du porteAvion
        porteAvion = new PorteAvion("porteAvion");
        pointPorteAvion = menu.menuPositionBateau(porteAvion.getNom());


        //Choisir l'orientation du porteAvion
        orientationPorteAvion = menu.menuOrientationBateau(porteAvion.getNom());

        //Creation du porteAvion
        porteAvion.setPosition(pointPorteAvion);
        porteAvion.setOrientation(orientationPorteAvion);
        //***************************************************

        //placement du porteAvion sur la grille
        joueur.ajouterBateau(porteAvion);
        placementBateau(porteAvion.getPosition(),porteAvion.getTaille(),porteAvion.getOrientation());
        menu.afficherChampBataille(champBataille);
        menu.logPositionsBateau(porteAvion);



        // Choisir la position du croiseur
        croiseur = new Croiseur("croiseur");
        pointCroiseur = menu.menuPositionBateau(croiseur.getNom());


        //Choisir l'orientation du croiseur
        orientationCroiseur = menu.menuOrientationBateau(croiseur.getNom());

        //Creation du croiseur
        croiseur.setPosition(pointCroiseur);
        croiseur.setOrientation(orientationCroiseur);
        //***************************************************

        //placement du croiseur sur la grille
        joueur.ajouterBateau(croiseur);
        placementBateau(croiseur.getPosition(),croiseur.getTaille(),croiseur.getOrientation());
        menu.afficherChampBataille(champBataille);
        menu.logPositionsBateau(croiseur);


    }

    public String[][] getChampBataille() {
        return champBataille;
    }


    public void placementBateau(Point point, int taille, int orientation){

        int i;

        switch (orientation){

            case 8:

                for (i= point.x ;i > point.x - taille ;i--){

                    champBataille[i][point.y]= "\033[31m"+"X" + "\033[00m";

                }

                break;

            case 4:

                for (i= point.y ;i > point.y - taille ;i--){

                    champBataille[point.x][i]= "\033[31m" + "X"+ "\033[00m";

                }

                break;

            case 2:

                for (i= point.x ;i < point.x + taille ;i++){

                    champBataille[i][point.y]= "\033[31m" +"X"+ "\033[00m";

                }

                break;

            case 6:

                for (i= point.y ;i < point.y + taille ;i++){

                    champBataille[point.x][i]= "\033[31m"+"X"+ "\033[00m";

                }

                break;
        }


    }

    public void updateGrid (Joueur joueur){

        int i,j;
        boolean pointPresent = false;
        List<Point> allPoints = new ArrayList<Point>();

        // recuperer toutes les positions des bateaux du joueur

        for (Bateau bateau: joueur.getListBateau()
             ) {
                  allPoints.addAll(bateau.getListPoint());

        }

        //**********************************************


        //Replacer toutes les positions dans la grille dans la grille
        for (i=0;i < champBataille.length;i++){
            for(j=0;j< champBataille[i].length;j++){

                pointPresent = false;

                for (Point point : allPoints
                     ) {

                    if(point.x == i && point.y == j)
                        pointPresent = true;
                }

                if(pointPresent)
                     champBataille[i][j]= "\033[31m"+"X" + "\033[00m";
                else
                    champBataille[i][j]= "O";

            }

        }
        //****************************************************************

        menu.afficherChampBataille(champBataille);

    }


    public ContreTorpilleur getContreTorpilleur() {
        return contreTorpilleur;
    }

    public Torpilleur getTorpilleur() {
        return torpilleur;
    }

    public SousMarin getSousMarin() {
        return sousMarin;
    }

    public Croiseur getCroiseur() {
        return croiseur;
    }

    public PorteAvion getPorteAvion() {
        return porteAvion;
    }
}