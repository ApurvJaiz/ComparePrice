<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
.isa_info, .isa_success, .isa_warning, .isa_error,.loader {
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
table, th, td{
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;    
}
.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 30px;
  height: 30px;
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

<!--  Sum is : <%= request.getAttribute("result") %> -->
<!-- 	Sum is : ${result} -->
<div class="isa_success">
<!--      <i class="fa fa-check"></i>   -->
     <h1 >Compare</h1>
</div>
<div class="isa_info" style="text-align: center">
<!--     <i class="fa fa-info-circle"></i>  -->
<form name="form1" action="add">
<input type=text name=t1 id="txt" required><br/>
<button id="btnSave" name="Save" class="button" type=submit onclick="myFunction()">Submit</button>
<div id="loader" class="loader" style="display:none;" ></div>
</form>

</div>
<br>
<div style="width: 30%; margin-left:15%; padding-left:30px; padding-right:10px; float:left; height:auto; margin:10px">
<table style="border:none;">
		<tr>
         	<td style="border: none"><img class="center" src="<%= request.getAttribute("imagea").toString()%>" alt="<%= request.getAttribute("productf").toString()%>"></td>
        </tr>
</table>
</div>
<div style="width: 45%; float:left; height:auto; margin:10px">
<table>
 		 <tr>
    		<th>Website</th>
    		<th>Product Details</th>
    		<th>Price</th>
  		</tr>
         <tr>
         	<td>Flipkart</td>
            <td><a href=" <%= request.getAttribute("urlf") %> ">${productf}</a></td>
            <td>Rs.${pricef}</td>
         </tr>
         <tr>
         	<td>Amazon</td>
            <td><a href=" <%= request.getAttribute("urla") %> ">${producta}</a></td>
            <td>Rs.${pricea}</td>
         </tr>
         <tr>
         	<td>eBay</td>
            <td><a href=" <%= request.getAttribute("urle") %> ">${producte}</a></td>
            <td>Rs.${pricee}</td>
         </tr>
      </table>  
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