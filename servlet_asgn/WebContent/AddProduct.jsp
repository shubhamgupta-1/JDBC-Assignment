<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Form</title>
</head>
<style>
.container {
	max-width: 1350px;
	width: 100%;
	margin: 50px;
	height: auto;
	display: block;
}

body {
	color: #8A2BE2;
	font-size: 20px;
	font-family: Verdana, Arial, Helvetica, monospace;
	background-color: #F0E8A0;
}

h2 {
	text-align: center;
}

.form_group {
	padding: 10px;;
	display: block;
}

label {
	float: left;
	padding-right: 50px;
	line-height: 10%;
	display: block;
	width: 208px;
}
</style>
<body>
	<h2>Sign Up</h2>
	<form name="form1" action="addProduct" method="post"
		enctype="multipart/form-data">
		<div class="container">
			<div class="form_group">
				<label>Product Name:</label> <input type="text" name="pName"
					value="" required />
			</div>
			<div class="form_group">
				<label>Price:</label> <input type="text" name="pPrice" value=""
					required />
			</div>
			<div class="form_group">
				<label>Quantity:</label> <input type="number" name="pQuantity"
					value="" required />
			</div>
			<div class="form_group">
				<label>Manufacture Date :</label> <input type="Date" name="mfdDate"
					value="" required />
			</div>
			<div class="form_group">
				<label>Inspection Date :</label> <input type="Date" name="insDate"
					value="" required />
			</div>
			<div class="form_group">
				<input type="submit" name="" value="Add Product"
					style="float: center" onclick=validate() />
			</div>
		</div>
	</form>
</body>
</html>
