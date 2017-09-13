/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class Archivo {
        
    private BufferedWriter archivoEscritura;
    private BufferedReader archivoLectura;

    /**
     * abre un buffer de lectura o de escritura para un archivo
     * @param nombre nombre del archivo que se desea manejar
     * @param escritura TRUE si se desea escribir en el archivo, FALSE si se desea leer
     */
    public void abrirArchivo(String nombre, boolean escritura){
        try {
            if (escritura)
            {                
                this.archivoEscritura = new BufferedWriter(new FileWriter(nombre,false));                
            }
            else{
                this.archivoLectura=new BufferedReader(new FileReader(nombre));
            }
        } catch (IOException ex) {
            System.out.println("Ocurrio un erro abriendo el archivo. err:" + ex.getMessage());
        }
    }

    /**
     * escribir contenido en un archivo
     * @param datos contenido que se desea escribir en el archivo
     * @param saltar indica si se coloca un salto de linea lueo de terminar de escribir en el archivo
     * 
     */
    public void escribirArchivo(String datos, boolean saltar){
        try {
            archivoEscritura.write(datos);
            //colocar el puntero en la siguiente linea(simula enter)
            if (saltar) archivoEscritura.newLine();
        } catch (IOException ex) {
            System.out.println("Ocurrio un error escribiendo en el archivo. err:" + ex.getMessage());
        }
    }	    

    /**
     * lee una linea del archivo
     * @return cadena con el contenido de la linea que se leyo
     */
    public String leerArchivo(){
        try {
            return archivoLectura.readLine();
        } catch (IOException ex) {
            System.out.println("Ocurrio un error al leer el archivo. err:" + ex.getMessage());
        }
        return "";
    }	

    /**
     * cierra el buffer de lectura o escitura del archivo
     */
    public void cerrarArchivo(){
        try {
            if(archivoEscritura!=null) archivoEscritura.close();
            if(archivoLectura!=null) archivoLectura.close();
        } catch (IOException ex) {
            System.out.println("ocurrio un erro cerrando el archivo. err:" + ex.getMessage());
        }
    }

    /**
     * indica si se puede leer el archivo
     * @return verdadero si se puede leer, falso si no se puede leer
     */
    public boolean puedeLeer(){
        try {
            return archivoLectura.ready();
        } catch (IOException ex) {
            System.out.println("ocurrio un error consultando estado del archivo. err:" + ex.getMessage());            
        }
        return false;
    }

    /**
     * lee una cantidad de palabras indicada por el usuario. el archvo debe estar abierto
     * @param cantidad cantidad de palabras que se desean leer
     * @return vector con las palabras leidas del archivo
     */
    public String[] LeerPalabras(int cantidad){
        String[] palabras= new String[cantidad];
        int i=0;        
        while(this.puedeLeer() && i< cantidad){
            palabras[i] = this.leerArchivo();
            i ++;
        }          
        return palabras;
    }
		    
    /**
     * Cuenta la cantidad de lineas que tiene el archivo
     * @param nombre nombre del archivo del cual se desean contar la cantidad de lineas
     * @return numero entero con la cantidad de lineas
     */
    public int contarLineas(String nombre)
    {
        abrirArchivo(nombre,false);
        int lineas = 0;
        while (puedeLeer()){
                leerArchivo();
                lineas++;
        }
        cerrarArchivo();
        return lineas;		
    }	
    
}
