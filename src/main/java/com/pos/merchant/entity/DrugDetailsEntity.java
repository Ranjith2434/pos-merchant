package com.pos.merchant.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "drug_details")
public class DrugDetailsEntity {
	
	@Id	
	@JsonProperty("id")
	public Integer id;
	
	@JsonProperty("name")
	public String name;
	
	@JsonProperty("imgUrl")
	public String imgUrl;
	
	@JsonProperty("price")
	public String price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "DrugDetailsEntity [id=" + id + ", name=" + name + ", imgUrl=" + imgUrl + ", price=" + price + "]";
	}	
	
}
