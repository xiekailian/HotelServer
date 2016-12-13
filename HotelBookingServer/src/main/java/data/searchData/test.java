//package data.searchData;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Calendar;
//
//import po.SearchPO;
//
//public class test {
//	public static void main (String args[]) throws SQLException{
//		Calendar cal=Calendar.getInstance();
//		cal.set(Calendar.YEAR, 2017);
//		cal.set(Calendar.MONTH, 2);
//		cal.set(Calendar.DATE, 31);
//		cal.set(Calendar.HOUR_OF_DAY, 23);
//		cal.set(Calendar.MINUTE, 45);
//		cal.set(Calendar.SECOND, 45);
//		SearchPO sp=new SearchPO();
//		sp.setTime(cal);
//		sp.setPersonname("xiamutian");
//		sp.setHotelname("南京大酒店");
//		SearchData sd=new SearchData();
////		sd.addSearchHistory(sp);
////		sd.deleteSearchHistory(sp);
//		ArrayList<SearchPO> spList=new ArrayList<SearchPO>();
//		spList=sd.showSearchHistory("xiamutian");
//		System.out.println(spList.get(0).getTime());
//		}
//}
