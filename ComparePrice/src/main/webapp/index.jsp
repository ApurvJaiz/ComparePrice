<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compare</title>
</head>
<style>
input[type=text], select {
  
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
.button {
  /*background-color: #4CAF50;  Green */
  border: none;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  background-color: #008CBA;/* Blue */
} 
.isa_info, .isa_success, .isa_warning, .isa_error .loader {
margin: 10px 0px;
padding:12px;
 
}
.isa_info {
    color: #00529B;
    background-color: #BDE5F8;
}
.isa_success {
    color: #4F8A10;
    background-color: #DFF2BF;
}
.isa_warning {
    color: #9F6000;
    background-color: #FEEFB3;
}
.isa_error {
    color: #D8000C;
    background-color: #FFD2D2;
}
h1
{
text-align: center;
}

.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 50px;
  height: 50px;
  -webkit-animation: spin 2s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
  margin: 0 auto;
}

/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

</style>
<body>
<div class="isa_success">
     <h1 >Compare</h1>
</div>
<div class="isa_info" style="text-align: center">
<form name="form1" action="add">
<input type=text name=t1 required><br/>
<button id="btnSave" name="Save" class="button" type=submit onclick="myFunction()">Submit</button>
<div id="loader" class="loader" style="display:none;" ></div>
</form>
</div>

</body>
<script type="text/javascript">
function myFunction()
{
	var t1 = document.forms["form1"]["t1"].value;
	if(t1!="")
	{
		var x = document.getElementById("btnSave");
		var l = document.getElementById("loader");
		x.style.display = "none";
		l.style.display = "block";
	}
}
</script>
</html>
