function paintTask(task){
    const tasksPanel = document.querySelector(".task-container");

    const divRow = document.createElement("div");
    divRow.setAttribute("class", "task-row row valign-wrapper");
    divRow.addEventListener("dblclick", (e)=>{
        taskDblClickController(task)
    });

    const divColTask = document.createElement("div");
    divColTask.setAttribute("class", "col s5");

    const pTask = document.createElement("p");
    pTask.setAttribute("class", "m12");
    const taskText = document.createTextNode(task.name);

    const divColProgress = document.createElement("div");
    divColProgress.setAttribute("class", "col s7");

    const divProgress = document.createElement("div");
    divProgress.setAttribute("class", "progress")

    const divDeterminate = document.createElement("div");
    divDeterminate.setAttribute("class", "determinate");
    divDeterminate.setAttribute("style", "width: "+task.progress+"%");

    divProgress.appendChild(divDeterminate);
    divColProgress.appendChild(divProgress);
    pTask.appendChild(taskText);
    divColTask.appendChild(pTask);

    divRow.appendChild(divColTask);
    divRow.appendChild(divColProgress);

    tasksPanel.appendChild(divRow);
    
}

function paintProject(project){
    const projectsPanel = document.querySelector("#slide-out");

    const li = document.createElement("li")
    const a = document.createElement("a")
    const projectNameTxt = document.createTextNode(project.name);

    a.appendChild(projectNameTxt);
    li.appendChild(a);
    a.addEventListener("click", ()=>{
        clickProjectController(project);
    })

    projectsPanel.appendChild(li);
}

function repaintModalProject(newProjectName, newName, newPercentageProgress, newDateStart, newDateEnd){
    const project = document.querySelector("#project");
    const name = document.querySelector("#name");
    const progress = document.querySelector("#progress");
    const dateStart = document.querySelector("#dateStart");
    const dateEnd = document.querySelector("#dateEnd");

    project.lastChild.remove();

    const projectTxt = document.createTextNode(newProjectName);
    const nameTxt = document.createTextNode(newName);

    const h4Project = document.createElement("h4");
    h4Project.setAttribute("id", "project");
    h4Project.appendChild(projectTxt);

    //const pName = document.createElement("p");
    //pName.setAttribute("id", "name");
    //pName.appendChild(nameTxt);

    project.appendChild(h4Project);
    //name.appendChild(pName);

    name.value = newName;
    progress.value = newPercentageProgress;
    dateStart.value = newDateStart;
    dateEnd.value = newDateEnd;
}