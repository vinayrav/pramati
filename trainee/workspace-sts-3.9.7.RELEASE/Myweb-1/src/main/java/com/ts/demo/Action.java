package com.ts.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
public class Action {
	@Id
	@GeneratedValue
	private String ss;
	private int id;
	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Action [ss=" + ss + ", id=" + id + "]";
	}

	

}