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


    <title>ユーザ情報詳細参照</title>
  </head>

  <body>

	<!-- ナビバー -->
  	<nav class="navbar navbar-dark bg-primary">
  		<p class="right"><font size="5" color="white"><c:out value="${userInfo.name}"/> さん</font></p>
  		<a href="Logout">
	  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	  			ログアウト
	  		</button>
	  	</a>
	</nav>
	<!-- ナビバーここまで -->

	<div class="container"><!-- 幅固定 -->
		<div align="center"><!-- センター寄せ -->


			<p><b><font size="6">ユーザ情報詳細参照</font></b></p>

			<table class="table-css" style="WIDTH: 50%">
				<tr>
					<td class="td-css13"><b>ログインID</b></td>
					<td class="td-css13"><p><c:out value="${user.login_id}"/></p></td>
				</tr>
				<tr>
					<td class="td-css13"><b>ユーザ名</b></td>
					<td class="td-css13"><p><c:out value="${user.name}"/></p></td>
				</tr>
				<tr>
					<td class="td-css13"><b>生年月日</b></td>
					<td class="td-css13"><p><c:out value="${user.birth_date}"/></p></td>
				</tr>
				<tr>
					<td class="td-css13"><b>登録日時</b></td>
					<td class="td-css13"><p><c:out value="${user.create_date}"/></p></td>
				</tr>
				<tr>
					<td class="td-css13"><b>更新日時</b></td>
					<td class="td-css13"><p><c:out value="${user.update_date}"/></p></td>
				</tr>
			</table>
			<br>
			<a href="javascript:history.back();">戻る</a>

		</div>
	</div>
  </body>
</html>