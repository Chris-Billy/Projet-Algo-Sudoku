package com.company;

public class Main {

    static int[][] boardEasy = {
            {4, 0, 0, 1, 0, 2, 6, 8, 0},
            {1, 0, 0, 0, 9, 0, 0, 0, 4},
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

    public static void afficherGrille (int [][] tab){
        int value = 0;
        for (int ligne = 0; ligne < tab.length; ligne++){
            for (int colonne = 0; colonne < tab[ligne].length; colonne++){
                value = tab[ligne][colonne];
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        afficherGrille(boardEasy);
        System.out.println();
        afficherGrille(boardMedium);
    }
}
