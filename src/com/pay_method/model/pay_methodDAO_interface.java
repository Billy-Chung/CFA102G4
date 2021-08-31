package com.pay_method.model;

import java.util.List;


public interface pay_methodDAO_interface {
	public void add(pay_methodVO pay_methodVO);//新增
	public void update(pay_methodVO pay_methodVO);//修改
	public void delete(Integer pay_no);//刪除
	public pay_methodVO findPayMethodPk(Integer pay_no);//主鍵findByPk
	public List<pay_methodVO> getAllpay_method();//查	
	
	
	
}
