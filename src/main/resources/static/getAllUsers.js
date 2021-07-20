function getUsers() {
    fetch("http://localhost:8088/api/admin")
        .then((res) => res.json())
        .then((data) => {
            let output = "";
            data.forEach(function (user) {

                let userRoles = "";
                for (let i = 0; i < user.roles.length; i++){
                    userRoles+=`${user.roles[i].name} `
                }

                output += `
                <tr>
                <td id="id${user.id}">${user.id}</td>
                <td id="name${user.id}">${user.name}</td> 
                <td id="lastname${user.id}">${user.lastname}</td>
                <td id="age${user.id}">${user.age}</td>
                <td id="login${user.id}">${user.login}</td>
                <td id="password${user.id}">${user.password}</td>
                <td id="roles${user.id}">${userRoles}</td>
                <td>
                <a class="btn btn-info" 
                role="button"
                data-toggle="modal" 
                data-target="#modalEDIT" 
                id="callModalEdit"  
                onclick="openModalWindowEdit(${user.id})">Edit</a>
                </td>
                <td>
                <a class="btn btn-danger" 
                role="button"
                data-toggle="modal" 
                data-target="#modalDELETE" 
                id="delete-post"
                onclick="openModalWindowDelete(${user.id})">Delete</a>
                </td>
              </tr>
          `;
            });
            document.getElementById("getAllUsersTable").innerHTML = output;
        })
}
getUsers()