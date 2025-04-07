package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class m_notice_listok {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql;	//SQL Query
	
	m_dbinfo db = new m_dbinfo();
	
	ArrayList<String> data = null; //각 컬럼별 값 저장
	ArrayList<ArrayList<String>> all = null; //DB전체 데이터 저장
	
	public ArrayList<ArrayList<String>> db_data(){
		
		try {
			this.con = db.getConnection();
			this.sql = "select midx, mtitle, mname, mdate, mview from notice "
					+ "order by nidx desc";
			this.rs = this.ps.executeQuery();
			
			this.all = new ArrayList<ArrayList<String>>();
			
			while(this.rs.next()) {
			this.data.add(this.rs.getString("midx"));
			this.data.add(this.rs.getString("mtitle"));
			this.data.add(this.rs.getString("mname"));
			this.data.add(this.rs.getString("mdate"));
			this.data.add(this.rs.getString("mview"));
			this.all.add(this.data);
			}
		}
		catch(Exception e) {
			this.all = null;
		}
		finally {
			try {
				this.ps.close();
				this.rs.close();
				this.con.close();
			}
			catch(Exception e) {
				this.all = null;
			}
		}
		
		return all;
	}
	
}
