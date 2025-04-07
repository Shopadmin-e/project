package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

// 데이터 추가하는 모델

public class m_adminok {
	Connection con = null;
	PreparedStatement ps = null;
	
	String sql;
	Integer result = null;
	
	m_dbinfo db = new m_dbinfo();
	
	public Integer allow_ok(allow_member m) {
		try {
			this.con = this.db.getConnection();
			this.sql = "insert into allow_ad values ('0',?,?,?,?,?,?,?,now())";
			this.ps = this.con.prepareStatement(this.sql);
			
			this.ps.setString(1, m.getAid());
			this.ps.setString(2, m.getApass());
			this.ps.setString(3, m.getAname());
			this.ps.setString(4, m.getAemail());
			this.ps.setString(5, m.getAtel());
			this.ps.setString(6, m.getAdep());
			this.ps.setString(7, m.getApos());
			
			this.result = this.ps.executeUpdate();
		}
		catch(Exception e) {
			this.result = null;
		}
		finally {
			try {
				this.ps.close();
				this.con.close();
			}
			catch(Exception e) {
				this.result = null;
			}
		}
		return this.result;
	}
}