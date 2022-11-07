package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.service.SubwayService;
import com.kh.model.vo.Order;

/**
 * Servlet implementation class SubwayOrderController
 */
@WebServlet("/order.do")
public class SubwayOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubwayOrderController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get으로 보냈는지 post보냈는지 생각
		// 1) POST방식일때만 => 인코딩
		
		// 2) 뽑기 => request의 Parameter영역(request.getParameter("키값") / request.getParameterValues("키값"))
		// 뽑아서 변수에 담아야함!
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		
		// 주문 정보 뽑기
		String sandwich = request.getParameter("sandwich");
		// checkbox == request.getParameterValues(); => String[] => 체크된게 하나도 없을 때 null
		String[] vegetable = request.getParameterValues("vegetable");
		String[] sauce = request.getParameterValues("sauce");
		String[] cookie = request.getParameterValues("cookie");
		String payment = request.getParameter("payment");
		
		// 3) 가공 => VO클래스 객체생성해서 거기 담았음
		
		// 요청처리 간단하게
		int price = 0; // 지역변수는 항상 초기화
		// 가격책정
		
		// 샌드위치에 따른 기본가격
		
		switch(sandwich) {
		case "스테이크 & 치즈" : price += 6900; break;
		case "로티세리 바비큐 치킨" : price += 6800; break;
		case "스파이시 바비큐" :  price += 6400; break;
		case "K-바비큐" : price += 6300; break;
		case "풀드 포크 바비큐" : price += 6200; break;
		case "머쉬룸" : price += 5600; break;
		case "쉬림프" : price += 5500; break;
		case "로스트 치킨" : price += 6100; break;
		case "치킨 데리야끼" : price += 5700; break;
		case "서브웨이 클럽" : price += 5800; break;
		case "치킨 슬라이스" : price += 5600; break;
		case "참치" : price += 4400; break;
		case "에그마요" : price += 4500; break;
		case "이탈리안 비엠티" : price += 6200; break;
		case "터키 베이컨 아보카도" : price += 6600; break;
		}
		// 쿠키 종류에 따라서 추가금액 더하기
		// 배열의 경우 체크된게 없을 때 null이기 때문에
		// 무작정 반복문을 돌리면 NullPoninterException 발생할 가능성이 있음
		if(cookie != null){
			for(int i = 0; i < cookie.length; i++) {
				switch(cookie[i]) {
				case "라즈베리치즈케잌" :
				case "더블초코칩쿠키" :
				case "스모어초코어쩌고" : price += 2300; break;
				}
			}
		}
		
		// 값다 뽑았다!!! => VO객체에 담기
		Order order = new Order(userName,
								phone,
								address,
								message,
								sandwich,
								String.join(",", vegetable),
								String.join(",", sauce),
								String.join(",", cookie),
								payment,
								price,
								null);
		
		// 4) Service단으로 토스~ => 결과값
		int result = new SubwayService().insertOrder(order);
		
		// 수하물 붙이기 => request의 Attribute영역에 담기
		request.setAttribute("sandwich", sandwich);
		request.setAttribute("vegetable", vegetable);
		request.setAttribute("sauce", sauce);
		request.setAttribute("cookie", cookie);
		request.setAttribute("payment", payment);
		request.setAttribute("price", price);
		
		// 응답 뷰 지정 => 응답화면 jsp파일로 하나만들어서 보내기
		// WebContent/views/~~~.jsp
		// 포워딩방식으로!
		
		if(result > 0) {
			RequestDispatcher view = request.getRequestDispatcher("views/result.jsp");
			view.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
