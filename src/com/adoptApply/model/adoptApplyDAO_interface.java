package com.adoptApply.model;

import java.util.List;

public interface adoptApplyDAO_interface {
	
		public adoptApplyVO insert(adoptApplyVO adoptApply);
	
		public void update(adoptApplyVO adoptApply);

		public adoptApplyVO findByadoptApplyNo(Integer ADOPT_APPLY_NO);
	
		public List<adoptApplyVO> getAlladoptApply();
}
