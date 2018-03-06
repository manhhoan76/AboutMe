<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file="/templates/taglib.jsp" %>
<div class="col-md-3">
					<div>
						<h2 style="text-align: center; ">Tin Mới Nhất</h2>
						<div style="border-top: 1px solid;">
						<c:forEach items="${listNewNew }" var="objNewMoi">
							<div>
								<div class="col-md-8">
									<div class="fh5co-spacer fh5co-spacer-sm"></div>
									<a href="${pageContext.request.contextPath }/${slug.makeSlug(objNewMoi.name)}/${objNewMoi.id_news}.html"><img src="${pageContext.request.contextPath }/files/${objNewMoi.picture }" alt="${objNewMoi.name }" class="img-rounded img-responsive"></a>
								</div>
								<div class="col-md-4">
									<p style="font-size: 12px; width: 123px;  margin-top: 56px; margin-left: -24px; font-weight: bold;">${objNewMoi.name }</p>
								</div>
							</div>
						</c:forEach>
						</div>	
					</div>
					<div>
							<div style="padding-top: 17px;" class="fh5co-spacer fh5co-spacer-sm">
								<h2 style="text-align: center; border-top: 1px solid; text-align: center; padding-top: 18px;">Tin Phổ Biến Nhất</h2>
							</div>
							<c:forEach items="${listMostView }" var="objNewMostView">
								<div>
								<div class="col-md-8">
									<div class="fh5co-spacer fh5co-spacer-sm"></div>
									<a href="${pageContext.request.contextPath }/${slug.makeSlug(objNewMostView.name)}/${objNewMostView.id_news}.html"><img src="${pageContext.request.contextPath }/files/${objNewMostView.picture }" alt="${objNewMostView.name }" class="img-rounded img-responsive"></a>
								</div>
								<div class="col-md-4">
									<p style="font-size: 12px; width: 123px;  margin-top: 56px; margin-left: -24px; font-weight: bold;">${objNewMostView.name }</p>
								</div>
							</div>
							</c:forEach>
							
						</div>
						<%-- <div>
							<div style="padding-top: 17px;" class="fh5co-spacer fh5co-spacer-sm">
								<h2 style="text-align: center; border-top: 1px solid; text-align: center; padding-top: 18px;">Video</h2>
							</div>
							<p style="padding-top: 36px;"><img src="${pageContext.request.contextPath }/templates/public/other/images/img_29_large.jpg" alt="Free HTML5 template by FREEHTML5.co" class="img-rounded img-responsive"></p>
							<p  style="font-size: 13px;">Far far away, behind the word mountains, far from the </p>
							<p  style="font-size: 13px;">Far far away, behind the word mountains, far from the </p>
							<p  style="font-size: 13px;">Far far away, behind the word mountains, far from the </p>
						</div> --%>
						<div>
							<div style="padding-top: 17px;" class="fh5co-spacer fh5co-spacer-sm">
								<h2 style="text-align: center; border-top: 1px solid; text-align: center; padding-top: 18px;">Danh Mục</h2>
							</div>
							<div style="padding-top: 30px;" >
							<c:forEach items="${listCat }"  var="objCat">
								<p  style="font-size: 13px; "><a href="${pageContext.request.contextPath }/${slug.makeSlug(objCat.name)}/${objCat.id_cat}">${objCat.name }</a></p>
							</c:forEach>
							</div>
						</div>
					</div>
				