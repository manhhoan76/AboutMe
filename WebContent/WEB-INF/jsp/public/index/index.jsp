<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/templates/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="ninodezign.com, ninodezign@gmail.com">
	<meta name="copyright" content="ninodezign.com"> 
	<title>CV Mạnh Hoan</title>
	
	<!-- favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/templates/public/index/images/ico/favicon.jpg">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath }/templates/public/index/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath }/templates/public/index/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath }/templates/public/index/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath }/templates/public/index/images/ico/apple-touch-icon-57-precomposed.png">
	
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/templates/public/index/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/templates/public/index/css/materialdesignicons.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/templates/public/index/css/jquery.mCustomScrollbar.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/templates/public/index/css/prettyPhoto.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/templates/public/index/css/unslider.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/templates/public/index/css/template.css" />
	    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/templates/public/index/css/agency.min.css" rel="stylesheet">
	 <link href="${pageContext.request.contextPath }/templates/public/index/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
</head>

<body data-target="#nino-navbar" data-spy="scroll">

	<!-- Header
    ================================================== -->
	<header id="nino-header">
		<div id="nino-headerInner">					
			<nav id="nino-navbar" class="navbar navbar-default" role="navigation">
				<div class="container">

					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nino-navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="${pageContext.request.contextPath }/">MyCV</a>
						<a style="padding-left: 854px;padding-top: 14px;" href="${pageContext.request.contextPath }/lien-he">Contact </a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="nino-menuItem pull-right">
						<div class="collapse navbar-collapse pull-left" id="nino-navbar-collapse">
							<ul class="nav navbar-nav">
								
							</ul>
						</div><!-- /.navbar-collapse -->
						<ul class="nino-iconsGroup nav navbar-nav">
							<li><a href="#" class="nino-search"><i class="mdi mdi-magnify nino-icon"></i></a></li>
						</ul>
					</div>
				</div><!-- /.container-fluid -->
			</nav>

			<section id="nino-slider" class="carousel slide container" data-ride="carousel">
				
				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<h2 class="nino-sectionHeading">
							<span class="nino-subHeading">MyCV</span>
							Welcome <br>to My CV
						</h2>
					</div>
				</div>

				<!-- Indicators -->
				<ol class="carousel-indicators clearfix">
				</ol>
			</section>
		</div>
	</header><!--/#header-->
	 <!-- Our Team
    ================================================== -->
	<section id="nino-ourTeam">
		<div class="container">
			<h2 class="nino-sectionHeading">
				<span class="nino-subHeading">Who I am</span>
				NGUYEN MANH HOAN
			</h2>
			<p class="nino-sectionDesc">
				Welcome to My CV -- 
				Hello World
			</p>
			<div class="sectionContent">
				<div class="row nino-hoverEffect">
					<div class="col-md-4 col-sm-4">
						
					</div>
					<div class="col-md-4 col-sm-4">
						<div class="item">
							<div class="overlay" href="#">
								<div class="content">
									<a href="${linkFB }" class="nino-icon"><i class="mdi mdi-facebook"></i></a>
									<a href="${linkYT }" class="nino-icon"><i class="mdi mdi-youtube-play"></i></a>
									<a href="${linkIN }" class="nino-icon"><i class="mdi mdi-instagram"></i></a>
								</div>
								<img src="${pageContext.request.contextPath }/templates/public/index/images/our-team/anhdaidien.jpg" alt="">
							</div>
						</div>
						<div class="info">
							<h4 class="name">Nguyễn Mạnh Hoan</h4>
							<span class="regency">Developer Java/ Spring Framework</span>
						</div>
					</div>
				
				</div>
			</div>
		</div>
	</section><!--/#nino-ourTeam-->

<!-- ABOUT -->
	<section  id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">My Story</h2>
            <h3 class="section-subheading text-muted">Chặng đường mà tôi đã đi qua</h3>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-12">
            <ul style="z-index: 1; " class="timeline  text-muted">
            <c:forEach items="${listJob }"  var="objJob">
            	<li class="timeline-inverted">
               <div class="timeline-image">
                  <img style="height: 100%;" class="rounded-circle img-circle img-fluid" src="${pageContext.request.contextPath }/files/${objJob.picture }" alt="">
                </div>
                <div class="timeline-panel">
                  <div class="timeline-heading">
                    <h4>${objJob.time }</h4>
                    <h4 class="subheading">${objJob.name }</h4>
                  </div>
                  <div class="timeline-body">
                    <p class="text-muted">${objJob.content }</p>
                  </div>
                </div>
              </li>
              
            </c:forEach>
              <li class="timeline-inverted">
                <div class="timeline-image">
                  <h4>Be Part
                    <br>Of Our
                    <br>Story!</h4>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </section>

    <!-- Testimonial
    ================================================== -->
	<h2 class="nino-sectionHeading">
				<span class="nino-subHeading">Skills</span>
				My Skills
			</h2>
    <section class="nino-testimonial">
	
    	<div class="container">
		
    		<div class="nino-testimonialSlider">
				<ul>
				<c:forEach items="${listSkill }" var="objSkill">
					<li>
						<div layout="row">
							<div class="nino-symbol fsr">
								<i class="mdi mdi-comment-multiple-outline nino-icon"></i>
							</div>
							<div style="width: 100%">
								<p class="quote">"${objSkill.name }"</p>
								<div class="progress">
								  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="2" aria-valuemin="0" aria-valuemax="100" style="width: ${objSkill.percent}%;">
									${objSkill.percent }%
								  </div>
								</div>
							</div>
						</div>
					</li>
				</c:forEach>
				</ul>
			</div>
    	</div>
    </section><!--/#nino-testimonial-->

   
	

	<!-- Portfolio
    ================================================== -->
	<section id="nino-portfolio">
		<div class="container">
			<h2 class="nino-sectionHeading">
				<span class="nino-subHeading">What I do</span>
				some of my project
			</h2>
			<p class="nino-sectionDesc">
			Một số dự án mà tôi đã tham gia
			</p>
		</div>
		<div class="sectionContent">
			<ul class="nino-portfolioItems">
			<c:forEach items="${listProject }" var="objProject">
				<li class="item col">
					<a href="${pageContext.request.contextPath }/${slug.makeSlug(objProject.name)}/${objProject.id_project }.php">
						<img src="${pageContext.request.contextPath }/files/${objProject.picture}" />
						<div class="overlay">
							<div class="content">
								<i class="mdi mdi-crown nino-icon"></i>
								<h4 class="title">${objProject.name }</h4>
								<span class="desc">${objProject.preview_text }</span>
							</div>
						</div>
					</a>
				</li>
				</c:forEach>
			</ul>
		</div>
	</section><!--/#nino-portfolio-->

	<!-- Testimonial
    ================================================== -->
	
    <section class="nino-testimonial bg-white">
	<h2 class="nino-sectionHeading">
				<span class="nino-subHeading">Châm ngôn</span>
				Những câu châm ngôn, thành ngữ hay
			</h2>
    	<div class="container">
    		<div class="nino-testimonialSlider">
				<ul>
				<c:forEach items="${listMaxim }" var="objMaxim">
					<li>
						<div layout="row" class="verticalCenter">
							<div class="nino-avatar fsr">
								<img class="img-circle img-thumbnail" src="${pageContext.request.contextPath }/files/${objMaxim.picture }" alt="">
							</div>
							<div>
								<p class="quote">"${objMaxim.content }"</p>
								<span class="name">${objMaxim.author }</span>
							</div>
						</div>
					</li>
				</c:forEach>
				</ul>
			</div>
    	</div>
    </section><!--/#nino-testimonial-->

  
    <!-- Latest Blog
    ================================================== -->
    <section id="nino-latestBlog">
    	<div class="container">
    		<h2 class="nino-sectionHeading">
				<span class="nino-subHeading">News</span>
				Bài Viết
			</h2>
			<div class="sectionContent">
				<div class="row">
				<c:forEach items="${listNewNew }" var="objNewNew">
					<div class="col-md-4 col-sm-4">
						<article>
							<div class="articleThumb">
								<a href="#"><img src="${pageContext.request.contextPath }/files/${objNewNew.picture }" alt=""></a>
								<div class="date">
									<span class="number">15</span>
									<span class="text">Jan</span>
								</div>
							</div>
							<h3 class="articleTitle"><a href="${pageContext.request.contextPath }/${slug.makeSlug(objNewNew.name)}/${objNewNew.id_news }.html">${objNewNew.name }</a></h3>
							<p class="articleDesc">
								${objNewNew.preview_text }
							</p>
							<div class="articleMeta">
								<a href="#"><i class="mdi mdi-eye nino-icon"></i>${objNewNew.count_number }</a>
							</div>
						</article>
					</div>
				</c:forEach>
					
				</div>
			</div>
    	</div>
    </section><!--/#nino-latestBlog-->
	
	
	
	<!-- Brand  Quang cao
    ================================================== -->
    <section id="nino-brand">
    	<div class="container">
    		<div class="verticalCenter fw" layout="row">
    		<c:forEach items="${listAds }" var="objAds">
    			<div class="col-md-2 col-sm-4 col-xs-6"><a href="${objAds.link }"><img src="${pageContext.request.contextPath }/files/${objAds.picture}" alt="${objAds.name }"></a></div>
    		</c:forEach>
    		</div>
    	</div>
    </section><!--/#nino-brand-->
    <!-- Map
    ================================================== -->
    <section id="nino-map">
    	<div class="container">
    		<h2 class="nino-sectionHeading">
    			<i class="mdi mdi-map-marker nino-icon"></i>
    			<span class="text">Open map</span>
    			<span class="text" style="display: none;">Close map</span>
    		</h2>
    		<div class="mapWrap">
	    		<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d3833.9871001081624!2d108.14701611460076!3d16.066159188882832!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1svi!2sus!4v1510296031302" width="800" height="600" frameborder="0" style="border:0" allowfullscreen></iframe>
	    	</div>
    	</div>
    </section><!--/#nino-map-->
	
    <!-- Footer
    ================================================== -->
    <footer id="footer">
        <div class="container">
        	<div class="row">
        		<div class="col-md-4">
        			<div class="colInfo">
	        			<div class="footerLogo">
	        				<a href="${pageContext.request.contextPath }/" >MyCV</a>	
	        			</div>
	        			<p>
	        			Cảm ơn bạn đã ghé thăm trang CV của mình <br />
	        			Nếu bạn có thông tin quan tâm thì xin liên hệ qua <br />
	        			Mạnh Hoan: 0981.615.773 <br />
	        			Chào các bạn!!
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
	        					<a href="${linkFB }" class="nino-icon"><i class="mdi mdi-facebook"></i></a>
	        					<a href="${linkFB }" class="nino-icon"><i class="mdi mdi-instagram"></i></a>
	        					<a href="${linkFB }" class="nino-icon"><i class="mdi mdi-google-plus"></i></a>
	        					<a href="${linkFB }" class="nino-icon"><i class="mdi mdi-youtube-play"></i></a>
	        				</div>
	        			</div>
        			</div>
        		</div>
        	</div>
			<div class="nino-copyright">Copyright &copy; 2017 <a target="_blank" href="http://www.ninodezign.com/" title="Ninodezign.com - Top quality open source resources for web developer and web designer">MyCV/a>. All Rights Reserved. <br/> Project in <a href="https://www.behance.net/laaqiq"> VinaEnter Center</a></div>
        </div>
    </footer><!--/#footer-->

    <!-- Search Form - Display when click magnify icon in menu
    ================================================== -->
    <form action="" id="nino-searchForm">
    	<input type="text" placeholder="Search..." class="form-control nino-searchInput">
    	<i class="mdi mdi-close nino-close"></i>
    </form><!--/#nino-searchForm-->
	
    <!-- Scroll to top
    ================================================== -->
	<a href="#" id="nino-scrollToTop">Go to Top</a>
	
	<!-- javascript -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/templates/public/index/js/jquery.min.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath }/templates/public/index/js/isotope.pkgd.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/templates/public/index/js/jquery.prettyPhoto.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/templates/public/index/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/templates/public/index/js/jquery.hoverdir.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/templates/public/index/js/modernizr.custom.97074.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/templates/public/index/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/templates/public/index/js/unslider-min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/templates/public/index/js/template.js"></script>
	 <script src="${pageContext.request.contextPath }/templates/public/index/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
     <script src="${pageContext.request.contextPath }/templates/public/index/js/agency.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="${pageContext.request.contextPath }/templates/public/index/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact form JavaScript -->
    <script src="${pageContext.request.contextPath }/templates/public/index/js/jqBootstrapValidation.js"></script>
    <script src="${pageContext.request.contextPath }/templates/public/index/js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
   


	<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<!-- css3-mediaqueries.js for IE less than 9 -->
	<!--[if lt IE 9]>
	    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
	<![endif]-->
		
</body>
</html>