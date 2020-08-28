package com.wellsfargo.fsd.cpk.service;

import java.util.List;

import com.wellsfargo.fsd.cpk.entity.kit;
import com.wellsfargo.fsd.cpk.exception.cpkException;

public interface KitService {

	kit ValidateAndAdd(kit kit) throws cpkException;
	kit ValidateAndSave(kit kit) throws cpkException;
	boolean deleteKit(int kitID) throws cpkException;
	kit getKitById(int kitID) throws cpkException;	
	List<kit> getAllKits() throws cpkException;
	
	
}
