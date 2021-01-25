class Dashboard{

    constructor(projects, tasks){
        this.projects = projects;
        this.tasks = tasks;
    }

    get projects() {
        return this.projects;
    }
    
    set projects(projects) {
        this._projects = projects; 
    }

    addProject(project){
        this.projects.add(project);
    }

}

//INSERT INTO task(cveProject, name, datestart, duration, predecessor, progress) values (2, 'Esta es la tarea 2','25-01-2021', '20', '1', '20');