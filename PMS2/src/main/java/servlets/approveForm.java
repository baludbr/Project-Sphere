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
 * Servlet implementation class approveForm
 */
@WebServlet("/approveForm")
public class approveForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(lookup="java:global/PROJECT_MANAGEMENT_SYSTEM/ProjectImpl!com.klu.model.ProjectActions")
	ProjectActions pb;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email=request.getParameter("email");
		int id=Integer.parseInt(request.getParameter("id"));
		String status=request.getParameter("status");
		Project p=new Project();
		p.setEmail(email);
		p.setProjectID(id);
		p.setStatus(status);
		System.out.println(p.getProjectID()+" "+p.getStatus());
		String response1=pb.approveProject(p);
		System.out.println(response1);
		RequestDispatcher rs1=request.getRequestDispatcher("/approvalForm.jsp");
		rs1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
