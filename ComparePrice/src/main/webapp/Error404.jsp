<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<style> 
.isa_info, .isa_success, .isa_warning, .isa_error {
margin: 10px 0px;
padding:12px;
}
.isa_error {
    color: #D8000C;
    background-color: #FFD2D2;
}
</style>
<body>

<div class="isa_error">
<!-- <i class="fa fa-times-circle"></i> -->
<h1>Cannot find server</h1>
<h2><%= request.getAttribute("error") %></h2>
</div>

</body>
</html>