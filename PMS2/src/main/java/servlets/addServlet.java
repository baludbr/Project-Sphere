package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.klu.entity.Project;
import com.klu.model.ProjectActions;

/**
 * Servlet implementation class addServlet
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(lookup="java:global/PROJECT_MANAGEMENT_SYSTEM/ProjectImpl!com.klu.model.ProjectActions")
	ProjectActions pb;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String ptitle=request.getParameter("ptitle");
		String pdescription=request.getParameter("pdescription");
		System.out.println(email+" \n"+" \n"+ptitle+"\n"+pdescription);
		Project p=new Project();
		p.setEmail(email);
		p.setPdescription(pdescription);
		p.setPtitle(ptitle);
		String res=pb.addProject(p);
		if(res=="Project Added Successfully")
		{
			RequestDispatcher rs=request.getRequestDispatcher("/projects.jsf");
			rs.forward(request, response);
		}
		else
		{
			RequestDispatcher rs=request.getRequestDispatcher("/addproject.jsp");
			rs.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
