package com.order_form.model;

import java.util.List;

public interface order_formDAO_interface {

	
	public void add(order_formVO order_formVO);//新增
	public void update(order_formVO order_formVO);//修改
	public void delete(Integer ORDER_NO);//刪除
	public order_formVO findOrderFormPk(Integer ORDER_NO);//主鍵findByPk
	public List<order_formVO> getAllorderForm();//查	
}




