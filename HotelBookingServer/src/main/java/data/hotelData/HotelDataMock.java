package data.hotelData;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataService.hotelDataService.*;
import po.*;

public class HotelDataMock implements HotelDataService{

	public HotelPO showHotelinfo(String Hotelname) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean modify(HotelPO hotelinfo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addComment(String comment, String username, String hotelname)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<HotelPO> findWithReq(HotelPO condition)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean roomModify(String roomtype, int number)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
