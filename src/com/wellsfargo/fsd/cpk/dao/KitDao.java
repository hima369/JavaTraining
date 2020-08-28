package com.wellsfargo.fsd.cpk.dao;

import java.util.List;

import com.wellsfargo.fsd.cpk.entity.kit;
import com.wellsfargo.fsd.cpk.exception.cpkException;

public interface KitDao {

	 kit add(kit kit) throws cpkException;
	 kit save(kit kit) throws cpkException;
	 boolean deleteById(Integer kitID) throws cpkException;
	 kit getById(Integer kitID)throws cpkException;
	 List<kit> getAll() throws cpkException;
	
	
}
