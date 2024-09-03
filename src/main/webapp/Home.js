

let mode = document.getElementById("mode");
let currMode = "light";
let navbar= document.getElementById("navbarcomp");
let form = document.getElementById("formcomp");
let product = document.getElementsByClassName("products")
let body = document.querySelector("body");
let filterheading = document.getElementsByTagName("h5")



mode.addEventListener("click",()=>{
	if(currMode==="light")
	{
		currMode= "dark";
		body.style.backgroundColor = "#222831";
		body.style.color = "White"
		for(p of product)
		{
			p.classList.add("darkmode");
		}
		for(fh of filterheading)
		{
			fh.style.color = "white"
		}
		navbar.classList.add("darkmode");	
		form.classList.add("darkmode")
		
	}
	else{
		currMode = "light";
		body.style.backgroundColor = "white";
		body.style.color = "black"
		navbar.classList.remove("darkmode");
		form.classList.remove("darkmode");
		for(p of product)
		{
			p.classList.remove("darkmode");
		}
		
		
	}
})