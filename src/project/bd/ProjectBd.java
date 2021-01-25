package project.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataBase.DataBase;
import project.bean.Project;
import task.bean.Task;
import util.StatusCodes;

public class ProjectBd extends DataBase{
	
	public int createProject(Project project) {
		int statusCode;
		String query = "insert into Project(cveProject, name) values(?,?)";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			pst.setString(1, project.getCveProject());
			pst.setString(2, project.getName());
			int afectedRows = pst.executeUpdate();
			statusCode = (afectedRows == 1) ? StatusCodes.SUCCESS : StatusCodes.ERROR;
		}catch(SQLException e) {
			statusCode = StatusCodes.ERROR;
			e.printStackTrace();
		}
		return statusCode;
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
		int statusCode;
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
				statusCode = StatusCodes.SUCCESS;
			}else {
				statusCode = StatusCodes.ERROR;
			}
		}catch(SQLException e) {
			statusCode = StatusCodes.ERROR;
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
