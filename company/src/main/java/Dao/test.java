package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	public static void main(String[] args) {
		String Url="jdbc:mysql://localhost:3307/company";
		String user="root";
		String password="1234";
		String SQL="insert into member(name,username,password,address,phone,mobile) "
				+"values('abc','ff','123','taipei','333','000')";
		String SQL2="insert into member(name,username,password,address,phone,mobile) "
				+"values(?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(Url, user, password);
//			Statement st=conn.createStatement();
//			st.executeUpdate(SQL);
			
			PreparedStatement ps=conn.prepareStatement(SQL2);
			ps.setString(1, "teacher");
			ps.setString(2, "aaa");
			ps.setString(3, "111");
			ps.setString(4, "ddd");
			ps.setString(5, "hhh");
			ps.setString(6, "aaa");
			
			
			ps.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			System.out.println("no Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no connection");
			e.printStackTrace();
		}

	}

}

