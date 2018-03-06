<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file="/templates/taglib.jsp" %>
<footer id="footer">
        <div class="container">
        	<div class="row">
        		<div class="col-md-4">
        			<div class="colInfo">
	        			<div class="footerLogo">
	        				<a href="${pageContext.request.contextPath }/" >MoGo</a>	
	        			</div>
	        			<p>
	        			Chào mừng bạn đến với trang CV của Nguyễn Mạnh Hoan <br />
	        			Mong rặng bạn sẽ tìm được những điều thú vị về tôi, cũng như sẽ tìm hiểu được những kiến thức hay mà tôi chia sẽ
	        			Cảm ơn các bạn! <br />
	        			</p>
        			</div>
        		</div>
        		<div class="col-md-4 col-sm-6">
        			<div class="colInfo">
	        			<div class="footerLogo">
	        				<a href="#" >Category</a>	
	        			</div>
	        			<ul class="listArticles">
	        				<c:forEach items="${listCat }" var="objCat">
	        					<li layout="row" class="verticalCenter">
	        					<div class="info">
	        						<h3 class="articleTitle"><a href="${pageContext.request.contextPath }/${slug.makeSlug(objCat.name)}/${objCat.id_cat}">${objCat.name }</a></h3>
	        					</div>
	        				</li>
	        				</c:forEach>
	        			</ul>
        			</div>
        		</div>
        		<div class="col-md-4">
        			<div class="colInfo">
	        			<div class="footerLogo">
	        				<a href="#" >Follow</a>	
	        			</div>
	        			
	        			<div class="nino-followUs">
	        				<div class="socialNetwork">
	        					<span class="text">Follow Me: </span>
	        					<a href="" class="nino-icon"><i class="mdi mdi-facebook"></i></a>
	        					<a href="" class="nino-icon"><i class="mdi mdi-twitter"></i></a>
	        					<a href="" class="nino-icon"><i class="mdi mdi-instagram"></i></a>
	        					<a href="" class="nino-icon"><i class="mdi mdi-pinterest"></i></a>
	        					<a href="" class="nino-icon"><i class="mdi mdi-google-plus"></i></a>
	        					<a href="" class="nino-icon"><i class="mdi mdi-youtube-play"></i></a>
	        					<a href="" class="nino-icon"><i class="mdi mdi-dribbble"></i></a>
	        					<a href="" class="nino-icon"><i class="mdi mdi-tumblr"></i></a>
	        				</div>
	        			</div>
        			</div>
        		</div>
        	</div>
			<div class="nino-copyright">Copyright &copy; 2017 <a target="_blank" href="https://www.facebook.com/hoan.gunner" title="Facebook">Gunner.com</a><br/> Project Spring in  <a href="http://vinaenter.edu.vn/">VinaEnter Center</a></div>
        </div>
    </footer><!--/#footer-->
<a href="#" id="nino-scrollToTop">Go to Top</a>

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath }/templates/public/other/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="${pageContext.request.contextPath }/templates/public/other/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath }/templates/public/other/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="${pageContext.request.contextPath }/templates/public/other/js/jquery.waypoints.min.js"></script>
	<!-- Magnific Popup -->
	<script src="${pageContext.request.contextPath }/templates/public/other/js/jquery.magnific-popup.min.js"></script>
	<!-- Salvattore -->
	<script src="${pageContext.request.contextPath }/templates/public/other/js/salvattore.min.js"></script>
	<!-- Main JS -->
	<script src="${pageContext.request.contextPath }/templates/public/other/js/main.js"></script>

	

	
	</body>
</html>
