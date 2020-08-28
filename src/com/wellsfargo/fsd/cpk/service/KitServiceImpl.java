package com.wellsfargo.fsd.cpk.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.cpk.dao.KitDao;
import com.wellsfargo.fsd.cpk.dao.kitdaojdbcImpl;
import com.wellsfargo.fsd.cpk.entity.kit;
import com.wellsfargo.fsd.cpk.exception.cpkException;


public class KitServiceImpl implements KitService{

	KitDao kitdao;
	
	private boolean iskitIdValid(Integer kitID) {
		return kitID>0;
	}
	
	private boolean isproductitem(String productitem) {
		return productitem!=null && (productitem.length() >=3 ||productitem.length()<20);
	}
	
	private boolean isproductitem(Double cost) {
		return cost>=0;
	}
	
	private boolean isproductdescription(String productdescription) {
		return productdescription!=null &&(productdescription.length()>=3||productdescription.length()<20);
	}
	
	private boolean isvalidkit(kit kit) throws cpkException {
		List<String> errMsg = new ArrayList<>();
		
		boolean isValid = true;
		if (!iskitIdValid(kit.getKitID())) {
			isValid = false;
			errMsg.add("KitId can not be null or negative or zero");
		}
		
		if(!isproductitem(kit.getProductitem())) {
			isValid = false;
			errMsg.add("Product item can not be null");
		}
		
		if(!isproductitem(kit.getCost())) {
			isValid = false;
			errMsg.add("Cost price can not be zerp or negative");
		}
		
		
		if(!isproductdescription(kit.getProductdescription())) {
			isValid = false;
			errMsg.add("Product description can not be null");
		}
		
		if(!isValid) {
			throw new cpkException(errMsg.toString());
		}
		return isValid;
		

	}
	
	public KitServiceImpl() {
		kitdao = new kitdaojdbcImpl();
	}
		
	@Override
	public kit ValidateAndAdd(kit kit) throws cpkException {
		if(kit!=null) {
			if(isvalidkit(kit)) {
				kitdao.add(kit);				
			}
		}
		return kit;
	}

	@Override
	public kit ValidateAndSave(kit kit) throws cpkException {
		if(kit!=null) {
			if(isvalidkit(kit)) {
				kitdao.save(kit);				
			}
		}
		return kit;
	}

	@Override
	public boolean deleteKit(int kitID) throws cpkException {
		return kitdao.deleteById(kitID);
	}

	@Override
	public kit getKitById(int kitID) throws cpkException {
		return kitdao.getById(kitID);
	}

	@Override
	public List<kit> getAllKits() throws cpkException {
		return kitdao.getAll();
	}
	

}
