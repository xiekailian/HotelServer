package po.hotelPO;

import java.io.Serializable;
import java.util.ArrayList;

public class HotelPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hotelID;
	private String hotelname;
	private int star;// 酒店星级
	private String feature;// 酒店简介
	private ArrayList<Boolean> service;// 设施服务，需要初始化list，所有的都要设为false, 
	private String address;
	private String circle;
	private double score;// 酒店平均评分
	private ArrayList<RoomPO> room;
	private ArrayList<CommentPO> comment;
	private String hotelworker;
	private String hotelPhone;//酒店电话号码


	public HotelPO() {
		super();
	}

	public HotelPO(String hotelname, int star, String feature,
			ArrayList<Boolean> service, String address, String circle,
			double score, ArrayList<RoomPO> room, ArrayList<CommentPO> comment,
			String hotelworker) {
		super();
		this.hotelname = hotelname;
		this.star = star;
		this.feature = feature;
		this.service = service;
		this.address = address;
		this.circle = circle;
		this.score = score;
		this.room = room;
		this.comment = comment;
		this.hotelworker = hotelworker;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public ArrayList<Boolean> getService() {
		return service;
	}

	public void setService(ArrayList<Boolean> service) {
		this.service = service;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public ArrayList<RoomPO> getRoom() {
		return room;
	}

	public void setRoom(ArrayList<RoomPO> room) {
		this.room = room;
	}

	public ArrayList<CommentPO> getComment() {
		return comment;
	}

	public void setComment(ArrayList<CommentPO> comment) {
		this.comment = comment;
	}

	public String getHotelworker() {
		return hotelworker;
	}

	public void setHotelworker(String hotelworker) {
		this.hotelworker = hotelworker;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelPhone() {
		return hotelPhone;
	}

	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}

}
