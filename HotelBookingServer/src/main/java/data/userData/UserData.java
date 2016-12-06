package data.userData;

import java.io.IOException;
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
import po.personPO.*;
import data.dataHelper.folder.personFolderHelper;
import data.dataHelper.jdbc.*;
import data.dataHelper.ser.personSerHelper;
import data.promotionData.PromotionData;
import dataService.*;
import dataService.userDataService.UserDataService;

public class UserData /* implements UserDataService */{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private Builder builder = new Builder();
	private ResultSet rs = null;
	private personFolderHelper personhelper = new personFolderHelper();
	private personSerHelper personserhelper = new personSerHelper();
	static UserData userdata = null;

	/**
	 * 增加一个客户
	 * 
	 * @author xiamutian
	 * @return boolean
	 */
	public static UserData getInstance() {
		if (userdata == null)
			userdata = new UserData();
		return userdata;
	}

	public boolean addPerson(PersonPO personInfo) {
		int lastID = 0;
		try {
			personhelper.mkdirs(personInfo.getUsername());
			String select = "select * from `Person`;";
			String insert = "insert into Person (id,用户名,密码,vip类型,vip等级,企业会员名,信用值,生日) values(?,?,?,?,?,?,?,?);";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getInt(1) > lastID) {
					lastID = rs.getInt(1);
				}
				if (rs.getString(2).equals(personInfo.getUsername())) {
					rs.close();
					return false;
				}
			}
			rs.close();
			ps = conn.prepareStatement(insert);
			ps.setInt(1, lastID + 1);
			ps.setString(2, personInfo.getUsername());
			ps.setString(3, personInfo.getPassword());
			ps.setString(4, personInfo.getVipType());
			ps.setInt(5, 0);
			ps.setString(6, personInfo.getEnterpriseName());
			ps.setInt(7, 0);
			java.util.Date date = personInfo.getBirthday().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String birth = sdf.format(date);
			java.sql.Date bd = java.sql.Date.valueOf(birth);
			ps.setDate(8, bd);
			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}

	/**
	 * 寻找一个客户
	 * 
	 * @author xiamutian
	 * @return PersonPO
	 */
	public PersonPO findPerson(String personname) {
		PersonPO pp = new PersonPO();
		try {
			String select = "select * from `person`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(2).equals(personname)) { 
					pp.setPersonID(rs.getInt(1));
					pp.setUsername(rs.getString(2));
					pp.setPassword(rs.getString(3));
					pp.setVipType(rs.getString(4));
					pp.setVipLevel(rs.getInt(5));
					pp.setEnterpriseName(rs.getString(6));
					pp.setCredit(rs.getInt(7));
					if (rs.getDate(8) != null) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(rs.getDate(8));
						pp.setBirthday(cal);
					}
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
	 * 
	 * @author xiamutian
	 * @return boolean
	 */
	public boolean modifyPerson(PersonPO personInfo) {
		try {
			String select = "select * from `person`;";
			String update = "update person set `用户名`=?,`密码`=?,`vip类型`=?,`vip等级`=?,`企业会员名`=?,`信用值`=?,`生日`=? where id=?;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(2).equals(personInfo.getUsername())) {
					ps = conn.prepareStatement(update);
					ps.setString(1, personInfo.getUsername());
					ps.setString(2, personInfo.getPassword());
					ps.setString(3, personInfo.getVipType());
					ps.setInt(4, personInfo.getVipLevel());
					ps.setString(5, personInfo.getEnterpriseName());
					ps.setInt(6, personInfo.getCredit());
					if (personInfo.getBirthday() == null) {
						ps.setDate(7, null);
					} else {
						java.util.Date date = personInfo.getBirthday().getTime();
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd");
						String birth = sdf.format(date);
						java.sql.Date bd = java.sql.Date.valueOf(birth);
						ps.setDate(7, bd);
					}
					ps.setInt(8, rs.getInt(1));
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
	 * 
	 * @author xiamutian
	 * @return boolean
	 */
	public boolean personLogin(String personname, String password) {

		try {
			String select = "select * from `person`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(2).equals(personname)
						&& rs.getString(3).equals(password)) {
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

	/**
	 * @author xiamutian 寻找一个网站营销人员
	 */
	public MarketPO findMarket(String marketname) {
		MarketPO mp = new MarketPO();
		try {
			String select = "select * from `market`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(marketname)) {
					mp.setUsername(rs.getString(1));
					mp.setPassword(rs.getString(2));
					return mp;
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
	 * @author xiamutian 改变一个网站营销人员信息
	 */
	public boolean modifyMarket(MarketPO marketInfo) {
		try {
			String select = "select * from `market`;";
			String update = "update market set `密码`=? where 用户名=?;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(marketInfo.getUsername())) {
					ps = conn.prepareStatement(update);
					ps.setString(1, marketInfo.getPassword());
					ps.setString(2, marketInfo.getUsername());
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
	 * @author xiamutian 网站营销人员登陆
	 */
	public boolean marketLogin(String marketname, String password) {

		try {
			String select = "select * from `market`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(marketname)
						&& rs.getString(2).equals(password)) {
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

	/**
	 * @author xiamutian 改变一个客户的信用值
	 */
	public boolean changeCredit(String username, int credit) {
		try {
			String select = "select * from `person`;";
			String update = "update person set `信用值`=? where id=?;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(2).equals(username)) {
					ps = conn.prepareStatement(update);
					ps.setInt(2, rs.getInt(1));
					ps.setInt(1, rs.getInt(7) + credit);
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
	 * @author xiamutian 寻找一个酒店工作人员信息
	 */
	public HotelWorkerPO findHotelWorker(String hotelWorkername) {
		HotelWorkerPO hp = new HotelWorkerPO();
		try {
			String select = "select * from `hotelworker`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(hotelWorkername)) {
					hp.setUsername(rs.getString(1));
					hp.setPassword(rs.getString(2));
					hp.setHotelname(rs.getString(3));
					return hp;
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
	 * @author xiamutian 改变一个酒店工作人员信息
	 */
	public boolean modifyHotelWorker(HotelWorkerPO hotelWorkerInfo) {

		try {
			String select = "select * from `hotelworker`;";
			String update = "update hotelworker set `密码`=?,`酒店名`=? where 用户名=?;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(hotelWorkerInfo.getUsername())) {
					ps = conn.prepareStatement(update);
					ps.setString(1, hotelWorkerInfo.getPassword());
					ps.setString(3, hotelWorkerInfo.getUsername());
					ps.setString(2, hotelWorkerInfo.getHotelname());
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
	 * @author xiamutian 酒店工作人员登陆
	 */
	public boolean hotelWorkerLogin(String hotelWorkername, String password) {

		try {
			String select = "select * from `hotelworker`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(hotelWorkername)
						&& rs.getString(2).equals(password)) {
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

	/**
	 * @author xiamutian 增加一个网站营销人员
	 */
	public boolean addMarket(MarketPO marketInfo) {
		try {
			String select = "select * from `market`;";
			String insert = "insert into market (用户名,密码) values(?,?);";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(marketInfo.getUsername())) {
					rs.close();
					return false;
				}
			}
			rs.close();
			ps = conn.prepareStatement(insert);
			ps.setString(1, marketInfo.getUsername());
			ps.setString(2, marketInfo.getPassword());
			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	/**
	 * @author xiamutian 网站管理人员登录
	 */
	public boolean managerLogin(String managername, String password) {
		try {
			String select = "select * from `manager`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(managername)
						&& rs.getString(2).equals(password)) {
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

	public boolean addHotelWorker(HotelWorkerPO hotelworker) {
		/**
		 * @author xiamutian 增加一个酒店工作人员
		 */
		try {
			String select = "select * from `hotelworker`;";
			String insert = "insert into hotelworker (用户名,密码,酒店名) values(?,?,?);";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(hotelworker.getUsername())) {
					rs.close();
					return false;
				}
			}
			rs.close();
			ps = conn.prepareStatement(insert);
			ps.setString(1, hotelworker.getUsername());
			ps.setString(2, hotelworker.getPassword());
			ps.setString(3, hotelworker.getHotelname());
			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;

	}

	/**
	 * 用于写入信用记录
	 * 
	 * @param personname
	 * @param record
	 * @return
	 * @throws IOException
	 */
	public boolean writeRecord(String personname, RecordPO record)
			throws IOException {
		personserhelper.writeRecordSer(personname, record);
		return false;
	}
}
