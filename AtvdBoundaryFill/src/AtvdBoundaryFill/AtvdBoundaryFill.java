/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtvdBoundaryFill;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class AtvdBoundaryFill {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja escolher a posicao de inicio de entrada para colorir?");
        System.out.println("Caso não quiser, a posição padrão é (h/2, w/2)");
        System.out.print("Insira 1 caso queira inserir valores: ");
        int opcao = 1;// sc.nextInt();
        MatrizQuadrados mq = new MatrizQuadrados(opcao);

        
//        Scanner sc = new Scanner(System.in);
//        int[][] m = new int[7][10];
//        preencheMatriz(m);
//        imprimeMatriz(m);
//        System.out.println("Insira as coordenadas:");
//        System.out.print("i: ");
//        int i = sc.nextInt();
//        System.out.print("j: ");
//        int j = sc.nextInt();
//        System.out.print("Insira cAnt: ");
//        int cAnt = sc.nextInt();
//        System.out.print("Insira C: ");
//        int c = sc.nextInt();
//        alteraMatriz(i, j, c, cAnt, m);
//        imprimeMatriz(m);
    }

    public static void preencheMatriz(int[][] m) {
        Random rdm = new Random();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                int n = rdm.nextInt(3);
                m[i][j] = n * 1000 + n * 100 + n * 10 + n;
            }
        }
    }

    public static void imprimeMatriz(int[][] m) {
        for (int i = 0; i < m[0].length; i++) {
            System.out.print("\t" + i);
        }
        System.out.println("");
        for (int i = 0; i < m.length; i++) { 
            System.out.print(i + "\t[");
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j]);
                if (j < m[i].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("]");
        }
    }

    public static void alteraMatriz(int i, int j, int c, int cAnt, int[][] m) {
        if (m[i][j] == cAnt) {
            m[i][j] = c;
            if (j - 1 >= 0) {
                alteraMatriz(i, j - 1, c, cAnt, m);
            }
            if (i - 1 >= 0) {
                alteraMatriz(i - 1, j, c, cAnt, m);
            }
            if (j + 1 < m[0].length) {
                alteraMatriz(i, j + 1, c, cAnt, m);
            }
            if (i + 1 < m.length) {
                alteraMatriz(i + 1, j, c, cAnt, m);
            }
        }
    }

}
