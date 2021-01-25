


document.querySelectorAll(".datepicker").forEach((dp)=>{
    M.Datepicker.init(dp);
})
const sidenav = M.Sidenav.init(document.querySelectorAll('.sidenav'));
const modalDelete = M.Modal.init(document.querySelector("#modalDelete"));
const modalCreateProject = M.Modal.init(document.querySelector("#modalCreateProject"));
const modalUpdate = M.Modal.init(document.querySelector("#modalUpdate"));
const taskRow = document.querySelectorAll(".task-row");
const btnAddTask = document.querySelector("#btnAddTask");
const btnAddProject = document.querySelector("#btnAddProject");
const btnAcceptCreateProject = document.querySelector("#btnAcceptCreateProject");

//Variables
let draggedElement;

//Add Listeners
taskRow.forEach(task => {
    task.setAttribute("draggable", "true");
    task.addEventListener("dblclick", taskDblClickController)
    task.addEventListener("dragstart", taskDragRowController)
});

document.addEventListener("dragover", function(e) {
    e.preventDefault();
});

btnAddTask.addEventListener("click", btnAddTaskClickController);

btnAddProject.addEventListener("click", btnAddProjectController);

document.addEventListener("drop", documentDropController);

btnAcceptCreateProject.addEventListener("click", btnAcceptCreateProjectController);


//Listeners Controllers

async function btnAcceptCreateProjectController(){
    const newProjectName = document.querySelector("#newProjectName").value;
    const project = new Project(null, newProjectName);
    const projectCreated = await createProject(project);
    if(projectCreated!=null){
        M.toast({html: 'Project Created...!'})
        modalCreateProject.close();
        paintProject(projectCreated.name)
    }
}

async function clickProjectController(project){
    const tasksPanel = document.querySelector(".task-container");
    tasksPanel.innerHTML = '';

    const projectTasks = await getProjectTasks(project);
    projectTasks.forEach(t => {
        const task = new Task(t.id, t.cveProject, t.name, t.dateStart, t.duration, t.predecessor, t.progress);
        paintTask(task);
    });
}

function btnAddProjectController(){
    modalCreateProject.open();
}

function btnAddTaskClickController(){
    
    //paintProject("Proyecto 4");
    //repaintModalProject("Proyectito", "Esta es la descripcion", "10", "24-01-2021", "24-01-2021");
}

function taskDblClickController(task){
    const project = document.querySelector("#project");
    const name = document.querySelector("#name");
    const progress = document.querySelector("#progress");
    const dateStart = document.querySelector("#dateStart");
    const dateEnd = document.querySelector("#dateEnd");
    const btnDeleteTask = document.querySelector("#btnDeleteTask");

    name.value = task.name;
    progress.value = task.progress;    
    dateStart.value = task.dateStart;
    dateEnd.value = task.duration;
    btnDeleteTask.onclick = btnDeleteTaskController(task.id)
    modalUpdate.open();
}

function btnDeleteTaskController(idTask){
    //alert(idTask);
}

function taskDragRowController(e){
    draggedElement = e.target;
}

function documentDropController(e){
    e.preventDefault();

    let element = e.target;
    try{
        let elementIsTaskRow = element.className.includes("task-row"); 
        let isContainer = element.className.includes("task-container");
        while(!elementIsTaskRow && !isContainer){
            element = element.parentNode;
            elementIsTaskRow = element.className.includes("task-row"); 
        }
        if(element!=draggedElement){
            let tasks = element.parentNode.children;
            let elementIndex = Array.from(tasks).indexOf(element)
            let elementDraggedIndex = Array.from(tasks).indexOf(draggedElement)

            if(elementDraggedIndex<elementIndex){
                draggedElement.parentNode.removeChild(draggedElement);
                element.parentNode.insertBefore(draggedElement, element.nextSibling);      
            }else if(elementDraggedIndex>elementIndex){
                draggedElement.parentNode.removeChild(draggedElement);
                element.parentNode.insertBefore(draggedElement, element);      
            }
        }
    }catch(error){

    }
}