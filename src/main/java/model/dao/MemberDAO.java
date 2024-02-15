package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import com.basic.rentcar.util.DBUtil;

import model.vo.MemberVO;

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
				vo.setPw(rs.getString("pw"));
				vo.setEmail(rs.getString("email"));
				vo.setTel(rs.getString("tel"));
				vo.setHobby(rs.getString("hobby"));
				vo.setJob(rs.getString("job"));
				vo.setAge(rs.getString("age"));
				vo.setInfo(rs.getString("info"));
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
		return null;
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
