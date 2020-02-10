package sdm.controladoresServicios;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdm.controladores.Globales;
import sdm.modelos.Mensaje;
import sdm.repositorios.AccesoDatosException;

@WebServlet("/admin/servicio/borrar")
public class ServicioBorrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idservicios = request.getParameter("idservicios");
		

		
		Mensaje mensaje;
		
		try {
			Globales.daos.borrar(Long.parseLong(idservicios));
			mensaje = new Mensaje(
					"Borrado correctamente", 
					Mensaje.Nivel.INFORMATIVO);
		} catch (AccesoDatosException e) {
			mensaje = new Mensaje(
				"No se ha encontrado el servicio a borrar",
				Mensaje.Nivel.ALERTA);
		} catch(NumberFormatException e) {
			mensaje = new Mensaje(
					"No se ha recibido id válido para borrar",
					Mensaje.Nivel.ERROR);
		}
		
		request.getSession().setAttribute("mensaje", mensaje);

		response.sendRedirect(request.getContextPath() + "/admin/servicios");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
