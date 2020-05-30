package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.ipartek.formacion.model.Noticia;

public class NoticiaDAO implements IDAO<Noticia> {

	private static final Logger LOGGER = Logger.getLogger(NoticiaDAO.class.getCanonicalName());

	private static final String SQL_GET_ALL = 
			"SELECT id, titulo, fecha, contenido FROM noticia ORDER BY fecha DESC";

	private static NoticiaDAO INSTANCIA = null;
	
	public NoticiaDAO() {
		super();
	}
	
	public synchronized static NoticiaDAO getInstancia() {
		if (INSTANCIA == null) {
			INSTANCIA = new NoticiaDAO();
		}
		return INSTANCIA;
	}

	@Override
	public List<Noticia> getAll() {
		LOGGER.info("NoticiaDAO getAll()");
		
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();
		try(Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
			ResultSet rs = pst.executeQuery()){
			
			while (rs.next()) {
				noticias.add(mapper(rs));
			}
			
		}catch( SQLException e) {
			e.printStackTrace();
		}
		return noticias;
	}

	private Noticia mapper(ResultSet rs) throws SQLException {
		
		Noticia noticia = new Noticia();
		
		noticia.setId(rs.getInt("id"));
		noticia.setTitulo(rs.getString("titulo"));
		noticia.setFecha(rs.getTimestamp("fecha"));
		noticia.setContenido(rs.getString("contenido"));
		
		return noticia;		
	}

	@Override
	public Noticia getById(int id) throws Exception {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
	}

	@Override
	public Noticia insert(Noticia noticia) throws Exception, SQLException {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
	}

	@Override
	public Noticia update(Noticia noticia) throws Exception, SQLException {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
	}

	@Override
	public Noticia delete(int id) throws Exception {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
	}
	
	
}
