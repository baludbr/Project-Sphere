package servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class displayServlet
 */
@WebServlet("/displayServlet")
public class displayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(lookup="java:global/PROJECT_MANAGEMENT_SYSTEM/ProjectImpl!com.klu.model.ProjectActions")
	ProjectActions pb;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println(request.getParameter("email"));
		List<Project> pp=pb.getProjectDetails(request.getParameter("email"));
		request.setAttribute("aa", pp);
		RequestDispatcher xx=request.getRequestDispatcher("/ProjectList.jsp");
		xx.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
