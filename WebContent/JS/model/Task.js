class Task{
    constructor(id, cveProject, name, dateStart, duration, predecessor, progress){
        this.id = id; 
        this.cveProject = cveProject; 
        this.name = name; 
        this.dateStart = dateStart; 
        this.duration = duration; 
        this.predecessor = predecessor; 
        this.progress = progress; 
    }
}