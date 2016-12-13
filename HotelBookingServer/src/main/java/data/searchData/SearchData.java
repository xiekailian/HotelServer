package data.searchData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import data.dataHelper.jdbc.Builder;
import dataService.searchDataService.*;
import po.SearchPO;

public class SearchData implements SearchDataService {
	Connection conn = null;
	PreparedStatement ps = null;
	Builder builder = new Builder();
	ResultSet rs = null;
	public static SearchData getInstance() {
		if (searchData == null) {
			searchData = new SearchData();
			return searchData;
		}
		return searchData;
	}
	private static SearchData searchData = null;

	public ArrayList<SearchPO> showSearchHistory(String username) {
		ArrayList<SearchPO> spList = new ArrayList<SearchPO>();
		SearchPO sp = new SearchPO();
		try {
			String select = "select * from `search`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(username)) {
					sp.setPersonname(rs.getString(1));
					sp.setHotelname(rs.getString(3));
					Calendar cal = Calendar.getInstance();
					cal.setTime(rs.getTimestamp(2));
					sp.setTime(cal);
					spList.add(sp);
				}
			}
			rs.close();
			ps.close();
			conn.close();
			if(spList.size()!=0){
			return spList;}
			else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}

		return null;
	}

	public boolean addSearchHistory(SearchPO s) {
		String insert = "insert into search (用户名,时间,酒店名) values(?,?,?);";
		conn = builder.BuildConnection();
		try {
			ps = conn.prepareStatement(insert);
			ps.setString(1, s.getPersonname());
			java.util.Date date = s.getTime().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(date);
			java.sql.Timestamp bd = java.sql.Timestamp.valueOf(time);
			ps.setTimestamp(2, bd);
			ps.setString(3, s.getHotelname());
			ps.execute();
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteSearchHistory(SearchPO s) {
		String delete = "delete from search where 时间=?;";
		conn = builder.BuildConnection();
		try {
			ps = conn.prepareStatement(delete);
			java.util.Date date = s.getTime().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(date);
			java.sql.Timestamp bd = java.sql.Timestamp.valueOf(time);
			ps.setTimestamp(1, bd);
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
