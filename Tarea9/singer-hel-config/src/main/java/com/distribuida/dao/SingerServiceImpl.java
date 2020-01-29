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

import com.distribuida.dto.Singer;


@ApplicationScoped
public class SingerServiceImpl implements SingerService {

	@Inject
	private DataSource dataSource;

	private Singer toDto(ResultSet rs) throws SQLException {
		Singer dto = new Singer();
		dto.setId(rs.getInt("id"));
		dto.setFirstName(rs.getString("first_name"));
		dto.setLastName(rs.getString("last_name"));
		dto.setBirthDate(rs.getDate("birth_date"));

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
	public List<Singer> findAll() {
		String sql = "select * from singer";
		Connection con = null;
		List<Singer> ret = new ArrayList<>();

		try {
			con = dataSource.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Singer dto = toDto(rs);
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
	public Singer findById(Integer id) {
		String sql = "select * from singer where id=?";
		Connection con = null;
		Singer dto = null;
		
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
