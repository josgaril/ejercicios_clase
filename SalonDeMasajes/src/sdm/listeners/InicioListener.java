package sdm.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import sdm.controladores.Globales;
import sdm.repositorios.FabricaDao;

@WebListener
public class InicioListener implements ServletContextListener {
	
	public void contextDestroyed(ServletContextEvent sce) {}

    public void contextInitialized(ServletContextEvent sce)  { 
        String pathConfiguracion = sce.getServletContext().getRealPath("/WEB-INF/") + "dao.properties";
    	
        FabricaDao fabricaDao = FabricaDao.getInstancia(pathConfiguracion);
    	
        Globales.daot = fabricaDao.getInstanciaTrabajador();
        Globales.daos = fabricaDao.getInstanciaServicio();
        Globales.daoc = fabricaDao.getInstanciaCliente();
    }	
}
