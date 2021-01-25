const mainDashboard = new Dashboard;
getProjects();
//getProjectTasks();

async function getProjects(){
    let path = "getProjects";
    let fetchResult = await FETCH("GET", path, null);
    if(fetchResult instanceof Error){
        //Ocurrio un error en el fetch
        alert(fetchResult.message);
    }else{
        fetchResult.forEach(p => {
            const project = new Project(p.cveProject, p.name);
            paintProject(project.name);
        });
    }
}

//insert into Project(name) values('Project A');

async function getProjectTasks(project){
    let path = "GetProjectTasks";
    let fetchResult = FETCH("GET", path, project);
    if(fetchResult instanceof Error){
        //Ocurrio un error en el fetch
        alert(fetchResult.message);
    }else{
        mainDashboard.tasks = fetchResult;
    }
}