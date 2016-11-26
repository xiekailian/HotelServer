package data.hotelData;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataService.hotelDataService.*;
import po.*;

public class HotelDataMock implements HotelDataService{

	public HotelPO showHotelinfo(String Hotelname) throws RemoteException {
		ArrayList<Boolean> service=new ArrayList<Boolean>();
		service.add(true);
		service.add(true);
		service.add(false);
		service.add(false);
		ArrayList<String> roomType=new ArrayList<String>();
		roomType.add("单人房");
		roomType.add("双人房");
		roomType.add("大床房");
		roomType.add("总统套房");
		ArrayList <Integer>roomNum=new ArrayList<Integer>();
		roomNum.add(50);
		roomNum.add(20);
		roomNum.add(70);
		roomNum.add(15);
		ArrayList <Integer>roomPrice=new ArrayList<Integer>();
		roomPrice.add(300);
		roomPrice.add(500);
		roomPrice.add(400);
		roomPrice.add(1000);
		ArrayList<String> comment=new ArrayList<String>();
		comment.add("很好，很棒");
		comment.add("不好，不棒");
		comment.add("还好，一般");
		
		HotelPO po=new HotelPO("南京大酒店",5,"物美价廉",service,"仙林大道168号","仙林大学城",9.3, roomType,roomNum,roomPrice,comment,"小夏");
		return po;
	}

	public boolean modify(HotelPO hotelinfo) throws RemoteException {
		if(hotelinfo.getHotelname().equals("南京大酒店"))
			return true;
		return false;
	}

	public boolean addComment(String comment, String username, String hotelname) throws RemoteException {
		if(hotelname!=null)
			return true;
		return false;
	}

	public ArrayList<HotelPO> findWithReq(HotelPO condition) throws RemoteException {
		ArrayList<HotelPO> list=new ArrayList<HotelPO>();
		ArrayList<Boolean> service=new ArrayList<Boolean>();
		service.add(true);
		service.add(true);
		service.add(false);
		service.add(false);
		ArrayList<String> roomType=new ArrayList<String>();
		roomType.add("单人房");
		roomType.add("双人房");
		roomType.add("大床房");
		roomType.add("总统套房");
		ArrayList <Integer>roomNum=new ArrayList<Integer>();
		roomNum.add(50);
		roomNum.add(20);
		roomNum.add(70);
		roomNum.add(15);
		ArrayList <Integer>roomPrice=new ArrayList<Integer>();
		roomPrice.add(300);
		roomPrice.add(500);
		roomPrice.add(400);
		roomPrice.add(1000);
		ArrayList<String> comment=new ArrayList<String>();
		comment.add("很好，很棒");
		comment.add("不好，不棒");
		comment.add("还好，一般");
		
		HotelPO po=new HotelPO("南京大酒店",5,"物美价廉",service,"仙林大道168号","仙林大学城",9.3, roomType,roomNum,roomPrice,comment,"小夏");
		HotelPO po2=new HotelPO("仙林大酒店",3,"快捷方便",service,"仙林小道190号","仙林大学城",4.5,roomType,roomNum,roomPrice,comment,"大夏");
		list.add(po);
		list.add(po2);
		return list;
	}

	public boolean roomModify(String roomtype, int number) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
