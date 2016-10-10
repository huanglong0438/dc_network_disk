<%@include file="../header.jsp" %>
<c:set var="token" value="${token}"/>
<center>
	<div>
		<b>Select the file you'd like to upload.</b>
	</div>
	<div id = "upload_form">
		<c:url var="actionUrl" value="/file/upload/${token}/%252F"/>
		<form action="${actionUrl}" method="post" enctype="multipart/form-data">
			<p><label for="file">File</label></p>
			<p><input id="file" type="file" name="file"></p>
			<p><button type="submit">upload</button></p>
		</form>
	</div>	
</center>
</body>
</html>