<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/templates/taglib.jsp" %>
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
		  <div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa-user-md"></i> Profile</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="${pageContext.request.contextPath }/admin/index">Home</a></li>
						<li><i class="fa fa-user-md"></i><a href="${pageContext.request.contextPath }/admin/user">User</a></li>
					</ol>
				</div>
			</div>
			<div style="margin-left: 16px; margin-top: -14px; margin-bottom: 5px;">
					<a class="btn btn-success btn-sm" href="${pageContext.request.contextPath }/admin/user/add" title="Bootstrap 3 themes generator">Thêm</a>
					<form class="navbar-form" style="display: inline-block;" action="${pageContext.request.contextPath }/admin/user/search" method="get">
                            <input class="form-control" placeholder="Search" type="text" name="key">
                      </form>
			</div>
						<c:choose>
				<c:when test="${msg == 1 }">
					<div class="panel-body"><div class="alert alert-success fade in"><button data-dismiss="alert" class="close close-sm" type="button"><i class="icon-remove"></i></button><strong>Well done!</strong> Bạn đã Thêm thành công</div></div>
				</c:when>
				<c:when test="${msg == 2 }">
					<div class="panel-body"><div class="alert alert-success fade in"><button data-dismiss="alert" class="close close-sm" type="button"><i class="icon-remove"></i></button><strong>Well done!</strong> Bạn đã Sửa thành công</div></div>
				</c:when>
				<c:when test="${msg == 3 }">
					<div class="panel-body"><div class="alert alert-success fade in"><button data-dismiss="alert" class="close close-sm" type="button"><i class="icon-remove"></i></button><strong>Well done!</strong> Bạn đã Xóa thành công</div></div>
				</c:when>
				<c:when test="${msg == 4 }">
					<div class="panel-body"><div class="alert alert-danger fade in"><button data-dismiss="alert" class="close close-sm" type="button"><i class="icon-remove"></i></button><strong>Oh No!</strong> ID không tồn tại</div></div>
				</c:when>
				<c:when test="${msg == 5 }">
					<div class="panel-body"><div class="alert alert-success fade in"><button data-dismiss="alert" class="close close-sm" type="button"><i class="icon-remove"></i></button><strong>Well done!</strong> Bạn đã Active thành công</div></div>
				</c:when>
				<c:when test="${msg == 6 }">
					<div class="panel-body"><div class="alert alert-success fade in"><button data-dismiss="alert" class="close close-sm" type="button"><i class="icon-remove"></i></button><strong>Well done!</strong> Bạn đã Block thành công</div></div>
				</c:when>
				<c:when test="${msg == 7}">
					<div class="panel-body"><div class="alert alert-danger fade in"><button data-dismiss="alert" class="close close-sm" type="button"><i class="icon-remove"></i></button><strong>Warning!</strong> Đã xảy ra lỗi!</div></div>
				</c:when>
			</c:choose>
			
		<c:forEach items="${listUser }" var="objUser">
		<div>
              <div class="row">
                <!-- profile-widget -->
                <div class="col-lg-12">
                    <div class="profile-widget profile-widget-info">
                          <div class="panel-body">
                            <div class="col-lg-2 col-sm-2">
                              <h4>${objUser.fullname }</h4>               
                              <div class="follow-ava">
                                  <img src="${pageContext.request.contextPath }/files/${objUser.picture }" alt="${objUser.username }">
                              </div>
                              <h6>${objUser.username }</h6>
                            </div>
                            <div class="col-lg-4 col-sm-4 follow-info">
                                <p>@${objUser.username }</p>
                                <h6>
                                 <span><i class="icon_pin_alt"></i>${objUser.email }</span>
                                </h6>
                                
                            </div>
                            <div class="col-lg-3 col-sm-6 follow-info weather-category">
                                      <ul>
                                          <li class="active">
                                              <i class="fa fa-comments fa-2x"> </i><br>
                                              <%-- <%
                                              	NewsDAO newsDAO = new NewsDAO();
                                              	int numberNew = (Integer) newsDAO.countNewsByUserId(objUser.getId());
                                              %>
                                              Số tin đã đăng: <%=numberNew %> --%>
                                          </li>
                                      </ul>
                            </div>
							<div class="col-lg-3 col-sm-6 follow-info weather-category">
                                      <ul>
                                          <li class="active">
                                              <i class="fa fa-bell fa-2x"> </i><br>
											  Trạng thái:  
											  <c:choose>
											  	<c:when test="${objUser.enable == 1 }">
											  	Active
											  	</c:when>
											  	<c:otherwise>
											  		 Block
											  	</c:otherwise>
											  </c:choose>
                                          </li>
                                      </ul>
                            </div>
                          </div>
                    </div>
                </div>
              </div>
              <!-- page start-->
              <div class="row">
                 <div class="col-lg-12">
                    <section class="panel">
                          <header class="panel-heading tab-bg-info">
                              <ul class="nav nav-tabs">
                            <%--  <%
                             	if ("admin".equals(objuserInfor.getUsername())){ 
                             %> --%>
                                  <li class="">
                                      <a href="${pageContext.request.contextPath }/admin/user/edit/${objUser.id_user}">
                                          <i class="icon-envelope"></i>
                                          Edit Profile
                                      </a>
                                  </li>
								  <li class="">
                                      <a href="${pageContext.request.contextPath }/admin/user/del/${objUser.id_user}" onclick="return confirm('Bạn có muốn xóa không')">
                                          <i class="icon-envelope"></i>
                                          Delete
                                      </a>
                                  </li>
                                   <li class="" id="active-${objUser.id_user}">
                                      <a   onclick="active(${objUser.id_user},${objUser.enable})" href="javascript:void(0)" >
                                          <i class="icon-envelope"></i>
                                          <c:choose>
											  	<c:when test="${objUser.enable == 0 }">
											  	Active
											  	</c:when>
											  	<c:otherwise>
											  		 Block
											  	</c:otherwise>
											  </c:choose>
                                      </a>
                                  </li>
                                   <li class="">
                                      <a href="${pageContext.request.contextPath }/admin/user/mess/${objUser.id_user}/${objUser.id_user}" >
                                          <i class="icon-envelope"></i>
                                          Message
                                      </a>
                                  </li>
                              </ul>
                          </header>
                      </section>
                 </div>
              </div>
			</div>
		</c:forEach>
		<script>
				function  active(id, active) {
					$.ajax({
						url: '${pageContext.request.contextPath }/admin/user/active',
						type: 'POST',
						cache: false,
						data: {
								//Dữ liệu gửi đi
								uid : id,
								uactive : active,
								},
						success: function(data){
							// Xử lý thành công
							$('#active-'+id).html(data);
						},
						error: function (){
						// Xử lý nếu có lỗi
						alert('Loi');
						}
					});
				}
						
				
				
			</script>
		
              <!-- page end-->
          </section>
           <div class="pagination" style="margin-left: 23px;   margin-top: -15px;">           
			<div class="numbers">
			<c:set value="${pageContext.request.contextPath }/admin/user/index/${page-1 }"  var="urlPre"></c:set>
                <c:set value="${pageContext.request.contextPath }/admin/user/index/${page+1 }" var="urlNext"></c:set>
                   <c:if test="${(page-1) > 0 }">
                    <a href="${urlPre }"><<</a>
                    </c:if>
                    <c:choose>
                    	<c:when test="${sumPage < 4 }">
                    		<c:forEach begin="1"  end="${sumPage }" var="i">
                      	 		<a <c:if test="${i == page }">class=active</c:if> href="${pageContext.request.contextPath }/admin/user/index/${i }">${i } <span class="sr-only"></span></a>
                      		</c:forEach>
                    	</c:when>
                    	<c:when test="${page<(sumPage-3) && sumPage>3 }">
                    		<c:forEach begin="${page }"  end="${page+3 }" var="i">
                      			 <a <c:if test="${i == page }">class=active</c:if> href="${pageContext.request.contextPath }/admin/user/index/${i }">${i } <span class="sr-only"></span></a>
                     		 </c:forEach>
                    	</c:when>
                    	<c:when test="${page>=(sumPage-3) && sumPage>3 }">
                    		<c:forEach begin="${sumPage-3 }"  end="${sumPage }" var="i">
                      			 <a <c:if test="${i == page }">class=active</c:if> href="${pageContext.request.contextPath }/admin/user/index/${i }">${i } <span class="sr-only"></span></a>
                     		 </c:forEach>
                    	</c:when>
                    </c:choose>
                      <c:if test="${page+1 <= sumPage }">
                       <a href="${urlNext }"> >> </a>
                    </c:if>
			</div> 
			<div style="clear: both;"></div> 
		 </div> 
      </section>
      <!--main content end-->
