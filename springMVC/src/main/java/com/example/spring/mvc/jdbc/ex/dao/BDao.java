package com.example.spring.mvc.jdbc.ex.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {

    DataSource dataSource;

    public BDao(){
        try{
            Context context = new InitialContext();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
