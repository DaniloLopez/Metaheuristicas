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
public class Griewank extends Funcion{
    
    private double minEsperado = 0.1;
    private Double valorminimoEsperado = 0.1;

    public Griewank(int min, int max) {
        super(min, max, "griewank");
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
        double sum = 0;
        double prod = 0;
        int tam = s.getCromosoma().length;
        for (int i= 0; i< tam; i++) {
            double crom  = s.getCromosoma()[i];
            sum = sum + Math.pow(crom, 2)/4000;
            prod = prod * Math.cos(crom / Math.sqrt(i));
        }
        
        return (sum - prod + 1);
    }

    
    
}
