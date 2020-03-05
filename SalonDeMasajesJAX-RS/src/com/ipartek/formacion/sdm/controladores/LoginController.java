package com.ipartek.formacion.sdm.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.sdm.modelos.Mensaje;
import com.ipartek.formacion.sdm.repositorios.AccesoDatosException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final String LOGIN_JSP = "/WEB-INF/vistas/login.jsp";

	private static final long serialVersionUID = 1L;
	// private String urlbd, usuariobd, passwordbd;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String email = request.getParameter("usuario");

		

		try (Connection conexion = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/masajes?serverTimezone=Europe/Madrid", "root", "admin")) {
			
			try (PreparedStatement ps = conexion
					.prepareStatement("SELECT * FROM usuarios WHERE email=? AND password=?")) {
				ps.setString(1, email);
				ps.setString(2, password);
				
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						request.getSession().setAttribute("usuario", email);
						request.getRequestDispatcher("/admin/index").forward(request, response);
					} else {
						request.setAttribute("usuario", email);
						request.setAttribute("mensaje", new Mensaje("Login incorrecto", Mensaje.Nivel.ERROR));

						request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros", e);
				}
				
			} catch (SQLException e) {
				throw new AccesoDatosException("Error al crear la sentencia", e);
			}
			
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar a la base de datos", e);
		}

	}

	/*
	 * if("administrador".equals(usuario) &&
	 * "123456".equals(password)||("cliente".equals(usuario) &&
	 * "112233".equals(password))) { request.getSession().setAttribute("usuario",
	 * usuario); request.getRequestDispatcher("/admin/index").forward(request,
	 * response); } else { request.setAttribute("usuario", usuario);
	 * request.setAttribute("mensaje", new Mensaje("Login incorrecto",
	 * Mensaje.Nivel.ERROR));
	 * 
	 * request.getRequestDispatcher(LOGIN_JSP).forward(request, response); }
	 */
}
