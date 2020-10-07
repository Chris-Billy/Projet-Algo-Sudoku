package com.company;

public class Main {

    public static void afficherGrille (int[][] tab){
        int value = 0;
        for (int ligne = 0; ligne < tab.length; ligne++){
            // On test tous les indices d'une ligne
            for (int colonne = 0; colonne < tab[ligne].length; colonne++){
                // On test tous les indices d'une colonne
                value = tab[ligne][colonne];
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static boolean ligneIsTrue (int[][] tab,int ligne){
        // On test tous les nombres de 1 à 9
        for (int i = 1; i < 10; i++){
            // On test tous les indices d'une ligne
            int conter = 0;
            for (int colonne = 0; colonne < tab.length; colonne++){
                if (i == tab[ligne][colonne]){
                    conter++;
                }
                if (conter > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean colonneIsTrue (int[][] tab,int colonne){
        // On test tous les nombres de 1 à 9
        for (int i = 1; i < 10; i++){
            // On test tous les indices d'une colonne
            int counter = 0;
            for (int ligne = 0; ligne < tab.length; ligne++){
                if (i == tab[ligne][colonne]){
                    counter++;
                }
                if (counter > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sectionIsTrue (int[][] tab){
        // On test tous les nombres de 1 à 9
        for (int num = 1; num < 10; num++){
            int counter = 0;
            // On test tous les indices d'une ligne
            for (int i = 0; i < 3; i++){
                // On test tous les indices d'une colonne
                for (int j = 0; j < 3; j++){
                    if (num == tab[i][j]){
                        counter++;
                    }
                    if (counter > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        //afficherGrille(Boards.boardEasy);
        System.out.println();
        System.out.println("Les règles sont respectés a l'horizontale: " + ligneIsTrue(Boards.boardEasy, 0));
        System.out.println();
        System.out.println("Les règles sont respectés a la verticale: " + colonneIsTrue(Boards.boardEasy, 0));
        System.out.println();
        System.out.println("les règles sont respectés pour la section: " + sectionIsTrue(Boards.boardEasy));
    }
}
