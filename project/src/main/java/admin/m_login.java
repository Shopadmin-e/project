package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class m_login {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql;
	
	m_dbinfo db = new m_dbinfo();
	allow_member dto = new allow_member();
	
	ArrayList<String> data = null;
	
	public ArrayList<String> admin_login(allow_member dto){
		try {
			this.con = this.db.getConnection();
			
			this.sql = "select aid, apass, aname from allow_ad where aid=? and apass=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, dto.getAid());
			this.ps.setString(2, dto.getApass());
			this.rs = this.ps.executeQuery();
			
			this.data = new ArrayList<String>();

			if(this.rs.next()) {
				this.data.add(this.rs.getString("aid"));	// 아이디
				this.data.add(this.rs.getString("apass"));	// 비밀번호
				this.data.add(this.rs.getString("aname"));	// 이름
			}
		}
		catch(Exception e) {
			this.data = null;
		}
		finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			}
			catch(Exception e) {
				this.data = null;
			}
		}
		return this.data;
	}
}
