package com.ipartek.formacion.mf0966_3ejerciciocasa.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.mf0966_3ejerciciocasa.controladores.Globales;
import com.ipartek.formacion.mf0966_3ejerciciocasa.repositorios.FabricaDao;

@WebListener
public class InicioListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		String pathConfiguracion = sce.getServletContext().getRealPath("/WEB-INF/") + "dao.properties";

		FabricaDao fabricaDao = FabricaDao.getInstancia(pathConfiguracion);

		Globales.daoCurso = fabricaDao.getInstanciaCurso();
		Globales.daoResena = fabricaDao.getInstanciaResena();
		Globales.daoAlumno = fabricaDao.getInstanciaAlumno();
	}

}
