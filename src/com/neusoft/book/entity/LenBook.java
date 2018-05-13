package com.neusoft.book.entity;

import java.util.Date;

public class LenBook {
   private Integer leid;
   private Books books;
   private Member member;
   private Date credate;
   private Date retdate;
   private int retday;
   private int creditno;
   public int getCreditno() {
	return creditno;
}
public void setCreditno(int creditno) {
	this.creditno = creditno;
}
private String retstatus;
public String getRetstatus() {
	return retstatus;
}
public void setRetstatus(String retstatus) {
	this.retstatus = retstatus;
}
public int getRetday() {
	return retday;
}
public void setRetday(int retday) {
	this.retday = retday;
}

@Override
public String toString() {
	return "LenBook [leid=" + leid + ", books=" + books + ", member=" + member
			+ ", credate=" + credate + ", retdate=" + retdate + ", retday="
			+ retday + ", retstatus=" + retstatus + "]";
}
public Integer getLeid() {
	return leid;
}
public void setLeid(Integer leid) {
	this.leid = leid;
}
public Books getBooks() {
	return books;
}
public void setBooks(Books books) {
	this.books = books;
}
public Member getMember() {
	return member;
}
public void setMember(Member member) {
	this.member = member;
}
public Date getCredate() {
	return credate;
}
public void setCredate(Date credate) {
	this.credate = credate;
}
public Date getRetdate() {
	return retdate;
}
public void setRetdate(Date retdate) {
	this.retdate = retdate;
}
   
}
