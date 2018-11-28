
package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.datacontract.schemas._2004._07.sge_service_contracts.Autorizacion;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ILoginService", targetNamespace = "http://ISTP1.Service.Contracts.Service")
@XmlSeeAlso({
    com.microsoft.schemas._2003._10.serialization.ObjectFactory.class,
    org.datacontract.schemas._2004._07.sge_service_contracts.ObjectFactory.class,
    service.contracts.service.istp1.ObjectFactory.class
})
public interface ILoginService {


    /**
     * 
     * @param codigo
     * @return
     *     returns org.datacontract.schemas._2004._07.sge_service_contracts.Autorizacion
     */
    @WebMethod(operationName = "SolicitarAutorizacion", action = "http://ISTP1.Service.Contracts.Service/ILoginService/SolicitarAutorizacion")
    @WebResult(name = "SolicitarAutorizacionResult", targetNamespace = "http://ISTP1.Service.Contracts.Service")
    @RequestWrapper(localName = "SolicitarAutorizacion", targetNamespace = "http://ISTP1.Service.Contracts.Service", className = "service.contracts.service.istp1.SolicitarAutorizacion")
    @ResponseWrapper(localName = "SolicitarAutorizacionResponse", targetNamespace = "http://ISTP1.Service.Contracts.Service", className = "service.contracts.service.istp1.SolicitarAutorizacionResponse")
    public Autorizacion solicitarAutorizacion(
        @WebParam(name = "codigo", targetNamespace = "http://ISTP1.Service.Contracts.Service")
        String codigo);

}
