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
public class TipoDeComprobante {
    String Descripcion;
    int codigoAFIP;

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

    public TipoDeComprobante(String Descripcion, int codigoAFIP) {
        this.Descripcion = Descripcion;
        this.codigoAFIP = codigoAFIP;
    }
    
    
}
