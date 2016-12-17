package po.hotelPO;

import java.io.Serializable;
import java.util.Calendar;

public class CommentPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hotelname;
	private String personname;// 评价者
	private Calendar time;
	private int score;
	private String content;// 评价内容

	public CommentPO() {
		super();
	}

	public CommentPO(String hotelname, String personname, Calendar time,
			int score, String content) {
		super();
		this.hotelname = hotelname;
		this.personname = personname;
		this.time = time;
		this.score = score;
		this.content = content;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
