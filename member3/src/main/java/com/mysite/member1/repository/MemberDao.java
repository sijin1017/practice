package com.mysite.member1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.mysite.member1.model.Member;

@Repository
public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao() {}
	@Autowired
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Member member) {
		/*
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into member(id, email, password, name, " +
					"registerDate) values(seq_id.nextVal, ?, ?, ?, ?)";
				
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, member.getEmail());
				stmt.setString(2, member.getPassword());
				stmt.setString(3, member.getName());
				stmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				
				return stmt;
			}
		});
		*/
		
		jdbcTemplate.update(
			(Connection con) -> {
				String sql = "insert into member(id, email, password, name, " +
					"registerDate) values(seq_id.nextVal, ?, ?, ?, ?)";
				
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, member.getEmail());
				stmt.setString(2, member.getPassword());
				stmt.setString(3, member.getName());
				stmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				
				return stmt;
			}
		);	
	}
	
	// 같은 이메일주소가 있는지 확인
	public Member selectByEmail(String email) {
		String sql = "select * from member where email=?";
		/*
		Member mem = jdbcTemplate.query(sql, 
			new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, email);
				}
			}, 
			new ResultSetExtractor<Member>() {
				@Override
				public Member extractData(ResultSet rs) throws SQLException, DataAccessException {
					Member memDto = null;
					if(rs.next()) {
						memDto = new Member(rs.getString("name"), 
											rs.getString("email"),
											rs.getString("password"), 
											rs.getTimestamp("registerDate"));
						memDto.setId(rs.getLong("id"));
					}
					
					return memDto;
				}
			}
		);
		*/
		
		Member mem = jdbcTemplate.query(sql, 
				(PreparedStatement ps) -> {
					ps.setString(1, email);
				}, 
				(ResultSet rs) -> {
					Member memDto = null;
					if(rs.next()) {
						memDto = new Member(rs.getString("name"), 
											rs.getString("email"),
											rs.getString("password"), 
											rs.getTimestamp("registerDate"));
						memDto.setId(rs.getLong("id"));
					}
					
					return memDto;
				}
		);
		
		return mem;
	}
	
	// 전체 회원정보 조회
	public Collection<Member> selectAll(){
		String sql = "select * from member";
		
		/*
		List<Member> result = jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member memDto = new Member(	rs.getString("name"), 
											rs.getString("email"),
											rs.getString("password"), 
											rs.getTimestamp("registerDate"));
				memDto.setId(rs.getLong("id"));
				
				return memDto;
			}
		});
		*/
		
		List<Member> result = jdbcTemplate.query(sql, 
				(ResultSet rs, int rowNum) -> {
					Member memDto = new Member(	rs.getString("name"), 
												rs.getString("email"),
												rs.getString("password"), 
												rs.getTimestamp("registerDate"));
					memDto.setId(rs.getLong("id"));
				
					return memDto;
				}
		);
		
		return result;
	}
	
	// 패스워드 수정
	public void update(Member member) {
		String sql = "update member set password=? where email=?";
		jdbcTemplate.update(sql, member.getPassword(), member.getEmail());
	}
}













