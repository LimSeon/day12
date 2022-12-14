package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Order;

public class SubwayDao {
	// DAO단에서 항상 해야할 것
	// mapper 파일 연결
	// => 기본생성자
	private Properties prop = new Properties();
	
	public SubwayDao() {
		// mapper파일의 경로 담아주기
		String fileName = SubwayDao.class.getResource("/sql/subway/subway-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int insertOrder(Connection conn, Order order) {
		// INSERT -> int -> 트랜잭션 처리
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertOrder");
		
		try {
			// pstmt는 항상 conn객체로 만듬(쿼리문을 미리 넘김)
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, order.getUserName());
			pstmt.setString(2, order.getPhone());
			pstmt.setString(3, order.getAddress());
			pstmt.setString(4, order.getMessage());
			pstmt.setString(5, order.getSandwich());
			pstmt.setString(6, order.getVegetable());
			pstmt.setString(7, order.getSauce());
			pstmt.setString(8, order.getCookie());
			pstmt.setString(9, order.getPayment());
			pstmt.setInt(10, order.getPrice());
			
			// DML문은 executeUpdate() 호출
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public ArrayList<Order> selectOrderList(Connection conn) {
		
		// SELECT문 => ResultSet => 여러행(ArrayList, while문)
		
		// 필요한 변수들 셋팅
		ArrayList<Order> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOrderList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Order o = new Order(rset.getString("USER_NAME"),
									rset.getString("PHONE"),
									rset.getString("ADDRESS"),
									rset.getString("MESSAGE"),
									rset.getString("SANDWICH"),
									rset.getString("VEGETABLE"),
									rset.getString("SAUCE"),
									rset.getString("COOKIE"),
									rset.getString("PAYMENT"),
									rset.getInt("PRICE"),
									rset.getDate("ORDER_DATE"));
				list.add(o);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
}
