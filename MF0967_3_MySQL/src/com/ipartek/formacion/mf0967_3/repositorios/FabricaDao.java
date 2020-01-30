package com.ipartek.formacion.mf0967_3.repositorios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.ipartek.formacion.mf0967_3.modelos.Libro;


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
	
	public Dao<Libro> getInstanciaLibro() {
		switch(tipo) {
		case "memoria": return LibroTreeMap.getInstancia();
		case "mysql": return LibroMySQL.getInstancia(pathConfiguracion);
		default: throw new AccesoDatosException("No se reconoce el tipo " + tipo);
		}
	}
}