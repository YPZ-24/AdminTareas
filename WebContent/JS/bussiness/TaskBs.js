async function createTask(task){
      let path = "createTask";
  
      let fetchResult = FETCH("POST", path, task);
      if(fetchResult instanceof Error){
          //Ocurrio un error en el fetch
          alert(fetchResult.message);
      }else{
          mainDashboard.addProject(fetchResult);
      }
  }
  
  //Return task updated
async function updateTask(task){
    let path = "updateTask";
    let fetchResult = FETCH("PUT", path, project);
    if(fetchResult instanceof Error){
        //Ocurrio un error en el fetch
        alert(fetchResult.message);
    }else{
        return fetchResult;
    }
}

  //Return task deleted
async function deleteTask(task){
    let path = "deleteTask";

    let fetchResult = FETCH("DELETE", path, task);
    if(fetchResult instanceof Error){
        //Ocurrio un error en el fetch
        alert(fetchResult.message);
    }else{
        return fetchResult;
    }
}