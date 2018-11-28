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
public class Rubro {
    private String descripcionRubro;
    private ArrayList<Producto>listaProductos=new ArrayList<>();    
    public Rubro(String descripcionRubro) {
        this.descripcionRubro = descripcionRubro;
    }

    public String getDescripcionRubro() {
        return descripcionRubro;
    }

    public void setDescripcionRubro(String descripcionRubro) {
        this.descripcionRubro = descripcionRubro;
    }
    
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public void addProducto(Producto p){
        listaProductos.add(p);
    }
}
