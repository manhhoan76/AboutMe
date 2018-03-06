<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/templates/taglib.jsp" %>
				<div class="col-md-9">
				
				<div class="col-md-12">
					<h2 style="text-align: center;"> ${objProject.name }</h2>
					<p style="font-weight: bold;">${objProject.preview_text }</p>
					<div class="fh5co-spacer fh5co-spacer-sm"></div>
					<p>
					<img src="${pageContext.request.contextPath }/files/${objProject.picture }" alt="${objProject.name }" class="img-rounded img-responsive"></p>
					<p>Ngày xuất bản: ${objProject.date_create }</p> 
					<p>${objProject.detail }</p>
				
					</div>
					<div class="col-md-12">
					<h4>Tin tức liên quan</h4>
					<c:forEach items="${listOther }" var="objOther">
						<div class="col-md-3">
							<a href="${pageContext.request.contextPath }/${slug.makeSlug(objOther.name)}/${objOther.id_project}.php"><img src="${pageContext.request.contextPath }/files/${objOther.picture}" alt="${objOther.name }" class="img-rounded img-responsive"/></a>
							<p style="font-weight: bold;" >${objOther.name }</p>
						</div>
					</c:forEach>
					</div>
					
				</div>
