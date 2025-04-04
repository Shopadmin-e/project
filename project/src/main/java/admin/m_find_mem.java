package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// 데이터 가져오는 모델

public class m_find_mem {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql;
	
	m_dbinfo db = new m_dbinfo();
	
	ArrayList<String> member = null;
	
	public ArrayList<String> find_mem(Integer n) {
		try {
			this.con = this.db.getConnection();
			
			this.sql = "select * from ad_join where midx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, n);
			this.rs = this.ps.executeQuery();
			
			if(this.rs.next()) {
				this.member = new ArrayList<String>();
				this.member.add(this.rs.getString("mid"));
				this.member.add(this.rs.getString("mpass"));
				this.member.add(this.rs.getString("mname"));
				this.member.add(this.rs.getString("memail"));
				this.member.add(this.rs.getString("mtel1"));
				this.member.add(this.rs.getString("mtel2"));
				this.member.add(this.rs.getString("mtel3"));
				this.member.add(this.rs.getString("dep"));
				this.member.add(this.rs.getString("pos"));
				this.member.add(this.rs.getString("mdate"));
			}
			else {
				this.member = null;
			}
		}
		catch(Exception e) {
			this.member = null;
		}
		finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			}
			catch(Exception e) {
				this.member = null;
			}
		}
		return this.member;
	}
}
