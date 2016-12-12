package po.hotelPO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;


public class RoomPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String roomType;
	private String roomnum;//房间号
	private int roomPrice;
	private ArrayList<Calendar> checkInTime;//入住日期
	private ArrayList<Calendar> checkOutTime;//退房日期
	
	public RoomPO() {
		super();
	}
	
	public RoomPO(String roomType, String roomnum, int roomPrice, ArrayList<Calendar> checkInTime,
			ArrayList<Calendar> checkOutTime) {
		super();
		this.roomType = roomType;
		this.roomnum = roomnum;
		this.roomPrice = roomPrice;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}


	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public ArrayList<Calendar> getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(ArrayList<Calendar> checkInTime) {
		this.checkInTime = checkInTime;
	}

	public ArrayList<Calendar> getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(ArrayList<Calendar> checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	

}
