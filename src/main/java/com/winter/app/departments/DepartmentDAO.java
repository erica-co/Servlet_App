package com.winter.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;

public class DepartmentDAO {

	// 부서 리스트
	public List<DepartmentDTO> getList()throws Exception {
		//DB에서 부서 리스트를 조회
		Connection con = DBConnection.getConnection();
		String sql= "SELECT * FROM DEPARTMENTS";
		PreparedStatement st = con.prepareStatement(sql);
		List<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getLong("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getLong("LOCATION_ID"));
			ar.add(departmentDTO);
		}
		
		DBConnection.disConnection(rs, st, con);
		
		return ar;
	}
	
	
	//한 부서의 모든 정보
	public void getDetail() throws Exception {
		//DB에서 하나의 부서 정보를 조회
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM DEPARTMENTS WHERE ";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		
		
		DBConnection.disConnection(rs, st, con);
		
		
	}
	
}
