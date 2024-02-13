package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.basic.rentcar.util.DBUtil;
import com.basic.rentcar.vo.CarVO;

public class CarDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	private CarDAO() {
	}

	private static CarDAO instance = new CarDAO();

	public static CarDAO getInstance() {
		return instance;
	}

	public ArrayList<CarVO> getSelectCar() {
		ArrayList<CarVO> v = new ArrayList<CarVO>();
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM rentcar ORDER BY no DESC";
			// String sql = "SELECT * FROM rentcar ORDER BY no DESC LIMIT 3";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				CarVO bean = new CarVO();
				bean.setNo(rs.getInt("no"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getInt("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setUsepeople(rs.getInt("usepeople"));
				bean.setTotalQty(rs.getInt("total_qty"));
				bean.setCompany(rs.getString("company"));
				bean.setImg(rs.getString("img"));
				bean.setInfo(rs.getString("info"));
				v.add(bean);
				count++;
				if (count > 2)
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
		return v;
	}

	public ArrayList<CarVO> getCategoryCar(int cate) {
		ArrayList<CarVO> v = new ArrayList<>();
		CarVO bean = null;
		conn = DBUtil.getConnection();
		try {
			String sql = "SELECT * FROM rentcar WHERE category=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cate);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new CarVO();
				bean.setNo(rs.getInt("no"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getInt("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setUsepeople(rs.getInt("usepeople"));
				bean.setTotalQty(rs.getInt("total_qty"));
				bean.setCompany(rs.getString("company"));
				bean.setImg(rs.getString("img"));
				bean.setInfo(rs.getString("info"));
				v.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
		return v;
	}

	public ArrayList<CarVO> getAllCar() {
		ArrayList<CarVO> v = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			String sql = "SELECT * FROM rentcar";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CarVO bean = new CarVO();
				bean.setNo(rs.getInt("no"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getInt("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setUsepeople(rs.getInt("usepeople"));
				bean.setTotalQty(rs.getInt("total_qty"));
				bean.setCompany(rs.getString("company"));
				bean.setImg(rs.getString("img"));
				bean.setInfo(rs.getString("info"));

				v.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
		return v;
	}
}
