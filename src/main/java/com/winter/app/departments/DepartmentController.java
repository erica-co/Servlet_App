package com.winter.app.departments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
        super();
        // TODO Auto-generated constructor stub 생성자
    }

	/**
	 * 서버 요청시 
	 * 1. URL(ip:port/경로)
	 * 2. 메서드 형식
	 * 		1) GET
	 * 			단순 요청시
	 * 			파라미터가 주소창에 노출(파라미터가 Header에 담김)
	 * 			작은 용량을 보낼때 사용
	 * 		2) POST
	 * 			보안에 요구되는 요청시
	 * 			파라미터가 주소창에 노출x (파라미터가 body에 담김)
	 * 			데이터가 큰용량을 보낼 때 사용
	 * 3. 메서드 결정
	 * 		1) 주소창에 URL 직접 입력 - 무조건 GET
	 * 		2) a 태그 사용 		   - 무조건 GET
	 * 	
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try{ String method = request.getMethod();
		     StringBuffer sb= request.getRequestURL();
		     String uri=request.getRequestURI();
		     
		     //parameter
		     String department_id= request.getParameter("department_id");
		     
		     //System.out.println(method);
		     //System.out.println(sb.toString());
		     //System.out.println(uri);
		
		     uri = this.useSubString(uri);
		     //this.useSplit(uri);
		     //this.useToken(uri);
		
		
		     DepartmentDAO departmentDAO = new DepartmentDAO();
		
		     if(uri.equals("list.do")) {
			    List<DepartmentDTO> list = departmentDAO.getList();
			
			     PrintWriter writer = response.getWriter();
			     writer.println("<h1>Department List</h1>");
			     
			     writer.println("<table border = 1px solid>");
			     
			     writer.println("<thead>");
			     writer.println("<tr>");
			     writer.println("<th>Dept ID</th> <th>Dept name</th>");
			     writer.println("</tr>");
			     writer.println("</thead>");
			     
			     writer.println("<tbody>");
	
			     
			  for(int i=0; i<list.size(); i++) {
				  	 writer.println("<tr>");
				     writer.println("<td>" + list.get(i).getDepartment_id()+"</td>");
				     writer.println("<td>"+ list.get(i).getDepartment_name()+"</td>");
				     writer.println("</tr>");
				     
			  }
				 writer.println("</tbody>");
				 writer.println("</table>");
				 writer.close();
			
			     
		      }else {
			       departmentDAO.getDetail();
		      }
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//departmentDAO.getList();
		//departmentDAO.getDetail();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String useSubString(String data) {
		String result =  data.substring(data.lastIndexOf("/")+1); 
		//+1하는 이유는 /를 출력하지 않기 위해서, 유일하게 useSubString만 /detail.do로 출력됨
		System.out.println(result);
		return result;
	}
	
	private void useSplit (String data) {
		String [] datas = data.split("/");
		System.out.println(datas[datas.length-1]);
	}

	private void useToken(String data) {
		StringTokenizer st = new StringTokenizer(data, "/");
		String result ="";
		while(st.hasMoreTokens()) {
			result= st.nextToken();
		}
		System.out.println(result);
		
	}
}
