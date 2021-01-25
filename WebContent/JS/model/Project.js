class Project{
    constructor(cveProject, name){
        this.cveProject = cveProject;
        this.name = name;
    }

    get name() {
        return this.name;
    }
    
    set name(name) {
        this._name = name; 
    }
}