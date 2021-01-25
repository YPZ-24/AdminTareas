package project.bs;

import java.util.ArrayList;

import project.bd.ProjectBd;
import project.bean.Project;
import task.bean.Task;

public class ProjectBs {

	public int saveProject(Project project) {
		int statusCode;
		ProjectBd projectBd = new ProjectBd();
		
		//SI la tarea existe, actualizamos
		//SI la tarea no existe, creamos
		if(projectExists(project)) {
			statusCode = projectBd.updateProject(project);
		}else{
			statusCode = projectBd.createProject(project);
		}
		
		return statusCode;
	}
	
	public boolean projectExists(Project project) {
		ProjectBd projectBd = new ProjectBd();
		boolean projectExists = false;	
		//La tarea solo existe si hay un id y existe ese id en la base
		if(project.getCveProject()!=null) {
			if(projectBd.getProjectByCve(project.getCveProject()) != null) {
				projectExists = true;
			}
		}
		return projectExists;
	}
	
	public int deleteProject(String cveProject) {
		int statusCode;
		ProjectBd projectBd = new ProjectBd();
		statusCode = projectBd.deleteProjectByCve(cveProject);
		return statusCode;
	}
	
	public Project getProject(String cveProject) {
		ProjectBd projectBd = new ProjectBd();
		Project project = projectBd.getProjectByCve(cveProject);
		if(project!=null) {
			ArrayList<Task> tasks = projectBd.getProjectTasks(cveProject);
			project.setTasks(tasks);
		}
		return project;
	}
	
	
	
	/*
	public void registraProyecto(Project proyecto) {
		ProjectBd proyectoBd = new ProjectBd();
		proyectoBd.registrarProyecto(proyecto);
	}
	
	public boolean agregaTarea(Project proyecto, Task tarea) {
		boolean respuesta = false;
		//proyecto.addTarea(tarea);
		return respuesta;
	}
	
	public Task getTarea(Project proyecto, int posicion) {
		Task tarea = proyecto.getTarea(posicion);
		return tarea;
	}
	
	public boolean guardaProyecto(Project proyecto) {
		boolean respuesta = false;
		registraProyecto(proyecto);
		return respuesta;
	}
	
	public void registraTareas(Project proyecto) {
		TaskBd tareabd = new TaskBd();
		Task tarea;
		for(int i=0; i<proyecto.getTareasSize(); i++) {
			tarea = proyecto.getTarea(i);
			tareabd.guardarTarea(tarea);
		}
	}
	*/
}
