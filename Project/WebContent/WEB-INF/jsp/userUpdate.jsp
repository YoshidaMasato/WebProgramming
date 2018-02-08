<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!doctype html>
<html lang="ja">
	<head>
	    <!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="./css/bootstrap.min.css" >
	    <link rel="stylesheet" href="./css/original/common.css" >
		<title>ユーザ情報更新</title>
	</head>

	<body>
		<!-- ナビバー -->
	  	<nav class="navbar navbar-dark bg-primary">
	  		<p class="right"><font size="5" color="white">${userInfo.name} さん</font></p>
	  		<a href="Logout">
		  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		  			ログアウト
		  		</button>
		  	</a>
		</nav>
		<!-- ナビバーここまで -->

		<div class="container"><!-- 幅固定 -->
			<div align="center"><!-- センター寄せ -->


				<p><b><font size="6">ユーザ情報更新</font></b></p>

				<form action="UserUpdate" method="post">
					<table class="table-css" style="WIDTH: 50%">
						<tr>
							<td class="td-css13"><b>ログインID</b></td>
							<td class="td-css13"><p>${user.login_id}</p></td>
						</tr>
						<tr>
							<td class="td-css13"><b>パスワード</b></td>
							<td class="td-css13"><p><input type="password" name="updatePassword" style="WIDTH: 150px"/></p></td>
						</tr>
						<tr>
							<td class="td-css13"><b>パスワード(確認)</b></td>
							<td class="td-css13"><p><input type="password" name="updatePasswordCheck" style="WIDTH: 150px"/></p></td>
						</tr>
						<tr>
							<td class="td-css13"><b>ユーザ名</b></td>
							<td class="td-css13"><p><input type="text" name="updateName" style="WIDTH: 150px" value="${user.name}"/></p></td>
						</tr>
						<tr>
							<td class="td-css13"><b>生年月日</b></td>
							<td class="td-css13"><input type="date" name="updateBirthDate" value="${user.birth_date}" style="WIDTH: 150px">
						</tr>
					</table>
					<input type="hidden" name="updateId" value="${user.id}">
					<input type="hidden" name="loginId" value="${user.login_id}">
					<p><font color=red>${errMsg}</font><p/>
					<br>
					<p><input type="submit" value="更新" class="btn btn-primary btn-sm" style="WIDTH: 70px"></p>
				</form>


			</div>
			<a href="javascript:history.back();">戻る</a>
		</div>
	</body>
</html>