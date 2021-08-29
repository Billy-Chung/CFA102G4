package com.promotions.model;

import java.util.List;


public interface promotionsDAO_interface {
	// 此介面定義對資料庫的相關存取抽象方法，定義規格，以後換資料庫不用改
	public void add(promotionsVO promotions);//新增
	public void update(promotionsVO promotions);//修改
	public void delete(int promot_no);//刪除
	public promotionsVO findByPromotNoPk(int promot_no);//主鍵findByPk
	public List<promotionsVO> getAll();//查	
}


