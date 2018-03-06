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
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/ads/index">Tin tức</a></li>
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/ads/edit">edit</a></li>
					</ol>
				</div>
			</div>
			 <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                             edit ads
                          </header>
                          <div class="panel-body">
                              <form class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/admin/ads/edit/${objAds.id_ads}">
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Name</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objAds.name }" name="name">
                                           <form:errors path="objAds.name" cssStyle="color :red;"></form:errors>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Link</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control round-input" value="${objAds.link }" name="link">
                                           <form:errors path="objAds.link" cssStyle="color :red;"></form:errors>
                                      </div>
                                  </div>
                                  
                                  <div class="form-group">
                                      <label class="control-label col-lg-2" for="inputSuccess">Hiển thị</label>
                                      <div class="col-lg-10">
                                          <select id="active"  class="form-control round-input" name="active" >
                                          <c:if test="${objAds.active == 1 }">
                                          <option value="1" >Yes</option>
                                          	<option value="0" >No</option>
                                          </c:if>
                                          <c:if test="${objAds.active == 0 }">
                                          	<option value="0" >No</option>
                                               <option value="1" >Yes</option>
                                          </c:if>
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
                              <!--  <script type="text/javascript">
								$(document).ready(function() {
									$('.form-horizontal').validate({
										rules : {
											tentin : {
												required : true,
											},
											mota : {
												required : true,
											},
											chitiet : {
												required : true,
											},
											
										},
										messages : {
											tentin : {
												required : "Bạn chưa nhập tên tin",
											},
											mota : {
												required : "Bạn chưa nhập mô tả",
											},
											chitiet : {
												required : "Bạn chưa nhập chi tiết",
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
								</style> -->
                          </div>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
