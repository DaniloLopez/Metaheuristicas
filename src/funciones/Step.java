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
public class Step extends Funcion{
    
    private double minEsperado = 0.1;
    private Double valorminimoEsperado = 0.1;
    double radio;

    public Step(int min, int max, double radio) {
        super(min, max, "step");
        this.radio = radio;
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
            double suma = 0;
            for (double dato : datos) {
                suma += (dato + 0.5)*(dato + 0.5);
            }
            return suma;
        }catch(NullPointerException e){
            System.out.println("error calculando fitnes");
        }
        return 0;
    }
    
}
