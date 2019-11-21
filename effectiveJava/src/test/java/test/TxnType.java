package test;

/**
 * 
 * 类 @code(TxnType)
 *
 * <p>
 *  功能简介：
 * <p>
* 交易类型枚举类
 * <p>
 *  创建时间：2019年4月24日
 *
 * @author chenxj
 */
public enum TxnType {
	
	PREORDER(1009,"预定单交易"),
	
	
	ALIPAY(1010,"支付宝交易");
		
	@SuppressWarnings("unused")
	private final int value;
	
	@SuppressWarnings("unused")
	private final String desc;
	
	private TxnType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
}
