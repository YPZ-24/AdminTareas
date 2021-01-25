package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import project.bean.Project;
import project.bs.ProjectBs;
import util.Fetch;

/**
 * Servlet implementation class createProjectSv
 */
@WebServlet("/createProjectSv")
public class createProjectSv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createProjectSv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String body = Fetch.readBody(request.getReader());
		Project project = new Gson().fromJson(body, Project.class);
		ProjectBs projectBs = new ProjectBs();
		Project projectCreated = projectBs.createProject(project);
		
        String projectCreatedJson = (new Gson()).toJson(projectCreated);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(projectCreatedJson);
	}

}
