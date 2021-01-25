<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- MATERIALIZE -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!--ME-->
    <link rel="stylesheet" href="CSS/style.css">
    <title>Y-TEAM</title>
</head>
<body>
    <!--OTHER-->
    <script defer src="JS/Controller.js"></script>
    <script defer src="JS/CreateViews.js"></script>
    <!--MODEL-->
    <script  src="JS/model/Project.js"></script>
    <script  src="JS/model/Task.js"></script>
    <script  src="JS/model/Dashboad.js"></script>
    <script  src="JS/model/FetchHelper.js"></script>
    <!--BUSSINES-->
    <script  src="JS/bussiness/TaskBs.js"></script>    
    <script  src="JS/bussiness/ProjectBs.js"></script>    
    <script  src="JS/bussiness/DashboardBs.js"></script>
    
	<!-- MATERIALIZE -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>    




    <header>
        <nav>
            <div class="nav-wrapper black">
                <a href="#" class="brand-logo center">Y-TEAM</a>
                <ul>
                    <li><a data-target="slide-out" class="sidenav-trigger hide-on-large-only waves-effect waves-light btn-dark"><i class="material-icons">menu</i></a></li>
                </ul>
            </div>
        </nav>
    </header>
    

    <ul id="slide-out" class="sidenav sidenav-fixed">
        <li><a id="btnAddProject" class="waves-effect waves-light btn-large purple">New Project</a></li>
    </ul>

    <main class="task-container">

        <div class="task-row row valign-wrapper">
            <div class="col s5">
                <p class="m12">Tarea1</p>
            </div>
            <div class="col s7">
                <div class="progress">
                    <div class="determinate" style="width: 70%"></div>
                </div>
            </div>
        </div>
        <div class="task-row row valign-wrapper">
            <div class="col s5">
                <p class="m12">Tarea2</p>
            </div>
            <div class="col s7">
                <div class="progress">
                    <div class="determinate" style="width: 70%"></div>
                </div>
            </div>
        </div>
        
    </main>
    
    <a id="btnAddTask" class="btn-floating btn-large waves-effect waves-light purple"><i class="material-icons">add</i></a>
    
    
    
    
    
    
    
    
    
    
    


    <!--Modal Delete-->
    <div id="modalDelete" class="modal">
        <div class="modal-content">
            <p>Seguro de eliminar esta tarea?</p>
        </div>
        <div class="modal-footer">
            <a href="#" class="waves-effect waves-light btn gray">Cancelar</a>
            <a href="#" class="waves-effect waves-light btn red">Eliminar</a>
        </div>
    </div>

    <!--Modal Create Project-->
    <div id="modalCreateProject" class="modal">
        <div class="modal-content">
            <form>
                <label for="newProjectName">Nombre del proyecto</label>
                <input id="newProjectName" type="text">
            </form>
        </div>
        <div class="modal-footer">
            <a href="#" class="waves-effect waves-light btn gray">Cancelar</a>
            <a href="#" id="btnAcceptCreateProject" class="waves-effect waves-light btn purple">Guardar</a>
        </div>
    </div>

    <!--Modal Update-->
    <div id="modalUpdate" class="modal bottom-sheet">
        <div class="modal-content">
            <div class="row">
                <div class="col s12">
                    <h4 id="project">Task</h4>
                </div>
                <div class="col s12">
                    <label for="name">Nombre</label>
                    <input id="name" type="text">
                    <!--
                    <p id="name">Tarea Lorem ipsum dolor sit amet consectetur, adipisicing elit. Iusto doloribus explicabo, voluptatem quia culpa laborum voluptates nihil veritatis necessitatibus id nisi, laboriosam pariatur. Quam repellendus quidem, voluptas possimus quibusdam ratione?</p>
                    -->
                </div>
                <div class="col s12">
                    <label for="progress">Avance</label>
                    <p class="range-field">
                        <input id="progress" type="range" min="0" max="100" />
                    </p>
                </div>
                <div class="input-field col s6">
                    <label for="dateStart">Fecha inicio</label>
                    <input id="dateStart" type="text" class="datepicker">
                </div>
                <div class="input-field col s6">
                    <label for="dateEnd">Duracion</label>
                    <input id="dateEnd" type="text">
                </div>
                <div class="col s12 right-align">
                    <a class="waves-effect waves-light btn grey lighten-1">Cancelar</a>
                    <a class="waves-effect waves-light btn deep-purple accent-2">Guardar Cambios</a>
                </div>
            </div>   
        </div>
        <div class="modal-footer">
            <a id="btnDeleteTask" class="waves-effect waves-light btn red darken-4">Eliminar Tarea</a>
        </div>
      </div>





  
</body>
</html>