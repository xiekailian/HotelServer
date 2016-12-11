package data.hotelData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dataService.hotelDataService.*;
import po.*;
import po.hotelPO.CommentPO;
import po.hotelPO.HotelPO;
import po.hotelPO.RoomPO;
<<<<<<< HEAD
=======
import vo.OrderVO;
import vo.hotelVO.hotelblVO.RoomVO;
>>>>>>> master

public class HotelDataMock implements HotelDataService {

	public HotelPO showHotelinfo(String Hotelname) throws RemoteException {
		
		/*
		 * public HotelPO(String hotelname, int star, String feature,
			ArrayList<Boolean> service, String address, String circle,
			double score, ArrayList<RoomPO> room, ArrayList<CommentPO> comment,
			String hotelworker)
			
			public CommentPO(String hotelname, String personname, Calendar time,
			int score, String content)
			
			public RoomPO(String roomType, String roomnum, int roomPrice)
		 */
		
		ArrayList<Boolean> service = new ArrayList<Boolean>();
		service.add(true);
		service.add(true);
		service.add(false);
		service.add(false);
		
		RoomPO room1=new RoomPO("单人间", "111", 300, null, null);
		RoomPO room2=new RoomPO("双人间", "222", 500, null, null);
		ArrayList<RoomPO> roomList=new ArrayList<RoomPO>();
		roomList.add(room1);
		roomList.add(room2);
		
		CommentPO comment1=new CommentPO("南京大酒店","xiamutian",null,5,"good");
		CommentPO comment2=new CommentPO("南京大酒店","xiaxia",null,4,"ok");
		ArrayList<CommentPO> commentList=new ArrayList<CommentPO>();
		commentList.add(comment1);
		commentList.add(comment2);
		
		HotelPO hotelpo=new HoyelPO("南京大酒店", 5, "good", 
				service, "仙林大道", "仙林大学城",
				4.8, roomList, commentList, "xiamutian");
		

		return hotelpo;
	}

	public boolean modify(HotelPO hotelinfo) throws RemoteException {
		if (hotelinfo.getHotelname().equals("南京大酒店"))
			return true;
		return false;
	}

	public boolean addComment(CommentPO comment)
<<<<<<< HEAD
			throws RemoteException{
		
=======
			throws RemoteException {
		if (comment.getHotelname().equals("南京大酒店"))
			return true;
>>>>>>> master
		return false;
	}

	public ArrayList<HotelPO> findWithReq(HotelPO worstcondition, HotelPO bestcondition) throws RemoteException {
		ArrayList<Boolean> service = new ArrayList<Boolean>();
		service.add(true);
		service.add(true);
		service.add(false);
		service.add(false);
		
		RoomPO room1=new RoomPO("单人间", "111", 300, null, null);
		RoomPO room2=new RoomPO("双人间", "222", 500, null, null);
		ArrayList<RoomPO> roomList=new ArrayList<RoomPO>();
		roomList.add(room1);
		roomList.add(room2);
		
		CommentPO comment1=new CommentPO("南京大酒店","xiamutian",null,5,"good");
		CommentPO comment2=new CommentPO("南京大酒店","xiaxia",null,4,"ok");
		ArrayList<CommentPO> commentList=new ArrayList<CommentPO>();
		commentList.add(comment1);
		commentList.add(comment2);
		
		HotelPO hotelpo1=new HoyelPO("酒店1", 5, "very good", 
				service, "仙林大道", "仙林大学城",
				4.8, roomList, commentList, "xiamutian");
		HotelPO hotelpo2=new HoyelPO("酒店2", 4, "good", 
				service, "新街口道路1", "新街口",
				4.3, roomList, commentList, "tiantian");
		
		ArrayList<HotelPO> hotelList=new ArrayList<HotelPO>();
		hotelList.add(hotelpo1);
		hotelList.add(hotelpo2);
		
		return hotelList;

	}

<<<<<<< HEAD
	public boolean addHotel(HotelPO hotel) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean roomModify(String hotelname, ArrayList<RoomPO> rooms)
			throws RemoteException {
		// TODO Auto-generated method stub
=======

	public boolean roomModify(String hotelname, ArrayList<RoomPO> roompoList) throws RemoteException {
		if(hotelname.equals("南京大酒店")){
			return true;
		}
>>>>>>> master
		return false;
	}

	public boolean addHotel(HotelPO hotelpo){
		if(hotelpo.getHotelname().equals("南京大酒店")){
			return true;
		}else{
			return false;
		}
		
	}
}
