<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BASE64</title>
<script src="/webjars/angularjs/1.7.8/angular.min.js"></script>
<script>
	var app = angular.module('app', []);
	app.controller('controller', function($scope, $http) {
		$scope.btn = function(){
			var fd = new FormData();
			fd.append("id", "A");
			fd.append("url", "111");
			
			$http({
	            method: 'POST',
	            url: "/test",
	            data: fd,
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	         }).then(function(data) {
				console.log(data);
	         });
		}
	});
</script>
</head>
<body data-ng-app="app" data-ng-controller="controller">
	<button type="button" style="width: 100%;" data-ng-click="btn()">전송</button>
</body>
</html>