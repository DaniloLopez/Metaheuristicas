/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.util.Arrays;
import Utilidades.Aleatorio;

/**
 *
 * @author Danilo 
 */
public class Individuo  implements Cloneable{
    
    //varibale que almacenará el tipo de dato    
    private Double[] cromosoma;
    private double fitness;
    private Funcion funcion;    
    private double probabilitiAddNoise;
    private double halfRangeNoise;
    private double paso;
    Aleatorio random = new Aleatorio();
    
    public Individuo(Double[] cromosoma, Funcion funcion, double prob, double range, double paso) {
        this.cromosoma = cromosoma;
        this.funcion = funcion;        
        this.probabilitiAddNoise = prob;
        this.halfRangeNoise = range;        
        this.paso = paso;        
        calcularFitness();
    }   

    public Individuo(Double[] vn, Individuo d) {
        this.cromosoma = vn;
        this.funcion = d.getFuncion();
        this.probabilitiAddNoise = d.getProbabilitiAddNoise();
        this.halfRangeNoise = d.getHalfRangeNoise();
        this.paso = d.getPaso();        
        calcularFitness();
    }
    
    private void calcularFitness(){
        this.fitness = funcion.calculateFitness(this);
    }
        
    public Individuo tweak(Individuo d, double min, double max) {
        double n;
        Double vn[] = new Double[d.getCromosoma().length];
        int i = 0;
        for (Double dato : d.getCromosoma()) {
            //if probability > un numero aleatorio entre 0.0 y 1.0 
            if (d.getProbabilitiAddNoise() >= Math.random()){
                do{
                    //encontrar numero aleatorio entre el rango de ruido
                    n = random.random(d);
                //mientras el valor se salga de los valores minimo y maximo, repita...
                }while(min > (dato + n)  || (dato + n)> max);
                //adicionar el paso y el numero aleatorio asl valor del vector de la posicion i
                vn[i] = dato + n;
                i++;
            }
        }
        return new Individuo(vn, d);
    }  
    
    public Individuo tweakGaussian(Individuo d, double min, double max) {
        double n;
        Double vn[] = new Double[d.getCromosoma().length];
        int i = 0;
        for (Double dato : d.getCromosoma()) {
            //if probability > un numero aleatorio entre 0.0 y 1.0 
            if (d.getProbabilitiAddNoise() >= Math.random()){
                do{
                    //encontrar numero aleatorio entre el rango de ruido
                    n = random.random(d);
                //mientras el valor se salga de los valores minimo y maximo, repita...
                }while(min > (dato + n)  || (dato + n)> max);
                //adicionar el paso y el numero aleatorio asl valor del vector de la posicion i
                vn[i] = dato + n;
                i++;
            }
        }
        return new Individuo(vn, d);
    }  

    public double getProbabilitiAddNoise() {
        return probabilitiAddNoise;
    }

    public void setProbabilitiAddNoise(double probabilitiAddNoise) {
        this.probabilitiAddNoise = probabilitiAddNoise;
    }

    public double getHalfRangeNoise() {
        return halfRangeNoise;
    }

    public void setHalfRangeNoise(double halfRangeNoise) {
        this.halfRangeNoise = halfRangeNoise;
    }

    
    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    
    public Double[] getCromosoma() {
        return cromosoma;
    }

    public void setCromosoma(Double[] cromosoma) {
        this.cromosoma = cromosoma;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }        

    public double getPaso() {
        return paso;
    }

    public void setPaso(double paso) {
        this.paso = paso;
    }        
    
    /**
     *metodo implementado de la interfaz cloneable para poder clonar objetos de este tipo
     * @return una copia del objeto de esta clase
     * @throws java.lang.CloneNotSupportedException se produce si no se a implementado la interfaz cloneable
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("The class could not be cloned");
        }
        return obj;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Arrays.hashCode(this.cromosoma);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Individuo other = (Individuo) obj;
        if (!Arrays.equals(this.cromosoma, other.cromosoma)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "TipoDato{" + "dato=" + Arrays.toString(cromosoma) + '}';
    }
        
    
}
