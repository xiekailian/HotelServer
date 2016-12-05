package data.dataHelper.folder;

import java.io.File;

public class orderFolderHelper {
	private static String path = "src/main/resources/order/";

	/**
	 * 用于新建订单文件夹文件夹
	 * 
	 * @param orderID
	 */
	public void mkdirs(String orderID) {
		path = path + orderID;
		File A = new File(path);
		if (A.exists() == false) {
			A.mkdirs();
		}
	}
}
