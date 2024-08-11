function clearFields()
{
	let username = document.getElementById("username");
	let password = document.getElementById("password");
	password.value = "";
	username.value = "";
	console.log("working");
}

var myVar;

function myFunction() {
  myVar = setTimeout(showPage, 3000);
}

function showPage() {
  document.getElementById("loader").style.display = "none";
  document.getElementById("myDiv").style.display = "block";
}