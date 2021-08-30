package com.logistics.model;

import java.util.List;

import com.promotions.model.promotionsVO;

public interface logisticsDAO_interface {
	public void add(logisticsVO logistics);//新增
	public void update(logisticsVO logistics);//修改
	public void delete(Integer LOGISTICS_NO);//刪除
	public logisticsVO findByLogisticsPk(Integer LOGISTICS_NO);//主鍵findByPk
	public List<logisticsVO> getAllLogistics();//查	
}
