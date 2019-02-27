package com.ts.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	private int cost;
	private String name;
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Book [cost=" + cost + ", name=" + name + "]";
	}

}
