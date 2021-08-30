package com.storedValRecord.model;

import java.util.List;

public interface StoredValRecodeDAO_Interface {
	public void insert(StoredValRecodeVO svrVO);
	public void update(StoredValRecodeVO svrVO);
	public void delete(Integer svrno);
	public StoredValRecodeVO findByPrimaryKey(Integer svrno);
	public List<StoredValRecodeVO> getAll();

}
