package com.ipartek.formacion.mf0967_3.repositorios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.mf0967_3.modelos.Libro;

public class LibroMySQL implements Dao<Libro> {

	private static final String SQL_SELECT = "SELECT * FROM libreria";

	private static String url, usuario, password;

	// SINGLETON
	private static LibroMySQL instancia;

	private LibroMySQL(String url, String usuario, String password) {
		LibroMySQL.url = url;
		LibroMySQL.usuario = usuario;
		LibroMySQL.password = password;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado al driver de MySQL");
		}
	}

	public static LibroMySQL getInstancia(String pathConfiguracion) {
		try {
			if (instancia == null) {
				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));

				instancia = new LibroMySQL(configuracion.getProperty("mysql.url"),
						configuracion.getProperty("mysql.usuario"), configuracion.getProperty("mysql.password"));
			}

			return instancia;
		} catch (FileNotFoundException e) {
			throw new AccesoDatosException("Fichero de configuración no encontrado", e);
		} catch (IOException e) {
			throw new AccesoDatosException("Fallo de lectura/escritura al fichero", e);
		}
	}

	// FIN SINGLETON

	private Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("No se puede establecer la conexión con la base de datos", e);
		}
	}
	
	@Override
	public Iterable<Libro> obtenerTodos() {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_SELECT)) {
				try (ResultSet rs = ps.executeQuery()) {
					ArrayList<Libro> libros = new ArrayList<>();
					
					while (rs.next()) {
						libros.add(new Libro(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"),
								rs.getByte("descuento"), rs.getString("autor"), rs.getString("imagen")));
					}
					return libros;
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener todos los libros", e);
		}

	}



	@Override
	public Libro obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregar(Libro objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(Libro objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub

	}

}
