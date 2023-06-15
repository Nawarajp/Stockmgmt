package com.takeo.service;

import java.util.List;

import com.takeo.excetpion.RecordNotFoundException;
import com.takeo.model.Shop;

public interface ShopService {
	
	public List<Shop> getAllShops();
	
	public Shop addShop(Shop shop);
	
	public Shop saveOrUpdateShop(Shop shop);
	
	public boolean deleteShop(Integer id);
	
	
	Shop getShopById(Integer id)throws RecordNotFoundException;
	
	

}
