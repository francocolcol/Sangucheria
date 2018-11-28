/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandw.dominio;
import sandw.dominio.TipoDeComprobante;
import java.util.ArrayList;

/**
 *
 * @author alech
 */
public class Venta {

private double total = 0;
private ArrayList<Producto> listaProductos=new ArrayList<>();
private int contadorProductos;
private TipoDeComprobante comp;

    public int getContadorProductos() {
        return contadorProductos;
    }

    public void setContadorProductos(int contadorProductos) {
        this.contadorProductos = contadorProductos;
    }

    public TipoDeComprobante getComp() {
        return comp;
    }

    public void setComp(TipoDeComprobante comp) {
        this.comp = comp;
    }
    


    public Venta(double total) {
        this.total = total;
    }

    public Venta() {
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public double calcularTotal(){
        total=0;
        for (Producto p : listaProductos) {
            total=total+p.getPrecio()+p.calcularTotalPremiuns();
        }
        return total;
    }
    public void addProducto(Producto p){
        listaProductos.add(p);
    }
    
    public void removeProducto(Producto pro){
        listaProductos.remove(pro);
    }
    
}
