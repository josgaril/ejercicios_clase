const endpoint = "http://localhost:8080/appRestFinal/api/";

let noticias = [];

window.addEventListener('load', init);

function init(){
    console.debug('Document Load and Ready');
   
   cargarNoticias(); 
   
}

function cargarNoticias(){
    console.log('Cargar noticias');    
    
    let url = endpoint + 'noticias/';
    ajax('GET', url, undefined)
        .then(data =>{
            console.info('Promesa resuelta');
            noticias = data;
            pintarNoticias(noticias);
        })
        .catch(error => {
            console.warn('Promesa rechazada');
            alert('Lo sentimos, no se han podido cargar las noticias');
        });

}

function pintarNoticias(noticias){
    let tarjetasNoticias = document.getElementById('tarjetasNoticias');

    tarjetasNoticias.innerHTML = '';
    noticias.forEach(el => {

        tarjetasNoticias.innerHTML +=
        `   
        <div class="card tarjetas col-12" >
            <div class="card-body ">
                <div class="card-title row ">
                        <div class="col-12 mb-1 col-sm-10"> 
                            <spam class="tituloNoticia" >${el.titulo}</spam>
                        </div>
                        <div class="col-12 col-sm-2">
                            <span class="d-flex justify-content-end">${el.fecha}</span>
                        </div>
                    </div>
                </div>
                <div class="card-text mb-2">${el.contenido}</div>
            </div>
        </div>
        `       
    });
}