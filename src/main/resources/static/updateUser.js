document.getElementById("formEditUser").addEventListener("submit", updatePost)

function updatePost() {

    let id = document.getElementById("idEdit").value;
    let name = document.getElementById("nameEdit").value;
    let lastname = document.getElementById("lastnameEdit").value;
    let age = document.getElementById("ageEdit").value;
    let login = document.getElementById("loginEdit").value;
    let password = document.getElementById("passwordEdit").value;
    let roles = setRoles(Array.from(document.getElementById("roleEdit").selectedOptions)
        .map(option => option.value));



    fetch("http://localhost:8088/api/admin/update", {
        method:"PUT",
        headers: {
            "Accept": "application/json, text/plain, */*",
            "Content-type":"application/json"
        },
        body:JSON.stringify({
            id:id,
            name:name,
            lastname:lastname,
            age:age,
            login:login,
            password:password,
            roles:roles
        })
    }).finally(() => {
        $('#modalEDIT').remove()
        getUsers();
    })
}