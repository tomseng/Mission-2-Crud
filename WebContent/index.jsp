<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cr�er un webservice</title>
</head>
<body>
<form method="post" action="traitement.php">
   <p>
       <label for="name">Cr�er webservice :</label>
       <input type="text" name="name" id="name" />
   </p>
   <p>
   		<label for="IP">IP:</label>
   		<input type="text" name="ip" id="ip" />
   	</p>
   	<p>
   		<label for="Champs">Champs:</label>
   		<input type="textarea" name="champs" id="champs" />
   	</p>

       
   </p>
</form>
</body>
</html>