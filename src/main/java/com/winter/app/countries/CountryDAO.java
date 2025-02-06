package com.winter.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;

public class CountryDAO {
	
	public List<CountryDTO> getList() throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM COUNTRIES";
		PreparedStatement st = con.prepareStatement(sql);
		List<CountryDTO> ar = new ArrayList<CountryDTO>();
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			CountryDTO countryDTO = new CountryDTO();
			countryDTO.setCountry_id(rs.getString("country_id"));
			countryDTO.setCountry_name(rs.getString("country_name"));
			countryDTO.setRegion_id(rs.getLong("region_id"));
			ar.add(countryDTO);
		}
		
		DBConnection.disConnection(rs, st, con);
		
		return ar;
	}
	
	public CountryDTO getDetail(CountryDTO countryDTO) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID=? ";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, countryDTO.getCountry_id());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			countryDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			countryDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
			countryDTO.setRegion_id(rs.getLong("REGION_ID"));
		}else {
			countryDTO=null;
		}
		
		DBConnection.disConnection(rs, st, con);
		
		return countryDTO;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
