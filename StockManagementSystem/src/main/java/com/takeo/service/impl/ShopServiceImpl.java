package com.takeo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.excetpion.RecordNotFoundException;
import com.takeo.model.Shop;
import com.takeo.repo.ShopRepository;
import com.takeo.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopRepository shopRepo;
	
	
	@Override
	public List<Shop> getAllShops() {
		// TODO Auto-generated method stub
		
		List<Shop> viewShopInfo = shopRepo.findAll();
		
		return viewShopInfo;
	}

	@Override
	public Shop saveOrUpdateShop(Shop shop) {
		// TODO Auto-generated method stub
		Optional<Shop> findById = shopRepo.findById(shop.getId());
		boolean flag=false;
		Shop s = findById.get();
		if(s!=null)
 s=		shopRepo.save(s);
		
		
				
		
		
		return s;
	}

	@Override
	public boolean deleteShop(Integer id) {
		// TODO Auto-generated method stub
Optional<Shop> findById = shopRepo.findById(id);
		boolean flag=false;
		Shop s = findById.get();
		if(s!=null)
		{
		shopRepo.delete(s);
		flag=true;
		}
		return flag;
	}

	@Override
	public Shop getShopById(Integer id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Shop> findById = shopRepo.findById(id);
		
		Shop s = findById.get();
		
		if(s!=null)
			return s;
		
		else
			
		throw new RecordNotFoundException("Not Found");
		
		
	}

	@Override
	public Shop addShop(Shop shop) {
		// TODO Auto-generated method stub
		Shop saveEnt = shopRepo.save(shop);
		
		if(saveEnt!=null)
			return saveEnt;
		else
		return null;
	}

}
