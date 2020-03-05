package com.ipartek.formacion.sdm.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	public int validar_ingreso() {
		
		/*
		 * String email = request.getParameter("usuario"); String password =
		 * request.getParameter("password");
		 */
		int resultado=0;
		 try(Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/masajes?serverTimezone=Europe/Madrid","root","admin")){
			 Statement s = conexion.createStatement();
			 ResultSet rs = s.executeQuery ("SELECT * FROM usuarios WHERE email=? AND password=?");
			 if (rs.next()) {
				 resultado=1;
			 }
		 }catch(SQLException e){
			throw new RuntimeException("Error al conetar a la bd y ver los ususarios",e); 
		 }
		return resultado;
	 }
	
	// Creamos un método que recibe 2 parametros, el nombre de usuario y la
	// contraseña
	public void Login(String email, String password){
	  
		 try{
		 //Obtenemos una referencia al driver de MySQL que nos permitirá realizar la conexión
			 new com.mysql.cj.jdbc.Driver();
		  
		 /*Creamos la conexión donde lo unico que se tiene que cambiar es el NOMBRE DE USUARIO Y LA CONTRASEÑA
		 del servidor, en este caso localhost para poder realizar las pruebas desde nuestra computadora, también se debe colocar el nombre de la base de datos, es este caso registros*/
		 Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/masajes?serverTimezone=Europe/Madrid","root","admin");
		  
		 Statement s = conexion.createStatement();
		  
		 //Aquí es donde realizamos una consulta para poder comparar los resultados de los parametros y la base de datos
		 ResultSet rs = s.executeQuery ("SELECT * FROM usuarios");
		  
		 while(rs.next()){
		 int valor = rs.getRow();
		 //Se el valor de usuario coincide con alguno de los usuarios registrados
		 if(rs.getString(valor).equals(email)){
		 valor++;
		 //Si el valor de la contraseña conincide con la del usuario
		 if(rs.getString(valor).equals(password)){
			 //Si todo es correcto, este mensaje aparecerá si se trata de un usuario registrado
		 	System.out.println("usuario registrado");
		 }
		 else{
			 	System.out.println("contraseña incorrecta");
		 }
		 break;
		 }
		 else{
			 	System.out.println("usuario registrado");
		 }
		 break;
		 }
		  
		 /*Cerramos la conexión que abrimos con la base de datos, es muy importante 
		 para no consumir recursos al terminar la conexión */
		 conexion.close();
		  
		 }
		 catch(Exception e){
		 e.printStackTrace();
		 }
	 }

}