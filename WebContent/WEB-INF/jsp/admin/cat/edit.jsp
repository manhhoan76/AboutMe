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
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/cat/index">Tin tức</a></li>
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/cat/edit">edit</a></li>
					</ol>
				</div>
			</div>
			 <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                             edit cat
                          </header>
                          <div class="panel-body">
                              <form class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/admin/cat/edit/${objCat.id_cat}">
                               
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Tên Danh Mục</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objCat.name }" name="name">
                                           <form:errors path="objCat.name" cssStyle="color :red;"></form:errors>
                                      </div>
                                  </div>
                                  <div class="form-group">
	                                  <div style="margin-left: 182px;" class="col-lg-10" >
										<input type="submit" class="btn btn-success btn-sm"  title="Bootstrap 3 themes generator" value="Sửa">
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
											
											
										},
										messages : {
											name : {
												required : "Bạn chưa nhập tên",
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
