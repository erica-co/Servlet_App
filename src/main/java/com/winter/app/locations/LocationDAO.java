package com.winter.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;

public class LocationDAO {
	
	public List<LocationDTO> getList() throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS";
		PreparedStatement st = con.prepareStatement(sql);
		List<LocationDTO> ar = new ArrayList<LocationDTO>();
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setStreet_address(rs.getLong("STREET_ADDRESS"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			locationDTO.setCity(rs.getString("CITY"));
			ar.add(locationDTO);
			
		}
		DBConnection.disConnection(rs, st, con);
		
		return ar;
	}
	
	public void getDetail() {
		System.out.println("한 지역정보 조회");
	}

}
