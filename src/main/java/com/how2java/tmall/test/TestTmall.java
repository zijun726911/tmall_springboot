package com.how2java.tmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTmall {
   
    public static void main(String args[]){
        //准备分类测试数据：
   
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
   
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://101.132.135.108:3306/tmall_springboot?useUnicode=true&characterEncoding=utf8",
                        "root", "47127412");
                Statement s = c.createStatement();
        )
        {
            for (int i = 1; i <=57 ; i++) {
                String sqlFormat = "insert into category values (null, '测试分类%d')";
//                String sqlFormat = "delete from category where 1=1";

                String sql = String.format(sqlFormat, i);
                s.execute(sql);
            }
              
            System.out.println("已经成功创建10条分类测试数据");
   
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   
    }
   
}