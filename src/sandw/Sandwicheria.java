/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandw;

import fev1.dif.afip.gov.ar.ArrayOfFECAEDetRequest;
import fev1.dif.afip.gov.ar.ArrayOfFECAEDetResponse;
import fev1.dif.afip.gov.ar.FEAuthRequest;
import fev1.dif.afip.gov.ar.FECAECabRequest;
import fev1.dif.afip.gov.ar.FECAECabResponse;
import fev1.dif.afip.gov.ar.FECAEDetRequest;
import fev1.dif.afip.gov.ar.FECAERequest;
import fev1.dif.afip.gov.ar.FECAEResponse;
import fev1.dif.afip.gov.ar.FERecuperaLastCbteResponse;
import sandw.vista.VentanaLogin;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import org.datacontract.schemas._2004._07.sge_service_contracts.Autorizacion;
import sandw.dominio.Agregado;
import sandw.dominio.Empleado;
import sandw.dominio.Producto;
import sandw.dominio.Rubro;
import sandw.dominio.Turno;
import sandw.dominio.Venta;
import sandw.vista.VentanaVentas;
import sandw.dominio.CondicionTributaria;

/**
 *
 * @author alech
 */
public class Sandwicheria {

    /**
     * @param args the command line arguments
     */
        public static ArrayList<Empleado>listaEmpleado=new ArrayList<Empleado>();
        public static ArrayList<Rubro>listaRubros=new ArrayList<>();
        public static ArrayList<Producto>listaProductos=new ArrayList<>();
        public static Empleado logueado=null;
        public static Turno turnoactual;
        public static CondicionTributaria condtrib;
        public static void main(String[] args) {
        obtenerDatos();
        new VentanaLogin().setVisible(true);
        
    }
    public static void obtenerDatos(){
    Empleado e1=new Empleado("Ana Jacinta","ana","ana");
    Empleado e2=new Empleado("Juan Alberto","juan","juan");
    listaEmpleado.add(e1);
    listaEmpleado.add(e2);
    Rubro rub1=new Rubro("Sandwichs");
    Rubro rub2=new Rubro("Bebidas Sin Alcohol");
    Rubro rub3=new Rubro("Bebidas Alcohol");
    listaRubros.add(rub1);
    listaRubros.add(rub2);
    listaRubros.add(rub3);
    Producto p1=new Producto("Milanesa", 100, 100, rub1, 75);
    Producto p2=new Producto("Lomito", 100, 101, rub1, 90);
    Producto p3=new Producto("Mexicano", 100, 102, rub1, 150);
    
    rub1.addProducto(p1);
    rub1.addProducto(p2);
    rub1.addProducto(p3);
    
    Producto p5=new Producto("Cerveza", 2, 105, rub3, 80.00);
    Producto p6=new Producto("Coca Cola", 50, 106, rub2, 40.00);
    rub3.addProducto(p5);
    rub2.addProducto(p6);
    
    listaProductos.add(p1);
    listaProductos.add(p2);
    listaProductos.add(p3);
    listaProductos.add(p5);
    listaProductos.add(p6);
    
    p1.addComponente(new Agregado("tomate", false));
    p1.addComponente(new Agregado("lechuga", false));
    p1.addComponente(new Agregado("mayonesa", false));
    p1.addComponente(new Agregado("mostaza", false));
    
    
    p2.addComponente(new Agregado("tomate", false));
    p2.addComponente(new Agregado("lechuga", false));
    p2.addComponente(new Agregado("mayonesa", false));
    p2.addComponente(new Agregado("mostaza", false));
    
    
    
}

    public static boolean login(String usu, String clave) {
        
        for(Empleado  e:listaEmpleado){
            if(usu.equals(e.getUsuarioEmpleado()) && clave.equals(e.getClaveEmpleado())){
                logueado=e;
                Turno t = new Turno();
                e.addTurno(t);
                turnoactual = t;
                return true;
            }
        }
        
        return false;
    }

    
    
    public static Empleado getLogueado() {
        return logueado;
    }

    public static Turno getTurnoactual() {
        return turnoactual;
    }

    public static String getNombreEmpleado() {
        String nombre = logueado.getNombreEmpleado();
        return nombre;
    }
    
    public static String getFechaTurno() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String FechaTurno = dateFormat.format(turnoactual.getFecha());
        return FechaTurno;
    }
    
    public static String getDescripcionTurno() {
        String tipoTurno = turnoactual.getTurnoDescripcion();
        return tipoTurno;
    }
    
    public static Producto buscarProductoPorId(int id) {
        for(Producto p:listaProductos){
            if(id==p.getIdProducto()){
                return p;
            }
        }
        
        return null;
    }
    
    public static void addVentaTurno(Venta v){
        logueado.addVentaTurno(v);
    }

    public static ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
    
    public static double calcularTotalTurno(){
        double total = 0;
        for(Venta v:turnoactual.getVentas()){
            total = total + v.calcularTotal();
        }
        return total;
    }
    
    public static String cierreTurno(){
        String s = "";
        for(Producto p:listaProductos){
            s = s + p.getDescripcionProducto()+":   "+cantidadProducto(p.getIdProducto())+"\n";
        }
        return s;
    }
    
    public static int cantidadProducto(int Id){
        int i = 0;
        for(Venta v:turnoactual.getVentas()){
            for(Producto p:v.getListaProductos()){
                if(p.getIdProducto() == Id){
                    i = i + 1;
                }
            }
        }
        return i;
    }
    
    public static void facturar(Venta venta, VentanaVentas ventana){
        Autorizacion auto = solicitarAutorizacion("74C26206-6D2F-4909-BD6B-BDF692565A13");
        fev1.dif.afip.gov.ar.FEAuthRequest auth = new FEAuthRequest();
        auth.setCuit(auto.getCuit());
        auth.setSign(auto.getSign().getValue());
        auth.setToken(auto.getToken().getValue());
        FECAERequest req = getfeCAEReq(venta.calcularTotal(),auth);
        FECAEResponse resultado = fecaeSolicitar(auth, req);
        /*FECAECabResponse cabresp = resultado.getFeCabResp();
        ArrayOfFECAEDetResponse detresp = resultado.getFeDetResp();
        JOptionPane.showMessageDialog(rootPane, cabresp.getResultado());*/
    }
    
    private static Autorizacion solicitarAutorizacion(java.lang.String codigo) {
        org.tempuri.LoginService service = new org.tempuri.LoginService();
        org.tempuri.ILoginService port = service.getSGEAuthService();
        return port.solicitarAutorizacion(codigo);
    }

    private static FERecuperaLastCbteResponse feCompUltimoAutorizado(fev1.dif.afip.gov.ar.FEAuthRequest auth, int ptoVta, int cbteTipo) {
        fev1.dif.afip.gov.ar.Service service = new fev1.dif.afip.gov.ar.Service();
        fev1.dif.afip.gov.ar.ServiceSoap port = service.getServiceSoap();
        return port.feCompUltimoAutorizado(auth, ptoVta, cbteTipo);
    }

    private static FECAEResponse fecaeSolicitar(fev1.dif.afip.gov.ar.FEAuthRequest auth, fev1.dif.afip.gov.ar.FECAERequest feCAEReq) {
        fev1.dif.afip.gov.ar.Service service = new fev1.dif.afip.gov.ar.Service();
        fev1.dif.afip.gov.ar.ServiceSoap port = service.getServiceSoap();
        return port.fecaeSolicitar(auth, feCAEReq);
    }
    
    public static fev1.dif.afip.gov.ar.FECAERequest getfeCAEReq(double total, fev1.dif.afip.gov.ar.FEAuthRequest auth){
        fev1.dif.afip.gov.ar.FECAERequest req = new fev1.dif.afip.gov.ar.FECAERequest();
        FECAECabRequest reqcab = new FECAECabRequest();
        reqcab.setCantReg(1);
        reqcab.setCbteTipo(11);
        reqcab.setPtoVta(1);
        req.setFeCabReq(reqcab);
        ArrayOfFECAEDetRequest arraydetreq = new ArrayOfFECAEDetRequest();
        FECAEDetRequest detreq = new FECAEDetRequest();
        detreq.setConcepto(1);
        detreq.setDocTipo(99);
        detreq.setDocNro(0);
        FERecuperaLastCbteResponse ultimoaut = feCompUltimoAutorizado(auth, 1, 11);
        long lon = ultimoaut.getCbteNro() + 1;
        detreq.setCbteDesde(lon);
        detreq.setCbteHasta(lon);
        detreq.setImpTotal(total);
        detreq.setImpTrib(0);
        detreq.setImpTotConc(0);
        detreq.setImpOpEx(0);
        detreq.setImpNeto(0);
        detreq.setImpIVA(0);
        detreq.setMonId("PES");
        detreq.setMonCotiz(1);
        java.util.Date fecha = new Date();
        String mes;
        if(fecha.getMonth() < 9){
            mes = "0"+Integer.toString(fecha.getMonth()+1);
        }
        else{
            mes = Integer.toString(fecha.getMonth()+1);
        }
        String fecha2 = Integer.toString(
                fecha.getDate())+
                mes+
                Integer.toString(1900+fecha.getYear()
         );
        detreq.setCbteFch(fecha2);
        arraydetreq.getFECAEDetRequest().add(detreq);
        req.setFeDetReq(arraydetreq);
        System.out.println(lon + 1);
        return req;
    }
    
}

