package com.neusoft.book.entity;

import java.io.Serializable;
import java.util.Date;

public class Books implements Serializable {
	private Integer bid;
	private String name;
	private Date creadate;
	private Integer status;
	private String note;
	private Item item; // 表示一本书对应一种类别
	private Admin admin;// 表示一本书对应一个管理员
	private String imagepath;

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public Books(String name, Date creadate, Integer status, String note,
			Item item, Admin admin) {
		super();
		this.name = name;
		this.creadate = creadate;
		this.status = status;
		this.note = note;
		this.item = item;
		this.admin = admin;
	}

	public Books() {

	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreadate() {
		return creadate;
	}

	public void setCreadate(Date creadate) {
		this.creadate = creadate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
