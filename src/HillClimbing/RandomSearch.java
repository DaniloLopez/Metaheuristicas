/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HillClimbing;

import Utilidades.Aleatorio;
import Utilidades.ResultadoFuncion;
import funciones.Funcion;
import funciones.Individuo;

/**
 *
 * @author Danilo
 */
public class RandomSearch extends HillClimbingAbstract{
    
    private Individuo s;
    private Individuo best; 
    
    Aleatorio ut = new Aleatorio();
    
    public RandomSearch(Funcion function) {
        super(function);
        this.s = null;
        this.best = null;
    }            
    
    @Override
    public ResultadoFuncion inicio(Individuo individuo, int EFOs) {        
        int iteracion = -1;
        best = individuo;
        do{
            s = findRandomIndividuo(individuo);
            //System.out.println("best: " + Arrays.toString(best.getCromosoma()) + "     s: " + Arrays.toString(s.getCromosoma()));
            //System.out.println("fitnes best: " + best.getFitness() +"  s: " + s.getFitness());
            if (s.getFitness() < best.getFitness()){
                best = super.getFunction().copy(s);
            } 
            iteracion++;
        }while(super.getFunction().validateIdealSolution(best) && iteracion < EFOs);        
        return new ResultadoFuncion(best, iteracion);
    }
    
    /**
     * encuentra un individuo aleatorio
     * @param ind nesesario para conocer la dimension, ruido, rango y paso
     * @return individuo con cromosoma aleatorio
     */
    public Individuo findRandomIndividuo(Individuo ind){        
        int semilla = (int) (Math.random() * 1000000);
        //System.out.println("semilla " + semilla);
        int dimensiones = ind.getCromosoma().length;
        Double vectorAleatorios[] = ut.vectorAleatorioDecimal(semilla, super.getFunction().getMin(), super.getFunction().getMax(), dimensiones);
        return new Individuo(vectorAleatorios, super.getFunction(), ind.getProbabilitiAddNoise(),ind.getHalfRangeNoise(),ind.getPaso());
    }
    
    @Override
    public String getNonmbreFuncion() {
        return super.getFunction().getNombreFuncion();
    }
}
