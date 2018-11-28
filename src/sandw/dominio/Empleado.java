/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandw.dominio;

import java.util.ArrayList;
/**
 *
 * @author alech
 */
public class Empleado {
    private String nombreEmpleado;
    private ArrayList<Turno> listaturnos = new ArrayList<>();
    private Turno turnoActual;
    private String usuarioEmpleado;
    private String claveEmpleado;

    public Empleado(String nombreEmpleado, String usuarioEmpleado, String claveEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.usuarioEmpleado = usuarioEmpleado;
        this.claveEmpleado = claveEmpleado;
    }
    

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public ArrayList<Turno> getTurno() {
        return listaturnos;
    }

    public void setTurno(ArrayList<Turno> turnos) {
        this.listaturnos = turnos;
    }

    public String getUsuarioEmpleado() {
        return usuarioEmpleado;
    }

    public void setUsuarioEmpleado(String usuarioEmpleado) {
        this.usuarioEmpleado = usuarioEmpleado;
    }

    public String getClaveEmpleado() {
        return claveEmpleado;
    }

    public void setClaveEmpleado(String claveEmpleado) {
        this.claveEmpleado = claveEmpleado;
    }
    
    public void addTurno (Turno t){
        listaturnos.add(t);
        turnoActual = t;
    }
    
    public void addVentaTurno (Venta v) {
        for(Turno t:listaturnos){
            if (t.getFecha().equals(turnoActual.getFecha())){
                t.addVenta(v);
            }
        }
    }
    
}
