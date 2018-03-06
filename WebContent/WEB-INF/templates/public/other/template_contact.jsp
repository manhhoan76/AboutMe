<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
<!-- header -->
<tiles:insertAttribute name="header"></tiles:insertAttribute>
<!-- /.header -->
<div id="fh5co-main">
		<div class="container">
			<div class="row">
			<!-- Body -->				
				<tiles:insertAttribute name="body"></tiles:insertAttribute>
			<!-- ./Body -->
        	</div>
       </div>
	</div>
<!-- Footer -->
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
<!-- /.footer -->