/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HillClimbing;

import Utilidades.ResultadoFuncion;
import funciones.Funcion;
import funciones.Individuo;
import java.util.Arrays;

/**
 *
 * @author Danilo
 */
public class SAHillClimbingR extends HillClimbingAbstract{
        
    private Individuo s;
    private Individuo r;
    private Individuo w;
    private Individuo best;    
    private int numAjustes ;

    public SAHillClimbingR(Funcion function) {
        super(function);        
        this.s = null;
        this.r = null;
        this.w = null;
        this.best = null;
    }   
    
    @Override
    public ResultadoFuncion inicio(Individuo aleatorio, int EFOs){
        int iteracion = -1;
        s = aleatorio;
        best = s;        
        do{            
            r = aleatorio.tweak(s, super.getFunction().getMin(), super.getFunction().getMax());
            //System.out.println("s: " + Arrays.toString(s.getCromosoma()) + "     r: " + Arrays.toString(r.getCromosoma()));
            for (int i = 0; i < numAjustes; i++) {               
               w = aleatorio.tweak(s, super.getFunction().getMin(), super.getFunction().getMax());
               if(w.getFitness() < r.getFitness()) 
                   r = w;
            }
            s = r;
            if (s.getFitness() < best.getFitness()) 
                best = super.getFunction().copy(s);
            iteracion++;
        }while(super.getFunction().validateIdealSolution(best) && iteracion < EFOs);
        return new ResultadoFuncion( best ,iteracion);
    }        
    
    @Override
    public String getNonmbreFuncion() {
        return super.getFunction().getNombreFuncion();
    }
    
    public int getNumAjustes() {
        return numAjustes;
    }

    public void setNumAjustes(int numAjustes) {
        this.numAjustes = numAjustes;
    }
}
