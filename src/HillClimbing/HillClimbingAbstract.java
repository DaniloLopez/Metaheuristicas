/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HillClimbing;

import Utilidades.ResultadoFuncion;
import funciones.Funcion;
import funciones.Individuo;

/**
 *
 * @author Danilo
 */
public abstract class HillClimbingAbstract {       

    private Funcion function;

    public HillClimbingAbstract(Funcion function) {
        this.function = function;
    }        
    
    /**
     * inicio hill climbing steeppest ascent y steeppest ascent with replacement
     * @param individuo individuo con el que realizara las operaciones de modificar individuo
     * @param EFOs numero de veces que se realiza la exploracion
     * @return 
     */
    public abstract ResultadoFuncion inicio(Individuo individuo, int EFOs);
    
    /**
     * retorna el nombre de la funcion que se esta evaluando
     * @return nombre de la funcion
     */
    public abstract String getNonmbreFuncion();

    public Funcion getFunction() {
        return function;
    }

    public void setFunction(Funcion function) {
        this.function = function;
    }
    
    
}



