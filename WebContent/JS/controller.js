
document.querySelectorAll(".datepicker").forEach((dp)=>{
    M.Datepicker.init(dp);
})
const sidenav = M.Sidenav.init(document.querySelectorAll('.sidenav'));
const modalDelete = M.Modal.init(document.querySelector("#modalDelete"));
const modalUpdate = M.Modal.init(document.querySelector("#modalUpdate"));
const taskRow = document.querySelectorAll(".task-row");
const btnAddTask = document.querySelector("#btnAddTask");

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


document.addEventListener("drop", documentDropController);


//Listeners Controllers

function btnAddTaskClickController(){
    console.log("You click me")
    createProject();
}

function taskDblClickController(){
    modalUpdate.open();
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