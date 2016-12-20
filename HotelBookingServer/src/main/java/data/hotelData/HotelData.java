package data.hotelData;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





import data.dataHelper.folder.hotelFolderHelper;
import data.dataHelper.jdbc.Builder;
import data.dataHelper.ser.hotelSerHelper;
import dataService.hotelDataService.HotelDataService;
import po.hotelPO.CommentPO;
import po.hotelPO.HotelPO;
import po.hotelPO.RoomPO;

public class HotelData  implements HotelDataService {
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
	/* (non-Javadoc)
	 * @see dataService.hotelDataService.HotelDataService#showHotelinfo(java.lang.String)
	 */
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
					hp.setHotelPhone(rs.getString(13));
					hp.setRoom(hsh.readRoomSer(Hotelname));
					hp.setComment(hsh.readCommentSer(Hotelname));
					return hp;
				}
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see dataService.hotelDataService.HotelDataService#addComment(po.hotelPO.CommentPO)
	 */
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
	/*
	 * (non-Javadoc)
	 * @see dataService.hotelDataService.HotelDataService#modify(po.hotelPO.HotelPO)
	 */
	public boolean modify(HotelPO hotelinfo) {
		try {
			String select = "select * from `hotel`;";
			String update = "update hotel set `酒店名`=?,`酒店星级`=?,`酒店简介`=?,`wifi`=?,`电视`=?,`沙发`=?,`餐厅`=?,`地址`=?,`商圈`=?,`平均评分`=?,`酒店工作人员`=?,`联系方式`=? where 酒店ID=?;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(2).equals(hotelinfo.getHotelname())) {
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
					ps.setString(12, hotelinfo.getHotelPhone());
					ps.setInt(13, hotelinfo.getHotelID());
					ps.execute();
					return true;
				}
			}
			rs.close();
			ps.close();
			conn.close();
			if(hotelinfo.getRoom()!=null){
				hsh.writeRoomSer(hotelinfo.getHotelname(), hotelinfo.getRoom());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;

		}

		return false;
	}
	/*
	 * (non-Javadoc)
	 * @see dataService.hotelDataService.HotelDataService#roomModify(java.lang.String, java.util.ArrayList)
	 */
	public boolean roomModify(String hotelname, ArrayList<RoomPO> rooms) {
		try {
			hsh.writeRoomSer(hotelname, rooms);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/*
	 * (non-Javadoc)
	 * @see dataService.hotelDataService.HotelDataService#addHotel(po.hotelPO.HotelPO)
	 */
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
			String insert = "insert into `hotel` (酒店ID,酒店名,酒店星级,酒店简介,wifi,电视,沙发,餐厅,地址,商圈,平均评分,酒店工作人员,联系方式) values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
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
			ps.setString(13, hotel.getHotelPhone());
			try {
				if(hotel.getRoom()!=null){
					hsh.writeRoomSer(hotel.getHotelname(), hotel.getRoom());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.execute();
			ps.close();
			conn.close();
			return true;}
		catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see dataService.hotelDataService.HotelDataService#findWithReq(po.hotelPO.HotelPO, po.hotelPO.HotelPO)
	 */
	public ArrayList<HotelPO> findWithReq(HotelPO worstCondition,
			HotelPO bestCondition)  {
		ArrayList<HotelPO> hpList=new ArrayList<HotelPO>();
		try {
			String select = "select * from `hotel`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();		
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				boolean name=false;
				if(worstCondition.getHotelname()==(null)){
					name=true;
				}
				else{
					name=rs.getString(2).contains(worstCondition.getHotelname());
				}
				boolean circle=rs.getString(10).equals(worstCondition.getCircle());
				boolean socre=rs.getDouble(11)>=worstCondition.getScore()&&rs.getDouble(11)<=bestCondition.getScore();
				boolean star=rs.getInt(3)>=worstCondition.getStar()&&rs.getInt(3)<=bestCondition.getStar();
				if (name&&circle&&socre&&star) { 
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
					hp.setHotelPhone(rs.getString(13));
					hp.setRoom(hsh.readRoomSer(rs.getString(2)));
					hp.setComment(hsh.readCommentSer(rs.getString(2)));
					hpList.add(hp);
				}
			}
			rs.close();
			ps.close();
			conn.close();
			System.out.println(hpList.size());
				if(hpList.size()!=0){
				int expensivest=bestCondition.getRoom().get(0).getRoomPrice();
				System.out.println("best is "+expensivest);
				int cheapest=worstCondition.getRoom().get(0).getRoomPrice();
				System.out.println("worst is "+cheapest);
				for(int i=0;i<hpList.size();i++){
					int thisBest=0;
					int thisWorst=0;
					HotelPO hp = new HotelPO();
					ArrayList<RoomPO> rpList=new ArrayList<RoomPO>();
					hp=hpList.get(i);
					rpList=hsh.readRoomSer(hp.getHotelname());
					if(rpList!=null){
						for(int t=0;t<rpList.size();t++){
							if(rpList.get(t).getRoomPrice()>thisBest){
								thisBest=rpList.get(t).getRoomPrice();
							}
							thisWorst=thisBest;
							if(rpList.get(t).getRoomPrice()<thisWorst){
								thisWorst=rpList.get(t).getRoomPrice();
							}
						}
						System.out.println("this Best is "+thisBest);
						System.out.println("this Worst is "+thisWorst);
						boolean Best=(thisWorst<=expensivest)||(expensivest==-1);
						boolean Worst=(thisBest>=cheapest);
						if(Best&&Worst){			
						}
						else{
							hpList.remove(i);
							i=i-1;
						}
					}
				}
				return hpList;
			}
				else{
					return null;
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
