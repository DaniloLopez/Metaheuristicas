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
public class Schwefel extends Funcion{

    private double minEsperado = 0.1;
    private Double valorminimoEsperado = 0.1;
    double radio;
    
    public Schwefel(int min, int max) {
        super(min, max, "schwefel");
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
            for (int i = 0; i < datos.length; i++) {
                if( (i + 1) == datos.length){
                    //f(x) = x^2 + (x)^2
                    suma += (datos[i]*datos[i]) + (datos[i]*datos[i]);
                }else{
                    //f(x) = x^2 + (x+y)^2
                    suma += (datos[i]*datos[i]) + (datos[i] + datos[i+1])*(datos[i] + datos[i+1]);
                }                
            }            
            return suma;
        }catch(NullPointerException e){
            System.out.println("error calculando fitnes");
        }
        return 0;
    }
    
}
