package com.adoptApply.model;

import java.util.List;

public interface adoptApplyDAO_interface {
	
	public void insert(adoptApplyVO adoptApply);
	
	public void update(adoptApplyVO adoptApply);
	
	public void delete(Integer adopt_apply_no);
	
	public adoptApplyVO findByPrimaryKey(Integer adopt_apply_no);
	
	public List<adoptApplyVO> getAll();
}
