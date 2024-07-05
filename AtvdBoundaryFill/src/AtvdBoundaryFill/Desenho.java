/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtvdBoundaryFill;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class Desenho extends Canvas {

    Quadrado[][] quadrados;
    int x0;        // x0 da posicao onde comeca a recursao
    int y0;       // y0 da posicao onde comeca a recursao
    static int h = 25;  //Altura
    static int w = 19; //Largura
    int ladoQuad = 20;
    Color[] cor = {new Color(0, 100, 0), Color.yellow, new Color(0, 0, 230)};
    int espaco = 430;
    long tEspera = 100;

    public Desenho() {
        quadrados = new Quadrado[h][w];
        this.x0 = 0;
        this.x0 = 0;
    }

    public static Desenho getInstance() {
        Desenho d = new Desenho();
        d.x0 = (h + 1)/2;
        d.y0 = (w + 1)/2;
        return d;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        DesenhaQuadrados(g);
    }

    public void preencheMatriz(String[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                StringBuilder s = new StringBuilder();
                s.append("(");
                s.append(i);
                s.append(",");
                s.append(j);
                s.append(")");
                m[i][j] = s.toString();
            }
        }
    }

    public void imprimeMatriz(Object[][] m) {
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

    private void DesenhaQuadrados(Graphics g) {
        Random rdm = new Random();
        for (int i = 0; i < quadrados.length; i++) {
            for (int j = 0; j < quadrados[0].length; j++) {
                int xq = (j) * ladoQuad;
                int yq = (i) * ladoQuad;
                quadrados[i][j] = new Quadrado(xq, yq, rdm.nextInt(2));
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Quadrado quad = quadrados[i][j];
                for (int k = 0; k < 2; k++) {
                    g.setColor(cor[quad.cor]);
                    int vx[] = {
                        quad.x,
                        quad.x,
                        quad.x + ladoQuad,
                        quad.x + ladoQuad};
                    int vy[] = {
                        quad.y,
                        quad.y + ladoQuad,
                        quad.y + ladoQuad,
                        quad.y};
                    if (k == 1) {
                        vx[0] += espaco;
                        vx[1] += espaco;
                        vx[2] += espaco;
                        vx[3] += espaco;
                    }
                    g.fillPolygon(vx, vy, 4);
                    g.setColor(Color.black);
                    g.drawPolygon(vx, vy, 4);
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        String[][] m = new String[h][w];
        preencheMatriz(m);
        imprimeMatriz(m);
        if (x0 == 0 && y0 == 0) {
            System.out.println("Insira o elemento em que deseja iniciar, com indices i e j, Ex: (a,b).");
            System.out.print("Elemento o indice \"i\" desejado: ");
            x0 = sc.nextInt();
            System.out.print("Elemento o indice \"j\" desejado: ");
            y0 = sc.nextInt();
        }else{
            System.out.println("Posicao: (" + x0 + ", " + y0 + ")");
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BoundaryFill(g, x0, y0, quadrados[x0][y0].cor, 2);
        System.out.println("TERMINEI DE COLORIR!");
    }

    private void BoundaryFill(Graphics g, int x0, int y0, int cAnt, int c) {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Desenho.class.getName()).log(Level.SEVERE, null, ex);
        }
        Quadrado quad = quadrados[x0][y0];
        if (quad.cor != c && quad.cor == cAnt) {
            try {
                Thread.sleep(tEspera);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.setColor(cor[2]);
            int vx[] = {
                quad.x + espaco,
                quad.x + espaco,
                quad.x + ladoQuad + espaco,
                quad.x + ladoQuad + espaco};
            int vy[] = {
                quad.y,
                quad.y + ladoQuad,
                quad.y + ladoQuad,
                quad.y};
            g.fillPolygon(vx, vy, 4);
            g.setColor(Color.black);
            g.drawPolygon(vx, vy, 4);
            quadrados[x0][y0].cor = 3;
            if (y0 > 0) {
                BoundaryFill(g, x0, y0 - 1, cAnt, c);
            }
            if (x0 > 0) {
                BoundaryFill(g, x0 - 1, y0, cAnt, c);
            }
            if (y0 + 1 < w) {
                BoundaryFill(g, x0, y0 + 1, cAnt, c);
            }
            if (x0 + 1 < h) {
                BoundaryFill(g, x0 + 1, y0, cAnt, c);
            }
        }
    }
}
