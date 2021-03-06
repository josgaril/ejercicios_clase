package com.ipartek.formacion.uff2215Examen.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.uff2215Examen.controladores.Globales;
import com.ipartek.formacion.uff2215Examen.repositorios.FabricaDao;

@WebListener
public class InicioListener implements ServletContextListener {
	
	public void contextDestroyed(ServletContextEvent sce) {}

    public void contextInitialized(ServletContextEvent sce)  { 
        String pathConfiguracion = sce.getServletContext().getRealPath("/WEB-INF/") + "dao.properties";
    	
        FabricaDao fabricaDao = FabricaDao.getInstancia(pathConfiguracion);
    	
        Globales.daoLibro = fabricaDao.getInstanciaLibro();
        Globales.daoAutor = fabricaDao.getInstanciaAutor();


    }	
}
