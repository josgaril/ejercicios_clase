package Ejercicios.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculadora
 */
@WebServlet("/calculadora")
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		String op = request.getParameter("op");

		double numero1 = Double.parseDouble("op1");
		double numero2 = Double.parseDouble("op2");
		
		double resultado =0;
		switch(op)
		{
		case "s": resultado= numero1 + numero2; break;
		case "-": resultado= numero1 - numero2; break;
		case "*": resultado= numero1 * numero2; break;
		case "/": resultado= numero1 / numero2; break;
		default: out.println("Operación no reconocida"); return;
		}
		//Arreglar esto
		out.print("Resultado: ");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
