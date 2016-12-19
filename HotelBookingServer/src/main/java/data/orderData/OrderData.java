package data.orderData;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.dataHelper.jdbc.*;
import data.dataHelper.folder.orderFolderHelper;
import data.dataHelper.ser.orderSerHelper;
import dataService.orderDataService.OrderDataService;
import po.OrderPO;

public class OrderData implements OrderDataService {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private static OrderData orderData = null;
	private Builder builder = new Builder();
	private orderFolderHelper ofh = new orderFolderHelper();
	private orderSerHelper osh = new orderSerHelper();

	public static OrderData getInstance() {
		if (orderData == null) {
			orderData = new OrderData();
			return orderData;
		}
		return orderData;
	}

	public boolean add(OrderPO order) {
		ofh.mkdirs(order.getOrderID());
		try {
			try {
				osh.writeRoomSer(order.getOrderID(), order.getRoom());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			String insert = "insert into `order` (订单号,订单价格,订单状态,酒店名,入住人用户名,入住人真实姓名,总人数,儿童人数,生成时间,执行时间,取消时间,最晚执行时间,预计退房时间,实际退房时间,房间数量,客户电话) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(insert);
			ps.setString(1, order.getOrderID());
			ps.setInt(2, order.getOrderprice());
			ps.setString(3, order.getOrderstate());
			ps.setString(4, order.getHotelname());
			ps.setString(5, order.getPersonname());
			ps.setString(6, order.getRealname());
			ps.setInt(7, order.getPeoplenum());
			ps.setInt(8, order.getChildnum());
			ps.setTimestamp(9,
					ChangerHelper.changeToTimestamp(order.getProducttime()));
			ps.setTimestamp(10,
					ChangerHelper.changeToTimestamp(order.getExecutetime()));
			ps.setTimestamp(11,
					ChangerHelper.changeToTimestamp(order.getCanceltime()));
			ps.setTimestamp(12, ChangerHelper.changeToTimestamp(order
					.getPredictExecutetime()));
			ps.setTimestamp(13, ChangerHelper.changeToTimestamp(order
					.getPredictLeaveTime()));
			ps.setTimestamp(14,
					ChangerHelper.changeToTimestamp(order.getActualLeaveTime()));
			ps.setInt(15, order.getRoomNum());
			ps.setString(16, order.getPersonPhone());
			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public ArrayList<OrderPO> personFind(String personname) {
		OrderPO op = new OrderPO();
		ArrayList<OrderPO> aop = new ArrayList<OrderPO>();
		try {
			String select = "select * from `order`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(5).equals(personname)) {
					op.setOrderID(rs.getString(1));
					op.setOrderprice(rs.getInt(2));
					op.setOrderstate(rs.getString(3));
					op.setHotelname(rs.getString(4));
					op.setPersonname(rs.getString(5));
					op.setRealname(rs.getString(6));
					op.setPeoplenum(rs.getInt(7));
					op.setChildnum(rs.getInt(8));
					op.setProducttime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(9)));
					op.setExecutetime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(10)));
					op.setCanceltime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(11)));
					op.setPredictExecutetime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(12)));
					op.setPredictLeaveTime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(13)));
					op.setActualLeaveTime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(14)));
					op.setRoomNum(rs.getInt(15));
					op.setPersonPhone(rs.getString(16));

					try {
						op.setRoom(osh.readRoomSer(op.getOrderID()));
					} catch (IOException e) {
						e.printStackTrace();
					}
					aop.add(op);
				}
			}
			rs.close();
			ps.close();
			conn.close();
			if(aop.size()!=0){
				return aop;
				}
				else{
				return null;
				}
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean modify(OrderPO order) {
		try {
			try {
				osh.writeRoomSer(order.getOrderID(), order.getRoom());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String update="update `order` set `订单价格`=?,`订单状态`=?,`酒店名`=?,`入住人用户名`=?,`入住人真实姓名`=?,`总人数`=?,`儿童人数`=?,`生成时间`=?,`执行时间`=?,`取消时间`=?,`最晚执行时间`=?,`预计退房时间`=?,`实际退房时间`=?,`房间数量`=?,`客户电话`=? where 订单号=?;";
			String select = "select * from `order`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(order.getOrderID())) {
					ps = conn.prepareStatement(update);
					ps.setInt(1, order.getOrderprice());
					ps.setString(2, order.getOrderstate());
					ps.setString(3, order.getHotelname());
					ps.setString(4, order.getPersonname());
					ps.setString(5, order.getRealname());
					ps.setInt(6, order.getPeoplenum());
					ps.setInt(7, order.getChildnum());
					ps.setTimestamp(8,
							ChangerHelper.changeToTimestamp(order.getProducttime()));
					ps.setTimestamp(9,
							ChangerHelper.changeToTimestamp(order.getExecutetime()));
					ps.setTimestamp(10,
							ChangerHelper.changeToTimestamp(order.getCanceltime()));
					ps.setTimestamp(11, ChangerHelper.changeToTimestamp(order
							.getPredictExecutetime()));
					ps.setTimestamp(12, ChangerHelper.changeToTimestamp(order
							.getPredictLeaveTime()));
					ps.setTimestamp(13,
							ChangerHelper.changeToTimestamp(order.getActualLeaveTime()));
					ps.setInt(14, order.getRoomNum());
					ps.setString(15, order.getPersonPhone());
					ps.setString(16, order.getOrderID());
					ps.execute();
				}
			}
			rs.close();
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	

	public ArrayList<OrderPO> hotelFind(String hotelname) {
		OrderPO op = new OrderPO();
		ArrayList<OrderPO> aop = new ArrayList<OrderPO>();
		try {
			String select = "select * from `order`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(4).equals(hotelname)) {
					op.setOrderID(rs.getString(1));
					op.setOrderprice(rs.getInt(2));
					op.setOrderstate(rs.getString(3));
					op.setHotelname(rs.getString(4));
					op.setPersonname(rs.getString(5));
					op.setRealname(rs.getString(6));
					op.setPeoplenum(rs.getInt(7));
					op.setChildnum(rs.getInt(8));
					op.setProducttime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(9)));
					op.setExecutetime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(10)));
					op.setCanceltime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(11)));
					op.setPredictExecutetime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(12)));
					op.setPredictLeaveTime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(13)));
					op.setActualLeaveTime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(14)));
					op.setRoomNum(rs.getInt(15));
					op.setPersonPhone(rs.getString(16));
					try {
						op.setRoom(osh.readRoomSer(op.getOrderID()));
					} catch (IOException e) {
						e.printStackTrace();
					}
					aop.add(op);
				}
			}
			rs.close();
			ps.close();
			conn.close();
			if(aop.size()!=0){
			return aop;
			}
			else{
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}


	public OrderPO getOrderInfo(String orderID) {
		OrderPO op = new OrderPO();
		try {
			String select = "select * from `order`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(1).equals(orderID)) {
					op.setOrderID(rs.getString(1));
					op.setOrderprice(rs.getInt(2));
					op.setOrderstate(rs.getString(3));
					op.setHotelname(rs.getString(4));
					op.setPersonname(rs.getString(5));
					op.setRealname(rs.getString(6));
					op.setPeoplenum(rs.getInt(7));
					op.setChildnum(rs.getInt(8));
					op.setProducttime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(9)));
					op.setExecutetime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(10)));
					op.setCanceltime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(11)));
					op.setPredictExecutetime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(12)));
					op.setPredictLeaveTime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(13)));
					op.setActualLeaveTime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(14)));
					op.setRoomNum(rs.getInt(15));
					op.setPersonPhone(rs.getString(16));
					try {
						op.setRoom(osh.readRoomSer(op.getOrderID()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			rs.close();
			ps.close();
			conn.close();
			return op;
		} catch (SQLException e) {
			return null;
		}
	}

	public ArrayList<OrderPO> exceptionFind() {
		OrderPO op = new OrderPO();
		ArrayList<OrderPO> aop = new ArrayList<OrderPO>();
		try {
			String select = "select * from `order`;";
			conn = builder.BuildConnection();
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while (rs.next()) {// next函数 第一次调用先指向第一条，返回bool提示是否有下一条
				if (rs.getString(3).equals("异常")
						|| rs.getString(3).equals("未执行")) {
					op.setOrderID(rs.getString(1));
					op.setOrderprice(rs.getInt(2));
					op.setOrderstate(rs.getString(3));
					op.setHotelname(rs.getString(4));
					op.setPersonname(rs.getString(5));
					op.setRealname(rs.getString(6));
					op.setPeoplenum(rs.getInt(7));
					op.setChildnum(rs.getInt(8));
					op.setProducttime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(9)));
					op.setExecutetime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(10)));
					op.setCanceltime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(11)));
					op.setPredictExecutetime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(12)));
					op.setPredictLeaveTime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(13)));
					op.setActualLeaveTime(ChangerHelper.changeToCalendar(rs
							.getTimestamp(14)));
					op.setRoomNum(rs.getInt(15));
					op.setPersonPhone(rs.getString(16));
					try {
						op.setRoom(osh.readRoomSer(op.getOrderID()));
					} catch (IOException e) {
						e.printStackTrace();
					}
					aop.add(op);
				}
			}
			rs.close();
			ps.close();
			conn.close();
			if(aop.size()!=0){
				return aop;
				}
			else{
				return null;
				}
		} catch (SQLException e) {
			return null;
		}
	}

}
