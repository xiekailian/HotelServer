package po.promotionpo.webpromotionPO;

import java.sql.Date;
import java.util.ArrayList;

import po.PromotionPO;

/**
 *  @author 武秀峰
 *  网站促销策略：VIP会员特定商圈专属折扣（不同商圈不同等级圈折扣不一样）*/
public class CircleWebproPO extends PromotionPO {	
//	private String promotionType="CircleWebPromotion";
	/*会员等级、商圈、折扣为一组，即vipLevel[i]、circle[i]、discount[i]为对应一组某等级的会员在某商圈的折扣*/
	private int vipLevel;
	private String circle;//商圈
	private int discount;//如打九五折时，discount=95
	private static final long serialVersionUID = 1L;
	
	public CircleWebproPO() {
		super();
	}
	
		

	
	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}



}
