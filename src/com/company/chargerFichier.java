package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class chargerFichier {
    static int[][] charger(){
        int[][] tab = new int[9][9];

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("tableau.txt"));
            // Lire la ligne
            String line = reader.readLine();
            int j = 0;
            while (line != null){
                //System.out.println("line " + j + " = " + line);
                // 1. séparer les chiffres
                String[] array= line.split("\\ ");
                for(int i = 0; i < tab.length; i++){
                    int a = Integer.parseInt(array[i]);
                    tab[j][i] = a;
                    //System.out.print(a + " ");
                }
                //System.out.println();
                // read next line
                line = reader.readLine();
                j++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tab;
    }
}
