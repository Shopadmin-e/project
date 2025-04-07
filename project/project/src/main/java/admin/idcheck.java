package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 아이디 중복체크

public class idcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	PrintWriter pw = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		
		this.pw = response.getWriter();
		
		try {
			String id = request.getParameter("mid");
			
			if(id.equals("")) {
				msg = "error";
			}
			else {
				m_dbinfo db = new m_dbinfo();
				this.con = db.getConnection();	// DB 연결
				
				this.sql = "select count(*) as ctn from allow_ad where aid=?";
				this.ps = this.con.prepareStatement(this.sql);
				this.ps.setString(1, id);
				this.rs = this.ps.executeQuery();
				
				if(rs.next() == true) {	// 정상적으로 Query 문이 작동되었을 경우
					if(rs.getString("ctn").equals("0")) {	// 해당 데이터가 없을 경우
						msg = "ok";
					}
					else {	// 검색한 데이터가 있을 경우
						msg = "no";
					}
				}
				else {
					msg = "error";
				}
			}
			pw.write(msg);
		}
		catch(NullPointerException e) {	// Front-end가 올바른 값을 전달하지 않을 경우
			msg = "error";
			pw.write(msg);
		}
		catch(Exception e) {	// ok : 사용가능한 아이디, no : 사용 불가능한 아이디, error : 데이터 오류
			msg = "error";
			pw.write(msg);
		}
		finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
				this.pw.close();
			}
			catch(Exception e) {
				System.out.println("error");
			}
		}
	}
}