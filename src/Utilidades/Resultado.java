/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author Danilo
 */
public class Resultado{
    String funcion;    
    String algoritmo;
    int d;
    double promedioIteracion;
    double mejor_optimo;
    double peor_optimo;
    double promedioOptimos;
    double desviacionOptimos;
    double tiempoPromedio;

    public Resultado(String funcion, String algoritmo, int d,  double promedioIteracion, double mejor_optimo, double peor_optimo, double promedioOptimos, double desviacionOptimos, double tiempoPromedio) {
        this.funcion = funcion;
        this.algoritmo = algoritmo;
        this.d = d;
        this.promedioIteracion = promedioIteracion;
        this.mejor_optimo = mejor_optimo;
        this.peor_optimo = peor_optimo;
        this.promedioOptimos = promedioOptimos;
        this.desviacionOptimos = desviacionOptimos;
        this.tiempoPromedio = tiempoPromedio;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public double getPromedioIteracion() {
        return promedioIteracion;
    }

    public void setPromedioIteracion(double promedioIteracion) {
        this.promedioIteracion = promedioIteracion;
    }

    public double getMejor_optimo() {
        return mejor_optimo;
    }

    public void setMejor_optimo(double mejor_optimo) {
        this.mejor_optimo = mejor_optimo;
    }

    public double getPeor_optimo() {
        return peor_optimo;
    }

    public void setPeor_optimo(double peor_optimo) {
        this.peor_optimo = peor_optimo;
    }

    public double getPromedioOptimos() {
        return promedioOptimos;
    }

    public void setPromedioOptimos(double promedioOptimos) {
        this.promedioOptimos = promedioOptimos;
    }

    public double getDesviacionOptimos() {
        return desviacionOptimos;
    }

    public void setDesviacionOptimos(double desviacionOptimos) {
        this.desviacionOptimos = desviacionOptimos;
    }

    public double getTiempoPromedio() {
        return tiempoPromedio;
    }

    public void setTiempoPromedio(double tiempoPromedio) {
        this.tiempoPromedio = tiempoPromedio;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
    
    
    
    
    
    
    
}

