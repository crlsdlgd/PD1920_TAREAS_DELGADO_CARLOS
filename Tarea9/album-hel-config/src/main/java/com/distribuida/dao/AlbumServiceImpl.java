package com.distribuida.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.dto.Album;


@ApplicationScoped
public class AlbumServiceImpl implements AlbumService {

	@Inject
	private DataSource dataSource;

	private Album toDto(ResultSet rs) throws SQLException {
		Album dto = new Album();
		dto.setId(rs.getInt("id"));
		dto.setSingerId(rs.getString("singer_id"));
		dto.setTitle(rs.getString("title"));
		dto.setReleaseDate(rs.getDate("release_date"));

		return dto;
	}

	/*
	 * @Override public Singer create(Singer singer) { em.getTransaction().begin();
	 * em.persist(singer); em.getTransaction().commit(); return singer; }
	 * 
	 * @Override public Singer update(Singer singer) { em.getTransaction().begin();
	 * em.merge(singer); em.getTransaction().commit(); return singer; }
	 * 
	 * @Override public void delete(Integer id) { em.getTransaction().begin();
	 * Singer singer = em.createQuery("SELECT u FROM Singer u WHERE id = :id",
	 * Singer.class).setParameter("id", id).getResultList().get(0);
	 * em.remove(singer); em.getTransaction().commit();
	 * 
	 * }
	 * 
	 */

	@Override
	public List<Album> findAll() {
		String sql = "select * from album";
		Connection con = null;
		List<Album> ret = new ArrayList<>();

		try {
			con = dataSource.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Album dto = toDto(rs);
				ret.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	@Override
	public Album findById(Integer id) {
		String sql = "select * from album where id=?";
		Connection con = null;
		Album dto = null;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				dto = toDto(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

}
