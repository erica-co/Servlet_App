package com.winter.app.locations;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;

public class LocationService {
	
	private LocationDAO locationDAO;
	
	public LocationService () {
		this.locationDAO = new LocationDAO();
	}
	
	public ActionForward getList(HttpServletRequest request, ActionForward actionForward)throws Exception {
		List<LocationDTO> ar = locationDAO.getList();
		request.setAttribute("list",ar);
		
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/locations/list.jsp");
		return actionForward;
	}
	
	public ActionForward getDetail(HttpServletRequest request, ActionForward actionForward) throws Exception {
		String id = request.getParameter("location_id");
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Long.parseLong(id));
		locationDTO = locationDAO.getDetail(locationDTO);
		request.setAttribute("dto", locationDTO);
		
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/locations/detail.jsp");
		return actionForward;
	}
	
	public void add(HttpServletRequest request, ActionForward actionForward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		
		
	}
	public void update(HttpServletRequest request, ActionForward actionForward)throws Exception {
		
	}
	public void delete(HttpServletRequest request, ActionForward actionForward) throws Exception {
		
	}
}
