package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//controller
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2, //5MB
//		maxFileSize = 1024 * 1024 * 50,	//최대용량 50MB
		maxRequestSize = 1024 * 1024 * 500
	)
public class notice_writeok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection con = null;
	PreparedStatement ps = null;
	PrintWriter pw = null;
	
	m_dbinfo db = new m_dbinfo();
	notice_DTO nd = new notice_DTO();
	notice_writeok_DAO wd = null;
	m_notice_writeok nw = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 페이지 이동만 처리
	    RequestDispatcher rd = request.getRequestDispatcher("./notice_writeok.jsp");
	    rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		
		//첨부파일 있고, 없고 따라서 SQL 저장방식 변경됨
		Part mfile = request.getPart("mfile");
		long filesize = mfile.getSize();
				
		try {
		
			this.con = this.db.getConnection(); //db연결
			
			//사용자가 입력한 값을 받음
			String mtitle = request.getParameter("mtitle");
			String mname = request.getParameter("mname");
			String mtext = request.getParameter("mtext");
			String mnotice = request.getParameter("mnotice");
		
			if(mnotice != null) {
				mnotice = "Y";
			}
			else {
				mnotice = "N";
			}
			
			//받아온 값 dto에 추가
			this.nd.setMtitle(mtitle);
			this.nd.setMname(mname);
			this.nd.setMtext(mtext);
			this.nd.setMnotice(mnotice);
			
			//controller - dao 연결
			wd = new notice_writeok_DAO();
			
			//notice_writeok_DAO에서 writedao에서 dto를 사용하여 db에 insert한 값 받아옴 
			int dbresult = wd.writedao(this.nd);

		if(filesize==0) {

			//결과 확인
			if(dbresult > 0) { //파일이 없을 경우
				this.pw.write("<script>"
						+ "alert('게시물이 올바르게 등록 되었습니다.');"
						+ "location.href = './notice_listok.do';"
						+ "</script>");
			}
		}
			else { //파일이 있을 경우
				m_notice_writeok nw = new m_notice_writeok(mfile, mtitle, mname, mtext, mnotice, request);
				String msg = nw.msg;
				
				
				
				if(msg.equals("ok")){
					this.pw.write("<script>"
							+ "alert('올바르게 공지사항이 등록 되었습니다.');"
							+ "location.href = './notice_listok.do';"
							+ "</script>");
				}
				else {
					//오류나던거 파일 저장 url을 받아 폴더를 만들어주니 해결되었음
					this.pw.write("<script>"
							+ "alert('Database 및 첨부파일 오류 발생!!');"
							+ "history.go(-1);"
							+ "</script>");
				}
			}
		}
		catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('데이터베이스 문제로 인하여 저장되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		finally {
			try {
				this.con.close();
				this.pw.close();
			}
			catch(Exception e) {
				
			}
		}
		
	}

}
