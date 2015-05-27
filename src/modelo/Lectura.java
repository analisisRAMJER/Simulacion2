/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import javax.imageio.stream.FileImageInputStream;
//import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode


/**
 *
 * @author TOSHIBA
 */
public class Lectura {

    private String pagina = "";
    private boolean encontro=true;
    private String ruta;

    public Lectura() {
    }
    public Lectura(String ruta){
        this.ruta=ruta;
    }

    
    
   

    public String[] Leer() {

        int caracter;
        String text = "";
        

        try {
            InputStreamReader archivoOrigen = new InputStreamReader(new FileInputStream(ruta));

            try {
                while ((caracter = archivoOrigen.read()) != -1) {
                    text += (char) caracter;
                }
                archivoOrigen.close();
            } catch (IOException e) {
//                javax.swing.JOptionPane.showMessageDialog(null,
//                        "Fallo al leer del archivo.\n" + e.toString(),
//                        "Error en archivo",
//                        javax.swing.JOptionPane.ERROR_MESSAGE);
                System.out.println( "Fallo al leer del archivo.\n" + e.toString()
                        +"Error en archivo"+javax.swing.JOptionPane.ERROR_MESSAGE);
               
            }
        } catch (FileNotFoundException e) {
            
            System.out.println("Fallo al tratar de abrir el archivo.\n" + e.toString()+
                    "Error en archivo"+
                    javax.swing.JOptionPane.ERROR_MESSAGE);
             encontro=false;
        }
        setPagina(text);
        return dividir();
        
    }

    public String[] dividir() {
        int cont = 0;

        String[] split = getPagina().split(" ");

        return split;
    }

    private void setPagina(String text) {
        pagina = text;
    }

    /**
     * @return the pagina
     */
    public String getPagina() {
        return pagina;
    }

    /**
     * @return the encontro
     */
    public boolean isEncontro() {
        return encontro;
    }

    /**
     * @param encontro the encontro to set
     */
    public void setEncontro(boolean encontro) {
        this.encontro = encontro;
    }

}
