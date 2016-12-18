package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.hotelData.HotelData;
//import data.hotelData.HotelDataMock;
import data.orderData.OrderData;
import data.promotionData.PromotionData;
import data.searchData.SearchData;
import data.userData.UserData;
import dataService.hotelDataService.HotelDataService;
import dataService.orderDataService.OrderDataService;
import dataService.promotionDataService.PromotionDataService;
import dataService.searchDataService.SearchDataService;
import dataService.userDataService.UserDataService;
import po.hotelPO.CommentPO;
import po.hotelPO.HotelPO;
import po.hotelPO.RoomPO;
import po.personPO.PersonPO;
import po.personPO.RecordPO;
import po.HotelWorkerPO;
import po.MarketPO;
import po.OrderPO;
import po.PromotionPO;
import po.SearchPO;

public class DataRemoteObject extends UnicastRemoteObject implements
		HotelDataService, OrderDataService, PromotionDataService,
		UserDataService, SearchDataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4029039744279087114L;
	private HotelDataService hoteldataservice;
	private OrderDataService orderdataService;
	private PromotionDataService promotiondataService;
	private SearchDataService searchdataservice;
	private UserDataService userdataservice;

	protected DataRemoteObject() throws RemoteException {// ���췽������ʵ��Service�ľ��巽��
		hoteldataservice = new HotelData();
		orderdataService = new OrderData();
		promotiondataService = new PromotionData();
		searchdataservice = new SearchData();
		userdataservice = new UserData();
	}

	public ArrayList<SearchPO> showSearchHistory(String username)
			throws RemoteException {
		// TODO Auto-generated method stub
		return searchdataservice.showSearchHistory(username);
	}

	public boolean addSearchHistory(SearchPO s) throws RemoteException {
		// TODO Auto-generated method stub
		return searchdataservice.addSearchHistory(s);
	}

	public boolean deleteSearchHistory(SearchPO s) throws RemoteException {
		// TODO Auto-generated method stub
		return searchdataservice.deleteSearchHistory(s);
	}


	public PersonPO findPerson(String personname) throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.findPerson(personname);
	}


	public boolean personLogin(String personname, String password)
			throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.personLogin(personname, password);
	}

	public MarketPO findMarket(String marketname) throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.findMarket(marketname);
	}

	public boolean marketLogin(String marketname, String password)
			throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.marketLogin(marketname, password);
	}

	public HotelWorkerPO findHotelWorker(String hotelWorkername)
			throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.findHotelWorker(hotelWorkername);
	}

	public boolean modifyHotelWorker(HotelWorkerPO hotelWorkerInfo)
			throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.modifyHotelWorker(hotelWorkerInfo);
	}

	public boolean hotelWorkerLogin(String hotelWorkername, String password)
			throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.hotelWorkerLogin(hotelWorkername, password);
	}

	public boolean addMarket(MarketPO marketInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.addMarket(marketInfo);
	}

	public boolean managerLogin(String managername, String password)
			throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.managerLogin(managername, password);
	}

	public ArrayList<OrderPO> personFind(String personname)
			throws RemoteException {
		// TODO Auto-generated method stub
		return orderdataService.personFind(personname);
	}

	public boolean modify(OrderPO order) throws RemoteException {
		return orderdataService.modify(order);
		// TODO Auto-generated method stub
	}

	public ArrayList<OrderPO> hotelFind(String hotelname)
			throws RemoteException {
		// TODO Auto-generated method stub
		return orderdataService.hotelFind(hotelname);
	}

	public ArrayList<OrderPO> exceptionFind() throws RemoteException {
		// TODO Auto-generated method stub
		return orderdataService.exceptionFind();
	}

	public HotelPO showHotelinfo(String Hotelname) throws RemoteException {
		// TODO Auto-generated method stub
		return hoteldataservice.showHotelinfo(Hotelname);
	}

	public boolean addComment(CommentPO comment)
			throws RemoteException {
		// TODO Auto-generated method stub
		return hoteldataservice.addComment(comment);
	}

	public boolean addHotel(HotelPO hotel) throws RemoteException{
		return hoteldataservice.addHotel(hotel);
	}
	public boolean roomModify(String hotelname, ArrayList<RoomPO> rooms)
			throws RemoteException {
		// TODO Auto-generated method stub
		return hoteldataservice.roomModify(hotelname, rooms);
	}

	public boolean changeCredit(String username, int credit)
			throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.changeCredit(username, credit);
	}

	public boolean addHotelWorker(HotelWorkerPO hotelworker)
			throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.addHotelWorker(hotelworker);
	}


	public ArrayList<PromotionPO> find(String hotelnames)
			throws RemoteException {
		// TODO Auto-generated method stub
		return promotiondataService.find(hotelnames);
	}

	public boolean modify(PromotionPO promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return promotiondataService.modify(promotion);
	}

	public boolean delete(PromotionPO promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return promotiondataService.delete(promotion);
	}

	public boolean add(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return orderdataService.add(order);
	}


	public boolean modifyPerson(PersonPO personInfo)
			throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.modifyPerson(personInfo);
	}

	public boolean writeRecord(String personname, po.personPO.RecordPO record)
			throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.writeRecord(personname, record);
	}

	public boolean modify(po.hotelPO.HotelPO hotelinfo) throws RemoteException {
		// TODO Auto-generated method stub
		return hoteldataservice.modify(hotelinfo);
	}

	public ArrayList<po.hotelPO.HotelPO> findWithReq(
			po.hotelPO.HotelPO worstCondition,
			po.hotelPO.HotelPO bestCondition) throws RemoteException {
		// TODO Auto-generated method stub
		return hoteldataservice.findWithReq(worstCondition, bestCondition);
	}

	public boolean addPerson(PersonPO personInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.addPerson(personInfo);
	}

	public boolean modifyMarket(MarketPO marketInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.modifyMarket(marketInfo);
	}

	public boolean add(PromotionPO promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return promotiondataService.add(promotion);
	}

	public PersonPO findPerson(int personID) throws RemoteException {
	
		return userdataservice.findPerson(personID);
	}

	public ArrayList<RecordPO> getRecord(String personname)throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.getRecord(personname);
	}

	public OrderPO getOrderInfo(String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return orderdataService.getOrderInfo(orderID);
	}

	

}
