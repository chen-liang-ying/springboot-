package com.cf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cf.bean.Grade;

/**
 * 使用@Repository注解，标注这是一个持久化操作对象.
 */
@Repository
public class GradeDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public Grade selectByGradeNm(String gradeNm) {

		/**
		 * 1、定义一个Sql语句； 2、定义一个RowMapper. 3、执行查询方法.
		 */
		String sql = "select *from grade where grade_nm=?";
		RowMapper<Grade> rowMapper = new BeanPropertyRowMapper<>(Grade.class);
		Grade grade = jdbcTemplate.queryForObject(sql, new Object[] { gradeNm }, rowMapper);

		return grade;
	}

	@Transactional(readOnly = true)
	public List<Grade> findAll() {
		return jdbcTemplate.query("select * from grade", new GradeRowMapper());
	}

	@Transactional(readOnly = true)
	public Grade findGradeById(int id) {
		return jdbcTemplate.queryForObject("select * from grade where id=?", new Object[] { id }, new GradeRowMapper());
	}

	public Grade create(final Grade grade) {
		final String sql = "insert into grade(grade_nm,teacher_id) values(?,?)";

		KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//				ps.setString(1, grade.getGradeNm());
//				ps.setInt(2, grade.getTeacherId());
//				return ps;
//			}
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
				ps.setString(1, grade.getGradeNm());
				ps.setInt(2, grade.getTeacherId());
				return ps;
			}
		}, holder);

		int newGradeId = holder.getKey().intValue();
		grade.setId(newGradeId);
		return grade;
	}

	public void delete(final Integer id) {
		final String sql = "delete from grade where id=?";
		jdbcTemplate.update(sql, new Object[] { id }, new int[] { java.sql.Types.INTEGER });
	}

	public void update(final Grade grade) {
		jdbcTemplate.update("update grade set grade_nm=?,teacher_id=? where id=?",
				new Object[] { grade.getGradeNm(), grade.getTeacherId(), grade.getId() });
	}
}

class GradeRowMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grade g = new Grade();
		g.setId(rs.getInt("id"));
		g.setGradeNm(rs.getString("grade_nm"));
		g.setTeacherId(rs.getInt("teacher_id"));

		return g;
	}
}
