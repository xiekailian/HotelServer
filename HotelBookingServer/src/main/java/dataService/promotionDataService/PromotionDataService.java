package dataService.promotionDataService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

import po.*;
public interface PromotionDataService extends Remote{
	/**
	 * 添加促销策略
	 * @param promotion
	 * @return
	 * @throws RemoteException 
	 */
	public boolean add(PromotionPO promotion) throws RemoteException;
	/**
	 * 返回酒店的促销策略
	 * @param hotelnames
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList <PromotionPO> find(String hotelnames) throws RemoteException;
	/**
	 * 修改酒店促销策略
	 * @param promotion
	 * @return
	 * @throws RemoteException 
	 */
	public boolean modify(PromotionPO promotion) throws RemoteException;
	/**
	 * 删除酒店促销策略
	 * @param promotion
	 * @return
	 * @throws RemoteException 
	 */
	public boolean delete(PromotionPO promotion) throws RemoteException;
}
