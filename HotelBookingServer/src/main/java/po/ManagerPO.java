package po;

import java.io.Serializable;

/**
 * 
 * @author xiamutian
 *
 */
public class ManagerPO  implements Serializable {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ManagerPO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public ManagerPO() {
		this.username=null;
		this.password=null;
	}
	
}
