package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.member;

public class memberDao implements implDao{

	public static void main(String[] args) {
		
			System.out.println( new memberDao().queryUsername("ff"));
			
			
			

	}

	@Override
	public void add(String name, String username, String password, String address, String phone, String mobile) {
		Connection conn=implDao.getDB();
		String sql="insert into member(name,username,password,address,phone,mobile) "
				+"values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, address);
			ps.setString(5, phone);
			ps.setString(6, mobile);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void add(member m) {
		Connection conn=implDao.getDB();
		String sql="insert into member(name,username,password,address,phone,mobile) "
				+"values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getMobile());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String queryAll() {
		Connection conn=implDao.getDB();
		String Sql="select * from member";
		String show=null;
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ResultSet rs=ps.executeQuery();
			String sum="";
			while(rs.next())
			{
				sum=sum+"\nname:"+rs.getString("name")
				+"\tusername:"+rs.getString("username")+
				"\tpassword:"+rs.getString("password")+
				"\taddress:"+rs.getString("address")+
				"\tphone:"+rs.getString("phone")+
				"\tmobile:"+rs.getString("mobile");
			}
			
			show=sum;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return show;
	}

	@Override
	public member queryID(int id) {
		member m=null;
		Connection conn=implDao.getDB();
		String sql="select * from member where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
				m=new member(
						rs.getString("name"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("address"),
						rs.getString("phone"),
						rs.getString("mobile"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
	}

	@Override
	public member queryUsername(String username, String password) {
		Connection conn=implDao.getDB();
		String Sql="select * from member where username=? and password=?";
		member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
				m=new member(
						rs.getString("name"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("address"),
						rs.getString("phone"),
						rs.getString("mobile"));
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
	}

	@Override
	public member queryUsername(String username) {
		Connection conn=implDao.getDB();
		String Sql="select * from member where username=? ";
		member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setString(1, username);
			
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
				m=new member(
						rs.getString("name"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("address"),
						rs.getString("phone"),
						rs.getString("mobile"));
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
	}

}
