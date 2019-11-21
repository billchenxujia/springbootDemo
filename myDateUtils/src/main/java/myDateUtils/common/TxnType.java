package myDateUtils.common;

public enum TxnType {
	PREORDER("1000");
	private final String name;
	private TxnType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
}
