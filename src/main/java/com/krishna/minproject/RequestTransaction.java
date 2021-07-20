package com.krishna.minproject;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class RequestTransaction {

	@Min(1)
	@NotNull
	private float amount;
	
	@NotNull
	@Pattern(regexp = "WITHDRAWAL|DEPOSIT")
	private String type;
	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
