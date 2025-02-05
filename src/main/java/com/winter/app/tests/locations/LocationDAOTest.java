package com.winter.app.tests.locations;

import java.util.List;

import com.winter.app.locations.LocationDAO;
import com.winter.app.locations.LocationDTO;

public class LocationDAOTest {

	public static void main(String[] args) {
		LocationDAO locationDAO = new LocationDAO();
		
		try {
			List<LocationDTO> ar = locationDAO.getList();
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
