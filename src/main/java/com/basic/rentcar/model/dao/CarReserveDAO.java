package com.basic.rentcar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.basic.rentcar.model.vo.CarReserveVO;
import com.basic.rentcar.util.DBUtil;

public class CarReserveDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	private CarReserveDAO() {
	}

	private static CarReserveDAO instance = new CarReserveDAO();

	public static CarReserveDAO getInstance() {
		return instance;
	}

	public void setReserveCar(CarReserveVO bean, int rentQty) {
		System.out.println(bean);

//		if (bean != null)
//			return;

		conn = DBUtil.getConnection();
		try {
			String sql = "INSERT INTO carreserve ( no, id, qty, dday, rday, " + "usein, usewifi, usenavi, useseat)"
					+ " VALUES( ?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bean.getNo());
			ps.setString(2, bean.getId());
			ps.setInt(3, bean.getQty());
			ps.setInt(4, bean.getDday());
			ps.setString(5, bean.getRday());
			ps.setInt(6, bean.getUsein());
			ps.setInt(7, bean.getUsewifi());
			ps.setInt(8, bean.getUsenavi());
			ps.setInt(9, bean.getUseseat());
			if (ps.executeUpdate() > 0) {
				updateRentcarQty(bean.getNo(), rentQty);
				System.out.println("차량 예약 완료");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
	}

	private void updateRentcarQty(int no, int rentQty) {
		conn = DBUtil.getConnection();

		try {
			String sql = "update rentcar set total_qty =total_qty - ? where no = ?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, rentQty);
			ps.setInt(2, no);

			ps.executeUpdate();

			System.out.println("수량 업데이트 완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
	}
}
