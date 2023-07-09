// Call the dataTables jQuery plugin
$(document).ready(function() {
    getAllUsuarios()
  $('#usuariosTable').DataTable();
});

async function getAllUsuarios(){
  const request = await fetch('api/getAllUsuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const usuarios = await request.json();

let usuariosHTML = "";
for(let usuario of usuarios){
  usuariosHTML = `
  <tr>
    <td>`+usuario.name+`</td>
    <td>`+usuario.surname+`</td>
    <td>`+usuario.role+`</td>
    <td>`+usuario.email+`</td>
    <td>`+usuario.password+`</td>
  </tr>
  `;
}


  $("#usuariosTable tbody").html(usuariosHTML)

  console.log(usuarios);
}
