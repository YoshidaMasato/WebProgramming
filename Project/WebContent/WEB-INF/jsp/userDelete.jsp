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


    <title>ユーザ削除</title>
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


			<p><b><font size="6">ユーザ削除確認</font></b></p>

			<table class="table-css" style="WIDTH: 50%">
				<tr>
					<td class="td-css13"><b>ログインID : <c:out value="${user.login_id}"/></b></td>
				</tr>
				<tr>
					<td class="td-css13"><b>を本当に削除してよろしいでしょうか。</b></td>
				</tr>
			</table>
			<br>
			<form action="UserDelete" method=post>
				<a href="javascript:history.back();"><button type="button" class="btn btn-primary" style="WIDTH: 120px">キャンセル</button></a>
				<input type="submit" name="delete" value="OK" class="btn btn-danger" style="WIDTH: 120px">
				<input type="hidden" name="id" value="${user.id}">
			</form>


		</div>
		<a href="javascript:history.back();">戻る</a>
	</div>
  </body>
</html>