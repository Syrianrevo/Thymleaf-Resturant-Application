package com.syrianrevo.thymeleafkafkaproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Ammar Mohrat.
 */
@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String itemName;
    

	private String itemDescription;
    private String itemPrice; 
    private String itemQuantity;
    private String itemCategory;

    protected Entry() {}
    
    
    public Entry(String itemName, String itemDescription, String itemPrice, String itemQuantity, String itemCategory) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice; 
        this.itemQuantity = itemQuantity; 
        this.itemCategory = itemCategory; 
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
