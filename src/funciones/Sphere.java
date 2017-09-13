package funciones;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class Sphere extends Funcion{

    
    private double minEsperado = 0.1;
    private Double valorminimoEsperado = 0.1;    
    double radio;
    
    //indicar si se va a maximizar
    private boolean maximizar;
    float paso;
    
    public Sphere(int min, int max, double radio) {
        super(min,max, "sphere");
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
                suma += dato*dato;
            }            
            return suma;
        }catch(NullPointerException e){
            System.out.println("error calculando fitnes");
        }
        return 0;
    }   

    public boolean isMaximizar() {
        return maximizar;
    }

    public void setMaximizar(boolean maximizar) {
        this.maximizar = maximizar;
    }

    public float getPaso() {
        return paso;
    }

    public void setPaso(float paso) {
        this.paso = paso;
    }

}
