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
               <img class="img-responsive" src='<c:url value="/img/road.jpg"/>' alt=""/>
            </div>
		</div>
		      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">You can backup and restore your files</h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" src='<c:url value="/img/photo.jpg"/>' alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">And lastly, you can browse photos and movies immediately at this site. <span class="text-muted">Exciting.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src='<c:url value="/img/ipad.png"/>' alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">
	</div>
	</div>
</body>
</html>