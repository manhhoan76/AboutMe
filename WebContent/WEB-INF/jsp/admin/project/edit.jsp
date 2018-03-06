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
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/project/index">Tin tức</a></li>
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/project/edit">edit</a></li>
					</ol>
				</div>
			</div>
			 <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                             edit projects
                          </header>
                          <div class="panel-body">
                              <form class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/admin/project/edit/${objProject.id_project}">
                               
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Name</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objProject.name }" name="name">
                                           <form:errors path="objProject.name" cssStyle="color :red;"></form:errors>
                                      </div>
                                  </div>
                                    <div class="form-group">
                                  <header class="panel-heading">
                                     Preview
                                  </header>
                                  <div class="panel-body">
                                      <div class="form">
                                              <div class="form-group">
                                                  <label class="control-label col-sm-2">Preview</label>
                                                  <div class="col-sm-10">
                                                      <textarea class="form-control ckeditor" id="editor1" rows="6" name="preview_text">${objProject.preview_text}</textarea>
                                                  		<form:errors path="objProject.preview_text" cssStyle="color :red;"></form:errors>
                                                  </div>
                                              </div>
                                      </div>
                                  </div>
                                  
								</div>
								<div class="form-group">
                                  <header class="panel-heading">
                                     Detail
                                  </header>
                                  <div class="panel-body">
                                      <div class="form">
                                              <div class="form-group">
                                                  <label class="control-label col-sm-2">Detail</label>
                                                  <div class="col-sm-10">
                                                      <textarea name="detail" class="form-control ckeditor" id="editor2" rows="6">${objProject.detail}</textarea>
                                                 		 <form:errors path="objProject.detail" cssStyle="color :red;"></form:errors>
                                                  </div>
                                              </div>
                                      </div>
                                  </div>
                                 
								</div>
								<div class="form-group">
                                      <label class="col-sm-2 control-label">Link</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objProject.link }" name="link">
                                           <form:errors path="objProject.link" cssStyle="color :red;"></form:errors>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Thời gian</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objProject.time }" name="time">
                                           <form:errors path="objProject.time" cssStyle="color :red;"></form:errors>
                                      </div>
                                  </div>
								<script type="text/javascript">
									var editor1 = CKEDITOR.replace('editor1');
									CKFinder.setupCKEditor(editor1,'${pageContext.request.contextPath }/templates/ckfinder/');
									var editor2 = CKEDITOR.replace('editor2');
									CKFinder.setupCKEditor(editor2,'${pageContext.request.contextPath }/templates/ckfinder/');
								</script>
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
											name : {
												required : true,
											},
											preview_text : {
												required : true,
											},
											detail : {
												required : true,
											},
											link : {
												required : true,
											},
											time : {
												required : true,
											},
											
										},
										messages : {
											name : {
												required : "Bạn chưa nhập tên tin",
											},
											preview_text : {
												required : "Bạn chưa nhập mô tả",
											},
											detail : {
												required : "Bạn chưa nhập chi tiết",
											},
											link : {
												required : "Bạn chưa nhập link",
											},
											time : {
												required : "Bạn chưa nhập thời gian",
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
