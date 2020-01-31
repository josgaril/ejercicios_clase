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

class LibroMySQL implements Dao<Libro> {
	private static final String SQL_SELECT = "SELECT * FROM libreria";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM libreria WHERE id = ?";

	private static final String SQL_INSERT = "INSERT INTO libreria (nonbre,precio,descuento,autor,imagen) VALUES (?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE libreria SET nombre=?, precio=?, descuento=?, autor=?, imagen=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM librerias WHERE id=?";

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
			throw new AccesoDatosException("No se ha encontrado al driver de MySQL", e);
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

	private Connection getConnection() {
		try {
			return DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la conexión a la base de datos", e);
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
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_BY_ID)) {
				ps.setLong(1, id);

				try (ResultSet rs = ps.executeQuery()) {

					if (rs.next()) {
						return new Libro(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"),
								rs.getByte("descuento"), rs.getString("autor"), rs.getString("imagen"));
					} else {
						return null;
					}
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener el libro id" + id, e);
		}

	}

	@Override
	public void agregar(Libro libro) {

		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
				ps.setString(1, libro.getNombre());
				ps.setBigDecimal(2, libro.getPrecio());
				ps.setByte(3, libro.getDescuento());
				ps.setString(4, libro.getAutor());
				ps.setString(5, libro.getImagen());

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una insert");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al insertar el libro", e);
		}
	}

	@Override
	public void modificar(Libro libro) {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
				ps.setString(1, libro.getNombre());
				ps.setBigDecimal(2, libro.getPrecio());
				ps.setByte(3, libro.getDescuento());
				ps.setString(4, libro.getAutor());
				ps.setString(5, libro.getImagen());
				ps.setLong(6, libro.getId());
				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una update");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al modificar el libro", e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
				ps.setLong(1, id);

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho mas o menos de un delete");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al borrar el libro", e);

		}
	}

}
