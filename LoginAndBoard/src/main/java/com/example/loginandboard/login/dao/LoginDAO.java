package com.example.loginandboard.login.dao;

import com.example.loginandboard.login.dto.LoginDTO;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class LoginDAO {
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    public LoginDAO() {
        try{
            Context init = new InitialContext();
            DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/Oracle11g");
            con = ds.getConnection();
        }catch(Exception ex){
            System.out.println("DB ���� ���� : " + ex);
            return;
        }
    }

    public boolean login(LoginDTO loginbean) {
        String sql = "SELECT ID, PW FROM MEMBER WHERE ID=?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, loginbean.getId());
            rs = pstmt.executeQuery();

            if(rs.next() && rs.getString("pw").equals(loginbean.getPw()))
                return true;
        }catch(Exception e) {
            System.out.println("login 예외 발생 : "+e);
        }finally {
            if(rs!=null) try{rs.close();}catch(SQLException ex){}
            if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
        }
        return false;
    }
}
