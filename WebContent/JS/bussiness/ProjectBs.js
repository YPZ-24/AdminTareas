//let URL = "http://localhost:8080/pw_web/";
/*
let path = "ProjectSv";
    let project = new Project("P24", "Project 1");
    let body = project;
*/

//Return project created;
async function createProject(project){
    let path = "createProjectSv";
    let fetchResult = FETCH("POST", path, project);
    if(fetchResult instanceof Error){
        //Ocurrio un error en el fetch
        alert(fetchResult.message);
    }else{
        return fetchResult;
    }
}

//Return project updated
async function updateProject(project){
    let path = "updateProject";

    let fetchResult = FETCH("PUT", path, project);
    if(fetchResult instanceof Error){
        //Ocurrio un error en el fetch
        alert(fetchResult.message);
    }else{
        return fetchResult;
    }
}