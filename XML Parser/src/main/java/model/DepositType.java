package model;

public class DepositType {
	
	private String type;
	
	public DepositType(){}
	
	public DepositType(String type){
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "type = " + type;
	}
	
}
