package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Model.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Model.member;

public interface implDao {
	//java8 static方法-->連線方法
	static Connection getDB()
	{
		Connection conn=null;
		String URL="jdbc:mysql://localhost:3307/company";
		String user="root";
		String password="1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	
   //Ｃ新增物件
	void add(String name,String username,String password,String address,String phone,String mobile);
	void add(member m);//DI(Dependence Injection)
	//Ｒ查詢物件
	String queryAll();//全部
	member queryID(int id);
	member queryUsername(String username,String password);//判斷帳號密碼
	member queryUsername(String username);//判斷帳號是否使用
	
	//Ｕ修改物件
	
	
	//Ｄ刪除物件

}
