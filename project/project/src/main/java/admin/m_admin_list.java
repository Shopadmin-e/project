package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class m_admin_list {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql;
	
	m_dbinfo db = new m_dbinfo();
	
	ArrayList<String> data = null;	// 각 컬럼 값을 저장
	ArrayList<ArrayList<String>> alldata = null;	// 데이터베이스의 전체 데이터를 저장
	
	Integer spage = 0;	// 첫번째 배열 값
	Integer epage = 8;	// 한 페이지 당 8개의 데이터 출력
	
	public m_admin_list(int s) {
		if(s > 0) {	// 1번 페이징 번호 외에 다른 번호 클릭했을 경우
			this.spage = (s - 1) * epage;
		}
		else {	// 1번 페이징 번호를 클릭했을 경우
			this.spage = s;
		}
	}

	public ArrayList<ArrayList<String>> db_data(){
		try {
			this.con = this.db.getConnection();
			
			this.sql = "select midx, mname, mid, mtel1, mtel2, mtel3, memail, dep, pos, mdate, (select count(*) from ad_join) as total "
					+ "from ad_join order by midx desc limit ?,?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, this.spage);
			this.ps.setInt(2, this.epage);
			this.rs = this.ps.executeQuery();
			
			this.alldata = new ArrayList<ArrayList<String>>();
			
			while(this.rs.next()) {
				this.data = new ArrayList<String>();
				
				this.data.add(String.valueOf(this.rs.getInt("midx")));
				this.data.add(this.rs.getString("mname"));
				this.data.add(this.rs.getString("mid"));
				this.data.add(this.rs.getString("mtel1"));
				this.data.add(this.rs.getString("mtel2"));
				this.data.add(this.rs.getString("mtel3"));
				this.data.add(this.rs.getString("memail"));
				this.data.add(this.rs.getString("dep"));
				this.data.add(this.rs.getString("pos"));
				this.data.add(this.rs.getString("mdate"));
				this.data.add(this.rs.getString("total"));
				
				this.alldata.add(this.data);
			}
		}
		catch(Exception e) {
			this.alldata = null;
		}
		finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();				
			}
			catch(Exception e) {
				this.alldata = null;
			}
		}
		return this.alldata;
	}
}
