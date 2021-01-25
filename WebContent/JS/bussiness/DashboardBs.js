const mainDashboard = new Dashboard;
getProjects();
//getProjectTasks();

async function getProjects(){
    console.log("AA")
    let path = "getProjects";
    let fetchResult = await FETCH("GET", path, null);
    if(fetchResult instanceof Error){
        //Ocurrio un error en el fetch
        alert(fetchResult.message);
    }else{
        fetchResult.forEach(p => {
            const project = new Project(p.cveProject, p.name);
            paintProject(project);
        });
    }
}