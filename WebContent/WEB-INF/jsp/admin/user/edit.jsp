<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/templates/taglib.jsp" %>
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
		  <div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa-table"></i> Tin tức</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/user/index">Tin tức</a></li>
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/user/edit">edit</a></li>
					</ol>
				</div>
			</div>
			<c:choose>
				<c:when test="${msg == 0}">
					<div class="panel-body"><div class="alert alert-danger fade in"><button data-dismiss="alert" class="close close-sm" type="button"><i class="icon-remove"></i></button><strong>Warning!</strong> Username đã tồn tại!</div></div>
				</c:when>
			</c:choose>
			 <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                             edit users
                          </header>
                          <div class="panel-body">
                              <form class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/admin/user/edit/${objUser.id_user}">
                               
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Username</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objUser.username }" name="username">
                                           <form:errors path="objUser.username" cssStyle="color :red;"></form:errors>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Password</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" name="password">
                                           <form:errors path="objUser.password" cssStyle="color :red;"></form:errors>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Fullname</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objUser.fullname }" name="fullname">
                                           <form:errors path="objUser.fullname" cssStyle="color :red;"></form:errors>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Email</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objUser.email }" name="email">
                                           <form:errors path="objUser.email" cssStyle="color :red;"></form:errors>
                                      </div>
                                  </div>
								   <div class="form-group">
                                      <label class="control-label col-lg-2" for="inputSuccess">Chức vụ</label>
                                      <div class="col-lg-10">
                                          <select id="role_id"  class="form-control round-input" name="role_id" >
                                         <c:forEach items="${listRole }" var="objRole">
                                         <c:if test="${objRole.role_id != 1 }">
                                         <c:choose>
										    	<c:when test="${objUser.role_id == objRole.role_id }">
                                           			 <option selected ="selected" value="${objRole.role_id }" >${objRole.name }</option>
										    	</c:when>
										    	<c:otherwise>
										    		<option   value="${objRole.role_id }" >${objRole.name }</option>
										    	</c:otherwise>
										    </c:choose>
                                         </c:if>
										</c:forEach>	
                                          </select>
                                      </div>
                                  </div>
                                 <div class="form-group">
                                      <label for="exampleInputFile" style="margin-left: 205px;">Hình ảnh</label>
                                      <input type="file" id="exampleInputFile" style="margin-left: 205px;" name="picture">
                                  </div>
                                  <div class="form-group">
	                                  <div style="margin-left: 182px;" class="col-lg-10" >
										<input type="submit" class="btn btn-success btn-sm"  title="Bootstrap 3 themes generator" value="Thêm">
									</div>
								</div>
                              </form>
                               <script type="text/javascript">
								$(document).ready(function() {
									$('.form-horizontal').validate({
										rules : {
											username : {
												required : true,
											},
											password : {
												required : true,
											},
											fullname : {
												required : true,
											},
											email : {
												required : true,
											},
											
										},
										messages : {
											username : {
												required : "Bạn chưa nhập thông tin",
											},
											password : {
												required : "Bạn chưa nhập thông tin",
											},
											fullname : {
												required : "Bạn chưa nhập thông tin",
											},
											email : {
												required : "Bạn chưa nhập thông tin",
											},
											
										},
									});
								});
							
							</script>
								<style>
								.error {
									color: red;
									font-weight: bold;
								}
								</style>
                          </div>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
