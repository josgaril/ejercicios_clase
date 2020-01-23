package com.ipartek.formacion.uf2218cms.controladores;
//NO GUARDAR ESTOOOOOOOOOO
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.uf2218cms.entidades.Libro;
import com.ipartek.formacion.uf2218cms.repositories.LibroRepository;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final String LIBRO_JSP = "/WEB-INF/vistas/libro.jsp";
	private static final String INDEX_JSP = "/WEB-INF/vistas/index.jsp";
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op==null) {
			op="";
		}
		switch (op) {
		case "agregar":
			request.setAttribute("primeravez", true);
			request.getRequestDispatcher(LIBRO_JSP).forward(request, response);
			break;
		case "atras":
			response.sendRedirect(request.getContextPath() + "/");
			break;
		default:
			request.setAttribute("libros", LibroRepository.getInstancia().obtenerTodos());
			request.getRequestDispatcher(INDEX_JSP).forward(request, response);
			break;
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibroRepository dao = LibroRepository.getInstancia();
		request.setCharacterEncoding("UTF-8");
		String btn = (request.getParameter("btn") == null ? "" : request.getParameter("btn"));
		String nombre = (request.getParameter("nombre") == null ? "" : request.getParameter("nombre"));
		String precio  = (request.getParameter("precio") == null ? "" : request.getParameter("precio"));
		String descuento = (request.getParameter("descuento") == null ? "" : request.getParameter("descuento"));
		HttpSession session = request.getSession();

		if("nuevoRegistro".equals(btn)) {
			//CONTROL POR SI EDITAN EL HTML Y MANDAN LOS DATOS VACIOS, SE CREAR UNA CLASE LIBRO NO VALIDAD EN SU TOTALIDAD
			Libro libro=null;
			try {
			 libro = new Libro(nombre, Double.parseDouble(precio), Integer.parseInt(descuento));
			}catch (Exception e) {
				libro= new Libro("", 0.0, 121);
			}

			if(libro.isValido()) {
				session.setAttribute("alertatexto", "El registro del nuevo libro se ha realizado correctamente");
				session.setAttribute("alertanivel", "success");
				dao.agregar(libro);
				response.sendRedirect(request.getContextPath() + "/");
				return;
			}else {
				session.setAttribute("alertatexto", "Ha habido algún error en el formulario. Revise los datos");
				session.setAttribute("alertanivel", "danger");
				request.setAttribute("libro", libro);
				request.setAttribute("primeravez", false);
				request.getRequestDispatcher(LIBRO_JSP).forward(request, response);
				return;
			}
			
		}else {
			session.setAttribute("alertatexto", "Ha habido una llamada no valida al servidor");
			session.setAttribute("alertanivel", "danger");
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
				
	}
}
