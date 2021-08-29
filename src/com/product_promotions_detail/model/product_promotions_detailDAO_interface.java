package com.product_promotions_detail.model;

import java.util.List;

public interface product_promotions_detailDAO_interface {
	public void add(product_promotions_detailVO product_promotions_detail);
	public void update(product_promotions_detailVO product_promotions_detail);
	public void delete(Integer product_pro_detail_no);
	public product_promotions_detailVO findByProductPro_DetailPK(Integer product_pro_detail_no);
	public List <product_promotions_detailVO> getAllproductPromotions_Detail();
}
