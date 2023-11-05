package com.fil.easemystay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.easemystay.dao.HotelOwnerDao;
import com.fil.easemystay.entities.Admin;
import com.fil.easemystay.entities.HotelOwner;

@Service
public class HotelOwnerServiceImpl implements HotelOwnerService {
	@Autowired
	HotelOwnerDao hotelOwnerDao;

	@Override
	public HotelOwner getHotelOwner(int owner_id) {
		// TODO Auto-generated method stub
		return hotelOwnerDao.findById(owner_id).get();
	}
	
	@Override
	public HotelOwner getHotelOwnerByEmail(String email) {
		// TODO Auto-generated method stub
		return hotelOwnerDao.findByEmailOwner(email);
	}

	@Override
	public HotelOwner addHotelOwner(HotelOwner hotelOwner) {
		// TODO Auto-generated method stub
		hotelOwnerDao.save(hotelOwner);
		return hotelOwner;
	}

	@Override
	public HotelOwner updateHotelOwner(HotelOwner hotelOwner) {
		// TODO Auto-generated method stub
		hotelOwnerDao.save(hotelOwner);
		return hotelOwner;
	}

	@Override
	public void removeHotelOwner(int owner_id) {
		// TODO Auto-generated method stub
		hotelOwnerDao.deleteById(owner_id);
	}

	@Override
	public List<HotelOwner> getHotelOwners() {
		// TODO Auto-generated method stub
		return hotelOwnerDao.findAll();
	}

	@Override
	public HotelOwner loginOwner(String email, String password) throws Exception {
		// TODO Auto-generated method stub
			
			HotelOwner authenticatedOwner = hotelOwnerDao.findByEmailOwner(email);
		
			if (authenticatedOwner != null && authenticatedOwner.getPassword().equals(password)) {
				return authenticatedOwner;
			} else {

				return null;
			}
	}
}