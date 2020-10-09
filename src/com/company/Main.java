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

    public static boolean sectionIsTrue (int[][] tab, int startLigne, int startColonne){
        int nbElem = 3;
        // On test tous les nombres de 1 à 9
        for (int num = 1; num < 10; num++){
            int counter = 0;
            // On test tous les indices d'une ligne
            for (int i = startLigne; i < startLigne + nbElem; i++){
                // On test tous les indices d'une colonne
                for (int j = startColonne; j < startColonne + nbElem; j++){
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

    public static boolean allSectionIsTrue (int [][] tab){
        // On test toutes les sections par ligne
        for (int starLigne = 0; starLigne < 7; starLigne = starLigne + 3){
            // On test toutes les sections par colonne
            for (int startColonne = 0; startColonne < 7; startColonne = startColonne + 3){
                if (sectionIsTrue(tab, starLigne, startColonne) == true){
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return  true;
    }

    public static boolean grilleIsTrue (int[][] tab){
        for (int i = 0; i < 9; i++) {
            if (ligneIsTrue(tab, i) != true || colonneIsTrue(tab, i) != true || allSectionIsTrue(tab) != true) {
                return false;
            }
        }
        return true;
    }

    public static boolean grilleComplete(int [][] tab, int position){
        // Si le tableau est remplis return vrai
        if (position == 9 * 9){
            return true;
        }
        int a = position / 9;
        int b = position % 9;
        // S'il y a déjà un numéro on passe à la case suivante
        if (tab[a][b] != 0){
            return grilleComplete(tab, position + 1);
        }
        // On test toutes les  lignes
        for (int ligne = a; ligne < 9; ligne = ligne++) {
            // On test toutes les colonnes
            for (int colonne = b; colonne < 9; colonne = colonne++) {
                // On test tous les numéros de 1 à 9
                for (int num = 1; num < 10; num++){
                    // On place le chiffre dans le tableau
                    tab[a][b] = num;
                    // On vérifie que la grille est toujours bonne
                    if (grilleIsTrue(tab)){
                        // Si la grille est complète retourne vrai
                        if (grilleComplete(tab, position + 1)){
                            return true;
                        }
                    }
                }
                // Retour en arrière
                tab[a][b] = 0;
                return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println("Grille AVANT");
        afficherGrille(Boards.boardGodLike);
        System.out.println();
        grilleComplete(Boards.boardGodLike, 0);
        System.out.println("Grille APRES");
        afficherGrille(Boards.boardGodLike);


        //afficherGrille(Boards.boardEasy);
        /*
        System.out.println();
        System.out.println("Les règles sont respectées a l'horizontale : " + ligneIsTrue(Boards.boardEasy, 0));
        System.out.println();
        System.out.println("Les règles sont respectées a la verticale : " + colonneIsTrue(Boards.boardEasy, 0));
        System.out.println();
        System.out.println("les règles sont respectés pour la section : " + sectionIsTrue(Boards.boardEasy, 0, 0));
        System.out.println();
        System.out.println("les règles sont respectés pour toutes les sections : " + allSectionIsTrue(Boards.boardEasy));
        System.out.println();
        System.out.println("La grille complete est valide : " + grilleIsTrue(Boards.boardEasy));
         */
    }
}
