package com.wellsfargo.fsd.cpk.entity;

public class kit {

	private Integer kitID;
	private String productitem;
	private Double cost;
	private String productdescription;
	
	public kit() {
		
		
	}

	public kit(Integer kitID, String productitem, Double cost, String productdescription) {
		super();
		this.kitID = kitID;
		this.productitem = productitem;
		this.cost = cost;
		this.productdescription = productdescription;
	}

	public Integer getKitID() {
		return kitID;
	}

	public void setKitID(Integer kitID) {
		this.kitID = kitID;
	}

	public String getProductitem() {
		return productitem;
	}

	public void setProductitem(String productitem) {
		this.productitem = productitem;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	@Override
	public String toString() {
		return "kit [kitID=" + kitID + ", productitem=" + productitem + ", cost=" + cost + ", productdescription="
				+ productdescription + "]";
	}
	
	
	
		
}
