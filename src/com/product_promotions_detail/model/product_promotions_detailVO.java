package com.product_promotions_detail.model;

import java.io.Serializable;


public class product_promotions_detailVO implements Serializable{
	
	private Integer product_pro_detail_no;
	private Integer promot_no;
	private Integer product_no;
	private Integer product_pro_price;
	private Integer product_pro_special_price;
	
	
	
	public Integer getProduct_pro_detail_no() {
		return product_pro_detail_no;
	}
	public void setProduct_pro_detail_no(Integer product_pro_detail_no) {
		this.product_pro_detail_no = product_pro_detail_no;
	}
	public Integer getPromot_no() {
		return promot_no;
	}
	public void setPromot_no(Integer promot_no) {
		this.promot_no = promot_no;
	}
	public Integer getProduct_no() {
		return product_no;
	}
	public void setProduct_no(Integer product_no) {
		this.product_no = product_no;
	}
	public Integer getProduct_pro_price() {
		return product_pro_price;
	}
	public void setProduct_pro_price(Integer product_pro_price) {
		this.product_pro_price = product_pro_price;
	}
	public Integer getProduct_pro_special_price() {
		return product_pro_special_price;
	}
	public void setProduct_pro_special_price(Integer product_pro_special_price) {
		this.product_pro_special_price = product_pro_special_price;
	}

}
