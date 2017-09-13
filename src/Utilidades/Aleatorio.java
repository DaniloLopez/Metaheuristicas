package Utilidades;

import funciones.Individuo;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Danilo
 */
public class Aleatorio {
    
    public Aleatorio(){
        
    }
    
    /**
     * funcion para calcular un vector de numero aleatorios
     * @param semilla indica la semilla para comenzr
     * @param min valor minimo del rango
     * @param max valor maximo del rango
     * @param cantidad
     * @return numero aleatorio entre min y max
     */    
    public Double[] vectorAleatorioDecimal(int semilla, double min, double max, int cantidad){                
        ArrayList<Double> vec = new ArrayList<>();   
        // Constructor pasadole una semilla
        Random numAleatorio = new Random(semilla);
        //ciclo desde cero hasta cantidad-1
        for (int i = 0; i < cantidad; i++) {                        
            // Numero real aleatorio entre min y max
            vec.add(numAleatorio.nextDouble()*(max - min) + min);           
        }                        
        return  vec.toArray(new Double[cantidad]);
    }
    
    public double numberRandomByGaussian(){
        double u = 0;
        double o = 0;
        double x = 0, y = 0, w = 0;
        
        do{
            x = Math.random();
            y = Math.random();
            w = (x*x) + (y*y);
        }while(0 < w || w < 1);
        
        double g = u + x*o*(Math.sqrt(-2*((Math.log(w))/w)));
        double h = u + y*o*(Math.sqrt(-2*((Math.log(w))/w)));
        
        return g;                
    }
    
    
    /**
     * perturba un valor dependiendo del radio del individuo
     * @param i
     * @return 
     */
    public double random(Individuo i){
        //encontrar distancia entre -r y r
        double distancia = 2*i.getHalfRangeNoise();
        //encontrar aleatorio etre -r y r
        double al = Math.random()*distancia - i.getHalfRangeNoise();
        return al;
    }
    
    
    /**
     * funcion para calcular un numero entero aleatorio entre un rango de valores
     * @param semilla
     * @param min valor minimo del rango
     * @param max valor maximo del rango
     * @return numero aleatorio entre min y max
     */    
    public int IntegerRandom(int semilla, int min, int max){
        // Constructor pasadole una semilla
        Random numAleatorio = new Random(semilla);
        // Numero entero entre min y max
        int al = numAleatorio.nextInt(max-min) + min;                                                
        return (int) (Math.random()*max + min);
    }
    
    
    /*
    for (int i = 0; i < 100; i++) {
            //nuero aleatorio entre -100 y 100
            System.out.println((Math.random()*200) - 100);    
        }              
    */
    
}
