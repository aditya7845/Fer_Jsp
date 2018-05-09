<html>

<script>  
	var request;  
	function isUsernameAvailable() {  
		var username = document.RegistrationForm.username.value;  
		var url="FER_Ajax.jsp?username="+username;  
	  
		//alert('url: '+url);
		if(window.XMLHttpRequest){  
			request=new XMLHttpRequest();
			//alert('XMLHTTPRequest');
		}  
		else if(window.ActiveXObject){  
			request=new ActiveXObject("Microsoft.XMLHTTP");
			//alert('ActiveXObject');
		}  
	  
		try {  
			request.onreadystatechange=displayStatus;  
			request.open("GET",url,true);  
			request.send();  
		}  
		catch(e) {  
			alert("Unable to connect to server");  
		}  
	}  
	  
	function displayStatus(){  
		if(request.readyState==4){  
			var response = request.responseText;
			//alert('Response:'+response+"...");
			//alert('Response:'+response.trim()+"...");
			var statusTdIdObj = document.getElementById('statusTdId');
			if(response.trim() == 'Y') {
				var str = "Username is available...";
			    var result = str.fontcolor("green");
				statusTdIdObj.innerHTML= result;
			}
			else {
				var str = "Username is not available...";
			    var result = str.fontcolor("red");
				statusTdIdObj.innerHTML= result;
			}
			
			document.getElementById('statusTrId').style.display='';
		}  
	}

	function vaidateForm() {
		var form = document.RegistrationForm;
		
		var errorMessages = "";
		if(form.firstname == null || form.firstname.value == '') {
			errorMessages = "Please enter first name<br>";
		}
		if(form.lastname == null || form.lastname.value == '') {
			errorMessages = errorMessages + "Please enter last name<br>";
		}
		if(form.emailid == null || form.emailid.value == '') {
			errorMessages += "Please enter email id<br>";
		}
		if(form.username == null || form.username.value == '') {
			errorMessages += "Please enter username<br>";
		}
		if(form.password == null || form.password.value == '') {
			errorMessages += "Please enter password<br>";
		}
		if(form.mobile == null || form.mobile.value == '') {
			errorMessages += "Please enter mobile<br>";
		}
		
		if(errorMessages != '') {
			//alert(errorMessages);
			
			var errorIdObj = document.getElementById('errorId');
			errorIdObj.innerHTML = errorMessages.fontcolor('red');
			
			document.getElementById('errorTrId').style.display='';
		}
		else {
			document.getElementById('errorTrId').style.display='none';
			
			form.submit();
		}
	}
</script>

<body>
	<form name = "RegistrationForm" action="RegistrationPost.jsp">
		<table border="10" align="center">
			<tr>
				<td colspan="2" align="center">Registration</td>
			</tr>
			<tr id="errorTrId" style='display:none;'>
				<td colspan="2">
					<span id="errorId">
					
					</span>
				</td>
			</tr>
			<tr>
				<td>Firstname <font color='red'>*</font></td>
				<td><input type="text" name="firstname"></td>
			</tr>
			<tr>
				<td>Middlename</td>
				<td><input type="text" name="middlename"></td>
			</tr>

			<tr>
				<td>Lastname <font color='red'>*</font></td>
				<td><input type="text" name="lastname"></td>
			</tr>

			<tr>
				<td>Emailid <font color='red'>*</font></td>
				<td><input type="text" name="emailid"></td>
			</tr>

			<tr>
				<td>Username <font color='red'>*</font></td>
				<td>
					<input type="text" name="username" onchange="isUsernameAvailable();">
				</td>
			</tr>
			<tr id="statusTrId" style='display:none;'>
				<td colspan="2">
					<span id="statusTdId"></span>
				</td>
			</tr>
			
			<tr>
				<td>Password <font color='red'>*</font></td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td>Mobile <font color='red'>*</font></td>
				<td><input type="text" name="mobile"></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<input type="button" value="Register" onclick="vaidateForm();"> 
				</td>
			</tr>


		</table>
	</form>
</body>
</html>