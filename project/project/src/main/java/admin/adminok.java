package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adminok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;
	
	allow_member dto = new allow_member();	// 승인 DTO
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		this.pw = response.getWriter();
		
		try {
			Integer num = Integer.parseInt(request.getParameter("midx"));
			// System.out.println(num);

			ArrayList<String> member = new m_find_mem().find_mem(num);
			
			String atel = member.get(5) + member.get(6) + member.get(7);
			
			dto.setAid(member.get(0));
			dto.setApass(member.get(1));
			dto.setAname(member.get(2));
			dto.setAemail(member.get(3));
			dto.setAtel(atel);
			dto.setAdep(member.get(7));
			dto.setApos(member.get(8));
			dto.setAdate(member.get(9));
			
			Integer result = new m_adminok().allow_ok(dto);
			// System.out.println(result);
			
			if(result > 0) {
				Integer result2 = new m_add_del().admin_del(num);
				// System.out.println(result2);
				
				if(result2 > 0) {
					this.pw.write("ok");				
				}
			}
			else {
				this.pw.write("no");
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