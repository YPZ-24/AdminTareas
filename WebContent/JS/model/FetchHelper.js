async function FETCH (method, path, body) {
    const bodyString = (body==null) ? null : JSON.stringify(body);
    console.log(bodyString);
    try{
        console.log("1");
        const res = await fetch(path, {
        method: method,
        body: bodyString,
        headers: {
            'Content-type': 'application/json',
            'Accept': 'application/json',
        }
        });
        if(res.ok){
            let data = await res.json();
            return data;
        }else{
            throw new Error("Ocurrio un error al hacer la peticion");
        }
    }catch(e){
        console.log(e);
        e.message = "Fetch failed"
        return e
    }
}