 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file="/templates/taglib.jsp" %>
 <div id="fh5co-board" data-columns class="col-md-9">
 		<c:forEach items="${listNewsByIdCat }" var="objNewByCid">
 			<div class="item">
        		<div class="animate-box">
	        		<a href="${pageContext.request.contextPath }/${slug.makeSlug(objNewByCid.name)}/${objNewByCid.id_news}.html"  title=""><img src="${pageContext.request.contextPath }/files/${objNewByCid.picture}" alt="${objNewByCid.name }"></a>
        		</div>
        		<div class="fh5co-desc">${objNewByCid.name }</div>
        	</div>
 		</c:forEach>
        	
			
        </div>