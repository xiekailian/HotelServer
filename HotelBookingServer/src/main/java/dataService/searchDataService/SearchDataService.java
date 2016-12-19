package dataService.searchDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SearchPO;

public interface SearchDataService extends Remote {
	/**
	 * 查找指定客户的搜索记录
	 * @param username
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<SearchPO> showSearchHistory(String username)
			throws RemoteException;

	/**
	 * 新增一条搜索记录
	 * @param s
	 * @return
	 * @throws RemoteException
	 */
	public boolean addSearchHistory(SearchPO s) throws RemoteException;

	/**
	 * 删除一条搜索记录
	 * @param s
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteSearchHistory(SearchPO s) throws RemoteException;
}
