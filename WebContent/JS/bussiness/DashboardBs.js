const mainDashboard = new Dashboard;
conta = 0;
if(conta == 0){
    console.log("TRE");
    getProjects();
    conta++;
}

//getProjectTasks();

async function getProjects(){
    console.log("Aa")
    let path = "getProjects";
    let fetchResult = await FETCH("GET", path, null);
    if(fetchResult instanceof Error){
        //Ocurrio un error en el fetch
        alert(fetchResult.message);
    }else{
        console.log(fetchResult);
        fetchResult.forEach(p => {
            paintProject(p);
        });
    }
}