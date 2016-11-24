package po;

import java.io.Serializable;
import java.util.*;


/**
 * 
 * @author xiamutian
 *
 */
public class PromotionPO implements Serializable {
	private String name;
	private Calendar start;
	private Calendar end;
	private int type;
	private double discount;
	private ArrayList <String> hotel;
	public PromotionPO(String name, Calendar start, Calendar end, int type,
			double discount, ArrayList<String> hotel) {
		super();
		this.name = name;
		this.start = start;
		this.end = end;
		this.type = type;
		this.discount = discount;
		this.hotel = hotel;
	}
	public PromotionPO(){
		name=null;
		start=null;
		end=null;
		type=0;
		discount=0.0;
		hotel=null;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calendar getStart() {
		return start;
	}
	public void setStart(Calendar start) {
		this.start = start;
	}
	public Calendar getEnd() {
		return end;
	}
	public void setEnd(Calendar end) {
		this.end = end;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public List<String> getHotel() {
		return hotel;
	}
	public void setHotel(ArrayList<String> hotel) {
		this.hotel = hotel;
	}
	}
