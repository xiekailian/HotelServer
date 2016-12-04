package data.dataHelper.folder;

import java.io.File;

public class hotelFolderHelper {
	private static String path = "src/main/resources/hotel/";

	/**
	 * 用于新建酒店文件夹
	 * 
	 * @param hotelname
	 */
	public void mkdirs(String hotelname) {
		path = path + hotelname;
		File A = new File(path);
		if (A.exists() == false) {
			A.mkdirs();
		}
	}


	
		
}
