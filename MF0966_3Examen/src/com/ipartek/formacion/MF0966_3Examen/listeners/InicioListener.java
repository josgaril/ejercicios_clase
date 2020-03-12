package com.ipartek.formacion.MF0966_3Examen.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.MF0966_3Examen.controladores.Globales;
import com.ipartek.formacion.MF0966_3Examen.repositorios.FabricaDao;

@WebListener
public class InicioListener implements ServletContextListener {
	
	public void contextDestroyed(ServletContextEvent sce) {}

    public void contextInitialized(ServletContextEvent sce)  { 
        String pathConfiguracion = sce.getServletContext().getRealPath("/WEB-INF/") + "dao.properties";
    	
        FabricaDao fabricaDao = FabricaDao.getInstancia(pathConfiguracion);
    	
        Globales.daoCurso = fabricaDao.getInstanciaCurso();
        Globales.daoResena = fabricaDao.getInstanciaResena();


    }	
}
