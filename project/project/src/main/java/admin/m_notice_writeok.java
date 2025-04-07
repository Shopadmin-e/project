package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

//파일 저장
public class m_notice_writeok {

	Connection con = null;
	PreparedStatement ps = null;
	
	m_dbinfo db = new m_dbinfo(); 
	
	String sql = "";
	int dbresult = 0;
	
	String msg = "";
	

	String mtitle, mname, mtext, mnotice;
	
	//즉시 실행 메소드에서 첨부파일을 저장하는 역활만 합니다.
	public m_notice_writeok(Part mfile, String mtitle, String mname, String mtext, String mnotice, HttpServletRequest request) throws Exception {

		this.mtitle = mtitle;
		this.mname = mname;
		this.mtext = mtext;
		this.mnotice = mnotice;
		
		//파일 용량
		long filesize = mfile.getSize();
		//파일명
		String mfilenm = mfile.getSubmittedFileName();
		//첨부파일 저장될 Web Directory 설정
		String url = request.getServletContext().getRealPath("/notice_file/");
		System.out.println(url);
		try {
			mfile.write(url + mfilenm);	//웹에 저장
			this.fileok(mfilenm);	//정상적으로 저장 되었을 경우
		}catch (Exception e) {
			this.fileok("error");	//비정상적으로 해당 디렉토리에 파일이 저장되지 않을 경우
		}
	}
	
	public String fileok(String data) throws Exception{
		if(data.equals("error")) {
			this.msg = "error";
		}
		else {
			
		try {
			this.con = this.db.getConnection(); //db연결
			this.sql = "insert into notice(midx, mtitle, mname, mfilenm, mfile, mtext, mnotice, mdate)"
					+ "values('0', ?, ?, ?, ?, ?, ?, now())";
			this.ps = this.con.prepareStatement(sql);
			this.ps.setString(1, this.mtitle);
			this.ps.setString(2, this.mname);
			this.ps.setString(3, data);
			this.ps.setString(4, data);
			this.ps.setString(5, this.mtext);
			this.ps.setString(6, this.mnotice);
			
			dbresult = ps.executeUpdate();
			if(this.dbresult > 0) {
				this.msg = "ok";
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			this.ps.close();
			this.con.close();
		}
		
	}
		return this.msg;
	}
}
