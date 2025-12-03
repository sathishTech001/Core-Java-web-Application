const url = "http://localhost:8080/servlet-api/hello";


let number = 0;


async function getList(){
	let container = document.getElementById("getCustomerList");
	container.innerHTML = "";
	let count = 0;
	try {
		const header_row = document.createElement("tr");
		const headers = ["S.No","Id","Name","Password"];
		headers.forEach(value=>{
			const theader = document.createElement("th");
			theader.textContent = value;
			header_row.appendChild(theader);
		});
		container.appendChild(header_row);
	    const res = await fetch(url);
	    console.log(res);
		if(res.status!=200){
			throw new Error("the status code is not 200, it is: " + res.status);
		}
	    const users = await res.json();
		console.log("user_json : ", users); 
		
		users.forEach(user => {
			let tr = document.createElement("tr");
			let tsno = document.createElement("td");
			let tid = document.createElement("td");
			let tname = document.createElement("td");
			let tpassword = document.createElement("td");
			tsno.innerText = ++count;
			tid.innerText =  user.id;
			tname.innerText = user.name;
			tpassword.innerText = user.password;

            // Append children one by one
			tr.appendChild(tsno);
			tr.appendChild(tid);
            tr.appendChild(tname);
            tr.appendChild(tpassword);

			container.appendChild(tr);
		});
	} catch (err) {
	    console.error("Fetch error:", err);
	    document.getElementById('customer_list_status').innerText = err.message || err; // Ensure we display a readable error
	}
}

async function postData(){
	const name = document.getElementById("name").value;
	const password = document.getElementById("password").value;
	if(name==null || name==""){
		alert("please enter a name!");
	}
	if(password==null || password==""){
			alert("please enter a password!");
	}
	const body = {
		id:++number,
		name:name,
		password:password
	};
	try {
		const res = await fetch(url, {
		        method: "POST",
		        headers: { "Content-Type": "application/json" },
		        body: JSON.stringify(body)
		 });
	    const data = await res.json();
		console.log("insert_response : "+data);
		document.getElementById("status_insert").innerText = 
		    "Server says: " + data.status;
	} catch (err) {
		document.getElementById("status_insert").innerText = "Error: " + err;
	}finally{
		getList();
	}
}
async function updateData(){
	const id =  parseInt(document.getElementById("update_id").value);
	const name = document.getElementById("name_update").value;
	const password = document.getElementById("password_update").value;
	if(id==null || id==""){
		alert("please enter a id!");
	}
	if(name==null || name==""){
		alert("please enter a name!");
	}
	if(password==null || password==""){
			alert("please enter a password!");
	}
	const body = {
		id:id,
		name:name,
		password:password
	};
	try {
		const res = await fetch(url, {
		        method: "PUT",
		        headers: { "Content-Type": "application/json" },
		        body: JSON.stringify(body)
		 });
	    const data = await res.json();
		console.log("update_response : "+data);
		document.getElementById("status_update").innerText = 
		    "Server says: " + data.message;
	} catch (err) {
		document.getElementById("status_update").innerText = "Error: " + err;
	}finally{
		getList();
	}
}

async function deleteData(){
	const cust_id = document.getElementById("customer_id").value;
	if(cust_id==null || cust_id==""){
		alert("please enter a customer id!");
	}
	try {
		const res = await fetch(url+"?id="+cust_id, {
		        method: "DELETE",
		        headers: { "Content-Type": "application/json" },
		 });
		 const data = await res.json();
		 console.log("delete_response : "+data);
		 document.getElementById("status_delete").innerText = "Server says: " + data.message;
	} catch (err) {
		document.getElementById("status_delete").innerText = "Error: " + err;
	}finally{
		getList();
	}
}
