<%@include file="../header.jsp" %>
	<c:set var="success" value="${success}"/>
	<div class="col-lg-5 col-sm-6">
	<c:if test="${success == true}">
		<c:set var="user" value="${user}"></c:set>
		<div>
			<div class="row">
				<img alt="" src='<c:url value="/img/avatar.jpg"/>' class="img-responsive">
			</div>
			<div class="row">
				<p>user name:${user.username}</p>
				<p>what's up:${user.whatsup}</p>
			</div>
		</div>
	</c:if>
	<c:if test="${success == false}">
		<c:set var="errorMsg" value="${errorMsg}"/>
		<p>${errorMsg}</p>	
	</c:if>
	</div>
</body>
</html>