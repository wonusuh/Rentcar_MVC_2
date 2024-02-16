package com.basic.rentcar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.basic.rentcar.model.vo.CarVO;
import com.basic.rentcar.util.DBUtil;

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

	public CarVO getOneCar(int no) {
		CarVO bean = new CarVO();
		conn = DBUtil.getConnection();
		try {
			String sql = "SELECT * FROM rentcar WHERE no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("no == " + no);
				System.out.println("total qty == " + rs.getInt("total_qty"));
				bean.setNo(no);
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getInt("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setUsepeople(rs.getInt("usepeople"));
				bean.setTotalQty(rs.getInt("total_qty"));
				bean.setCompany(rs.getString("company"));
				bean.setImg(rs.getString("img"));
				bean.setInfo(rs.getString("info"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
		return bean;
	}

	public void addNewCar(CarVO vo) {
		conn = DBUtil.getConnection();
		String sql = "INSERT INTO rentcar VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getCategory());
			ps.setInt(3, vo.getPrice());
			ps.setInt(4, vo.getUsepeople());
			ps.setInt(5, vo.getTotalQty());
			ps.setString(6, vo.getCompany());
			ps.setString(7, vo.getImg());
			ps.setString(8, vo.getInfo());
			if (ps.executeUpdate() > 0) {
				System.out.println("차량을 등록했습니다.");
			} else {
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, ps, rs);
		}
	}
}
