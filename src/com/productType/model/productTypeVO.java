package com.productType.model;

import java.io.Serializable;

public class productTypeVO implements Serializable {
	
	private Integer product_type_no;
	private String product_type_name;
	
	public Integer getProduct_type_no() {
		return product_type_no;
	}
	public void setProduct_type_no(Integer product_type_no) {
		this.product_type_no = product_type_no;
	}
	public String getProduct_type_name() {
		return product_type_name;
	}
	public void setProduct_type_name(String product_type_name) {
		this.product_type_name = product_type_name;
	}
}
