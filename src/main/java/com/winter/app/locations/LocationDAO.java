package com.winter.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.departments.DepartmentDTO;
import com.winter.app.utils.DBConnection;

public class LocationDAO {
	
	public int update(LocationDTO locationDTO) throws Exception {
		int result = 0;
		
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE LOCATIONS SET STREET_ADDRESS=?, STATE_PROVINCE=?, CITY=?, POSTAL_CODE=?, COUNTRY_ID=?"
				+ " WHERE LOCAITON_ID=? ";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getState_province());
		st.setString(3, locationDTO.getCity());
		st.setString(4, locationDTO.getPostal_code());
		st.setString(5, locationDTO.getCountry_id());
		st.setLong(6, locationDTO.getLocation_id());
		
		DBConnection.disConnection(st, con);
		
		return result;
	}
	
	public int delete(LocationDTO locationDTO) throws Exception {
		int result=0;
		
		Connection con = DBConnection.getConnection();
		String sql = "DELETE LOCATIONS WHERE LOCATION_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, locationDTO.getLocation_id());
		result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		
		return result;
	}
	
	public int add(LocationDTO locationDTO) throws Exception {
		int result =0;
		
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO LOCATIONS (COUNTRY_ID, STREET_ADDRESS, STATE_PROVINCE, POSTAL_CODE, CITY"
				+ " VALUES (LOCATIONS.SEQ_NEXTVAL,?,?,?,?,?)";
				
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getState_province());
		st.setString(3, locationDTO.getPostal_code());
		st.setString(4, locationDTO.getCity());
		
		result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		
		return result;
	}
	
	
	public List<LocationDTO> getList() throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS";
		PreparedStatement st = con.prepareStatement(sql);
		List<LocationDTO> ar = new ArrayList<LocationDTO>();
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getLong("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			locationDTO.setCity(rs.getString("CITY"));
			ar.add(locationDTO);
			
		}
		DBConnection.disConnection(rs, st, con);
		
		return ar;
	}
	
	public LocationDTO getDetail(LocationDTO locationDTO)throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, locationDTO.getLocation_id());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			locationDTO.setLocation_id(rs.getLong("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			locationDTO.setCity(rs.getString("CITY"));
		}else {
			locationDTO=null;
		}
		
		DBConnection.disConnection(rs, st, con);
		
		return locationDTO;
		
	}
		
}
