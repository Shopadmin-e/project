package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_listok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//list를 출력하기 위해 db table을 로드하는 model 연결
		m_notice_listok nl = new m_notice_listok();
		
		//2차 배열 result에 m_notice_listok.java db_data의 값을 넣음
		ArrayList<ArrayList<String>> result = nl.db_data();
		
		//JSP로 2차 클래스 배열 값을 전달(View)
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("./notice_listok.jsp");
		rd.forward(request, response);
	}

}
