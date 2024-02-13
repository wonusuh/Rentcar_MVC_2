package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basic.rentcar.vo.CarReserveVO;
import com.basic.rentcar.vo.CarViewVO;
import com.basic.rentcar.vo.RentcarVO;


public class RentcarDao {
	private RentcarDao() {
	}

	private static RentcarDao dao = new RentcarDao();

	public static RentcarDao getInstance() {
		return dao;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public Connection getConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/rentcardb01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String dbID = "root";
		String dbPassword = "Abcd123@";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public int getMember(String id, String pw) {

		System.out.println("id= " + id + " pw=" + pw);
		int result = 0; 

		conn = getConnection();
		try {

			String sql = "SELECT * FROM member WHERE id=? and pw=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbclose();
		}
		return result;
	}

	
	public ArrayList<RentcarVO> getSelectCar() {
		
		ArrayList<RentcarVO> v = new ArrayList<RentcarVO>();

		try {
			
			conn = getConnection();

			String sql = "SELECT * FROM rentcar ORDER BY no DESC";
			// String sql = "SELECT * FROM rentcar ORDER BY no DESC LIMIT 3";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			int count = 0;
			while (rs.next()) {

				RentcarVO bean = new RentcarVO();
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
			dbclose();
		}

		return v;
	}

	
	public RentcarVO getOneCar(int no) {
		
		RentcarVO bean = new RentcarVO();
		conn = getConnection();

		try {
			
			String sql = "SELECT * FROM rentcar WHERE no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("no=" + no );
				System.out.println("total qty=" + rs.getInt("total_qty"));
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
			dbclose();
		}
		return bean;
	}

	
	public void setReserveCar(CarReserveVO bean) {

		
		conn = getConnection();
		int num = 0;
		try {

			String sql = "INSERT INTO carreserve ( no, id, qty, dday, rday, "
					+ "usein, usewifi, usenavi, useseat)" + " VALUES( ?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, bean.getNo());
			pstmt.setString(2, bean.getId());
			pstmt.setInt(3, bean.getQty());
			pstmt.setInt(4, bean.getDday());
			pstmt.setString(5, bean.getRday());
			pstmt.setInt(6, bean.getUsein());
			pstmt.setInt(7, bean.getUsewifi());
			pstmt.setInt(8, bean.getUsenavi());
			pstmt.setInt(9, bean.getUseseat());

			if(pstmt.executeUpdate() > 0) {
				updateRentcarQty(bean.getNo() ,bean.getQty());
				System.out.println("차량 예약 완료");
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbclose();
		}
	}

	private void updateRentcarQty(int no , int rentQty) {
		conn = getConnection();

		try {
			String sql = "update rentcar set total_qty =total_qty - ? where no = ?";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, rentQty);
			pstmt.setInt(2, no);
		
			pstmt.executeUpdate();	
			
			System.out.println("수량 업데이트 완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbclose();
		}
	}
	public ArrayList<RentcarVO> getAllCar() {
		ArrayList<RentcarVO> v = new ArrayList<>();
		
		RentcarVO bean = null;

		conn = getConnection();
		try {
			String sql = "SELECT * FROM rentcar";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				bean = new RentcarVO();
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
			dbclose();
		}
		return v;

	}

	
	public ArrayList<RentcarVO> getCategoryCar(int cate) {

		ArrayList<RentcarVO> v = new ArrayList<>();
		
		RentcarVO bean = null;

		conn = getConnection();
		try {
			String sql = "SELECT * FROM rentcar WHERE category=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cate);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				bean = new RentcarVO();
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
			dbclose();
		}
		return v;
	}

	
	public ArrayList<CarViewVO> getAllReserve(String id) {

		ArrayList<CarViewVO> v = new ArrayList<>();
		CarViewVO bean = null;

		conn = getConnection();

		try {
			
			//select * from rentcar a2 ,carreserve a1  where a1.id = 'qwer' and curdate() < date_format(a1.rday , '%y-%m-%d') and a1.no = a2.no;
			// select * from rentcar a2 ,carreserve a1  where a1.id = 'qwer' and a1.no = a2.no;
			
			String sql = "select * from rentcar a2 ,carreserve a1  where a1.id = ? and a1.no = a2.no";
			System.out.println(id);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bean = new CarViewVO();
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
				System.out.println(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbclose();
		}

		return v;
	}

	
	public void carRemoveReserve(int reserveSeq ,int qty , int no) {

		conn = getConnection();
		try {
			String sql = "DELETE FROM carreserve where reserve_seq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserveSeq);
			if(pstmt.executeUpdate()> 0 ) {
				backRentcarQty(no, qty);
				System.out.println("삭제 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbclose();
		}
	}
	
	// 삭제하면 다시 토탈 car 다시 업데이트 되야함 
	
	private void backRentcarQty(int no , int rentQty) {
		conn = getConnection();

		try {
			String sql = "update rentcar set total_qty =total_qty + ? where no = ?";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, rentQty);
			pstmt.setInt(2, no);
		
			pstmt.executeUpdate();	
			
			System.out.println("rentQty= " + rentQty);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbclose();
		}
	}
	
	public void dbclose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		}
	}
	
}
