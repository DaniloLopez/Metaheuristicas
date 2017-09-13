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
public class ResultadoFuncion {
    private Individuo resultado;
    private int iteracion;

    public ResultadoFuncion(Individuo resultado, int iteracion) {
        this.resultado = resultado;
        this.iteracion = iteracion;
    }

    public Individuo getResultado() {
        return resultado;
    }

    public void setResultado(Individuo resultado) {
        this.resultado = resultado;
    }

    public int getIteracion() {
        return iteracion;
    }

    public void setIteracion(int iteracion) {
        this.iteracion = iteracion;
    }
    
    
}
