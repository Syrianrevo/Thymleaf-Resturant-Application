package com.syrianrevo.thymeleafkafkaproject.domain;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class MenuItem {
	private String itemName;
	private String itemDescription;
	private String itemPrice;
	private String itemQuantity;
	private String itemCategory;
	
	public MenuItem(JsonElement el) {		
		String in = el.getAsJsonObject().get("itemName").toString();
		String id = el.getAsJsonObject().get("itemDescription").toString();
		String ip = el.getAsJsonObject().get("itemPrice").toString();
		String iq = el.getAsJsonObject().get("itemQuantity").toString();
		String ic = el.getAsJsonObject().get("itemCategory").toString();
		
		//this.firstName = fn.substring(1, fn.length() - 1);
		this.itemName = in.substring(1, in.length() - 1);
		this.itemDescription = id.substring(1, id.length() - 1);
		this.itemPrice = ip.substring(1, ip.length() - 1);
		this.itemQuantity = iq.substring(1, iq.length() - 1);
		this.itemCategory = ic.substring(1, ic.length() - 1);		
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
}
