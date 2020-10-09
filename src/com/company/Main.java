package com.company;

public class Main {

    /**
     * Affiche la grille de Sudoku
     * @param tab un tableau d'entier à plusieurs dimensions
     */
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

    /**
     * Vérifie qu'un chiffre n'est pas présent plusieurs fois dans la ligne
     * @param tab un tableau d'entier à plusieurs dimensions
     * @param ligne indice de la ligne qui est testé
     * @return Vrai si la ligne n'a pas de doublons, sinon Faux
     */
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

    /**
     * Vérifie qu'un chiffre n'est pas présent plusieurs fois dans la colonne
     * @param tab un tableau d'entier à plusieurs dimensions
     * @param colonne indice de la colonne qui est testé
     * @return Vrai si la colonne n'a pas de doublons, sinon Faux
     */
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

    /**
     * Vérifie qu'un chiffre n'est pas présent plusieurs fois dans une section
     * @param tab un tableau d'entier à plusieurs dimensions
     * @param startLigne indice de départ des lignes
     * @param startColonne indice de départ des colonnes
     * @return Vrai si la section n'a pas de doublons, sinon Faux
     */
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

    /**
     * Vérifie qu'un chiffre n'est pas présent plusieurs fois dans toutes les sections
     * @param tab un tableau d'entier à plusieurs dimensions
     * @return Vrai si toutes les sections n'ont pas de doublons, sinon Faux
     */
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

    /**
     * Vérifie que toute la grille ne comporte pas de doublons
     * @param tab un tableau d'entier à plusieurs dimensions
     * @return Vrai s'il n'y a aucun doublons dans la grille, sinon Faux
     */
    public static boolean grilleIsTrue (int[][] tab){
        for (int i = 0; i < 9; i++) {
            if (ligneIsTrue(tab, i) != true || colonneIsTrue(tab, i) != true || allSectionIsTrue(tab) != true) {
                return false;
            }
        }
        return true;
    }

    /**
     * Rempli une grille de Sudoku entièrement
     * @param tab un tableau d'entier à plusieurs dimensions
     * @param position indice de la position de départ
     * @return Vrai si le tableau ne comporte pas d'erreur, sinon Faux
     */
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
                    essai++;
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

    /**
     * Variable calculant le nombre de combinaisons qui ont été testées pour résoudre la grille
     */
    static int essai=0;

    public static void main(String[] args) {

        System.out.println("Grille AVANT");
        afficherGrille(Boards.boardEasy);
        System.out.println();
        long debut = System.currentTimeMillis();
        grilleComplete(Boards.boardEasy, 0);
        long fin = System.currentTimeMillis();
        long temps = (fin - debut);
        System.out.println("Grille APRES");
        afficherGrille(Boards.boardEasy);
        System.out.println("Le nombre de combinaisons testées pour cette grille a été de : " + essai);
        System.out.println();
        System.out.println(temps);
    }
}
