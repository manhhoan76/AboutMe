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
						<li><i class="fa fa-table"></i><a href="${pageContext.request.contextPath }/admin/job/index">Tin tức</a></li>
						<!-- <li><i class="fa fa-th-list"></i>Basic Table</li> -->
					</ol>
				</div>
				<div style="margin-left: 16px; margin-top: -14px; margin-bottom: 5px; display: inline;">
					
                      <form class="navbar-form" style="display: inline-flex;" action="${pageContext.request.contextPath }/admin/job/search">
                           <div>
                            <input class="form-control" placeholder="Search" type="text" name="key">
                      </div>
                        </form>
                        <a class="btn btn-success btn-sm"  href="${pageContext.request.contextPath }/admin/job/add" title="Bootstrap 3 themes generator" >Thêm</a>
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
								<th><i class=""></i>ID</th>
								<th><i class="icon_profile"></i>Tên</th>
                                 <th><i class="icon_profile"></i>Nội dung</th>
                                 <th><i class="icon_mail_alt" ></i>Thời gian</th>
                                 <th><i class="icon_image" style="width: 250px;"></i>Hình ảnh</th>
                                 <th><i class="icon_calendar"></i> Ngày tạo</th>
                                 <th><i class="icon_cogs"></i> Action</th>
                              </tr>
                              <c:forEach items="${listJob }" var="objJob">
                              <tr>
								 <td>${objJob.id_job }</td>
								  <td>${objJob.name }</td>
                                 <td>${objJob.content }</td>
                                  <td>${objJob.time }</td>
                                  <td><img alt="${objJob.content }" class="img-rounded" style="width: 127px; height: 89px;" src="${pageContext.request.contextPath }/files/${objJob.picture }" /></td>
                                 <td>${objJob.date_create }</td>
                                 <td>
                                  <div class="btn-group">
                                  <ul class="nav nav-tabs">
                                  	<li><a class="btn btn-primary" href="${pageContext.request.contextPath }/admin/job/edit/${objJob.id_job }"><i class="icon_pencil-edit_alt"></i></a></li>
                                	<li><a class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không')" href="${pageContext.request.contextPath }/admin/job/del/${objJob.id_job}"><i class="icon_close_alt2"></i></a></li>
                                  </ul>
                                  </div>
                                  </td>
                              </tr>
                              </c:forEach>
                           </tbody>
                        </table>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      <div class="pagination" style="margin-left: 23px;   margin-top: -31px;">           
			<div align="center" class="numbers">
			 <c:set value="${pageContext.request.contextPath }/admin/job/index/${page-1 }"  var="urlPre"></c:set>
                <c:set value="${pageContext.request.contextPath }/admin/job/index/${page+1 }" var="urlNext"></c:set>
                   <c:if test="${(page-1) > 0 }">
                    <a href="${urlPre }"><<</a>
                    </c:if>
                    <c:choose>
                    	<c:when test="${sumPage < 4 }">
                    		<c:forEach begin="1"  end="${sumPage }" var="i">
                      	 		<a <c:if test="${i == page }">class=active</c:if> href="${pageContext.request.contextPath }/admin/job/index/${i }">${i } <span class="sr-only"></span></a>
                      		</c:forEach>
                    	</c:when>
                    	<c:when test="${page<(sumPage-3) && sumPage>3 }">
                    		<c:forEach begin="${page }"  end="${page+3 }" var="i">
                      			 <a <c:if test="${i == page }">class=active</c:if> href="${pageContext.request.contextPath }/admin/job/index/${i }">${i } <span class="sr-only"></span></a>
                     		 </c:forEach>
                    	</c:when>
                    	<c:when test="${page>=(sumPage-3) && sumPage>3 }">
                    		<c:forEach begin="${sumPage-3 }"  end="${sumPage }" var="i">
                      			 <a <c:if test="${i == page }">class=active</c:if> href="${pageContext.request.contextPath }/admin/job/index/${i }">${i } <span class="sr-only"></span></a>
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
     
