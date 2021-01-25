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