function openModalWindowEdit(id) {
    document.getElementById("idEdit").value = id;
    document.getElementById("nameEdit").value = $("#name" + id).text(); //userFirstNameGod
    document.getElementById("lastnameEdit").value = $("#lastname" + id).text();
    document.getElementById("ageEdit").value = $("#age" + id).text();
    document.getElementById("loginEdit").value = $("#login" + id).text();
    document.getElementById("passwordEdit").value = "";
}

function openModalWindowDelete(id) {
    document.getElementById("idDelete").value = id;
    document.getElementById("nameDelete").value = $("#name" + id).text();
    document.getElementById("lastnameDelete").value = $("#lastname" + id).text();
    document.getElementById("ageDelete").value = $("#age" + id).text();
    document.getElementById("loginDelete").value = $("#login" + id).text();
    document.getElementById("passwordDelete").value = "";
}