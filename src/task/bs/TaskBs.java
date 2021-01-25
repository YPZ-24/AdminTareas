package task.bs;

import task.bd.TaskBd;
import task.bean.Task;

public class TaskBs {
	
	/*public void agregarTarea(Task tarea) {
		TareaBd tareabd = new TareaBd();
		tareabd.guardarTarea(tarea);
	}*/
	
	public int saveTask(Task task) {
		int statusCode;
		TaskBd taskBd = new TaskBd();
		
		//SI la tarea existe, actualizamos
		//SI la tarea no existe, creamos
		if(taskExists(task)) {
			statusCode = taskBd.updateTask(task);
		}else{
			statusCode = taskBd.createTask(task);
		}
		
		return statusCode;
	}
	
	public boolean taskExists(Task task) {
		TaskBd taskBd = new TaskBd();
		boolean taskExists = false;	
		//La tarea solo existe si hay un id y existe ese id en la base
		if(task.getId()!=null) {
			if(taskBd.getTaskById(task.getId()) != null) {
				taskExists = true;
			}
		}
		return taskExists;
	}
	
	public int deleteTask(int id) {
		int statusCode;
		TaskBd taskBd = new TaskBd();
		statusCode = taskBd.deleteTaskById(id);
		return statusCode;
	}
	
	public int updateTaskPredecessor(int id, int predecessor) {
		TaskBd taskBd = new TaskBd();
		int statusCode = taskBd.updateTaskPredecessor(id, predecessor);
		return statusCode;
	}
	
}
