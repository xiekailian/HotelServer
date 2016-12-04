package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.hotelData.HotelData;
import data.hotelData.HotelDataMock;
import data.orderData.OrderData;
import data.orderData.OrderDataMock;
import data.promotionData.PromotionData;
import data.promotionData.PromotionDataMock;
import data.searchData.SearchData;
import data.searchData.SearchDataMock;
import data.userData.UserData;
import data.userData.UserDataMock;
import dataService.hotelDataService.HotelDataService;
import dataService.orderDataService.OrderDataService;
import dataService.promotionDataService.PromotionDataService;
import dataService.searchDataService.SearchDataService;
import dataService.userDataService.UserDataService;
import po.hotelPO.HotelPO;
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
		hoteldataservice = new HotelDataMock();
		orderdataService = new OrderDataMock();
		promotiondataService = new PromotionDataMock();
		searchdataservice = new SearchDataMock();
		userdataservice = new UserDataMock();
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

	public boolean addPerson(PersonPO personInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.addPerson(personInfo);
	}

	public PersonPO findPerson(String personname) throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.findPerson(personname);
	}

	public boolean modifyPerson(PersonPO personInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return userdataservice.modifyPerson(personInfo);
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

	public boolean addComment(String comment, String username, String hotelname)
			throws RemoteException {
		// TODO Auto-generated method stub
		return hoteldataservice.addComment(comment, username, hotelname);
	}

	public ArrayList<HotelPO> findWithReq(HotelPO worstcondition,
			HotelPO bestcondition) throws RemoteException {
		// TODO Auto-generated method stub
		return hoteldataservice.findWithReq(worstcondition, bestcondition);
	}

	public boolean roomModify(String roomtype, int number)
			throws RemoteException {
		// TODO Auto-generated method stub
		return hoteldataservice.roomModify(roomtype, number);
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

	public boolean modify(HotelPO hotelinfo) throws RemoteException {
		// TODO Auto-generated method stub
		return hoteldataservice.modify(hotelinfo);
	}

	public boolean modifyMarket(MarketPO marketInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean add(PromotionPO promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<PromotionPO> find(String hotelnames)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean modify(PromotionPO promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(PromotionPO promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean add(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean writeRecord(String personname, RecordPO record)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
