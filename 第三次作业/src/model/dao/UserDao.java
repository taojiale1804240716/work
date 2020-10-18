package model.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tools.JdbcUtil;
import vo.User;

public class UserDao {
       
	
	public  User getUser(String userName) throws SQLException, FileNotFoundException, IOException{
		 User user = null;
		
		JdbcUtil jdbcutil=new JdbcUtil();
	
		String sql="select * from t_user where userName='"+userName+"'";
		

	    ResultSet rs=jdbcutil.query(sql);
		
		if(rs.next()){			
			  user =new User(rs.getString("userName"),rs.getString("password"),rs.getString("charName"),rs.getString("role"));
		}
	    
		jdbcutil.close();
		return user;		
	}
	public List<User> getUserList() throws SQLException, FileNotFoundException, IOException{
   	  //准备一个搜索所有user的sql语句
		String sql="select * from t_user";
		JdbcUtil jdbcutil=new JdbcUtil();
		ResultSet rs=jdbcutil.query(sql);
		//实例化user的列表
		ArrayList<User> list=new ArrayList<User>();
		User user=null;
		while(rs.next()){
			user=new User(rs.getString("userName"),rs.getString("password"),rs.getString("charName"),rs.getString("role"));
			list.add(user);
		}
		return list;
   }
	public void add(User u) throws SQLException{
		String sql = "insert into t_user(role,userName,password,charName,provincial,city,email)values(?,?,?,?,?,?,?)";
		JdbcUtil jdbc=new JdbcUtil();
		PreparedStatement  ps=jdbc.getconnection().prepareStatement(sql);
		//得到数据库的连接
        ps.setString(1,u.getRole());
        ps.setString(2,u.getUserName());
        ps.setString(3,u.getPassword());
        ps.setString(4,u.getChrName());
        ps.setString(5,u.getprovincial());
        ps.setString(6,u.getcity());
        ps.setString(7, u.getemial());
        
        
        int row = ps.executeUpdate();//
        if(row>0){
            System.out.println("成功添加了" + row + "条数据！");
        }
	}
}
