<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>angularJS 入门demo-8  内置服务$http</title>
<script src="angular.min.js"></script>

        <script>

            var app=angular.module("myApp",[]);
         
            app.controller("myController",function($scope,$http){
            	$scope.findList=function(){
            		
            		//请求地址
            		$http.get("data.json").success(
            			function(response){
            				//response就是获取的的值，即返回结果
            				$scope.list = response
            			}		
            		);
            	}
            });
        </script>
</head>
    <body ng-init="findList()" ng-app="myApp" ng-controller="myController">
        <!--循环list-->
        <table>
            <tr>
                <td>姓名</td>
                <td>数学</td>
                <td>语文</td>
            </tr>

            <tr ng-repeat="x in list">
                    <td>{{x.name}}</td>
                    <td>{{x.shuxue}}</td>
                    <td>{{x.yuwen}}</td>
                </tr>
        </table>
    </body>
</html>