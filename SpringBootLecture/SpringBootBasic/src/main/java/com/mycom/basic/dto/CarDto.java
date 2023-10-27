package com.mycom.basic.dto;

import java.util.Arrays;

public class CarDto {
	private String name;
	private int price;
	private String owner;
	private String[] nickNames;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String[] getNickNames() {
		return nickNames;
	}
	public void setNickNames(String[] nickNames) {
		this.nickNames = nickNames;
	}
	
	
	@Override
	public String toString() {
		return "CarDto [name=" + name + ", price=" + price + ", owner=" + owner + ", nickNames="
				+ Arrays.toString(nickNames) + "]";
	}
	
	
}
