package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 로그인 session

public class admin_loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;
	allow_member dto = new allow_member();	// 회원 정보 DTO
	HttpSession session = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		this.pw = response.getWriter();
		
		try {
			String mpass = new m_md5().md5_code(request.getParameter("mpass"));	// 사용자가 입력한 값 암호화		
			
			this.dto.setAid(request.getParameter("mid"));
			this.dto.setApass(mpass);
			
			ArrayList<String> data = new m_login().admin_login(dto);
			
			if(data.isEmpty()) {	// 아이디가 없을 경우
				this.pw.write("<script>"
						+ "alert('아이디 및 비밀번호를 확인해주세요.');"
						+ "location='./index.jsp';"
						+ "</script>");
			}
			else {	// 아이디 및 비밀번호가 있을 경우
				this.session = request.getSession();	// 세션 생성
				this.session.setAttribute("id", data.get(0));	// 아이디를 세션에 등록
				this.session.setAttribute("name", data.get(2));	// 이름을 세션에 등록
				
				this.pw.write("<script>"
						+ "alert('로그인 되었습니다.');"
						+ "location='./admin_list.do';"
						+ "</script>");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			this.pw.close();
		}
	}
}