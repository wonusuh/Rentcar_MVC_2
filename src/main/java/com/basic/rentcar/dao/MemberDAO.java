package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.basic.rentcar.util.DBUtil;
import com.basic.rentcar.vo.MemberVO;

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

	public MemberVO getMember(String id, String pw) {
		System.out.println("id= " + id + " pw=" + pw);
		conn = DBUtil.getConnection();
		try {
			String sql = "SELECT * FROM member WHERE id=? and pw=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();

			if (rs.next()) {
//			no INT auto_increment primary key, -- 고객 정보
//			id VARCHAR(20), 
//		    pw VARCHAR(20), 
//		    email VARCHAR(50), 
//		    tel VARCHAR(20),
//		    hobby VARCHAR(60),
//		    job VARCHAR(15),
//		    age VARCHAR(10),
//		    info VARCHAR(500)
				MemberVO vo = new MemberVO();
				vo.setNo(rs.getInt("no"));
				vo.setId(rs.getString("id"));
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
		return null;
	}
}
