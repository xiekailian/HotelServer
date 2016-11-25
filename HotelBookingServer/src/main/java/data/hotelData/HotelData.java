package data.hotelData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataService.hotelDataService.HotelDataService;
import po.HotelPO;
import po.SearchPO;

public class HotelData /*implements HotelDataService*/{
	private static HotelData hoteldata;
	/**
	 * 
	 * @return 唯一的HotelData对象
	 */
	public static HotelData getInstance(){
		if(hoteldata==null)
			hoteldata=new HotelData();
		return hoteldata;
	}
	public HotelPO showHotelinfo(String Hotelname) throws RemoteException{
		System.out.println("调用成功");
		return null;
	}
	public boolean addComment (String comment,String username,String hotelname)throws RemoteException{
		boolean result=true;
		if(comment==null||username==null||hotelname==null)
			result=false;
		return result;
		
	}
	public ArrayList<HotelPO> findWithReq(HotelPO a) throws RemoteException{
		System.out.println("findWithReq is calle");
		return null;
	}
	public boolean modify(HotelPO hotelinfo) throws RemoteException{
		boolean result=true;
		if(hotelinfo==null)
			result=false;
		return result;
	}
	public boolean roomModify(String roomtype, int number) throws RemoteException{
		boolean result=true;
		if(roomtype==null||number==0)
			result=false;
		return result;
	}

	
}
