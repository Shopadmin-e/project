package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class admin_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	m_dbinfo db = new m_dbinfo();	// 데이터베이스
	add_member dto = new add_member();	// DTO
	HttpSession session = null;
	PrintWriter pw = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		this.pw = response.getWriter();
		
		this.session = request.getSession();
		
		if(this.session.getAttribute("id") == null) {	// 로그인하지 않고 사이트에 접속시
			this.pw.write("<script>"
					+ "alert('올바른 접근이 아닙니다.');"
					+ "location='./index.jsp';"
					+ "</script>");
		}
		else {	// 로그인하여 사이트에 접근시 
			String pageno = request.getParameter("pageno");	// 사용자가 클릭한 페이지 번호
			
			if(pageno == null || pageno.equals("1")) {	// 최초 게시판 접속시 페이지 배열 번호를 0으로 처리
				pageno = "0";
			}
			
			ArrayList<ArrayList<String>> alldata = new m_admin_list(Integer.parseInt(pageno)).db_data();
	
			request.setAttribute("alldata", alldata);
			request.setAttribute("pageno", pageno);
			
			RequestDispatcher rd = request.getRequestDispatcher("./admin_list.jsp");
			rd.forward(request, response);
		}
	}
}