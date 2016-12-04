package data.dataHelper.folder;

import java.io.*;

public class personFolderHelper {
	private static String path = "src/main/resources/person/";

	/**
	 * 用于新建客户个人文件夹
	 * 
	 * @param personname
	 */
	public void mkdirs(String personname) {
		path = path + personname;
		File A = new File(path);
		if (A.exists() == false) {
			A.mkdirs();
		}
	}

}
