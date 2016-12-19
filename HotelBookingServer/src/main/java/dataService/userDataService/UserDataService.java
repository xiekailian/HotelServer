package dataService.userDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;
import po.personPO.PersonPO;
import po.personPO.RecordPO;

public interface UserDataService extends Remote {
	/**
	 * 新增一个客户信息
	 * @param personInfo
	 * @return
	 * @throws RemoteException
	 */
	public boolean addPerson(PersonPO personInfo) throws RemoteException;

	/**
	 * 根据客户名寻找一个客户信息
	 * @param personname
	 * @return
	 * @throws RemoteException
	 */
	public PersonPO findPerson(String personname) throws RemoteException;

	/**
	 * 修改一个客户信息
	 * @param personInfo
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyPerson(PersonPO personInfo) throws RemoteException;

	/**
	 * 验证一个客户登陆
	 * @param personname
	 * @param password
	 * @return
	 * @throws RemoteException
	 */
	public boolean personLogin(String personname, String password)
			throws RemoteException;

	/**
	 * 寻找一个网站营销人员信息
	 * @param marketname
	 * @return
	 * @throws RemoteException
	 */
	public MarketPO findMarket(String marketname) throws RemoteException;

	/**
	 * 根据客户ID寻找一个客户信息
	 * @param personID
	 * @return
	 * @throws RemoteException
	 */
	public PersonPO findPerson(int personID) throws RemoteException;

	/**
	 * 修改一个网站营销人员信息
	 * @param marketInfo
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyMarket(MarketPO marketInfo) throws RemoteException;

	/**
	 * 验证一个网站营销人员登陆
	 * @param marketname
	 * @param password
	 * @return
	 * @throws RemoteException
	 */
	public boolean marketLogin(String marketname, String password)
			throws RemoteException;

	/**
	 * 更改指定客户名的信用值
	 * @param username
	 * @param credit
	 * @return
	 * @throws RemoteException
	 */
	public boolean changeCredit(String username, int credit)
			throws RemoteException;

	/**
	 * 根据用户名寻找酒店工作人员
	 * @param hotelWorkername
	 * @return
	 * @throws RemoteException
	 */
	public HotelWorkerPO findHotelWorker(String hotelWorkername)
			throws RemoteException;

	/**
	 * 修改酒店工作人员信息
	 * @param hotelWorkerInfo
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyHotelWorker(HotelWorkerPO hotelWorkerInfo)
			throws RemoteException;

	/**
	 * 验证酒店工作人员登陆
	 * @param hotelWorkername
	 * @param password
	 * @return
	 * @throws RemoteException
	 */
	public boolean hotelWorkerLogin(String hotelWorkername, String password)
			throws RemoteException;

	/**
	 * 增加一个网站营销人员
	 * @param marketInfo
	 * @return
	 * @throws RemoteException
	 */
	public boolean addMarket(MarketPO marketInfo) throws RemoteException;

	/**
	 * 验证网站管理人员登录
	 * @param managername
	 * @param password
	 * @return
	 * @throws RemoteException
	 */
	public boolean managerLogin(String managername, String password)
			throws RemoteException;

	/**
	 * 增加一个酒店工作人员
	 * @param hotelworker
	 * @return
	 * @throws RemoteException
	 */
	public boolean addHotelWorker(HotelWorkerPO hotelworker)
			throws RemoteException;

	/**
	 * 写入指定客户名的信用记录
	 * @param personname
	 * @param record
	 * @return
	 * @throws RemoteException
	 */
	public boolean writeRecord(String personname, RecordPO record)
			throws RemoteException;// 新增用于写入客户信用记录，传入客户名和此次写入的record对象
	/**
	 * 读取指定客户名的信用记录
	 * @param personname
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RecordPO> getRecord(String personname)throws RemoteException;
}
