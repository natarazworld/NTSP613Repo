
function validate(frm){
	  alert("123");
	//empty the previous errorm message
	document.getElementById("nameErr").innerHTML="";
	document.getElementById("addrsErr").innerHTML="";
	document.getElementById("aadharNoErr").innerHTML="";
	document.getElementById("vaccineNameErr").innerHTML="";
	document.getElementById("incomeErr").innerHTML="";
	
	//read form data
	let  name=frm.name.value;
	let  addrs=frm.addrs.value;
	let  aadharNo=frm.aadharNo.value;
	let  vaccineName=frm.vaccineName.value;
	let  income=frm.income.value;
	let  flag=true;
	
	//write form validation logic (client side)
	if(name==""){
		document.getElementById("nameErr").innerHTML="<b>name is required</b>";
		frm.name.focus();
		flag=false;
	}
	else if(name.length<5){
		document.getElementById("nameErr").innerHTML="<b>name must have  minimun of 5 chars</b>";
		frm.name.focus();
		flag=false;
	}
	
	if(addrs==""){
		document.getElementById("addrsErr").innerHTML="<b>addrs is required</b>";
		frm.addrs.focus();
		flag=false;
	}
	else if(addrs.length<5){
		document.getElementById("addrsErr").innerHTML="<b>addrs must have  minimun of 5 chars</b>";
		frm.addrs.focus();
		flag=false;
	}
	
	
	if(aadharNo==""){
		document.getElementById("aadharNoErr").innerHTML="<b>adharNo is required</b>";
		frm.aadharNo.focus();
		flag=false;
	}
	else if(isNaN(aadharNo)){
		document.getElementById("aadharNoErr").innerHTML="<b>aadharNo must be numeric value </b>";
		frm.aadharNo.focus();
		flag=false;
	}
	else if(aadharNo.length!=12){
		document.getElementById("aadharNoErr").innerHTML="<b>aadharNo must have  exact 12 digits</b>";
		frm.aadharNo.focus();
		flag=false;
	}
	
	
	if(vaccineName==""){
		document.getElementById("vaccineNameErr").innerHTML="<b>vaccinne name must be selected</b>";
		frm.vaccineName.focus();
		flag=false;
	}
	
	if(income==""){
		document.getElementById("incomeErr").innerHTML="<b>income is required</b>";
		frm.income.focus();
		flag=false;
	}
	else if(isNaN(income)){
		document.getElementById("incomeErr").innerHTML="<b>income must be numeric value </b>";
		frm.income.focus();
		flag=false;
	}
	else if(income<1000 || income>1000000){
		document.getElementById("incomeErr").innerHTML="<b>income must be there in the range 1 through 100000</b>";
		frm.income.focus();
		flag=false;
	}
	return flag;
}//function