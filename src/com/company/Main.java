package com.company;

public class Main {

    static int[][] boardEasy = {
            {4, 0, 0, 1, 0, 2, 6, 8, 0},
            {1, 0, 4, 0, 9, 0, 0, 0, 4},
            {0, 3, 8, 0, 6, 4, 0, 1, 0},
            {0, 0, 5, 0, 7, 1, 9, 2, 0},
            {0, 2, 6, 0, 0, 9, 8, 0, 0},
            {8, 0, 0, 2, 5, 0, 0, 0, 0},
            {9, 0, 3, 0, 0, 0, 0, 0, 8},
            {2, 5, 0, 6, 0, 0, 1, 0, 7},
            {6, 0, 7, 9, 0, 5, 3, 0, 0}
    };

    static int[][] boardMedium = {
            {0, 7, 0, 3, 4, 0, 2, 0, 6},
            {9, 0, 0, 7, 0, 6, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 7, 9, 8, 6, 0},
            {0, 0, 0, 0, 0, 2, 3, 0, 4},
            {4, 0, 7, 5, 0, 8, 0, 0, 0},
            {0, 0, 0, 9, 0, 0, 0, 0, 0},
            {0, 0, 6, 0, 0, 0, 0, 1, 7},
            {5, 1, 0, 0, 8, 0, 4, 0, 2}
    };

    static int[][] boardHard = {
            {0, 0, 0, 0, 0, 0, 9, 4, 0},
            {6, 0, 0, 0, 0, 0, 2, 7, 0},
            {8, 2, 0, 0, 4, 9, 6, 0, 0},
            {0, 7, 4, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 7, 6, 0, 0, 0, 0},
            {0, 6, 2, 0, 0, 5, 0, 8, 0},
            {0, 0, 0, 0, 5, 7, 0, 2, 3},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {7, 5, 3, 2, 0, 4, 0, 0, 0}
    };

    static int[][] boardGodLike = {
            {0, 0, 0, 6, 0, 2, 8, 0, 4},
            {0, 0, 0, 0, 3, 0, 0, 0, 7},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {4, 0, 6, 0, 5, 0, 3, 0, 0},
            {2, 0, 8, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 9, 1, 0},
            {1, 0, 0, 0, 0, 0, 2, 0, 0},
            {0, 7, 0, 9, 0, 0, 0, 5, 0},
            {0, 0, 2, 4, 0, 0, 0, 0, 8}
    };

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
    public static boolean Section (int [][]tab , int section){
    //On test tous les nombres de 1 à 9
        for (int num = 1; num < 10; num++ ){
            int conter = 0;
            //
            for (int i=0; i<3;i ++){
                for (int j=0; j<3; j++){
                    if (num == tab[i][j]){
                        conter ++;
                    }
                    if (conter >1){
                        return false;
                    }
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
<<<<<<< HEAD
        //afficherGrille(boardEasy);
        System.out.println("Les règles sont resperctées pour la ligne : " + ligneIsTrue(boardEasy, 0));
        System.out.println("Les règles sont resperctées pour la colonne : " + colonneIsTrue(boardEasy, 0));
        System.out.println("Les règles sont resperctées pour la section :" + sectionIsTrue(boardEasy));
=======

        afficherGrille(boardEasy);
        System.out.println();
        System.out.println("Les règles sont respectés a l'horizontale: " + ligneIsTrue(boardEasy, 0));
        System.out.println();
        System.out.println("Les règles sont respectés a la verticale: " + colonneIsTrue(boardEasy, 0));
        System.out.println("les règles sont respectés pour la section: " + Section(boardEasy,0));
>>>>>>> 2f554e31c1fc3e323b8afee2548bda3252efa8b2
    }
}
