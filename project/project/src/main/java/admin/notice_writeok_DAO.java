package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//db처리(데이터 저장, 조회)
public class notice_writeok_DAO {
	
	Connection con = null; //db연결
	PreparedStatement ps = null; //전송객체
	m_dbinfo db = new m_dbinfo(); //db접속정보
	String sql = "";
	
	public int writedao(notice_DTO nd) throws SQLException {
		int dbresult = 0;
		
		try {
			this.con = db.getConnection(); //db연결
			this.sql = "insert into notice(midx, mtitle, mname, mtext, mnotice, mdate)"
					+ "values('0', ?, ?, ?, ?, now())";
			this.ps = this.con.prepareStatement(sql);
			this.ps.setString(1, nd.getMtitle());
			this.ps.setString(2, nd.getMname());
			this.ps.setString(3, nd.getMtext());
			this.ps.setString(4, nd.getMnotice());
			
			dbresult = ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			this.ps.close();
			this.con.close();
		}
		
		return dbresult;
	}
	
	public int fileok(notice_DTO nd) throws SQLException{
		
		try {
			
		}
		catch(Exception e) {
			
		}
		finally {
			this.ps.close();
			this.con.close();
		}
		
		return 0;
	}
	
}
