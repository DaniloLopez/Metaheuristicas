/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public class Estadistica {

    public void calcularResultados(ArrayList<ResultadoIndividuo> res) {
        ArrayList<ResultadoIndividuo> copyRes = (ArrayList<ResultadoIndividuo>)res.clone();
        for (ResultadoIndividuo re : copyRes) {
            System.out.println("alg est: " + re.getAlgoritmo());
            switch(re.getFuncion()){
                case "":
                    switch(re.getFuncion()){
                        
                    }                         
                break;    
                
                case "SAHillClimbing":
                break;
                
                case "SAHillClimbingR":
                break;
                
                case "RandomSearch":
                break;
                
                case "HillClimbingRandomRestarts":
                break;
                
                default:
                
            }
        }
    }
    
}
