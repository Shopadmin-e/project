package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.m_dbinfo;

@WebServlet("/admin_siteinfook")
public class admin_siteinfook extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        m_dbinfo db = new m_dbinfo();

        try {
            this.con = db.getConnection();

            //사용자가 입력한 값 가져오기
            String homepagename = request.getParameter("homepagename");
            String admin_email = request.getParameter("admin_email");
            String use_points = request.getParameter("use_points");
            String signup_bonus = request.getParameter("signup_bonus");
            String signup_level = request.getParameter("signup_level");
            String corp_name = request.getParameter("corp_name");
            String ceo_name = request.getParameter("ceo_name");
            String corp_telno = request.getParameter("corp_telno");
            String corp_postno = request.getParameter("corp_postno");
            String corp_addr = request.getParameter("corp_addr");
            String corp_master = request.getParameter("corp_master");
            String master_email = request.getParameter("master_email");
            String corp_no = request.getParameter("corp_no");
            String master_no = request.getParameter("master_no");
            String corp_telno2 = request.getParameter("corp_telno2");
            String bank = request.getParameter("bank");
            String bank_no = request.getParameter("bank_no");
            String card = request.getParameter("card");
            String phone = request.getParameter("phone");
            String book = request.getParameter("book");
            String cash_smallpoint = request.getParameter("cash_smallpoint");
            String cash_maxpoint = request.getParameter("cash_maxpoint");
            String cash_receipt = request.getParameter("cash_receipt");
            String delivery_name = request.getParameter("delivery_name");
            String delivery_cash = request.getParameter("delivery_cash");
            String delivery_date = request.getParameter("delivery_date");
    
               String insertSql = "insert into joinsite values ('0',?,? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,now())";
               this.ps = this.con.prepareStatement(insertSql);
               this.ps.setString(1, homepagename);
               this.ps.setString(2, admin_email);
               this.ps.setString(3, use_points);
               this.ps.setString(4, signup_bonus);
               this.ps.setString(5, signup_level);
               this.ps.setString(6, corp_name);
               this.ps.setString(7, ceo_name);
               this.ps.setString(8, corp_telno);
               this.ps.setString(9, corp_postno);
               this.ps.setString(10, corp_addr);
               this.ps.setString(11, corp_master);
               this.ps.setString(12, master_email);
               this.ps.setString(13, corp_no);
               this.ps.setString(14, master_no);
               this.ps.setString(15, corp_telno2);
               this.ps.setString(16, bank);
               this.ps.setString(17, bank_no);
               this.ps.setString(18, card);
               this.ps.setString(19, phone);
               this.ps.setString(20, book);
               this.ps.setString(21, cash_smallpoint);
               this.ps.setString(22, cash_maxpoint);
               this.ps.setString(23, cash_receipt);
               this.ps.setString(24, delivery_name);
               this.ps.setString(25, delivery_cash);
               this.ps.setString(26, delivery_date);
                System.out.println(this.con.prepareStatement(insertSql));
                this.ps.executeUpdate();

            Map<String, String> siteInfo = new HashMap<>();

            siteInfo.put("homepagename", homepagename);
            siteInfo.put("admin_email", admin_email);
            siteInfo.put("use_points", use_points);
            siteInfo.put("signup_bonus", signup_bonus);
            siteInfo.put("signup_level", signup_level);
            siteInfo.put("corp_name", corp_name);
            siteInfo.put("ceo_name", ceo_name);
            siteInfo.put("corp_telno", corp_telno);
            siteInfo.put("corp_postno", corp_postno);
            siteInfo.put("corp_addr", corp_addr);
            siteInfo.put("corp_master", corp_master);
            siteInfo.put("master_email", master_email);
            siteInfo.put("corp_no", corp_no);
            siteInfo.put("master_no", master_no);
            siteInfo.put("corp_telno2", corp_telno2);
            siteInfo.put("bank", bank);
            siteInfo.put("bank_no", bank_no);
            siteInfo.put("card", card);
            siteInfo.put("phone", phone);
            siteInfo.put("book", book);
            siteInfo.put("cash_smallpoint", cash_smallpoint);
            siteInfo.put("cash_maxpoint", cash_maxpoint);
            siteInfo.put("cash_receipt", cash_receipt);
            siteInfo.put("delivery_name", delivery_name);
            siteInfo.put("delivery_cash", delivery_cash);
            siteInfo.put("delivery_date", delivery_date);

            
            // 🔹 JSP로 데이터 전달
            request.setAttribute("siteInfo", siteInfo);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./admin_siteinfook.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            try {
                this.rs.close();
                this.ps.close();
                this.con.close();
            } catch (Exception e) {
                
            }
        }
    }
}