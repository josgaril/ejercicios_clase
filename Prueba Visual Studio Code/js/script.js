var users = [
    {
        nombre: "Jimena",
        genero:"M",
        hobby: "mascotas",
        avatar: "Avatar1.jpg"
    },
    {
        nombre: "Javier",
        genero: "H",
        hobby: "fiesta",
        avatar: "Avatar2.jpg"
    },
    {
        nombre: "Alberto",
        genero: "H",
        hobby: "mascotas",
        avatar: "Avatar3.jpg"
    },
    {
        nombre: "Leticia",
        genero: "M",
        hobby: "musica",
        avatar: "Avatar4.jpg"
    },
    {
        nombre: "Jesus",
        genero: "H",
        hobby: "fiesta",
        avatar: "Avatar5.jpg"
    },
    {
        nombre: "Maria",
        genero: "M",
        hobby: "deportes",
        avatar: "Avatar6.jpg"
    },
    {
        nombre: "Rebeca",
        genero: "M",
        hobby: "mascotas",
        avatar: "Avatar7.jpg"
    },
    {
        nombre: "Bruno",
        genero: "H",
        hobby: "fiesta",
        avatar: "Avatar8.jpg"
    }
];

window.addEventListener('load', function(){

    function buscar(){
    
        //Obtener hobby
        var hobbyCampo = document.getElementById('hobby');
        var hobby = hobbyCampo.value;
        console.log(hobby);

        //Obtener género
        var generoCampo= document.getElementById('genero');
        var selected = generoCampo.selectedIndex;
        var genero = generoCampo.options[selected].value;
        console.log(genero);

        var resultadosHTML = '';
        var numUsuarios = users.length;

        for(var i = 0; i < numUsuarios; i++){
            
            if (genero== 'T' || genero == users[i].genero){
            
                if(hobby == '' || hobby == users[i].hobby){
                    resultadosHTML +=   '<div class="persona-row">\
                                        <img src="images/' + users[i].avatar + '" />\
                                        <div class="persona-info">\
                                        <div>' + users[i].nombre + '</div>\
                                        <div>' + users[i].hobby + '</div></div>\
                                        <button>Añadir como amigo</button></div>';
                }
            } 
        }
        resultados.innerHTML = resultadosHTML;

    };

    
    var resultados = document.getElementById('resultados');
    var botonBuscar = document.getElementById('botonBuscar');
    botonBuscar.addEventListener('click', buscar);
    buscar();
});