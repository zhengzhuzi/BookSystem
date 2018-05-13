package com.neusoft.book.entity;

import java.io.Serializable;

public class Member implements Serializable {
  private String mid;
  private String name;
  private Integer age;
  private Integer sex;
  private String phone;
  private int creditno;
  private int num;
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public int getCreditno() {
	return creditno;
}
public void setCreditno(int creditno) {
	this.creditno = creditno;
}
public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public Integer getSex() {
	return sex;
}
public void setSex(Integer sex) {
	this.sex = sex;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Member [mid=" + mid + ", name=" + name + ", age=" + age + ", sex="
			+ sex + ", phone=" + phone + ", creditno=" + creditno + ", num="
			+ num + "]";
}

}
