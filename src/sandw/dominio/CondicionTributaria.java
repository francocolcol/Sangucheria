/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandw.dominio;
import sandw.dominio.Cliente;

/**
 *
 * @author FRANCO-PC
 */
public class CondicionTributaria {
    String Descripcion;
    int codigoAFIP;
    Cliente cliente;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCodigoAFIP() {
        return codigoAFIP;
    }

    public void setCodigoAFIP(int codigoAFIP) {
        this.codigoAFIP = codigoAFIP;
    }

    public CondicionTributaria(String Descripcion, int codigoAFIP) {
        this.Descripcion = Descripcion;
        this.codigoAFIP = codigoAFIP;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
