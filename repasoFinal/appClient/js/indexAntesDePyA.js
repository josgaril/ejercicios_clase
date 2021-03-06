"use strict";
const endpoint = "http://localhost:8080/appRestFinal/api/";

// este array se carga de forma asincrona mediante Ajax
//const endpoint = "http://127.0.0.1:5500/appclient/js/data/personas.json";
let personas= [];
let personaSeleccionada = {};
let cursos = [];

window.addEventListener('load', init);


function init(){
    console.debug('Document Load and Ready');
    
    listener();
    galeriaImagenes();
    cargarCursosDisponibles();
    cargarPersonas();
  
}

function listener(){

    /* Filtro para buscar personas por sexo y nombre */
    let selectSexo = document.getElementById('selectSexo');
    let inputPersona = document.getElementById('inputPersona');
    inputNombre.value="";

    selectSexo.addEventListener('change', filtroBuscar);
    inputPersona.addEventListener('keyup', filtroBuscar);

    /* Filtro para buscar cursos disponibles */
    let inputCurso = document.getElementById('inputCurso');
    inputCurso.addEventListener('keyup', filtroCurso);

    /* Animaciones */
    let buscador = document.querySelector('.buscador');
    buscador.style.display= "block";
    buscador.classList.add("animated" , "slideInDown");
    
}

function filtroBuscar(){
    let selectSexo = document.getElementById('selectSexo');
    let inputPersona = document.getElementById('inputPersona');

    const sexo = selectSexo.value;
    const nombre = inputPersona.value.trim().toLowerCase();

    console.trace(`Filtrado por sexo = ${sexo} y nombre = ${nombre}`);

    let personasFiltradas = personas.map(el => el);
    if (sexo == 'h' || sexo == 'm'){
        personasFiltradas = personasFiltradas.filter( el => el.sexo == sexo);
        console.debug('Filtrado por sexo %o', sexo);
    }

    if (nombre != ''){
        personasFiltradas = personasFiltradas.filter( el => el.nombre.toLowerCase().includes(nombre))
        console.debug('FIltrado por nombre %o', nombre);
    }

    pintarPersonas(personasFiltradas); 
}

function filtroCurso(){
    let inputCurso = document.getElementById('inputCurso');
  
    const nombreCurso = inputCurso.value.trim().toLowerCase();
  
    if (nombreCurso.length >= 3) {
      console.debug('Nombre filtrado: %o ', nombreCurso);
      cargarCursosDisponibles(nombreCurso);
    } else {
      cargarCursosDisponibles();
    }
}

function cargarPersonas(){
    console.info('Cargando Personas');
    const url = endpoint + 'personas/';
    ajax("GET",url,undefined)
        .then(data => {
            console.debug('Promesa resuelta');
            personas = data;
            personas.sort((a,b)=> a.id>b.id? 1:-1);
            pintarPersonas(personas);
       })
       .catch(error => {
            console.warn('Promesa rechazada');
            alert("Lo sentimos, no se han podido cargar los datos");
       });
}

function pintarPersonas(personas){
    
    console.info('Se pinta el listado de personas');
    
    let listaPersonas= document.getElementById('listaPersonas');
    listaPersonas.style.display="block";
    listaPersonas.classList.add("animated","bounceInLeft", "delay-2" ,"slower");

    let listadoPersonas = document.getElementById('listadoPersonas');

    listadoPersonas.innerHTML = '';

    personas.forEach(el => 
        listadoPersonas.innerHTML +=
            `
            <li class="border border-dark">
                <img src="img/${el.avatar}" alt="avatar">
                <span> ${el.nombre} ${el.apellidos} (${el.cursos.length}) </span>
                <i onclick="verDetalles(${el.id})" class="fas fa-edit"></i>
                <i onclick="eliminarPersona(${el.id})" class="fas fa-trash-alt"></i>
            </li>
            `
    );
    console.debug(personas) ;
}

function verDetalles(id = 0){
    //console.info(`Ver detalles de persona con id ${id}`);

    let formularioPersonas = document.getElementById('formularioPersonas');
    formularioPersonas.style.display = 'block';
    formularioPersonas.classList.add('animated', 'fadeInRight');

    personaSeleccionada = personas.find(el => el.id == id);

    if (!personaSeleccionada){
        personaSeleccionada = 
            {
                "id": 0,
                "nombre": "Sin-nombre",
                "apellidos": "Sin-apellidos",
                "dni": "00000000O",
                "avatar": "avatar7.png",
                "sexo": "h",
                "rol": 1,
            };
        console.trace('Click en Agregar nueva persona');
    }else{
        console.trace(`Click en Ver detalles de ${personaSeleccionada.nombre}`);
        console.debug(personaSeleccionada);
    }
    
    document.getElementById('inputId').value = personaSeleccionada.id;
    document.getElementById('inputNombre').value = personaSeleccionada.nombre;
    document.getElementById('inputApellidos').value = personaSeleccionada.apellidos;
    document.getElementById('inputDNI').value = personaSeleccionada.dni;
    document.getElementById('inputAvatar').value = personaSeleccionada.avatar;
    
    const avatares = document.querySelectorAll('#gallery img');
    avatares.forEach(el => {
      el.classList.remove('selected');
      if ("img/" + personaSeleccionada.avatar == el.dataset.path) {
        el.classList.add('selected');
      }
    });
 
    let sexo = personaSeleccionada.sexo;
    let sexoHombre = document.getElementById('sexoH');
    let sexoMujer = document.getElementById('sexoM');

    if (sexo == 'h'){
        sexoHombre.checked = 'checked';
        sexoMujer.checked = '';
    }else{
        sexoMujer.checked = 'checked';
        sexoHombre.checked = '';
    }

    cursosContratados(personaSeleccionada);

}

function guardar(){
    //console.trace('Click en guardar');

    let id = document.getElementById('inputId').value;
    let nombre = document.getElementById('inputNombre').value;
    let apellidos = document.getElementById('inputApellidos').value;
    let dni = document.getElementById('inputDNI').value;
    let avatar = document.getElementById('inputAvatar').value;
    let avatarImagen = avatar.replace('img/', '');
    avatar = avatarImagen;
    let sexo = 'h';
    let sexoHombre = document.getElementById('sexoH').checked;


    if (!sexoHombre){
        sexo = 'm';
    }

    let persona = {
        'id': id,
        'nombre': nombre,
        'apellidos': apellidos,
        'dni': dni,
        'avatar': avatar,
        'sexo': sexo,
        'rol': 2
    }

    if (id == 0){  // GUARDAR PERSONA
        console.trace('Click en guardar persona');

        const url = endpoint + 'personas/';
        ajax('POST', url, persona)
        .then(data => {
            console.log('Promesa aceptada');
            persona = data;
            alert('Persona creada con éxito');
            cargarPersonas();
        })
        .catch(error => {
            console.log('Promesa rechazada');
            alert(error);
        })
    }else{  //MODIFICAR PERSONA
        console.trace('Click en mofificar persona');

        const url = endpoint + 'personas/' + persona.id;
        ajax('PUT', url, persona)
        .then(data => {
            console.info('Promesa aceptada');
            alert('Persona modificada con éxito');
            cargarPersonas();
        })
        .catch(error => {
            console.error('Promesa rechazada');
            console.error('No se ha podido modificar la persona');
            alert(error);
        })
    }
}

function eliminarPersona(idPersona = 0){
    personaSeleccionada = personas.find( el => el.id == idPersona);

    console.trace('Click en EliminarPersona', personaSeleccionada);

    const mensaje = `¿Seguro que quieres eliminar a ${personaSeleccionada.nombre}?`
    if ( confirm(mensaje) ){
        const url = endpoint + 'personas/' + personaSeleccionada.id;
        ajax('DELETE',url, undefined)
        .then(data =>{
            console.info('Promesa resuelta');
            cargarPersonas();
            verDetalles(0);
            alert('Persona eliminada correctamente');
        })
        .catch(error => {
            console.error('Error al eliminar la persona');
            alert(`Error: ${error}`);
        });
    }else{
        console.info('Se ha cancelado EliminarPersona');

    }
}

/**
 * Muestra todas las imagenes de los avatares
 */
function galeriaImagenes() {
    let imagenes = document.getElementById('gallery');
    for (let i = 1; i <= 7; i++) {
      imagenes.innerHTML += `<img onclick="seleccionarAvatar(event)" 
                          class="avatar" 
                          data-path="img/avatar${i}.png"
                          src="img/avatar${i}.png">`;
    }
  } //Fin function galeriaImagenes
  
  
  /**
   * Selecciona el avatar sobre el que se ha hecho el evento click
   * @param {*} evento 
   */
  function seleccionarAvatar(evento) {
    console.trace('click en avatar');
    const avatares = document.querySelectorAll("#gallery img");
    avatares.forEach(el => el.classList.remove('selected'));
    evento.target.classList.add('selected');
  
    let inputAvatar = document.getElementById('inputAvatar');
    inputAvatar.value = evento.target.dataset.path;
  } //Fin function selectAvatar

function cursosContratados(persona){
    console.debug('Obteniendo cursos contratados de %o', persona.nombre);

    
    let listadoCursosContratados = document.getElementById('listadoCursosContratados');
    let buttonModal = document.getElementById('buttonModal');
    listadoCursosContratados.innerHTML = '';
    cursos = persona.cursos;

    if (personaSeleccionada.id == 0){
        listadoCursosContratados.innerHTML += 
        `
            <li>
                <span>Agregue un nuevo usuario y editelo para añadir cursos.</span>
            </li>
        `;
        buttonModal.disabled = true;
    }else{
        buttonModal.disabled = false;
        if (personaSeleccionada.rol == 2){
            const url = endpoint + 'cursos/' + personaSeleccionada.id;
            ajax("GET", url, undefined)
            .then(data => {
                console.info('Promesa cursos profesor aceptada');
                cursos = data;
                console.info('Se muestran los cursos del profesor %o', persona.nombre);
                cursos.forEach( el => {
                    
                    listadoCursosContratados.innerHTML += 
                    `
                        <li>
                            <span>${el.nombre}</span>
                            <i class="fas fa-trash" onclick='eliminarCursoContratado(event, ${personaSeleccionada.id}, ${el.id})'></i>
                        </li>
                    `;
                })
            }).catch( error => {
                console.warn('Promesa cursos profesor rechazada');
                alert( error );
            });
    
        }else{
            cursos.forEach( el => {
            console.info('Se muestran los cursos de %o', persona.nombre);
            listadoCursosContratados.innerHTML += 
            `
                <li>
                    <span>${el.nombre}</span>
                    <i class="fas fa-trash" onclick='eliminarCursoContratado(event, ${personaSeleccionada.id}, ${el.id})'></i>
                </li>
            `;
            })
        }
    }
}

function cargarCursosDisponibles(nombreCurso = ''){
    console.debug('Cargando cursos disponibles');

    const url = endpoint + 'cursos/?filtro=' + nombreCurso;
    ajax('GET',url,undefined)
        .then( data => {
            console.info('Promesa cursos aceptada');
            cursos = data;
            console.debug('cursos disponibles: %o', cursos);
            pintarCursosDisponibles(cursos);
        })
        .catch( error => {
            console.error('Promesa rechazada');
            alert('Lo sentimos, no se han podido cargar los cursos');
        });
}


function pintarCursosDisponibles(cursosDisponibles){
    console.info('Se pintan los cursos disponibles');
    let listadoCursosDisponibles = document.getElementById('listadoCursosDisponibles');

    listadoCursosDisponibles.innerHTML = '';
    cursosDisponibles.forEach( el => 
        listadoCursosDisponibles.innerHTML += 
        `
            <li>
                <img src="img/cursos/${el.imagen}"/>
                <span>${el.nombre}</span>
                <span>${el.precio}</span>
                <span>${el.profesor.nombre}</span>
                <i class="fas fa-plus-square" onclick='contratarCurso(0,${el.id})'></i>
            </li>
        `);
}

function eliminarCursoContratado(event, idPersona,idCurso){
    console.trace(`Click Eliminar curso ${idCurso} de ${personaSeleccionada.nombre}`);

    const url = endpoint + 'personas/' + idPersona + '/curso/' + idCurso;
    ajax('DELETE', url, undefined)
        .then( data => { 
            console.info('Promesa eliminarCursoContratado aceptada');
            alert('Curso eliminado');
          
            event.target.parentElement.classList.add('animate','bounceOut','slow','delay-2');
            setTimeout(function(){
                event.target.parentElement.remove();
                cargarPersonas();
            },2000);
        })
        .catch( error => {
            console.error('Promesa eliminarCursoContratado rechazada');
            alert(error);
        })

}

function contratarCurso(idPersona = 0, idCurso){
    idPersona = (idPersona!=0)? idPersona : personaSeleccionada.id; 
    console.trace(`Click en Contratar curso ${idCurso} para la persona ${personaSeleccionada.nombre} con id ${idPersona}`);

    const url = endpoint + 'personas/' + idPersona + '/curso/' + idCurso;
    ajax("POST", url, undefined)
        .then( data => {
            console.log('Promesa contratarCurso aceptada');
            alert('Curso contratado');
            const nuevoCurso = data;
            let listadoCursosContratados = document.getElementById('listadoCursosContratados');

            listadoCursosContratados.innerHTML += 
                `
                <li class="animated bounceIn">
                <span>${nuevoCurso.nombre}</span>
                <i class="fas fa-trash" onclick='eliminarCursoContratado(event, ${personaSeleccionada.id}, ${nuevoCurso.id})'></i>
                 </li>
                `;
            cargarPersonas();
        })
        .catch( error => {
            console.warn('Promesa contratarCurso rechazada');
            alert(error);
        })
    ;
}


/*  Pendiente por hacer:
    - nombre disponible o no debajo del nombre
    -version 3.0
    - crud completo para cursos y noticias si me da tiempo. 
*/