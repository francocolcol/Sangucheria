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
public class Producto {
    private String descripcionProducto;
    private int cantidad;
    private int idProducto;
    private int iddeVenta;
    private Rubro rubro;
    private double precio;
    private ArrayList<Agregado>listaComponentes=new ArrayList<>();
    private ArrayList<Agregado>listaPremiuns=new ArrayList<>();

    public Producto(String descripcionProducto, int cantidad, int idProducto, Rubro rubro, double precio) {
        this.descripcionProducto = descripcionProducto;
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.rubro = rubro;
        this.precio = precio;
    }

    public Producto(Producto x) {
        descripcionProducto=x.getDescripcionProducto();
        cantidad=x.getCantidad();
        idProducto=x.getIdProducto();
        rubro=x.getRubro();
        precio=x.getPrecio();
        
    }

    public int getIddeVenta() {
        return iddeVenta;
    }

    public void setIddeVenta(int iddeVenta) {
        this.iddeVenta = iddeVenta;
    }

    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public ArrayList<Agregado> getListaComponentes() {
        return listaComponentes;
    }

    public void setListaComponentes(ArrayList<Agregado> listaComponentes) {
        this.listaComponentes = listaComponentes;
    }

    public ArrayList<Agregado> getListaPremiuns() {
        return listaPremiuns;
    }

    public void setListaPremiuns(ArrayList<Agregado> listaPremiuns) {
        this.listaPremiuns = listaPremiuns;
    }
    
    public void addComponente(Agregado a){
        listaComponentes.add(a);
    }
    public void addPremiuns(Agregado a){
        listaPremiuns.add(a);
    }
    public double calcularTotalPremiuns(){
        double total=0;
        for(Agregado a:listaPremiuns){
            total+=a.getPrecio();
        }
        return total;
    }
    public String revisarAgregado(String s){
        for(Agregado a:listaPremiuns){
            if (s.equals(a.getNombreAgregado())){
                return "✓";
            }
    }
        return null;
    }
}
