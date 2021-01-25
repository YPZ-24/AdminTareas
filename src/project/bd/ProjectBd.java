package project.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dataBase.DataBase;
import project.bean.Project;
import task.bean.Task;
import util.StatusCodes;

public class ProjectBd extends DataBase{
	
	public ArrayList<Project> getProjects(){
		ArrayList<Project> projects = new ArrayList<>();
		String query = "select * from project";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			boolean executed = pst.execute();
			if(executed) {
				ResultSet rs = pst.getResultSet();
				while(rs.next()) {
					Project project = new Project();
					project.setCveProject(rs.getString(1));
					project.setName(rs.getString(2));
					projects.add(project);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}
	
	public Project createProject(Project project) {
		Project projectCreated = null;
		String query = "insert into Project(name) values(?)";
		try {
			PreparedStatement pst = connect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, project.getName());
			int afectedRows = pst.executeUpdate();
			if(afectedRows==1) {
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()) {
					projectCreated = new Project();
					String cveProject = rs.getString(1);
					projectCreated.setCveProject(cveProject);
					projectCreated.setName(project.getName());
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return projectCreated;
	}
	
	public Project getProjectByCve(String cveProject) {
		int statusCode;
		Project project = null;
		String query = "select * from Project where cveProject=?";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			pst.setString(1, cveProject);
			boolean executed = pst.execute();
			if(executed) {
				ResultSet rs = pst.getResultSet();
				rs.next();
				project = new Project();
				project.setCveProject(rs.getString(1));
				project.setName(rs.getString(2));
				statusCode = StatusCodes.SUCCESS;
			}else {
				statusCode = StatusCodes.ERROR;
			}
		}catch(SQLException e) {
			statusCode = StatusCodes.ERROR;
			e.printStackTrace();
		}
		return project;
	}

	public int deleteProjectByCve(String cveProject) {
		int statusCode;
		String query = "delete from Project where cveProject=?";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			pst.setString(1, cveProject);
			int afectedRows = pst.executeUpdate();
			statusCode = (afectedRows == 1) ? StatusCodes.SUCCESS : StatusCodes.ERROR;
		}catch(SQLException e) {
			statusCode = StatusCodes.ERROR;
			e.printStackTrace();
		}
		return statusCode;
	}
	
	public int updateProject(Project project) {
		int statusCode;
		String query = "update Project set name=? where cveProject=?";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			pst.setString(1, project.getName());
			pst.setString(2, project.getCveProject());
			int afectedRows = pst.executeUpdate();
			statusCode = (afectedRows == 1) ? StatusCodes.SUCCESS : StatusCodes.ERROR;
		}catch(SQLException e) {
			statusCode = StatusCodes.ERROR;
			e.printStackTrace();
		}
		return statusCode;
	}

	public ArrayList<Task> getProjectTasks(String cveProject) {
		ArrayList<Task> tasks = null;
		String query = "select * from Task where cveProject=?";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			pst.setString(1, cveProject);
			boolean executed = pst.execute();
			if(executed) {
				ResultSet rs = pst.getResultSet();
				tasks = new ArrayList<>();
				while(rs.next()) {
					Task task = new Task();
					task.setId(rs.getInt(1));
					task.setCveProject(rs.getString(2));
					task.setName(rs.getString(3));
					
					task.setDateStart(rs.getDate(4).toLocalDate());
					task.setDuration(rs.getInt(5));
					task.setPredecessor(rs.getInt(6));
					task.setProgress(rs.getInt(7));
					tasks.add(task);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}
	
	
	/*
	public void registrarProyecto(Project proyecto) {
		int respuesta=0;
		String query = "insert into Proyecto(cveProyecto, nombre) values(?,?)";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			pst.setString(1, proyecto.getCveProyecto());
			pst.setString(2, proyecto.getNombre());
			respuesta = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	
}
