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
public class Jugador{
    
    private String piezas[] = new String[7];

    public String[] getPiezas() {
        return piezas;
    }

    public void setPiezas(String[] piezas) {
        this.piezas = piezas;
    }
    
    
    
    public char[] generar_letras(){
        char matriz[] = new char[7];
        int num1 = 97;
        int num2 = 122;
            for (int i=0; i<7; i++){
                int numAleatorio = (int)Math.floor(Math.random()*(num2 -num1)+num1);
			//para transformar los números en letras según ACSII
			
		piezas[i]=String.valueOf((char)numAleatorio);
            }
       return matriz; 
    }

    public String mostrar_piezas(){
        String resp ="";
        for (int j = 0; j < 7; j++) {
                resp = resp + piezas[j] + "\t";
            }
        return resp;
    }
    
    public void escribir(int f, int c,String a, boolean horizontal, Tablero obj){       
        String[] vect = a.split("");
        
        if (horizontal) {
                for (int j = 0; j < vect.length; j++) {          
                    obj.getTabla()[f-1][j+c-1].setLetra(vect[j]);
                }

        }
        else{
            for (int j = 0; j < vect.length; j++){                 
                obj.getTabla()[j+f-1][c-1].setLetra(vect[j]);
            }       
        }                   
    }
   
    
    public boolean fuera_de_tabla(int f, int c, String a, boolean horizontal, Tablero obj){
        String[] vect = a.split("");
        boolean resp = false;
            if (horizontal) {
                if (vect.length > obj.getTabla().length-(c-1)) {
                    resp = true;
                }
            }
            else{
                if (vect.length > obj.getTabla()[0].length-(f-1)) {
                    resp = true;
                }
            }
        return resp;
    }
    
    public boolean comprobar_juego_cruzado(int f, int c, String a, boolean horizontal, Tablero obj){
        String[] vect = a.trim().split("");
        boolean resp = false;
            if (horizontal) {
                for (int j = 0; j < vect.length && !resp; j++) {
                    if(!obj.getTabla()[f-1][j+c-1].getLetra().equals(".")){                     
                        resp = true;          
                    }
                }

        }
        else{
            for (int j = 0; j < vect.length && !resp; j++) {
                    if(!obj.getTabla()[j+f-1][c-1].getLetra().equals(".")){
                        resp = true;
                    }
                }
        }            
        return resp;
        
    }
    
    public int puntuacion(Tablero obj){
        int puntaje = 0;
        for (int i = 0; i < obj.getTabla().length; i++) {
            for (int j = 0; j < obj.getTabla()[0].length; j++) {
                switch (obj.getTabla()[i][j].getLetra()) {

                    case "a": 
                    case "e":
                    case "o":
                    case "s":
                    case "i":
                    case "u":
                    case "n":
                    case "l":
                    case "r":
                    case "t":
                                puntaje += 1;
                    break;

                    case "c": 
                    case "d":
                    case "g":

                                puntaje += 2;
                    break;

                    case "m": 
                    case "b":
                    case "p":

                                puntaje += 3;
                    break;

                    case "f": 
                    case "h":
                    case "v":
                    case "y": 
                                puntaje += 4;
                    break;

                    case "j":
                                puntaje += 6;
                    break;

                    case "k": 
                    case "ñ":
                    case "w":
                    case "x": 
                                puntaje += 8;
                    break;

                    case "z":
                                puntaje += 6;
                    break;

                    default: puntaje += 0;
                }
            }
            
        }
        return puntaje;
    } 
    
    public boolean comprobar_palabra_en_fichas(int f, int c, String pal, boolean horizontal, Tablero obj){ 
        boolean resp = true;
        boolean resp1;
        String[] vect = pal.split("");    
        for (int i = 0; i < vect.length && resp == true; i++) {
            resp1 = false;
            for (int j = 0; j < this.piezas.length && resp1 == false; j++) {
                if (vect[i].equals(this.piezas[j])) {
                     this.piezas[j] = "";
                     resp1 = true;                
                }
                else{
                    if(horizontal && obj.getTabla()[f-1][i+c-1].getLetra().equals(vect[i]) ){
                        resp1 = true;
                       
                    }
                    else if(!horizontal && obj.getTabla()[i+f-1][c-1].getLetra().equals(vect[i]) ){
                        resp1 = true;
                    }
                }
                  
            }
            if(resp1 == false){
                resp = false;
            }
        }     
        return resp;
    }
    
    public boolean logica_de_juego(int f, int c, String pal, boolean horizontal, int turno, Tablero obj){
      
        boolean resp = false;
        
        if(turno == 1 && comprobar_palabra_en_fichas(f, c, pal, horizontal, obj) && !fuera_de_tabla(f, c, pal, horizontal, obj)){
            resp =true;
        }
        else if(turno >1 && comprobar_juego_cruzado(f, c, pal, horizontal, obj) && comprobar_palabra_en_fichas(f, c, pal, horizontal, obj) && !fuera_de_tabla(f, c, pal, horizontal, obj)){        
            resp = true;
        }
        return resp;
    }
      
    
}
