/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandw.dominio;

/**
 *
 * @author FRANCO-PC
 */
public class Cliente {
    String nombre;
    String domicilio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Cliente(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
    }
    
    
}

