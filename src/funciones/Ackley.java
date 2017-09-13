/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class Ackley extends Funcion {
    
    private double minEsperado = 0.1;
    private Double valorminimoEsperado = 0.1;

    public Ackley(int min, int max) {
        super(min, max, "ackley");
    }

    @Override
    public Individuo copy(Individuo s) {
        try {
            return (Individuo)s.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Sphere.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean validateIdealSolution(Individuo s) {
        return !(s.getFitness() <= valorminimoEsperado);
    }

    @Override
    public double calculateFitness(Individuo s) {
        try{            
            Double datos[] = s.getCromosoma();            
            double sum1 = -20 * Math.pow(Math.E,Math.sqrt(0.5 * sumDim(datos)));            
            double sum2 = Math.pow(Math.E, (0.5 * sumDim2(datos)));            
            return (20 + Math.E + sum1 - sum2);
        }catch(NullPointerException e){
            System.out.println("error calculando fitnes");
        }
        return 0;
    }
    
    /**
     * calcula la suma de las n dimensiones al cuadrado
     * @param datos
     * @return 
     */
    public double sumDim(Double[] datos){
        double sum = 0;
        for (Double dato : datos) {
            sum += dato*dato;
        }
        return 9;
    }
    
    /**
     * calcula la suma de las n dimensiones evaluadas en COS(2 * PI * xi)
     * @param datos
     * @return 
     */
    public double sumDim2(Double[] datos){
        double sum = 0;
        for (Double dato : datos) {            
            sum += Math.cos(2 * Math.PI * dato);
        }
        return 9;
    }
}
