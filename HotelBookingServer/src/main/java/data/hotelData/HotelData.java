package data.hotelData;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;





import data.dataHelper.folder.hotelFolderHelper;
import data.dataHelper.jdbc.Builder;
import data.dataHelper.ser.hotelSerHelper;
import dataService.hotelDataService.HotelDataService;
import po.SearchPO;
import po.hotelPO.CommentPO;
import po.hotelPO.HotelPO;
import po.hotelPO.RoomPO;
import po.personPO.PersonPO;

public class HotelData /* implements HotelDataService */{
	private static HotelData hoteldata = null;
	private hotelSerHelper hsh = new hotelSerHelper();
	private hotelFolderHelper hfh = new hotelFolderHelper();
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Builder builder = new Builder();

	/**
	 * 
	 * @return 唯一的HotelData对象
	 */
	public static HotelData getInstance() {
		if (hoteldata == null)
			hoteldata = new HotelData();
		return hoteldata;
	}

	public HotelPO showHotelinfo(String Hotelname) {
		HotelPO hp = new HotelPO();
		try {
			String select = "select * from `hotel`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(2).equals(Hotelname)) { 
					hp.setHotelID(rs.getInt(1));
					hp.setHotelname(rs.getString(2));
					hp.setStar(rs.getInt(3));
					hp.setFeature(rs.getString(4));
					ArrayList<Boolean> ServiceList=new ArrayList<Boolean>();
					ServiceList.add(rs.getBoolean(5));
					ServiceList.add(rs.getBoolean(6));
					ServiceList.add(rs.getBoolean(7));
					ServiceList.add(rs.getBoolean(8));
					hp.setService(ServiceList);
					hp.setAddress(rs.getString(9));
					hp.setCircle(rs.getString(10));
					hp.setScore(rs.getDouble(11));
					hp.setHotelworker(rs.getString(12));
					hp.setRoom(hsh.readRoomSer(Hotelname));
					hp.setComment(hsh.readCommentSer(Hotelname));
					return hp;
				}
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public boolean addComment(CommentPO comment)  {
		try {
			hsh.writeCommentSer(comment.getHotelname(), comment);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean modify(HotelPO hotelinfo) {
		try {
			String select = "select * from `hotel`;";
			String update = "update person set `酒店名`=?,`酒店星级`=?,`酒店简介`=?,`wifi`=?,`电视`=?,`沙发`=?,`餐厅`=?,`地址`=?,`商圈`=?,`平均评分`=?,`酒店工作人员`=? where 酒店ID=?;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(hotelinfo.getHotelname())) {
					ps = conn.prepareStatement(update);
					ps.setString(1, hotelinfo.getHotelname());
					ps.setInt(2, hotelinfo.getStar());
					ps.setString(3, hotelinfo.getFeature());
					ps.setBoolean(4, hotelinfo.getService().get(0));
					ps.setBoolean(5, hotelinfo.getService().get(1));
					ps.setBoolean(6, hotelinfo.getService().get(2));
					ps.setBoolean(7, hotelinfo.getService().get(3));
					ps.setString(8, hotelinfo.getAddress());
					ps.setString(9, hotelinfo.getCircle());
					ps.setDouble(10, hotelinfo.getScore());
					ps.setString(11, hotelinfo.getHotelworker());
					ps.setInt(12, hotelinfo.getHotelID());
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

	public boolean roomModify(String hotelname, ArrayList<RoomPO> rooms) {
		try {
			hsh.writeRoomSer(hotelname, rooms);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addHotel(HotelPO hotel)  {
		int lastID = 0;
		hfh.mkdirs(hotel.getHotelname());
		try {
			String select = "select * from `hotel`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getInt(1) > lastID) {
					lastID = rs.getInt(1);
				}
				if (rs.getString(2).equals(hotel.getHotelname())) {
					rs.close();
					return false;
				}
			}

			rs.close();
		}
			catch (SQLException e) {
				
			}
		try{
			hfh.mkdirs(hotel.getHotelname());
			String insert = "insert into `hotel` (酒店ID,酒店名,酒店星级,酒店简介,wifi,电视,沙发,餐厅,地址,商圈,平均评分,酒店工作人员) values(?,?,?,?,?,?,?,?,?,?,?,?);";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(insert);
			ps.setInt(1, lastID+1);
			ps.setString(2,hotel.getHotelname());
			ps.setInt(3, hotel.getStar());
			ps.setString(4, hotel.getFeature());
			ps.setBoolean(5, hotel.getService().get(0));
			ps.setBoolean(6, hotel.getService().get(1));
			ps.setBoolean(7, hotel.getService().get(2));
			ps.setBoolean(8, hotel.getService().get(3));
			ps.setString(9, hotel.getAddress());
			ps.setString(10, hotel.getCircle());
			ps.setDouble(11, hotel.getScore());
			ps.setString(12, hotel.getHotelworker());
			try {
				hsh.writeRoomSer(hotel.getHotelname(), hotel.getRoom());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.execute();
			ps.close();
			conn.close();
			return true;}
		catch (SQLException e){
			return false;
		}
		
	}

	public ArrayList<HotelPO> findWithReq(HotelPO worstCondition,
			HotelPO bestCondition)  {
		ArrayList<HotelPO> hpList=new ArrayList<HotelPO>();
		try {
			String select = "select * from `hotel`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();		
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				boolean A=rs.getString(2).contains(worstCondition.getHotelname())||worstCondition.getHotelname().equals(null);
				boolean B=rs.getString(10).equals(worstCondition.getCircle());
				boolean C=rs.getDouble(11)>=worstCondition.getScore()&&rs.getDouble(11)<=bestCondition.getScore();
				boolean D=rs.getInt(3)>=worstCondition.getStar()&&rs.getInt(3)<=bestCondition.getStar();
				System.out.println("now is"+rs.getString(2));
				if (A&&B&&C&&D) { 
					HotelPO hp = new HotelPO();
					hp.setHotelID(rs.getInt(1));
					hp.setHotelname(rs.getString(2));
					hp.setStar(rs.getInt(3));
					hp.setFeature(rs.getString(4));
					ArrayList<Boolean> ServiceList=new ArrayList<Boolean>();
					ServiceList.add(rs.getBoolean(5));
					ServiceList.add(rs.getBoolean(6));
					ServiceList.add(rs.getBoolean(7));
					ServiceList.add(rs.getBoolean(8));
					hp.setService(ServiceList);
					hp.setAddress(rs.getString(9));
					hp.setCircle(rs.getString(10));
					hp.setScore(rs.getDouble(11));
					hp.setHotelworker(rs.getString(12));
					hp.setRoom(hsh.readRoomSer(worstCondition.getHotelname()));
					hp.setComment(hsh.readCommentSer(worstCondition.getHotelname()));
					hpList.add(hp);
				}
			}
			rs.close();
			ps.close();
			conn.close();
			if(hpList.size()==0){
				return null;	
			}else{
				int expensivest=0;
				int cheapest=0;
				for(int i=0;i<hpList.size();i++){
					HotelPO hp = new HotelPO();
					ArrayList<RoomPO> rpList=new ArrayList<RoomPO>();
					hp=hpList.get(i);
					rpList=hsh.readRoomSer(hp.getHotelname());
					for(int t=0;t<rpList.size();t++){
						
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
