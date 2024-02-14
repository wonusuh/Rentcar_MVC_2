//package com.basic.rentcar.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import com.basic.rentcar.vo.CarReserveVO;
//import com.basic.rentcar.vo.CarViewVO;
//import com.basic.rentcar.vo.RentcarVO;
//
//public class TempRentcarDao {
//	private TempRentcarDao() {
//	}
//
//	private static TempRentcarDao dao = new TempRentcarDao();
//
//	public static TempRentcarDao getInstance() {
//		return dao;
//	}
//
//	public ArrayList<CarViewVO> getAllReserve(String id) {
//
//		ArrayList<CarViewVO> v = new ArrayList<>();
//		CarViewVO bean = null;
//
//		conn = getConnection();
//
//		try {
//
//			// select * from rentcar a2 ,carreserve a1 where a1.id = 'qwer' and curdate() <
//			// date_format(a1.rday , '%y-%m-%d') and a1.no = a2.no;
//			// select * from rentcar a2 ,carreserve a1 where a1.id = 'qwer' and a1.no =
//			// a2.no;
//
//			String sql = "select * from rentcar a2 ,carreserve a1  where a1.id = ? and a1.no = a2.no";
//			System.out.println(id);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				bean = new CarViewVO();
//				bean.setNo(rs.getInt("no"));
//				bean.setReserveSeq(rs.getInt("reserve_seq"));
//				bean.setName(rs.getString("name"));
//				bean.setPrice(rs.getInt("price"));
//				bean.setImg(rs.getString("img"));
//				bean.setQty(rs.getInt("qty"));
//				bean.setDday(rs.getInt("dday"));
//				bean.setRday(rs.getString("rday"));
//				bean.setUsein(rs.getInt("usein"));
//				bean.setUsewifi(rs.getInt("usewifi"));
//				bean.setUsenavi(rs.getInt("usenavi"));
//				bean.setUseseat(rs.getInt("useseat"));
//				v.add(bean);
//				System.out.println(bean);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			dbclose();
//		}
//
//		return v;
//	}
//
//	public void carRemoveReserve(int reserveSeq, int qty, int no) {
//
//		conn = getConnection();
//		try {
//			String sql = "DELETE FROM carreserve where reserve_seq = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, reserveSeq);
//			if (pstmt.executeUpdate() > 0) {
//				backRentcarQty(no, qty);
//				System.out.println("삭제 완료");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			dbclose();
//		}
//	}
//
//	// 삭제하면 다시 토탈 car 다시 업데이트 되야함
//
//	private void backRentcarQty(int no, int rentQty) {
//		conn = getConnection();
//
//		try {
//			String sql = "update rentcar set total_qty =total_qty + ? where no = ?";
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setInt(1, rentQty);
//			pstmt.setInt(2, no);
//
//			pstmt.executeUpdate();
//
//			System.out.println("rentQty= " + rentQty);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			dbclose();
//		}
//	}
//
//}
