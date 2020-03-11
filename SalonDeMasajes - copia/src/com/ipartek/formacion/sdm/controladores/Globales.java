package com.ipartek.formacion.sdm.controladores;

import com.ipartek.formacion.sdm.modelos.Cliente;
import com.ipartek.formacion.sdm.modelos.Servicio;
import com.ipartek.formacion.sdm.modelos.Sesion;
import com.ipartek.formacion.sdm.modelos.SesionO;
import com.ipartek.formacion.sdm.modelos.Trabajador;
import com.ipartek.formacion.sdm.repositorios.Dao;

public class Globales {
	public static Dao<Servicio> daoServicio;
	public static Dao<Cliente> daoCliente;
	public static Dao<Trabajador> daoTrabajador;
	public static Dao<Sesion> daoSesion;
	public static Dao<SesionO> daoSesionO;
}

