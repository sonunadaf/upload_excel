<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload File</title>
<style>
.custom-file-upload {
	border: 1px solid #ccc;
	display: inline-block;
	padding: 6px 12px;
	cursor: pointer;
}
</style>
</head>
<body>
	<h1 align="center">Upload File</h1>
	<form action="onupload" method="post" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td>Enter File Location</td>
				<td><input type="file" name="xmlFile"
					class="custom-file-upload"></td>
				<td><p style="color: red;">${message}</p></td>
			</tr>
			<tr align="center">
				<td><input type="submit" value="upload"></td>
			</tr>
		</table>
	</form>
</body>
</html>