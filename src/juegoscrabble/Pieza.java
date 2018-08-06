/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoscrabble;

/**
 *
 * @author miguel
 */
public class Pieza {

     private int filas, columnas;
    private String letra;
   

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
    
    
    
    public Pieza(int f, int c, String l){
        filas = f;
        columnas = c;
        letra = l;
}
    @Override
    public String toString(){
        return String.valueOf(letra);
    }
}
