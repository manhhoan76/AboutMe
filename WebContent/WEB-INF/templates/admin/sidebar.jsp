<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/templates/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu">                
                  <li class="active">
                      <a class="" href="${pageContext.request.contextPath }/admin/new/index">
                          <i class="icon_house_alt"></i>
                          <span>Tin tức</span>
                      </a>
                  </li>
				  <li class="sub-menu">
                      <a href="${pageContext.request.contextPath }/admin/user/index" class="">
                          <i class="icon_document_alt"></i>
                          <span>Quản trị viên</span>
                      </a>
                  </li>  
                  <li class="sub-menu">
                      <a href="${pageContext.request.contextPath }/admin/contact/index" class="">
                          <i class="icon_desktop"></i>
                          <span>Liên hệ</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_desktop"></i>
                          <span>Bài viết</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="${pageContext.request.contextPath }/admin/cat/index">Danh mục</a></li>
                            <li><a class="" href="${pageContext.request.contextPath }/admin/comment/index">Comment</a></li>
                      </ul>
                  </li>  
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_desktop"></i>
                          <span>Hiển thị</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="${pageContext.request.contextPath }/admin/maxim/index">Châm ngôn</a></li>
                          <li><a class="" href="${pageContext.request.contextPath }/admin/ads/index">Quảng cáo</a></li>
                      </ul>
                  </li>     
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_desktop"></i>
                          <span>Thông  tin</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="${pageContext.request.contextPath }/admin/job/index">Công việc</a></li>
                          <li><a class="" href="${pageContext.request.contextPath }/admin/project/index">Dự án</a></li>
                          <li><a class="" href="${pageContext.request.contextPath }/admin/network/index">Mạng xã hội</a></li>
                          <li><a class="" href="${pageContext.request.contextPath }/admin/skill/index">Kỹ năng</a></li>
                      </ul>
                  </li>   
                  
             </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->