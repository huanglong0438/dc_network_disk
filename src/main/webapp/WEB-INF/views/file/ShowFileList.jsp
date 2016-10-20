<%@page import="com.dcnetworkdisk.file.model.DcFile"%>
<%@page import="java.io.File"%>
<%@page import="com.dcnetworkdisk.common.utils.URLEncoderUtil"%>
<%@page import="java.net.URLEncoder"%>
<%@include file="../header.jsp" %>
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Pictures</a></li>
            <li><a href="#">Documents</a></li>
            <li><a href="#">Videos</a></li>
            <li><a href="#">Torrents</a></li>
            <li><a href="#">Musics</a></li>
            <li><a href="#">Others</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">My Shares</a></li>
            <li><a href="">Recycle bin</a></li>
          </ul>
          <div class="progress">
	        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"><span class="sr-only">60% Complete</span></div>
	      </div>
	      <div>
	      	<div class= text-left>1.2G/2G <a href="" class="text-right">enlarge</a></div>
	      </div>
        </div>
	        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">File List</h1>
				<div class="module-toolbar g-clearfix">
					<div class="list-grid-switch list-switched-on">
						<a class="list-switch" node-type="list-switch" style="display: none;" href="javascript:void(0);"></a>
						<a class="grid-switch" node-type="grid-switch" href="javascript:void(0)"></a>
					</div>
					<div class="sort-switch"></div>
					<div class="bar-search"></div>
					<div class="bar" style="white-space: nowrap; position: relative;">
						<div class="tools" style="position: absolute; top: 0px; padding-top: 11px; line-height: normal;">
							<a href="javascript:void(0)">Upload</a>
							<a href="javascript:void(0);" onclick="create_folder()">Create folder</a>
							<a href="javascript:void(0);">Offline Download</a>
							<a href="javascript:void(0);">My Device</a>
						</div>
					</div>
				</div>
				<c:set var="token" value="${token}"/>
				<c:set var="sucess" value="${success}"></c:set>
				<c:if test="${sucess == true}">
					<dd class="list-view-item">
						<div class="div-item" style="width:60%"><a href="javascript:void(0);">File Name</a></div>
						<div class="div-item" style="width:16%"><a href="javascript:void(0);">File Size</a></div>
						<div class="div-item" style="width:12%"><a href="javascript:void(0);">Create Time</a></div>
						<div class="div-item" style="width:12%"><a href="javascript:void(0);">Modified Time</a></div>
					</dd>
					<c:forEach items="${filelist}" var="file">
						<c:set var="path" value="${file.filepath}"></c:set>
						<%
							String path = (String)pageContext.getAttribute("path");
							path = URLEncoderUtil.encode(path, "utf-8");
							pageContext.setAttribute("path", path);
							
							String filename = ((DcFile)pageContext.getAttribute("file")).getFilename();
							System.out.println(filename);
							pageContext.setAttribute("filename", filename);
						%>
						<dd class="list-view-item">
							<div class="fileicon" style="width:3%"></div>
							<div class="div-item" style="width:57%"><a href='<c:url value="/file/download/${token}/${path}/${filename}"/>'>${file.filename}</a></div>
							<div class="div-item" style="width:16%">${file.filesize} Bytes</div>
							<div class="div-item" style="width:12%">${file.create_date}</div>
							<div class="div-item" style="width:12%">${file.modified_date}</div>
						</dd>
					</c:forEach>
				</c:if>
				<c:if test="${sucess == false}">
					<c:out value="${errorMsg}"></c:out>
				</c:if>
			</div>
       </div>
      </div>
	
</body>
</html>