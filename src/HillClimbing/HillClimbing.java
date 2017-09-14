/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HillClimbing;

import Utilidades.ResultadoFuncion;
import funciones.Individuo;
import funciones.Funcion;

/**
 *
 * @author Danilo
 */
public class HillClimbing extends HillClimbingAbstract{
        
    private Individuo s;
    private Individuo r;          
    
    /**
     * contructor de la clase HillClimbing
     * @param function clase en donde van a estar los metodos de HillClimbingAbstract implementados          
     */        
    public HillClimbing(Funcion function) {
        super(function);
        this.s = null;
        this.r =null;
    }
    
    @Override
    /**
     * Metodo que da inicio a la busqueda mediante hill climbing.
     * El funcionamiento depende de las clases que se le envien al constructor     
     * @param aleatorio
     * @return valor maximo del tipo de TipoDato
     */
    public ResultadoFuncion inicio(Individuo individuo, int EFOs){
        int itr = -1;
        s = individuo;
        do{
            r = individuo.tweak(s, super.getFunction().getMin(), super.getFunction().getMax());            
            //System.out.println("s: " + Arrays.toString(s.getDato()) + "     r: " + Arrays.toString(r.getDato()));
            if (r.getFitness() < s.getFitness()){
                s = r;                
            }          
            itr++;
        }while(super.getFunction().validateIdealSolution(s) && itr < EFOs);
        return new ResultadoFuncion(s , itr);        
    }   

    @Override
    public String getNonmbreFuncion() {
        return super.getFunction().getNombreFuncion();
    }
        
}