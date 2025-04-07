package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

// ad_join 테이블 데이터 삭제하는 모델

public class m_add_del {
	Connection con = null;
	PreparedStatement ps = null;
	Integer result = null;
	
	String sql;
	
	m_dbinfo db = new m_dbinfo();
	
	public Integer admin_del(Integer n){
		try {
			this.con = this.db.getConnection();
			
			this.sql = "delete from ad_join where midx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, n);
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
		return result;
	}
}