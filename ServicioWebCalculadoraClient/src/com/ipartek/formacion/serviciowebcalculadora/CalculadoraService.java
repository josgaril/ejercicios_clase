/**
 * CalculadoraService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.serviciowebcalculadora;

public interface CalculadoraService extends javax.xml.rpc.Service {
    public java.lang.String getCalculadoraAddress();

    public com.ipartek.formacion.serviciowebcalculadora.Calculadora getCalculadora() throws javax.xml.rpc.ServiceException;

    public com.ipartek.formacion.serviciowebcalculadora.Calculadora getCalculadora(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
