package com.example.loginandboard.admin.dao;

import com.example.loginandboard.overall.dto.MemberInfoDTO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class AdminDAO {
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    public AdminDAO() {
        try{
            Context init = new InitialContext();
            DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/Oracle11g");
            con = ds.getConnection();
        }catch(Exception ex){
            System.out.println("DB ���� ���� : " + ex);
            return;
        }
    }

    public boolean deleteMember(String id) {
        String sql = "DELETE FROM member WHERE id=?";

        int result = 0;

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            result = pstmt.executeUpdate();

            if(result != 0) return true;
        }catch(Exception e) {
            System.out.println("deleteMember 예외 발생 : "+e);
        }finally {
            if(rs!=null) try{rs.close();}catch(SQLException ex){}
            if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
        }
        return false;
    }

    public MemberInfoDTO getMemberInfo(String id) {
        String sql = "SELECT * FROM member WHERE id=?";

        MemberInfoDTO memberInfoBean = new MemberInfoDTO();

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                memberInfoBean.setId(rs.getString("id"));
                memberInfoBean.setPw(rs.getString("pw"));
                memberInfoBean.setMail(rs.getString("mail"));
                memberInfoBean.setName(rs.getString("name"));
                memberInfoBean.setBirthday(rs.getString("birthday"));

                return memberInfoBean;
            }
        }catch(Exception e) {
            System.out.println("getMemberInfo 예외 발생 : "+e);
        }finally {
            if(rs!=null) try{rs.close();}catch(SQLException ex){}
            if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
        }
        return null;
    }

    public List getMemberList() {
        String sql = "SELECT id FROM member";

        List memberList = new ArrayList();

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                memberList.add(rs.getString("id"));
            }
            memberList.remove("admin");
            return memberList;
        }catch(Exception e) {
            System.out.println("getMemberList 예외 발생 : "+e);
        }finally {
            if(rs!=null) try{rs.close();}catch(SQLException ex){}
            if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
        }
        return null;
    }
}
