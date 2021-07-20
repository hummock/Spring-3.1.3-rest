document.getElementById("formNewUser").addEventListener("submit", addNewUser);

function addNewUser(e){
    e.preventDefault();

    let name = document.getElementById("newName").value;
    let lastname = document.getElementById("newLastname").value;
    let age = document.getElementById("newAge").value;
    let login = document.getElementById("newLogin").value;
    let password = document.getElementById("newPassword").value;
    let roles = setRoles(Array.from(document.getElementById("newRole").selectedOptions)
        .map(option => option.value));

    fetch("http://localhost:8088/api/admin/create", {
        method: "POST",
        headers: {
            "Accept": "application/json, text/plain, */*",
            "Content-type": "application/json"
        },
        body: JSON.stringify({
            name: name,
            lastname: lastname,
            age: age,
            login: login,
            password: password,
            roles: roles
        })
    })
        .finally(() => {
            document.getElementById("idUsersTable").click();
            getUsers();
            document.getElementById("formNewUser").reset();
        })
}

function setRoles(someRoles) {
    let roles = [];
    if (someRoles.indexOf("ROLE_USER") >= 0) {
        roles.push({"id": 2, "name": "ROLE_USER"});
    }
    if (someRoles.indexOf("ROLE_ADMIN") >= 0) {
        roles.push({"id": 1, "name": "ROLE_ADMIN"});
    }
    return roles;
}