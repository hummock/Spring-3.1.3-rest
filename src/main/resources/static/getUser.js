function getUser() {

    fetch("http://localhost:8088/api/user").then((res) => res.json())
        .then((currentUser) => {
            let userRoles = "";
            for (let i = 0; i < currentUser.roles.length; i++) {
                userRoles += `${currentUser.roles[i].name} `
            }

            let output = "<tr>";
            output += `
                <td>${currentUser.id}</td>
                <td>${currentUser.name}</td>
                <td>${currentUser.lastname}</td>
                <td>${currentUser.age}</td>
                <td>${currentUser.login}</td>
                <td>${userRoles}</td>
            `;
            output += "<tr>";

            document.getElementById("getUserTable").innerHTML = output;
        })
}


function getHeader() {
    fetch("http://localhost:8088/api/user").then((res) => res.json())
        .then((currentUser) => {
            let userRoles = "";
            for (let i = 0; i < currentUser.roles.length; i++) {
                userRoles += `${currentUser.roles[i].name} `
            }
            let output = "";
            output += `${currentUser.login} with roles: ${userRoles}`;
            document.getElementById("headerLogo").innerHTML = output;
        })
}

getHeader()

getUser()