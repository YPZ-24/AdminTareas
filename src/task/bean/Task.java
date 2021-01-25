package task.bean;

import java.sql.Date;
import java.time.LocalDate;

public class Task {
	private Integer id;
	private String cveProject;
	private String name;
	private LocalDate dateStart;
	private int duration;
	private int predecessor;
	private int progress;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCveProject() {
		return cveProject;
	}
	public void setCveProject(String cveProject) {
		this.cveProject = cveProject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getDateStart() {
		return dateStart;
	}
	public Date getDateStartLikeDate() {
		return Date.valueOf(dateStart);
	}
	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}
	
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart.toLocalDate();
	}
	
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(int predecessor) {
		this.predecessor = predecessor;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	
	
	
	
	
}
