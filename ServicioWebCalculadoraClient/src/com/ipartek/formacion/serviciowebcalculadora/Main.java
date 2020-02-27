package com.ipartek.formacion.serviciowebcalculadora;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class Main {

	public static void main(String[] args) throws MalformedURLException, ServiceException, RemoteException {
		URL endpoint = new URL(
				"http://localhost:8080/ServicioWebCalculadora/services/Calculadora");
								
		CalculadoraServiceLocator servicio = new CalculadoraServiceLocator();
		
		Calculadora calculadora = servicio.getCalculadora(endpoint);
		
		System.out.println(calculadora.sumar(3,4));
		System.out.println(calculadora.restar(3,4));
		System.out.println(calculadora.multiplicar(3,4));
		System.out.println(calculadora.dividir(3,4));
	}

}
