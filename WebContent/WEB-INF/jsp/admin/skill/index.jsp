<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/templates/taglib.jsp" %>
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
		  <div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa-table"></i>Danh Ngôn</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/skill/index">Tin tức</a></li>
						<!-- <li><i class="fa fa-th-list"></i>Basic Table</li> -->
					</ol>
				</div>
				<div style="margin-left: 16px; margin-top: -14px; margin-bottom: 5px; display: inline;">
					
                      <form class="navbar-form" style="display: inline-flex;" action="${pageContext.request.contextPath }/admin/skill/search">
                           <div>
                            <input class="form-control" placeholder="Search" type="text" name="key">
                      </div>
                        </form>
                       <a class="btn btn-success btn-sm"  href="${pageContext.request.contextPath }/admin/skill/add" title="Bootstrap 3 themes generator" >Thêm</a>
				</div>
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
              <!-- page start-->                        
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <table class="table table-striped table-advance table-hover">
                           <tbody>
                              <tr>
								<th><i class=""></i> ID</th>
                                 <th><i class="icon_profile"></i> Skill</th>
                                 <th><i class="icon_mail_alt" ></i> Percent</th>
                                 <th><i class="icon_calendar"></i> Ngày tạo</th>
                                 <th><i class="icon_cogs"></i> Action</th>
                              </tr>
                              <c:forEach items="${listSkill }" var="objskill">
                              <tr>
								 <td>${objskill.id_skill }</td>
                                 <td>${objskill.name }</td>
                                  <td>${objskill.percent }</td>
                                 <td>${objskill.date_create }</td>
                                 <td>
                                  <div class="btn-group">
                                  <ul class="nav nav-tabs">
                                  	<li><a class="btn btn-primary" href="${pageContext.request.contextPath }/admin/skill/edit/${objskill.id_skill }"><i class="icon_pencil-edit_alt"></i></a></li>
                                	<%-- <li id="active-${objskill.id_skill }">
                                	<c:choose>
                                		<c:when test="${objskill.active == 1 }">
                                			<a onclick="active(${objskill.id_skill }, ${objskill.active})" class="btn btn-success" href="javascript:void(0)" ><i class="icon_check_alt2"></i></a>
                                		</c:when>
                                		<c:otherwise>
                                			<a onclick="active(${objskill.id_skill }, ${objskill.active})" class="btn btn-warning" href="javascript:void(0)" ><i class="icon_upload"></i></a>
                                		</c:otherwise>
                                	</c:choose>
                                	</li> --%>
                                	<li><a class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không')" href="${pageContext.request.contextPath }/admin/skill/del/${objskill.id_skill}"><i class="icon_close_alt2"></i></a></li>
                                 
                                  </ul>
                                  </div>
                                  </td>
                              </tr>
                              </c:forEach>
                                <script>
								function  active(id, active) {
									$.ajax({
										url: '${pageContext.request.contextPath }/admin/skill/active',
										type: 'POST',
										cache: false,
										data: {
												//Dữ liệu gửi đi
												nid : id,
												nactive : active,
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
                           </tbody>
                        </table>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      <div class="pagination" style="margin-left: 23px;   margin-top: -31px;">           
			<div align="center" class="numbers">
			 <c:set value="${pageContext.request.contextPath }/admin/skill/index/${page-1 }"  var="urlPre"></c:set>
                <c:set value="${pageContext.request.contextPath }/admin/skill/index/${page+1 }" var="urlNext"></c:set>
                   <c:if test="${(page-1) > 0 }">
                    <a href="${urlPre }"><<</a>
                    </c:if>
                    <c:choose>
                    	<c:when test="${sumPage < 4 }">
                    		<c:forEach begin="1"  end="${sumPage }" var="i">
                      	 		<a <c:if test="${i == page }">class=active</c:if> href="${pageContext.request.contextPath }/admin/skill/index/${i }">${i } <span class="sr-only"></span></a>
                      		</c:forEach>
                    	</c:when>
                    	<c:when test="${page<(sumPage-3) && sumPage>3 }">
                    		<c:forEach begin="${page }"  end="${page+3 }" var="i">
                      			 <a <c:if test="${i == page }">class=active</c:if> href="${pageContext.request.contextPath }/admin/skill/index/${i }">${i } <span class="sr-only"></span></a>
                     		 </c:forEach>
                    	</c:when>
                    	<c:when test="${page>=(sumPage-3) && sumPage>3 }">
                    		<c:forEach begin="${sumPage-3 }"  end="${sumPage }" var="i">
                      			 <a <c:if test="${i == page }">class=active</c:if> href="${pageContext.request.contextPath }/admin/skill/index/${i }">${i } <span class="sr-only"></span></a>
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
     
