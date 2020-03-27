package com.ipartek.formacion.mf0966_3ejerciciocasa.controladores.resenas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0966_3ejerciciocasa.controladores.Globales;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Mensaje;
import com.ipartek.formacion.mf0966_3ejerciciocasa.repositorios.AccesoDatosException;

@WebServlet("/admin/resena/borrar")
public class ResenaBorrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codigo = request.getParameter("codigo");
		
		Mensaje mensaje;
		
		try {
			Globales.daoResena.borrar(Integer.parseInt(codigo));
			
			mensaje= new Mensaje("Reseña borrada correctamente", Mensaje.Nivel.INFORMATIVO);
		}catch (AccesoDatosException e) {
			mensaje= new Mensaje("No se ha recibido la reseña a borrar", Mensaje.Nivel.ALERTA);
		} catch (NumberFormatException e) {
			mensaje= new Mensaje("No se ha recibido un código válido de reseña para borrar", Mensaje.Nivel.ERROR);
		}
		
		request.getSession().setAttribute("mensaje", mensaje);
		
		response.sendRedirect(request.getContextPath() + "/admin/resenas");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
