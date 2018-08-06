package juegoscrabble;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
public class Tablero {
     private int fil, col;
    private Pieza tabla[][];

    public int getFil() {
        return fil;
    }

    public void setFil(int fil) {
        this.fil = fil;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Pieza[][] getTabla() {
        return tabla;
    }

    public void setTabla(Pieza[][] tabla) {
        this.tabla = tabla;
    }
    
    
    
    
    public Tablero(int f_tabla,int c_tabla){
        this.fil=f_tabla;
        this.col = c_tabla;
        tabla = new Pieza[f_tabla][c_tabla];
        for (int i = 0; i < f_tabla; i++) {
            for (int j = 0; j < c_tabla; j++) {
                tabla[i][j] = new Pieza(i,j,".");
            }     
        }
    }
    @Override
    public String toString(){
        String resp = "";
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                resp = resp + tabla[i][j].toString() + "\t";
            }
            resp = resp + "\n" + "\n";
        }
        return resp;
    }
    
    
}
