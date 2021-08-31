package com.order_detail.model;

import java.io.Serializable;

public class order_detailVO implements Serializable{
	private Integer order_detail_no;
	private Integer order_no;
	private Integer product_no;
	private Integer order_product_number;
	private String order_product_comment;
	private Integer order_product_stars;
	private String order_product_comment_state;
	public Integer getOrder_detail_no() {
		return order_detail_no;
	}
	public void setOrder_detail_no(Integer order_detail_no) {
		this.order_detail_no = order_detail_no;
	}
	public Integer getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}
	public Integer getProduct_no() {
		return product_no;
	}
	public void setProduct_no(Integer product_no) {
		this.product_no = product_no;
	}
	public Integer getOrder_product_number() {
		return order_product_number;
	}
	public void setOrder_product_number(Integer order_product_number) {
		this.order_product_number = order_product_number;
	}
	public String getOrder_product_comment() {
		return order_product_comment;
	}
	public void setOrder_product_comment(String order_product_comment) {
		this.order_product_comment = order_product_comment;
	}
	public Integer getOrder_product_stars() {
		return order_product_stars;
	}
	public void setOrder_product_stars(Integer order_product_stars) {
		this.order_product_stars = order_product_stars;
	}
	public String getOrder_product_comment_state() {
		return order_product_comment_state;
	}
	public void setOrder_product_comment_state(String order_product_comment_state) {
		this.order_product_comment_state = order_product_comment_state;
	}
	
	
	
	
	

}
