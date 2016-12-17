package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import po.hotelPO.RoomPO;

/**
 * 
 * @author xiamutian
 * @author 武秀峰
 * 
 */
public class OrderPO implements Serializable {
	// 订单的基本信息
	private static final long serialVersionUID = 1L;

	private String orderID;// 时间201602020512（4年2月2日2时2分）+酒店ID（5位）+客户ID(5位)
	private int orderprice;
	private String ordernum;
	private String orderstate;//订单状态,“未执行”、“已执行”、“已撤销”、“异常”、“延期”

	// 酒店信息
	private String hotelname;
	private ArrayList<RoomPO> room;//包括房间类型、房间号、房间价格

	// 入住者信息
	private String personname;
	private String realname;// 客户真实姓名
	private int peoplenum;// 包括child的人数
	private int childnum;// 儿童的人数。默认为0

	// 一系列时间
	private Calendar producttime;// 订单生成时间
	private Calendar executetime;// 订单执行时间
	private Calendar canceltime;// 订单取消时间
	private Calendar latestExecutetime;// 订单最晚执行时间
	private Calendar predictLeaveTime;// 预计退房时间
	private Calendar actualLeaveTime;// 实际退房时间

	// 空构造函数
	public OrderPO() {

	}

	// vo转po
	// 有所有参数的构造函数
	public OrderPO(String orderID, int orderprice, String ordernum,
			String orderstate, String hotelname, ArrayList<RoomPO> room,
			String personname, String realname, int peoplenum, int childnum,
			Calendar producttime, Calendar executetime, Calendar canceltime,
			Calendar latestExecutetime, Calendar predictLeaveTime,
			Calendar actualLeaveTime) {
		super();
		this.orderID = orderID;
		this.orderprice = orderprice;
		this.ordernum = ordernum;
		this.orderstate = orderstate;
		this.hotelname = hotelname;
		this.room=room;
		this.personname = personname;
		this.realname = realname;
		this.peoplenum = peoplenum;
		this.childnum = childnum;
		this.producttime = producttime;
		this.executetime = executetime;
		this.canceltime = canceltime;
		this.latestExecutetime = latestExecutetime;
		this.predictLeaveTime = predictLeaveTime;
		this.actualLeaveTime = actualLeaveTime;
	}

	// get and set
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public int getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(int orderprice) {
		this.orderprice = orderprice;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}

	public String getHotelname() {
		return hotelname;
	}
	public void setRoom(ArrayList<RoomPO> room) {
		this.room = room;
	}
	public ArrayList<RoomPO> getRoom() {
		return room;
	}
	
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}


	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public int getPeoplenum() {
		return peoplenum;
	}

	public void setPeoplenum(int peoplenum) {
		this.peoplenum = peoplenum;
	}

	public int getChildnum() {
		return childnum;
	}

	public void setChildnum(int childnum) {
		this.childnum = childnum;
	}

	public Calendar getProducttime() {
		return producttime;
	}

	public void setProducttime(Calendar producttime) {
		this.producttime = producttime;
	}

	public Calendar getExecutetime() {
		return executetime;
	}

	public void setExecutetime(Calendar executetime) {
		this.executetime = executetime;
	}

	public Calendar getCanceltime() {
		return canceltime;
	}

	public void setCanceltime(Calendar canceltime) {
		this.canceltime = canceltime;
	}

	public Calendar getLatestExecutetime() {
		return latestExecutetime;
	}

	public void setLatestExecutetime(Calendar latestExecutetime) {
		this.latestExecutetime = latestExecutetime;
	}

	public Calendar getPredictLeaveTime() {
		return predictLeaveTime;
	}

	public void setPredictLeaveTime(Calendar predictLeaveTime) {
		this.predictLeaveTime = predictLeaveTime;
	}

	public Calendar getActualLeaveTime() {
		return actualLeaveTime;
	}

	public void setActualLeaveTime(Calendar actualLeaveTime) {
		this.actualLeaveTime = actualLeaveTime;
	}

}
