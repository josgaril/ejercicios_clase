package com.ipartek.formacion.sdm.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.sdm.jaxrs.Globales;
import com.ipartek.formacion.sdm.repositorios.FabricaDao;

@WebListener
public class InicioListener implements ServletContextListener {
	
	public void contextDestroyed(ServletContextEvent sce) {}

    public void contextInitialized(ServletContextEvent sce)  { 
        String pathConfiguracion = sce.getServletContext().getRealPath("/WEB-INF/") + "dao.properties";
    	
        FabricaDao fabricaDao = FabricaDao.getInstancia(pathConfiguracion);
    	
        Globales.daoTrabajador = fabricaDao.getInstanciaTrabajador();
        Globales.daoServicio = fabricaDao.getInstanciaServicio();
        Globales.daoCliente = fabricaDao.getInstanciaCliente();
        Globales.daoSesion = fabricaDao.getInstanciaSesion();

    }	
}
