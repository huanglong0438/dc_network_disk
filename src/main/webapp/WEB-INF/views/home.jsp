<%@include file="header.jsp" %>
	<c:set var="token" value="${token}"></c:set>
	<div class="content-section-a">
	<div class="container">
		<div class="row">
			<div class="col-lg-5 col-sm-6">
			<h2>Welcome!!!<br></h2>
			welcome to Dc network disk home page.
			<div>you can test:</div>
			<ul>
			<li>
				<a href="<c:url value="/u/login"/> ">login</a>
			</li>
			<li>
				<a href="<c:url value="/file/sfl_web/${token}/%252f"/>">show filelist</a>
			</li>
			<li>
				<a href="<c:url value="/file/upload"/>">upload file to the Server</a>
			</li>
			<li>
				<a href="<c:url value="/file/download/${token}/%252f/西安兼职.txt"/>">download file from the Server</a>
			</li>
			</ul>
			</div>
			<div class="col-lg-5 col-lg-offset-2 col-sm-6">
               <img class="img-responsive" src='<c:url value="/img/ipad.png"/>' alt=""/>
            </div>
		</div>
	</div>
	</div>
</body>
</html>