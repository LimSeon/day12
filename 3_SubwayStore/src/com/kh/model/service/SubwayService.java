package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.SubwayDao;
import com.kh.model.vo.Order;

public class SubwayService {

	public int insertOrder(Order order) {
		
		// Service단의 가장 큰 역할!! : Connection객체 만들기
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO 호출
		// => Connection객체, Controller로 전달받은 그 무언가를 같이 넘겨버리기
		int result = new SubwayDao().insertOrder(conn, order);
		
		// insert, update, delte를 하면 ~?
		// 테이블의 내용물이 바뀜 => 확정(COMMIT) / 돌아가기(ROLLBACK)
		// 트랜잭션 처리
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		// Connection객체 자원 반납
		JDBCTemplate.close(conn);
		
		return result;
	}

	public ArrayList<Order> selectOrderList() {
		
		// Service => Connection 객체 만들기
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Order> list = new SubwayDao().selectOrderList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
}