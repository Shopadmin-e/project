package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

// 회원가입 모델

public class insert_admin {
	Connection con = null;
	PreparedStatement ps = null;
	
	String sql = "";
	Integer result = null;
	
	m_dbinfo db = new m_dbinfo();
	
	public Integer insert_member(add_member m) {
		try {
			this.con = this.db.getConnection();
			this.sql = "insert into ad_join values ('0',?,?,?,?,?,?,?,?,?,now())";
			this.ps = this.con.prepareStatement(this.sql);
			
			this.ps.setString(1, m.getMid());
			this.ps.setString(2, m.getMpass());
			this.ps.setString(3, m.getMname());
			this.ps.setString(4, m.getMemail());
			this.ps.setString(5, m.getMtel1());
			this.ps.setString(6, m.getMtel2());
			this.ps.setString(7, m.getMtel3());
			this.ps.setString(8, m.getDep());
			this.ps.setString(9, m.getPos());

			this.result = this.ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				this.ps.close();
				this.con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		return this.result;
	}
}