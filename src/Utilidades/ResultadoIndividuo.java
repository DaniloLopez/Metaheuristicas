/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import funciones.Individuo;

/**
 *
 * @author Danilo
 */
public class ResultadoIndividuo {
    
    private String funcion;    
    private String algoritmo;
    private double iteracion;        
    private double tiempo;
    private Individuo indviduo;

    public ResultadoIndividuo(String funcion, String algoritmo, double iteracion, double tiempoPromedio, Individuo indviduo) {
        this.funcion = funcion;
        this.algoritmo = algoritmo;
        this.iteracion = iteracion;
        this.tiempo = tiempoPromedio;
        this.indviduo = indviduo;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public double getIteracion() {
        return iteracion;
    }

    public void setIteracion(double iteracion) {
        this.iteracion = iteracion;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public Individuo getIndviduo() {
        return indviduo;
    }

    public void setIndviduo(Individuo indviduo) {
        this.indviduo = indviduo;
    }
    
    
    
    
}
