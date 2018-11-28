/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandw.dominio;

/**
 *
 * @author alech
 */
public class Agregado {
    private String nombreAgregado;
    private boolean tipoAgregado;
    private float precio;

    public Agregado(String nombreAgregado, boolean tipoAgregado, float precio) {
        this.nombreAgregado = nombreAgregado;
        this.tipoAgregado = tipoAgregado;
        this.precio = precio;
    }

    public Agregado(String nombreAgregado, boolean tipoAgregado) {
        this.nombreAgregado = nombreAgregado;
        this.tipoAgregado = tipoAgregado;
    }
    
    

    public String getNombreAgregado() {
        return nombreAgregado;
    }

    public void setNombreAgregado(String nombreAgregado) {
        this.nombreAgregado = nombreAgregado;
    }

    public boolean isTipoAgregado() {
        return tipoAgregado;
    }

    public void setTipoAgregado(boolean tipoAgregado) {
        this.tipoAgregado = tipoAgregado;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
