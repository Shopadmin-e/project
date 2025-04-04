package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adminno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		this.pw = response.getWriter();
		
		Integer num = Integer.parseInt(request.getParameter("midx"));
		// System.out.println(num);
		
		Integer result = new m_add_del().admin_del(num);
		// System.out.println(result);
		
		if(result > 0) {
			this.pw.write("ok");

		}
		else {
			this.pw.write("no");
		}
		this.pw.close();
	}
}