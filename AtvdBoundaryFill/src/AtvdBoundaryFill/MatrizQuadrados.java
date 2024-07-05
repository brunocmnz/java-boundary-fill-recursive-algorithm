/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtvdBoundaryFill;

import javax.swing.JFrame;

/**
 *
 * @author bruno
 */
public class MatrizQuadrados extends JFrame {
    
    int opcao;

    public MatrizQuadrados(int opcao) {
        this.opcao = opcao;
        initiGui();
    }

    private void initiGui() {
        //Alterando titulo
        this.setTitle("Boundary Fill");
        //Tamanho em pixels altura e largura
        setSize(850, 550);
        //Janela aparecer no meio
        setLocationRelativeTo(null);
        //terminar a aplicacao ao fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Desenho desenho; 
        if (opcao == 1) {
            desenho = new Desenho();
        }else{
            desenho = Desenho.getInstance();
        }
        this.add(desenho);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Tornar a janela visivel
        setVisible(true);
        setAlwaysOnTop(true);
    }

}
