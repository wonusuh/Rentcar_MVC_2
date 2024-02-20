package com.basic.rentcar.model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.basic.rentcar.model.vo.MemberVO;
import com.basic.rentcar.util.DBUtil;

public class MemberDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	private static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "com/basic/rentcar/mybatis/config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MemberVO getMember(String id, String pw) {
		Map<String, String> params = new HashMap<>();
		params.put("id", id);
		params.put("pw", pw);
		SqlSession session = sqlSessionFactory.openSession();
		MemberVO member = session.selectOne("getMember", params);
		System.out.println(member);
		return member;
	}

	public String checkMemberId(String id) {
		String SQL = "select pw from member where id=?";
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
		return null;
	}

	public int memberInsert(MemberVO vo) {
		conn = DBUtil.getConnection();
		String SQL = "INSERT INTO member VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPw());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getTel());
			ps.setString(5, vo.getHobby());
			ps.setString(6, vo.getJob());
			ps.setString(7, vo.getAge());
			ps.setString(8, vo.getInfo());
			if (ps.executeUpdate() > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
		return 0;
	}

	public ArrayList<int[]> getReturnedCarsList(String id) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		conn = DBUtil.getConnection();
		String sql = "SELECT * FROM carreserve WHERE id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				int[] arr = { rs.getInt("no"), rs.getInt("qty") };
				System.out.println(Arrays.toString(arr));
				list.add(arr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
		return list;
	}

	public int deleteAllReservationById(String id) {
		conn = DBUtil.getConnection();
		String SQL = "DELETE FROM carreserve WHERE id=?";
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			if (ps.executeUpdate() > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
		return 0;
	}

	public int deleteUserFromDB(MemberVO vo) {
		conn = DBUtil.getConnection();
		String SQL = "DELETE FROM member WHERE no=?";
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, vo.getNo());
			if (ps.executeUpdate() > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
		return 0;
	}
}
