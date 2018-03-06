<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/templates/taglib.jsp" %>
				<div class="col-md-9">
				
				<div class="col-md-12">
					<h2 style="text-align: center;"> ${objNew.name }</h2>
					<p style="font-weight: bold;">${objNew.preview_text }</p>
					<div class="fh5co-spacer fh5co-spacer-sm"></div>
					<p>
					<img src="${pageContext.request.contextPath }/files/${objNew.picture }" alt="Free HTML5 template by FREEHTML5.co" class="img-rounded img-responsive"></p>
					<p>Ngày xuất bản: ${objNew.date_create }  /Danh muc: ${objNew.cname }</p> 
					<p>${objNew.detail_text }</p>
				
					</div>
					<div class="col-md-12">
					<h4>Tin tức liên quan</h4>
					<c:forEach items="${listSameCid }" var="objSameCid">
						<div class="col-md-3">
							<a href="${pageContext.request.contextPath }/${slug.makeSlug(objSameCid.name)}/${objSameCid.id_news}.html"><img src="${pageContext.request.contextPath }/files/${objSameCid.picture}" alt="${objSameCid.name }" class="img-rounded img-responsive"/></a>
							<p style="font-weight: bold;" >${objSameCid.name }</p>
						</div>
					</c:forEach>
					</div>
					<div class="col-md-12">
					<h2>Comment</h2>
					<c:forEach items="${listComment }" var="objComment"> 
						<div class="col-md-12" >
							<div>
							<img style="float: left; width: 14%; margin-right: 20px;  padding-top: 13px;" alt="" src="${pageContext.request.contextPath }/templates/public/other/images/img_29_large.jpg"/>
							</div>
							<div class="media-body">
						      <h4 class="media-heading" style="padding-top: 12px;">${objComment.name }</h4>
						      <p> ${objComment.content }</p>
					  		 </div>
						</div>
					</c:forEach>
					<div class="col-md-12" style="border-top: 1px solid;  padding:0px; padding-top: 27px; border-color: #ccc;">
					
					<form  action="${pageContext.request.contextPath }/comment" method="post">
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" class="form-control" name="name" placeholder="Full Name">	
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<input type="email" class="form-control" name="email" placeholder="Email Address">
								</div>
								<div class="form-group">
									<textarea name="content" id="message" cols="30" class="form-control"  rows="10"></textarea>
								</div>
								<div class="form-group">
									<input type="submit" class="btn btn-primary" value="Send">
								</div>
						</div>
					</form>
					</div>
				</div>
					
				</div>
