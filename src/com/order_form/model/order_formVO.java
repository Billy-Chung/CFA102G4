package com.order_form.model;

import java.io.Serializable;
import java.sql.Date;


public class order_formVO implements Serializable{

	
	private Integer order_no;
	private Integer gen_meb_no;
	private Integer pay_no;
	private Integer logistics_no;
	private Integer promot_no;
	private Integer befort_amount;
	private Integer order_amount;
	private String delivery_address;
	private Date order_time;
	private String order_status;
	public Integer getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}
	public Integer getGen_meb_no() {
		return gen_meb_no;
	}
	public void setGen_meb_no(Integer gen_meb_no) {
		this.gen_meb_no = gen_meb_no;
	}
	public Integer getPay_no() {
		return pay_no;
	}
	public void setPay_no(Integer pay_no) {
		this.pay_no = pay_no;
	}
	public Integer getLogistics_no() {
		return logistics_no;
	}
	public void setLogistics_no(Integer logistics_no) {
		this.logistics_no = logistics_no;
	}
	public Integer getPromot_no() {
		return promot_no;
	}
	public void setPromot_no(Integer promot_no) {
		this.promot_no = promot_no;
	}
	public Integer getBefort_amount() {
		return befort_amount;
	}
	public void setBefort_amount(Integer befort_amount) {
		this.befort_amount = befort_amount;
	}
	public Integer getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(Integer order_amount) {
		this.order_amount = order_amount;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	

	
	
}
