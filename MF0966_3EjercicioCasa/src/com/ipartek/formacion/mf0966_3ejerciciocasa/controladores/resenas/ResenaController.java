package com.ipartek.formacion.mf0966_3ejerciciocasa.controladores.resenas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0966_3ejerciciocasa.controladores.Globales;

@WebServlet("/admin/resena")
public class ResenaController extends HttpServlet {
	private static final String RESENA_FORMULARIO = "/WEB-INF/vistas/admin/formularioResena.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		String codigo = request.getParameter("codigo");
		String codCurso = request.getParameter("codCurso");

		if (codigo != null && codigo.trim().length() > 0) {
			request.setAttribute("resena", Globales.daoResena.obtenerPorCodigo(Integer.parseInt(codigo)));
		}

		request.setAttribute("alumnos", Globales.daoAlumno.obtenerTodos());
		request.setAttribute("cursos", Globales.daoCurso.obtenerTodosRealizados());

		request.setAttribute("op", op);
		request.setAttribute("codCurso", codCurso);
		request.setAttribute("primeravez", true);
		request.getRequestDispatcher(RESENA_FORMULARIO).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
