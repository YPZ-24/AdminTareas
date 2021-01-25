package task.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataBase.DataBase;
import task.bean.Task;
import util.StatusCodes;

public class TaskBd extends DataBase{
	
	public int createTask(Task task) {
		int statusCode;
		String query = "insert into Task(cveProject, name, duration, predecessor, progress, dateStart) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			pst.setString(1, task.getCveProject());
			pst.setString(2, task.getName());
			pst.setInt(3, task.getDuration());
			pst.setInt(4, task.getPredecessor());
			pst.setInt(5, task.getProgress());
			pst.setDate(6, task.getDateStartLikeDate());
			int afectedRows = pst.executeUpdate();
			statusCode = (afectedRows == 1) ? StatusCodes.SUCCESS : StatusCodes.ERROR;
		}catch(SQLException e) {
			statusCode = StatusCodes.ERROR;
			e.printStackTrace();
		}
		return statusCode;
	}
	
	public Task getTaskById(int id) {
		Task task = null;
		int statusCode;
		String query = "select * from Task where id=?";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			pst.setInt(1, id);
			boolean executed = pst.execute();
			if(executed) {
				ResultSet rs = pst.getResultSet();
				rs.next();
				task = new Task();
				task.setId(rs.getInt(1));
				task.setCveProject(rs.getString(2));
				task.setName(rs.getString(3));
				
				task.setDateStart(rs.getDate(4).toLocalDate());
				task.setDuration(rs.getInt(5));
				task.setPredecessor(rs.getInt(6));
				task.setProgress(rs.getInt(7));
				statusCode = StatusCodes.SUCCESS;
			}else {
				statusCode = StatusCodes.ERROR;
			}
		}catch(SQLException e) {
			statusCode = StatusCodes.ERROR;
			e.printStackTrace();
		}
		return task;
	}

	public int deleteTaskById(int id) {
		int statusCode;
		String query = "delete from Task where id=?";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			pst.setInt(1, id);
			int afectedRows = pst.executeUpdate();
			statusCode = (afectedRows == 1) ? StatusCodes.SUCCESS : StatusCodes.ERROR;
		}catch(SQLException e) {
			statusCode = StatusCodes.ERROR;
			e.printStackTrace();
		}
		return statusCode;
	}
	
	public int updateTask(Task task) {
		int statusCode;
		String query = "update Task set cveProject=?, name=?, duration=?, predecessor=?, progress=?, dateStart=? where id=?";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			pst.setString(1, task.getCveProject());
			pst.setString(2, task.getName());
			pst.setInt(3, task.getDuration());
			pst.setInt(4, task.getPredecessor());
			pst.setInt(5, task.getProgress());
			pst.setDate(6, task.getDateStartLikeDate());
			int afectedRows = pst.executeUpdate();
			statusCode = (afectedRows == 1) ? StatusCodes.SUCCESS : StatusCodes.ERROR;
		}catch(SQLException e) {
			statusCode = StatusCodes.ERROR;
			e.printStackTrace();
		}
		return statusCode;
	}

	public int updateTaskPredecessor(int id, int predecessor) {
		int statusCode;
		String query = "update Task set predecessor=? where id=?";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			pst.setInt(1, predecessor);
			pst.setInt(2, id);
			int afectedRows = pst.executeUpdate();
			statusCode = (afectedRows == 1) ? StatusCodes.SUCCESS : StatusCodes.ERROR;
		}catch(SQLException e) {
			statusCode = StatusCodes.ERROR;
			e.printStackTrace();
		}
		return statusCode;
	}
	
	/*
	public void guardarTarea(Tarea tarea) {
		int respuesta=0;
		String query = "insert into Tarea(cveProyecto, nombre, duracion, predecesor, avance, fechaInicio) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pst = connect().prepareStatement(query);
			pst.setString(1, tarea.getCveProyecto());
			pst.setString(2, tarea.getNombre());
			pst.setInt(3, tarea.getDuracion());
			pst.setInt(4, tarea.getPredecesor());
			pst.setInt(5, tarea.getAvance());
			pst.setTimestamp(6, tarea.getFechaInicio());
			respuesta = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	
}
