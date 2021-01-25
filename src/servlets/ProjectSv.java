package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import project.bean.Project;
import util.Fetch;

//import project.bean.Project;

/**
 * Servlet implementation class ProjectSv
 */
@WebServlet(name = "ProjectSv", urlPatterns = { "/ProjectSv" })
public class ProjectSv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectSv() {
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
		
		Project p = new Gson().fromJson(body, Project.class);
		System.out.println("BODY: "+body);
		System.out.println("PROJECT");
		System.out.println(p.getCveProject());
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(body);
	}

}
