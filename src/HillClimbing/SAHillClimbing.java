package HillClimbing;

import Utilidades.ResultadoFuncion;
import funciones.Funcion;
import funciones.Individuo;
/**
 *
 * @author Danilo
 */
public class SAHillClimbing extends HillClimbingAbstract {
    
    private Individuo s;
    private Individuo r;
    private Individuo w;
    private int numAjustes ;

    /**
     *
     * @param funcion
     */
    public SAHillClimbing(Funcion function) {        
        super(function);
        this.s = null;
        this.r = null;        
        this.w = null;        
    }
            
    @Override
    public ResultadoFuncion inicio(Individuo aleatorio, int EFOs){
        int iteracion = -1;
        s = aleatorio;
        do{            
            r = aleatorio.tweak(s, super.getFunction().getMin(), super.getFunction().getMax());
            //System.out.println("s: " + Arrays.toString(s.getCromosoma()) + "     r: " + Arrays.toString(r.getCromosoma()));
            for (int i = 0; i < numAjustes; i++) {               
               w = aleatorio.tweak(s, super.getFunction().getMin(), super.getFunction().getMax());
               if(w.getFitness() < r.getFitness()) 
                   r = w;
            }
            if (r.getFitness() < s.getFitness()) 
                s = r;     
            iteracion++;
        }while(super.getFunction().validateIdealSolution(s) && iteracion < EFOs);
        return new ResultadoFuncion(s,iteracion);
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
