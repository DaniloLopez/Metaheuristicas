/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metaheuristicas;

import HillClimbing.*;
import funciones.Individuo;
import Utilidades.Aleatorio;
import Utilidades.Archivo;
import Utilidades.Estadistica;
import Utilidades.Resultado;
import Utilidades.ResultadoFuncion;
import Utilidades.ResultadoIndividuo;
import funciones.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


/**
 *
 * @author Danilo
 */
public class Metaheuristicas {

    /**
     * @param args the command line arguments
     */
    
    private static ArrayList<Resultado> resFinal = new ArrayList<>();
    private static int dimensiones = 10;  
    
    public static void main(String[] args) {     
        
        // <editor-fold desc="variables">
        //los efos son el numero de veces que va a realizar la busqueda
        //la cantidad de iteraciones es cuantas veces va a repetir la prueba
        Aleatorio   ut = new Aleatorio();
        Archivo     objArchivo = new Archivo();
        Estadistica objEstadistica = new Estadistica();
        
        int     paso = 1;
        double  prob = 1;
        double  radio = 0.9;     
        int     cantPruebas = 30 ;
        int EFOs = 5000;
        int     min = -100;
        int     max = 100;                                                                                        
        
        //instancia de la clase esfera
        Sphere objEsfera        = new Sphere(min, max, radio);
        Step objStep            = new Step(min, max, radio);
        Schwefel objSchwefel    = new Schwefel(min, max);
        Rastrigin objRastrigin  = new Rastrigin(-5.12, 5.12);
        Griewank objGriewank    = new Griewank(-600, 600);
        Ackley objackley        = new Ackley(-32, 32);
                        
        ArrayList<HillClimbingAbstract> algoritmos = new ArrayList<>();
        
        // </editor-fold>
        
        // <editor-fold desc="adicion de funciones en diferentes algoritmos">
        //adicion funcion esfera
        algoritmos.add(new BetaHillClimbing(objEsfera, 0.5, 0.6));
        algoritmos.add(new HillClimbing(objEsfera));
        algoritmos.add(new SAHillClimbing(objEsfera));
        algoritmos.add(new SAHillClimbingR(objEsfera));
        algoritmos.add(new RandomSearch(objEsfera));
        algoritmos.add(new HillClimbingRR(objEsfera));        
        //adicion funcion paso
        algoritmos.add(new BetaHillClimbing(objStep, 0.5, 0.6));
        algoritmos.add(new HillClimbing(objStep));
        algoritmos.add(new SAHillClimbing(objStep));
        algoritmos.add(new SAHillClimbingR(objStep));
        algoritmos.add(new RandomSearch(objStep));
        algoritmos.add(new HillClimbingRR(objStep));
        //adicion de la funcion schwefel
        algoritmos.add(new BetaHillClimbing(objSchwefel, 0.5, 0.6));
        algoritmos.add(new HillClimbing(objSchwefel));
        algoritmos.add(new SAHillClimbing(objSchwefel));
        algoritmos.add(new SAHillClimbingR(objSchwefel));
        algoritmos.add(new RandomSearch(objSchwefel));
        algoritmos.add(new HillClimbingRR(objSchwefel));
        //adicion de la funcion rastrigin
        algoritmos.add(new BetaHillClimbing(objRastrigin, 0.5, 0.6));
        algoritmos.add(new HillClimbing(objRastrigin));
        algoritmos.add(new SAHillClimbing(objRastrigin));
        algoritmos.add(new SAHillClimbingR(objRastrigin));
        algoritmos.add(new RandomSearch(objRastrigin));
        algoritmos.add(new HillClimbingRR(objRastrigin));
        //adicion de la funcion griewank
        algoritmos.add(new BetaHillClimbing(objGriewank, 0.5, 0.6));
        algoritmos.add(new HillClimbing(objGriewank));
        algoritmos.add(new SAHillClimbing(objGriewank));
        algoritmos.add(new SAHillClimbingR(objGriewank));
        algoritmos.add(new RandomSearch(objGriewank));
        algoritmos.add(new HillClimbingRR(objGriewank));
        //adicion de la funcion ackely
        algoritmos.add(new BetaHillClimbing(objackley, 0.5, 0.6));
        algoritmos.add(new HillClimbing(objackley));
        algoritmos.add(new SAHillClimbing(objackley));
        algoritmos.add(new SAHillClimbingR(objackley));
        algoritmos.add(new RandomSearch(objackley));
        algoritmos.add(new HillClimbingRR(objackley));
        // </editor-fold> 
        
                
        //vector de resultados        
        Individuo resultados[] = new Individuo[cantPruebas];               
        ArrayList<ResultadoIndividuo> res = new ArrayList();
        
        int it = 0;
        ResultadoFuncion resFun;
        for (HillClimbingAbstract algHC : algoritmos) {        
            for (int i = 0; i < cantPruebas; i++) {
                Double vectorAleatorios[] = ut.vectorAleatorioDecimal(i, algHC.getFunction().getMin(), algHC.getFunction().getMax(), dimensiones);                                
                //iniciar algoritmo hill climbing
                double start = System.currentTimeMillis();                                    
                resFun = algHC.inicio(new Individuo(vectorAleatorios, objEsfera, prob, radio, paso),EFOs);                
                double end = System.currentTimeMillis() - start;
                res.add(new ResultadoIndividuo(
                                                algHC.getNonmbreFuncion(),
                                                algHC.getClass().getSimpleName(), 
                                                resFun.getIteracion(), 
                                                end, 
                                                resFun.getResultado()
                                                )
                        );
            }            
            
            calcularEstadisticas(res, algHC);
            res.clear();
            System.out.println("********encontrado:  "+algHC.getClass().getSimpleName());
//            for (Individuo resultado : resultados) {
//                System.out.println(it + "  resultado: " + Arrays.toString(resultado.getCromosoma()));
//            }
            it ++;
        }               
        
        //recibe el nombre del archivo
        excribirResultados("D:\\1. Universidad\\Unicauca 2017-2\\Metaheuristicas\\quiz\\resultado.txt");
        //est.calcularResultados(res);                        
    }

    private static void calcularEstadisticas(ArrayList<ResultadoIndividuo> resultados, HillClimbingAbstract algHC) {
        double promItr = promedioIteraciones(resultados);
        double mejor = mejorOptimo(resultados);
        double peor = peorOptimo(resultados);
        double promedios = promedioOptimos(resultados);
        double desviacion = desviacionOptimos(resultados);
        double tiempo = tiempoPromedio(resultados);
        
        resFinal.add(new Resultado(
                resultados.get(0).getFuncion(),
                resultados.get(0).getAlgoritmo(),
                dimensiones,
                resultados.get(0).getIteracion(),
                mejor,
                peor,
                promedios,
                desviacion,
                tiempo));
    }
    
    private static double promedioIteraciones(ArrayList<ResultadoIndividuo> resultados) {
        double sum = 0;
        for (ResultadoIndividuo resultado : resultados) {
            sum = sum + resultado.getIteracion();
        }
        return sum / resultados.size();
    }

    private static double mejorOptimo(ArrayList<ResultadoIndividuo> resultados) {
        double mejor = resultados.get(0).getIndviduo().getFitness();
        for (ResultadoIndividuo resultado : resultados) {
            if(resultado.getIndviduo().getFitness() < mejor){
                mejor = resultado.getIndviduo().getFitness();
            }
        }
        return mejor;
    }

    private static double peorOptimo(ArrayList<ResultadoIndividuo> resultados) {
        double peor = resultados.get(0).getIndviduo().getFitness();
        for (ResultadoIndividuo resultado : resultados) {
            if(resultado.getIndviduo().getFitness() < peor){
                peor = resultado.getIndviduo().getFitness();
            }
        }
        return peor;
    }

    private static double promedioOptimos(ArrayList<ResultadoIndividuo> resultados) {
        double suma = 0;
        for (ResultadoIndividuo resultado : resultados) {
            suma += resultado.getIndviduo().getFitness();
        }
        return suma/resultados.size();
    }

    private static double desviacionOptimos(ArrayList<ResultadoIndividuo> resultados) {
        double prom = promedioOptimos(resultados);
        double media = 0;
        for (ResultadoIndividuo resultado : resultados) {
            media += Math.pow((resultado.getIndviduo().getFitness() - prom),2);            
        }
        return media/(resultados.size()-1);
    }

    private static double tiempoPromedio(ArrayList<ResultadoIndividuo> resultados) {
        double suma = 0;
        for (ResultadoIndividuo resultado : resultados) {
            suma += resultado.getTiempo();
        }
        return suma/resultados.size();
    }

    
    
    private static void excribirResultados(String nombre) {
        Date date = new Date();        
        //Caso 3: obtenerhora y fecha y salida por pantalla con formato:
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha = hourdateFormat.format(date);


        Archivo file = new Archivo();
        file.abrirArchivo(nombre, true);
            file.escribirArchivo(fecha, true);
            String cadena = "Funcion\t\tAlgoritmo\tD\tPro.Itr\t\tmejor Optimo \tPeor Optimo\t\tPromedio Optimos\tDesviacion Optimos\tTiempoPromedio";
            file.escribirArchivo(cadena, true);
            for (Resultado res : resFinal) {
                cadena =res.getFuncion() + 
                        "\t " + res.getAlgoritmo()+ "\t" + 
                        "\t " + res.getD() + 
                        "\t " + res.getPromedioIteracion() + 
                        "\t " + redondearDecimales(res.getMejor_optimo(),10) + 
                        "\t " + redondearDecimales(res.getPeor_optimo(),10) + 
                        "\t " + redondearDecimales(res.getPromedioOptimos(), 10) + 
                        "\t " + redondearDecimales(res.getDesviacionOptimos(), 10) + 
                        "\t " + redondearDecimales(res.getTiempoPromedio(), 4);
                file.escribirArchivo(cadena, true);
            }
            file.escribirArchivo("\n", false);
        file.cerrarArchivo();
    }
    
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }

    
       
}
