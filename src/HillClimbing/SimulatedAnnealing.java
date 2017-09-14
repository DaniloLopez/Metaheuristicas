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
public class SimulatedAnnealing extends HillClimbingAbstract{
    
    double t ;
    Individuo s;
    Individuo r;
    Individuo best;

    public SimulatedAnnealing(Funcion function, double temp) {
        super(function);
        this.t = temp;
        this.s = null;
        this.r = null;
        this.best = null;
    }
    
    
    
    @Override
    public ResultadoFuncion inicio(Individuo individuo, int EFOs) {
        int iteracion = -1;
        s = individuo;
        best = super.getFunction().copy(s);
        do{
            r = individuo.tweak(s, super.getFunction().getMin(), super.getFunction().getMax());
            boolean esEulerMayor = Math.random() < Math.pow(Math.E, (r.getFitness()-s.getFitness())/t);
            if(r.getFitness() < s.getFitness() || esEulerMayor){
                s = r;                
            }
            decreaseT(t);
            if(s.getFitness() < best.getFitness()){
                best = super.getFunction().copy(s);
            }               
            iteracion++;
        }while(super.getFunction().validateIdealSolution(best) && t > 0 && iteracion < EFOs);
        return new ResultadoFuncion(best,iteracion);
    }
    
    public double decreaseT (double t){
        return t--;
    }
    
    
    @Override
    public String getNonmbreFuncion() {
        return super.getFunction().getNombreFuncion();
    }
}
