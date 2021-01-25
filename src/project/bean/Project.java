package project.bean;

import java.util.ArrayList;
import java.util.List;

import task.bean.Task;

public class Project {
	
	private String cveProject;
	private String name;
	private ArrayList<Task> tasks;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCveProject() {
		return cveProject;
	}
	public void setCveProject(String cveProject) {
		this.cveProject = cveProject;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
	
	
	
	//private List<Task> tareas;
	/*
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCveProyecto() {
		return cveProyecto;
	}

	public void setCveProyecto(String cveProyecto) {
		this.cveProyecto = cveProyecto;
	}

	
	
	/*
	public Proyecto(String nombre){
		this.nombre = nombre;
		tareas = new ArrayList<>();
	}
	
	
	
	public int getTareasSize() {
		return tareas.size();
	}*/
	/*

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCveProyecto() {
		return cveProyecto;
	}
	
	public void setCveProyecto(String cveProyecto) {
		this.cveProyecto = cveProyecto;
	}
	
	public boolean addTarea(Tarea tarea) {
		boolean respuesta = false;
		respuesta = tareas.add(tarea);
		return respuesta;
	}
	
	public Tarea getTarea(int position) {
		Tarea tarea = tareas.get(position);
		return tarea;
	}
	
	public void getListaTareas() {
		for(int i=0; i<tareas.size(); i++) {
	        System.out.println("--> "+getTarea(i).getNombre());
		}
	}
	
	
	
	
	*/
}
