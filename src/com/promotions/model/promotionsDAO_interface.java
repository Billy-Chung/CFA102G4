package com.promotions.model;

import java.util.List;

public interface promotionsDAO_interface {
	// 此介面定義對資料庫的相關存取抽象方法
	public void insert(promotionsVO promotions);
	public void update(promotionsVO promotions);
	public void delete(Integer PROMOT_NO);
	public promotionsVO findByPromotNoPk(Integer PROMOT_NO);
	public List<promotionsVO> getAllPromot();
}


