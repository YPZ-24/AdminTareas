//let URL = "http://localhost:8080/pw_web/";

async function createProject(){
    let path = "ProjectSv";
    let project = new Project("P24", "Project 1");
    let body = project;

    try{
        const res = await fetch(path, {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            'Content-type': 'application/json',
        }
        });
        let data = await res.json();
        console.log(data);
        return data;
    }catch(e){
        e.message = "Fetch failed"
        console.log("OCURRIO UN ERROR")
        console.log(e);
        return e
    }
}