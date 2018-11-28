/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandw.dominio;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alech
 */
public class Turno {
    private String turnoDescripcion;
    private Date fecha;
    private ArrayList<Venta> listaventas = new ArrayList<>();

    public Turno() {
        this.fecha = new Date();
        if (fecha.getHours() > 12){
            turnoDescripcion = "Turno Tarde";
        }
        else{
            turnoDescripcion = "Turno Mañana";
        }
    }
    
    public String getTurnoDescripcion() {
        return turnoDescripcion;
    }

    public void setTurnoDescripcion(String turnoDescripcion) {
        this.turnoDescripcion = turnoDescripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Venta> getVentas() {
        return listaventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.listaventas = ventas;
    }
    
    public void addVenta(Venta venta) {
        listaventas.add(venta);
    }
    
}
