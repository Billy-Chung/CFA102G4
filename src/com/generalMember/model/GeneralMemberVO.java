package com.generalMember.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

public class GeneralMemberVO implements Serializable {
	private Integer ger_meb_no;
	private String meb_name;
	private String phone;
	private Date birthday;
	private byte[] photo;
	private String comment;
	private String address;
	private String email;
	private String account;
	private String password;
	private String gender;
	private Integer meb_money;
	private String post_permission;
	
	public Integer getGer_meb_no() {
		return ger_meb_no;
	}
	public void setGer_meb_no(Integer ger_meb_no) {
		this.ger_meb_no = ger_meb_no;
	}
	public String getMeb_name() {
		return meb_name;
	}
	public void setMeb_name(String meb_name) {
		this.meb_name = meb_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getMeb_money() {
		return meb_money;
	}
	public void setMeb_money(Integer meb_money) {
		this.meb_money = meb_money;
	}
	public String getPost_permission() {
		return post_permission;
	}
	public void setPost_permission(String post_permission) {
		this.post_permission = post_permission;
	}
	
	

}
