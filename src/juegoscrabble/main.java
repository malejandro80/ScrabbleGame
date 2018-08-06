/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoscrabble;

import java.util.Scanner;
import  javax.swing.JOptionPane;

/**
 *
 * @author miguel
 */
public class main {

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Jugador miguel = new Jugador();
    
        Tablero scrabble = new Tablero(10,10);

        for (int i = 1; i <= 5; i++) {
            System.out.println("estas son sus fichas:" + "\n");
            miguel.generar_letras();
            System.out.println(miguel.mostrar_piezas()+ "\n");
            
            int c=JOptionPane.showConfirmDialog(null, "¿Quieres cambiar de fichas?", "Scrabble", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (c==JOptionPane.YES_OPTION) {
               i--;     
            }
            else{
                String palabra = JOptionPane.showInputDialog(null,"ingresa la palabra numero "+i);
                int fila = Integer.parseInt(JOptionPane.showInputDialog(null, "ingresa la fila de la primera letra de la palabra"));
                int col = Integer.parseInt(JOptionPane.showInputDialog(null, "ingresa la columna de la primera letra de la palabra"));    
                int ori=JOptionPane.showConfirmDialog(null, "¿vas escribir la palabra horizontalmente?", "Scrabble", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                boolean resp = false;
                if (ori==JOptionPane.YES_OPTION) {
                    resp = true;  
                }
           
                
                if(miguel.logica_de_juego(fila, col, palabra, resp, i, scrabble)){
                    miguel.escribir(fila, col, palabra, resp, scrabble);
                    System.out.println(scrabble);
                }
                else{
                    
                    JOptionPane.showMessageDialog(null,"hay algun problema con la palabra que escribio, por favor intente nuevamente");
                    i--;
                }                  
            }
        }
        JOptionPane.showMessageDialog(null,"fin del juego, su puntuacion fue de: "+ miguel.puntuacion(scrabble));
        
            
        
    
    
    }
    
}
