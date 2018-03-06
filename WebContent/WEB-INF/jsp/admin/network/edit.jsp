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
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/network/index">Tin tức</a></li>
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/network/edit">edit</a></li>
					</ol>
				</div>
			</div>
			 <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                             edit network
                          </header>
                          <div class="panel-body">
                              <form class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/admin/network/edit/${objNetwork.id_network}">
                               
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Name</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objNetwork.name }" name="name">
                                           <form:errors path="objNetwork.name" cssStyle="color :red;"></form:errors>
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Link</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objNetwork.link }" name="link">
                                           <form:errors path="objNetwork.link" cssStyle="color :red;"></form:errors>
                                      </div>
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
											name : {
												required : true,
											},
											link : {
												required : true,
											},
											
										},
										messages : {
											name : {
												required : "Bạn chưa nhập ",
											},
											link : {
												required : "Bạn chưa nhập ",
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
