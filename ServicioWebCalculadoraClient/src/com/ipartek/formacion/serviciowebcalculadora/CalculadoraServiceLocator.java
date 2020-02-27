/**
 * CalculadoraServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.serviciowebcalculadora;

public class CalculadoraServiceLocator extends org.apache.axis.client.Service implements com.ipartek.formacion.serviciowebcalculadora.CalculadoraService {

    public CalculadoraServiceLocator() {
    }


    public CalculadoraServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CalculadoraServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Calculadora
    private java.lang.String Calculadora_address = "http://localhost:8080/ServicioWebCalculadora/services/Calculadora";

    public java.lang.String getCalculadoraAddress() {
        return Calculadora_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CalculadoraWSDDServiceName = "Calculadora";

    public java.lang.String getCalculadoraWSDDServiceName() {
        return CalculadoraWSDDServiceName;
    }

    public void setCalculadoraWSDDServiceName(java.lang.String name) {
        CalculadoraWSDDServiceName = name;
    }

    public com.ipartek.formacion.serviciowebcalculadora.Calculadora getCalculadora() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Calculadora_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCalculadora(endpoint);
    }

    public com.ipartek.formacion.serviciowebcalculadora.Calculadora getCalculadora(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ipartek.formacion.serviciowebcalculadora.CalculadoraSoapBindingStub _stub = new com.ipartek.formacion.serviciowebcalculadora.CalculadoraSoapBindingStub(portAddress, this);
            _stub.setPortName(getCalculadoraWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCalculadoraEndpointAddress(java.lang.String address) {
        Calculadora_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ipartek.formacion.serviciowebcalculadora.Calculadora.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ipartek.formacion.serviciowebcalculadora.CalculadoraSoapBindingStub _stub = new com.ipartek.formacion.serviciowebcalculadora.CalculadoraSoapBindingStub(new java.net.URL(Calculadora_address), this);
                _stub.setPortName(getCalculadoraWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Calculadora".equals(inputPortName)) {
            return getCalculadora();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://serviciowebcalculadora.formacion.ipartek.com", "CalculadoraService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://serviciowebcalculadora.formacion.ipartek.com", "Calculadora"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Calculadora".equals(portName)) {
            setCalculadoraEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
