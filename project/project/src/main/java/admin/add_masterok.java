package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class add_masterok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;

	add_member dto = new add_member();	// DTO
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		this.pw = response.getWriter();
		
		try {
			String mpass = request.getParameter("mpass");
			mpass = new m_md5().md5_code(mpass);	// 비밀번호 암호화
			
			dto.setMid(request.getParameter("mid"));	// 아이디
			dto.setMpass(mpass);	// 비밀번호
			dto.setMname(request.getParameter("mname"));	// 이름
			dto.setMemail(request.getParameter("memail"));	// 이메일
			dto.setMtel1(request.getParameter("mtel1"));	// 010
			dto.setMtel2(request.getParameter("mtel2"));	// 전화번호 중간번호
			dto.setMtel3(request.getParameter("mtel3"));	// 전화번호 끝번호
			dto.setDep(request.getParameter("dep"));	// 담당자 부서
			dto.setPos(request.getParameter("pos"));	// 담당자 직책
			
			Integer result = new insert_admin().insert_member(dto);

			if(result > 0) {
				this.pw.write("<script>"
						+ "alert('가입이 완료 되었습니다. 로그인은 전산 담당자가 확인 후에 가능합니다.');"
						+ "location.href = './index.jsp';"
						+ "</script>");
			}
			else {
				this.pw.write("<script>"
						+ "alert('서비스 점검으로 인하여 가입이 완료되지 않았습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			this.pw.flush();
			this.pw.close();			
		}
	}
}