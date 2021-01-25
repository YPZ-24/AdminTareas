package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import project.bean.Project;
import project.bs.ProjectBs;
import task.bean.Task;
import util.Fetch;

/**
 * Servlet implementation class getProjectTasks
 */
@WebServlet("/getProjectTasksSv")
public class getProjectTasksSv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getProjectTasksSv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String body = Fetch.readBody(request.getReader());
		Project project = new Gson().fromJson(body, Project.class);
		ProjectBs projectBs = new ProjectBs();
		ArrayList<Task> projectTasks = projectBs.getProjectTasks(project.getCveProject());
		Gson gson = new Gson();
        String projectTasksJson = gson.toJson(projectTasks);
        
        PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(projectTasksJson);
	}

}
