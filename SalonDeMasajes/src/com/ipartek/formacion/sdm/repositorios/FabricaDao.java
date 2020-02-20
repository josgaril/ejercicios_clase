package com.ipartek.formacion.sdm.repositorios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.ipartek.formacion.sdm.modelos.Cliente;
import com.ipartek.formacion.sdm.modelos.Servicio;
import com.ipartek.formacion.sdm.modelos.Sesion;
import com.ipartek.formacion.sdm.modelos.SesionO;
import com.ipartek.formacion.sdm.modelos.Trabajador;

public class FabricaDao {
	private String pathConfiguracion;
	private String tipo;
	
	// SINGLETON
	private static FabricaDao instancia;
	
	public static FabricaDao getInstancia(String pathConfiguracion) {
		if(instancia == null) {
			instancia = new FabricaDao(pathConfiguracion);
		}
		return instancia;
	}
	
	private FabricaDao(String pathConfiguracion) {
		this.pathConfiguracion = pathConfiguracion;
		
		Properties configuracion = new Properties();
		try {
			configuracion.load(new FileInputStream(pathConfiguracion));
			tipo = configuracion.getProperty("tipo");
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido leer el fichero de configuración");
		}
	}
	
	// FIN SINGLETON
	
	public Dao<Cliente> getInstanciaCliente() {
		switch(tipo) {
		case "memoria": return ClienteTreeMap.getInstancia();
		case "mysql": return ClientesMySQL.getInstancia(pathConfiguracion);
		default: throw new AccesoDatosException("No se reconoce el tipo " + tipo);
		}
	}
	
	//TODO Añadido despues un dao por cada modelo
	public Dao<Servicio> getInstanciaServicio() {
		switch(tipo) {
		case "memoria": return ServicioTreeMap.getInstancia();
		case "mysql": return ServiciosMySQL.getInstancia(pathConfiguracion);
		default: throw new AccesoDatosException("No se reconoce el tipo " + tipo);
		}
	}
	
	public Dao<Trabajador> getInstanciaTrabajador() {
		switch(tipo) {
		case "memoria": return TrabajadorTreeMap.getInstancia();
		case "mysql": return TrabajadoresMySQL.getInstancia(pathConfiguracion);
		default: throw new AccesoDatosException("No se reconoce el tipo " + tipo);
		}
	}
	
	public Dao<Sesion> getInstanciaSesion() {
		switch(tipo) {
		case "memoria": return SesionTreeMap.getInstancia();
		case "mysql": return SesionesMySQL.getInstancia(pathConfiguracion);
		default: throw new AccesoDatosException("No se reconoce el tipo " + tipo);
		}
	}
	
	public Dao<SesionO> getInstanciaSesionO() {
		switch(tipo) {
		case "memoria": return SesionTreeMapO.getInstancia();
		case "mysql": return SesionesOMySQL.getInstancia(pathConfiguracion);
		default: throw new AccesoDatosException("No se reconoce el tipo " + tipo);
		}
	}
	
}
