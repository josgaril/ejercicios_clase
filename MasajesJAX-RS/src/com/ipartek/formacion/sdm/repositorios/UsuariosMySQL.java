package com.ipartek.formacion.sdm.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.sdm.jaxrs.Usuario;

public class UsuariosMySQL {

	public Usuario ObtenerUsuario(Usuario usu) {
		//Usuario usuario = null;

		try (Connection con = getConexion()) { // Llamar al metodo getconexion o a la clase
			try (PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE nombre=? AND password=?")) {
				ps.setString(1, usu.getEmail());
				ps.setString(2, usu.getPassword());
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						return new Usuario(rs.getInt("idusuarios"), rs.getString("nombre"),
								rs.getString("password"));
					}else {
						return null;
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al acceder a los usuarios", e);
		}
	}

	private Connection getConexion() {
		try {
			new com.mysql.cj.jdbc.Driver();
			return DriverManager.getConnection(
					"url=jdbc:mysql://localhost:3306/masajes?serverTimezone=Europe/Madrid",
				   "usuario=root", 
				   "password=admin");
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la conexión a la base de datos,e");
		}
	}
}
