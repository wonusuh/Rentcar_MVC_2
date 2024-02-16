package com.basic.rentcar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.basic.rentcar.model.vo.CarViewVO;
import com.basic.rentcar.util.DBUtil;

public class CarViewDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	private CarViewDAO() {
	}

	private static CarViewDAO instance = new CarViewDAO();

	public static CarViewDAO getInstance() {
		return instance;
	}

	public ArrayList<CarViewVO> getAllReserve(String id) {
		ArrayList<CarViewVO> v = new ArrayList<>();
		conn = DBUtil.getConnection();
		String SQL = null;
		if (id.equals("admin")) {
			SQL = "SELECT * FROM rentcar a2 , carreserve a1  WHERE a1.no = a2.no";
		} else {
			SQL = "SELECT * FROM rentcar a2 , carreserve a1  WHERE a1.id = ? AND a1.no = a2.no";
		}
		try {
			ps = conn.prepareStatement(SQL);
			if (!id.equals("admin"))
				ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				CarViewVO bean = new CarViewVO();
				bean.setNo(rs.getInt("no"));
				bean.setReserveSeq(rs.getInt("reserve_seq"));
				bean.setName(rs.getString("name"));
				bean.setPrice(rs.getInt("price"));
				bean.setImg(rs.getString("img"));
				bean.setQty(rs.getInt("qty"));
				bean.setDday(rs.getInt("dday"));
				bean.setRday(rs.getString("rday"));
				bean.setUsein(rs.getInt("usein"));
				bean.setUsewifi(rs.getInt("usewifi"));
				bean.setUsenavi(rs.getInt("usenavi"));
				bean.setUseseat(rs.getInt("useseat"));
				v.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
		return v;
	}

	public void carRemoveReserve(int reserveSeq, int qty, int no) {
		conn = DBUtil.getConnection();
		try {
			String sql = "DELETE FROM carreserve where reserve_seq = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reserveSeq);
			if (ps.executeUpdate() > 0) {
				backRentcarQty(no, qty);
				System.out.println("삭제 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
	}

	public void backRentcarQty(int no, int rentQty) {
		conn = DBUtil.getConnection();
		try {
			String sql = "update rentcar set total_qty =total_qty + ? where no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rentQty);
			ps.setInt(2, no);
			ps.executeUpdate();
			System.out.println("rentQty= " + rentQty);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
	}
}
