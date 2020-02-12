package sdm.controladores;

import sdm.modelos.Cliente;
import sdm.modelos.Servicio;
import sdm.modelos.Sesion;
import sdm.modelos.SesionO;
import sdm.modelos.Trabajador;
import sdm.repositorios.Dao;

public class Globales {
	public static Dao<Servicio> daoServicio;
	public static Dao<Cliente> daoCliente;
	public static Dao<Trabajador> daoTrabajador;
	public static Dao<Sesion> daoSesion;
	public static Dao<SesionO> daoSesionO;

	/*
	 * public static Dao<Servicio> daos; public static Dao<Trabajador> daot;
	 */
}

