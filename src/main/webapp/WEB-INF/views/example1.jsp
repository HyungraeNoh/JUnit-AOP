<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Bootstrap Example</title>
  <link rel="shortcut icon" type="image/x-icon" href="http://gudi.kr/gdj16/images/icon_goodee.png">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/webjars/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/css/example1.css">
  <script src="/webjars/jquery/3.4.1/dist/jquery.min.js"></script>
  <script src="/webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="/webjars/angularjs/1.7.8/angular.min.js"></script>
  <script src="/resources/js/app.js"></script>
</head>
<body data-ng-app="app" data-ng-controller="controller">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">GUDI</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Messages</a></li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group input-group">
          <input type="text" class="form-control" placeholder="Search..">
          <span class="input-group-btn">
            <button class="btn btn-default" type="button">
              <span class="glyphicon glyphicon-search"></span>
            </button>
          </span>        
        </div>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> My Account</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container text-center">    
  <div class="row">
  
    <div class="col-sm-3 well">
      <div class="well">
        <p><a href="#">My Profile</a></p>
        <img data-ng-src="{{user.img}}" class="img-circle" height="65" width="65" alt="Avatar">
      </div>
      <div class="well">
        <p><a href="#">Interests</a></p>
        <p>
          <span class="label label-default" data-ng-if="user.label1 == 'Y'">News</span>
          <span class="label label-primary" data-ng-if="user.label2 == 'Y'">W3Schools</span>
          <span class="label label-success" data-ng-if="user.label3 == 'Y'">Labels</span>
          <span class="label label-info" data-ng-if="user.label4 == 'Y'">Football</span>
          <span class="label label-warning" data-ng-if="user.label5 == 'Y'">Gaming</span>
          <span class="label label-danger" data-ng-if="user.label6 == 'Y'">Friends</span>
        </p>
      </div>
      <div class="alert alert-success fade in">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
        <p><strong>Ey!</strong></p>
        People are looking at your profile. Find out who.
      </div>
      <p><a href="#">Link1</a></p>
      <p><a href="#">Link2</a></p>
      <p><a href="#">Link3</a></p>
    </div>
    <div class="col-sm-7">
      <div class="row">
        <div class="col-sm-12">
          <div class="panel panel-default text-left">
            <div class="panel-body">
              <p contenteditable="true">Status: Feeling Blue</p>
              <button type="button" class="btn btn-default btn-sm">
                <span class="glyphicon glyphicon-thumbs-up"></span> Like
              </button>     
            </div>
          </div>
        </div>
      </div>
      <div class="row" data-ng-repeat="row in list">
        <div class="col-sm-3">
          <div class="well">
           <p>{{row.name}}</p>
           <img data-ng-src="{{row.img}}" class="img-circle" height="55" width="55" alt="Avatar">
          </div>
        </div>
        <div class="col-sm-9">
          <div class="well">
            <p>{{row.comment}}</p>
          </div>
        </div>
      </div>
    </div>    
    <div class="col-sm-2 well">
	  <div data-ng-repeat="row in banner" data-ng-click="bannerEvent(row)">
	  	<div class="well" data-ng-show="row.on == 'N'">
	  		<p>{{row.name}}</p>
	  	</div>
	  	<div class="thumbnail" data-ng-show="row.on == 'Y'">
	  		<p>{{row.event}}</p>
	        <img data-ng-src="{{row.img}}" alt="Paris" width="400" height="300">
	        <p><strong>{{row.city}}</strong></p>
	        <p>{{row.day}}</p>
	        <button class="btn btn-primary">Info</button>
	  	</div>
	  </div>      
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
