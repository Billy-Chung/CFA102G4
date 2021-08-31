package com.order_detail.model;

import java.util.List;


public interface order_detailDAO_interface {
	public void add(order_detailVO order_detailVO);//新增
	public void update(order_detailVO order_detailVO);//修改
	public void delete(Integer pay_no);//刪除
	public order_detailVO findOrderDetailPk(Integer pay_no);//主鍵findByPk
	public List<order_detailVO> getAllorder_detail();//查	
}
