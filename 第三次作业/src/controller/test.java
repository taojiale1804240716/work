package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.CityDao;
import model.dao.ProvincialDao;
import model.dao.UserDao;
import vo.User;
import vo.city;
import vo.provincial;

public class test {
      public static void main(String[] args) throws SQLException {
    	 
		   UserDao U=new UserDao();
		   User u=new User("125","131","123","122","湖北","武汉","1730863951@qq.com");
		   U.add(u);
		   
	}
}
