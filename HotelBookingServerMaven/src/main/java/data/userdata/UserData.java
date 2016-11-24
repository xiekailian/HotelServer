package data.userData;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import po.HotelWorkerPO;
import po.MarketPO;
import po.PersonPO;
import data.jdbcConnector.Builder;
import dataService.*;
import dataService.userDataService.UserDataService;
public class UserData implements UserDataService{
	Connection conn=null;
	PreparedStatement ps=null;
	Builder builder=new Builder();
	ResultSet rs=null;
	/**
	 * 增加一个客户
	 * @author xiamutian
	 * @return boolean
	 */
	public boolean addPerson(PersonPO personInfo) {
		int lastID=0;
		try {
			String select="select * from `Person`;";
			String insert="insert into Person (id,用户名,密码,vip类型,vip等级,企业会员名,信用值,生日) values(?,?,?,?,?,?,?,?);";
			conn=builder.BuildConnection();
			ps=conn.prepareStatement(select);
			rs=ps.executeQuery();
			while(rs.next()){//next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if(rs.getInt(1)>lastID){
					lastID=rs.getInt(1);
				}
				if(rs.getString(2).equals(personInfo.getuserName())){
					rs.close();
					return false;
				}
			}
			rs.close();
			ps=conn.prepareStatement(insert);
			ps.setInt(1, lastID+1);
			ps.setString(2, personInfo.getuserName());
			ps.setString(3, personInfo.getpassword());
			ps.setString(4, personInfo.getVipType());
			ps.setInt(5, 0);
			ps.setString(6, personInfo.getEnterpriseName());
			ps.setInt(7, 0);
			int temp=personInfo.getBirthday().get(Calendar.DATE)+1;//用于修正日期
			personInfo.getBirthday().set(Calendar.DATE, temp);
			java.util.Date date=personInfo.getBirthday().getTime();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String birth=sdf.format(date);
			System.out.println(birth);
			java.sql.Date bd=java.sql.Date.valueOf(birth);
			ps.setDate(8, bd);
			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		System.out.println("good");

		return true;
	}
	/**
	 * 寻找一个客户
	 * @author xiamutian
	 * @return PersonPO
	 */		
	public PersonPO findPerson(String personname) {
		PersonPO pp=new PersonPO();
		try {
			String select="select * from `Person`;";
			conn=builder.BuildConnection();
			ps=conn.prepareStatement(select);
			rs=ps.executeQuery();
			while(rs.next()){//next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if(rs.getString(2).equals(personname)){
					pp.setPersonID(rs.getInt(1));
					pp.setuserName(rs.getString(2));
					pp.setpassword("");
					pp.setVipType(rs.getString(4));
					pp.setVIPlevel(rs.getInt(5));
					pp.setEnterpriseName(rs.getString(6));
					pp.setCredit(rs.getInt(7));
					if(rs.getDate(8)!=null){
						Calendar cal=Calendar.getInstance();  
						cal.setTime(rs.getDate(8)); 
						pp.setBirthday(cal);}
					return pp;
				}
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}

		return null;
	}
	/**
	 * 改变一个客户信息
	 * @author xiamutian
	 * @return boolean
	 */	
	public boolean modifyPerson(PersonPO personInfo) {
			
		PersonPO pp=new PersonPO();
		try {
			String select="select * from `Person`;";
			String update="update person set `用户名`=?,`密码`=?,`vip等级`=?,`vip信息`=?,`信用值`=? where id=?;";
			conn=builder.BuildConnection();
			ps=conn.prepareStatement(select);
			rs=ps.executeQuery();
			while(rs.next()){//next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if(rs.getString(2).equals(personInfo.getuserName())){
					ps=conn.prepareStatement(update);
					ps.setString(1, personInfo.getuserName());
					ps.setString(2, personInfo.getpassword());
					ps.setInt(3, personInfo.getVIPlevel());
					ps.setString(4, personInfo.getVIPinfo());
					ps.setInt(5, personInfo.getCredit());
					ps.setInt(6, rs.getInt(1));
					ps.execute();
					return true;
				}
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		return false;
	}
	/**
	 * 客户登陆
	 * @author xiamutian
	 * @return boolean
	 */	
	public boolean personLogin(String personname, String password) {
			
		try {
			String select="select * from `Person`;";
			conn=builder.BuildConnection();
			ps=conn.prepareStatement(select);
			rs=ps.executeQuery();
			while(rs.next()){//next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if(rs.getString(2).equals(personname)&&rs.getString(3).equals(password)){
					return true;
				}
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}	
		return false;
	}

	public MarketPO findMarket(String marketname) {
		/**
		 * @author xiamutian
		 * 寻找一个网站营销人员
		 */		return null;
	}

	public boolean modifyMarket(MarketPO marketInfo) {
		/**
		 * @author xiamutian
		 * 改变一个网站营销人员信息
		 */		return false;
	}

	public boolean marketLogin(String marketname, String password) {
		/**
		 * @author xiamutian
		 * 网站营销人员登陆
		 */		return false;
	}

	public boolean changeCredit(String username, int credit) {
		/**
		 * @author xiamutian
		 * 改变一个客户的信用值
		 */		return false;
	}

	public HotelWorkerPO findHotelWorker(String hotelWorkername) {
		/**
		 * @author xiamutian
		 * 寻找一个酒店工作人员信息
		 */		return null;
	}

	public boolean modifyHotelWorker(HotelWorkerPO hotelWorkerInfo) {
		/**
		 * @author xiamutian
		 * 改变一个酒店工作人员信息
		 */		return false;
	}

	public boolean hotelWorkerLogin(String hotelWorkername, String password) {
		/**
		 * @author xiamutian
		 * 酒店工作人员登陆
		 */		return false;
	}

	public boolean addMarket(MarketPO marketInfo) {
		/**
		 * @author xiamutian
		 * 增加一个网站营销人员
		 */		return false;
	}

	public boolean managerLogin(String managername, String password) {
		/**
		 * @author xiamutian
		 * 网站管理人员登录
		 */			return false;
	}

	public boolean addHotelWorker(HotelWorkerPO hotelworker) {
		/**
		 * @author xiamutian
		 * 增加一个酒店工作人员
		 */
		return false;
	}

}
