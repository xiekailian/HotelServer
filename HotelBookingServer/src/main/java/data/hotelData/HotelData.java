package data.hotelData;

import java.util.ArrayList;
import java.util.List;

import dataService.hotelDataService.HotelDataService;
import po.SearchPO;
import po.hotelpo.HotelPO;

public class HotelData /* implements HotelDataService */{
	private static HotelData hoteldata = null;

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
		return null;
	}

	public boolean addComment(String comment, String username, String hotelname) {
		boolean result = true;
		if (comment == null || username == null || hotelname == null)
			result = false;
		return result;

	}

	public ArrayList<HotelPO> findWithReq(HotelPO a) {
		System.out.println("findWithReq is called");
		return null;
	}

	public boolean modify(HotelPO hotelinfo) {
		boolean result = true;
		if (hotelinfo == null)
			result = false;
		return result;
	}

	public boolean roomModify(String roomtype, int number) {
		boolean result = true;
		if (roomtype == null || number == 0)
			result = false;
		return result;
	}

}
