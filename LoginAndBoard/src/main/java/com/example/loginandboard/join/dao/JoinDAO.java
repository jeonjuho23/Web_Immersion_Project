package com.example.loginandboard.join.dao;

import com.example.loginandboard.overall.dto.MemberInfoDTO;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class JoinDAO {
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    public JoinDAO() {
        try{
            Context init = new InitialContext();
            DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/Oracle11g");
            con = ds.getConnection();
        }catch(Exception ex){
            System.out.println("DB ���� ���� : " + ex);
            return;
        }
    }
    public boolean join(MemberInfoDTO joinbean) {
        String sql = "INSERT INTO member (id, pw, mail, name, birthday) "
                + "VALUES (?,?,?,?,?)";

        int result = 0;

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, joinbean.getId());
            pstmt.setString(2, joinbean.getPw());
            pstmt.setString(3, joinbean.getMail());
            pstmt.setString(4, joinbean.getName());
            pstmt.setString(5, joinbean.getBirthday());
            result = pstmt.executeUpdate();

            if(result != 0) return true;
        }catch(Exception e) {
            System.out.println("join 예외 발생 : "+e);
        }finally {
            if(rs!=null) try{rs.close();}catch(SQLException ex){}
            if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
        }
        return false;
    }
}
