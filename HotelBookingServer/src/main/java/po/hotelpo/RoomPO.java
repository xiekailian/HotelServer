package po.hotelPO;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomPO implements Serializable {
	private String roomType;
	private int roomnum;
	private int roomPrice;

	public RoomPO() {
		super();
	}

	public RoomPO(String roomType, int roomnum, int roomPrice) {
		super();
		this.roomType = roomType;
		this.roomnum = roomnum;
		this.roomPrice = roomPrice;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

}
