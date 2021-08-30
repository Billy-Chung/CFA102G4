package com.logistics.model;

import java.io.Serializable;

public class logisticsVO implements Serializable{
private Integer	logistics_no;
private String	logistics_name;


public Integer getLogistics_no() {
	return logistics_no;
}
public void setLogistics_no(Integer logistics_no) {
	this.logistics_no = logistics_no;
}
public String getLogistics_name() {
	return logistics_name;
}
public void setLogistics_name(String logistics_name) {
	this.logistics_name = logistics_name;
}

}
