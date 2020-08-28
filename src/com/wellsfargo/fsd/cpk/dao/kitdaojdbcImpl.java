package com.wellsfargo.fsd.cpk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.wellsfargo.fsd.cpk.entity.kit;
import com.wellsfargo.fsd.cpk.exception.cpkException;

public class kitdaojdbcImpl implements KitDao {

	
	
	
	public static final String INS_KIT_QRY="INSERT INTO Kits(kitID,productitem,cost,productdescription) values(?,?,?,?)";
	public static final String UPD_KIT_QRY="UPDATE Kits SET productitem=?,cost=?,productdescription=? WHERE kitID =?";
	public static final String DEL_KIT_QRY="DELETE from Kits WHERE kitID=?";
	public static final String SEL_KIT_QRY_BY_ID="SELECT kitID,productitem, cost,productdescription FROM Kits WHERE kitID=?";
	public static final String SEL_ALL_KITS_QRY="SELECT kitID,productitem,cost,productdescription from Kits";
	
	
	
	
	public kit add(kit kit) throws cpkException {
		if(kit!=null) {
			try(Connection con=ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_KIT_QRY)){
					pst.setInt(1, kit.getKitID());
					pst.setString(2, kit.getProductitem());
					pst.setDouble(3,kit.getCost());
					pst.setString(4, kit.getProductdescription());					
					pst.executeUpdate();
				
			}catch(SQLException | NamingException exp) {
				exp.printStackTrace();
				throw new cpkException("saving the item failed");
			}
					
		}
		return kit;
	}

	public kit save(kit kit) throws cpkException {
		if(kit!=null) {
			try(Connection con=ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_KIT_QRY)){
				
					pst.setString(1, kit.getProductitem());
					pst.setDouble(2,kit.getCost());
					pst.setString(3, kit.getProductdescription());
					pst.setInt(4, kit.getKitID());
					pst.executeUpdate();
				
			}catch(SQLException | NamingException exp) {
				exp.printStackTrace();
				throw new cpkException("saving the item failed");
			}
					
		}
		return kit;
	}

	public boolean deleteById(Integer kitID) throws cpkException {
		boolean isDelated =false;
		
		try(Connection con=ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_KIT_QRY)){
			
				pst.setInt(1,kitID );				
				int rowcount = pst.executeUpdate();
				isDelated = rowcount>0;
			
		}catch(SQLException | NamingException exp) {
			exp.printStackTrace();
			throw new cpkException("Deleteing the item failed!");
		}
		
		return isDelated;
		
	}

	public kit getById(Integer kitID) throws cpkException {
		kit kit = null;
	
		try(Connection con=ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SEL_KIT_QRY_BY_ID)){
			
				pst.setInt(1,kitID );				
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					kit = new kit();
					kit.setKitID(rs.getInt(1));
					kit.setProductitem(rs.getString(2));
					kit.setCost(rs.getDouble(3));
					kit.setProductdescription(rs.getString(4));
				}
			
		}catch(SQLException | NamingException exp) {
			exp.printStackTrace();
			throw new cpkException("Retrieval the item failed!");
		}
		
		return kit;
	}

	public List<kit> getAll() throws cpkException {
		
		List<kit> kits = new ArrayList<>();
		try(Connection con=ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SEL_ALL_KITS_QRY)){
			
								
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
				kit	kit = new kit();
					kit.setKitID(rs.getInt(1));
					kit.setProductitem(rs.getString(2));
					kit.setCost(rs.getDouble(3));
					kit.setProductdescription(rs.getString(4));					
					kits.add(kit);
				}
				
				if(kits.isEmpty()) {
					kits=null;
				}
			
		}catch(SQLException | NamingException exp) {
			exp.printStackTrace();
			throw new cpkException("Retrieval the item failed!");
		}
		return kits;
	}
	
	

}
