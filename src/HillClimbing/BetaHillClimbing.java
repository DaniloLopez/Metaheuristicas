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
public class BetaHillClimbing extends HillClimbingAbstract {
    
    private Individuo x; 
    private Individuo xi; 
    private double beta;
    private double bw;
    
    Aleatorio ut = new Aleatorio();

    public BetaHillClimbing(Funcion function, double beta, double bw) {
        super(function);
        this.beta = beta;
        this.bw = bw;
    }
    
    
      
    @Override
    public ResultadoFuncion inicio(Individuo individuo, int EFOs) {
        double min = super.getFunction().getMin();
        double max = super.getFunction().getMax();
        x = individuo;
        int itr = 0;        
        while(super.getFunction().validateIdealSolution(x) && itr < EFOs ){
            xi = inprove(individuo);
            Double[] cromosoma = xi.getCromosoma();
            for (int i = 0; i < individuo.getCromosoma().length; i++) {                                
                if(Math.random() <= beta){
                    cromosoma[i] = min + (max - min) * Math.random();
                }
            }            
            if(xi.getFitness() < x.getFitness()){
                x = xi;
            }
            itr++;
        }                               
        return new ResultadoFuncion(x , itr);
    }   
    
    private Individuo inprove(Individuo individuo) {
        int dim = individuo.getCromosoma().length;
        Double[] cro = individuo.getCromosoma().clone();
        int i = (int) (0 + (dim - 0) * Math.random());        
        double nuevo = cro[i] + (Math.random() * dim)  + bw;
        //metodo para controlar que los valores no superen las fronteras
        cro[i] = controlarFronteras(individuo, nuevo);
        
        //individuo.setCromosoma(cro);
        return new Individuo(cro, super.getFunction(), individuo.getProbabilitiAddNoise(), individuo.getHalfRangeNoise(), individuo.getPaso());
    }
            
    
    /**
     * controlar que los valores aleatorios no sobrepasen los valores frontera, se controla con tecnica de espejo
     * @param individuo individuo que posee el cromosoma
     * @param nuevo numero aleatorio
     * @return numero aleatorio modificado dentro del rango de valores de cada funcion
     */
    private Double controlarFronteras(Individuo individuo, double nuevo) {
        double min = individuo.getFuncion().getMin();        
        if(nuevo < min){
            nuevo = nuevo - min;
            return min + Math.abs(nuevo);
        }
        else{
            double max = individuo.getFuncion().getMax();
            if(nuevo > max){
                nuevo = nuevo - max;
                return max - nuevo;
            }
        }        
        return nuevo;
    }
    
    
    @Override
    public String getNonmbreFuncion() {
        return super.getFunction().getNombreFuncion();
    }       
}
