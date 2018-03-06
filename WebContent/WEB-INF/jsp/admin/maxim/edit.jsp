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
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/maxim/index">Tin tức</a></li>
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/maxim/edit">edit</a></li>
					</ol>
				</div>
			</div>
			 <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                             edit maxim
                          </header>
                          <div class="panel-body">
                              <form class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/admin/maxim/edit/${objMaxim.id_maxim}">
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Name</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objMaxim.author}" name="author">
                                           <form:errors path="objMaxim.author" cssStyle="color :red;"></form:errors>
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Nội dung</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objMaxim.content }" name="content">
                                           <form:errors path="objMaxim.content" cssStyle="color :red;"></form:errors>
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
											author : {
												required : true,
											},
											content : {
												required : true,
											},
											
										},
										messages : {
											author : {
												required : "Bạn chưa nhập ",
											},
											content : {
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
