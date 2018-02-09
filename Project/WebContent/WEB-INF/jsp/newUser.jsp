<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./css/bootstrap.min.css" >
    <link rel="stylesheet" href="./css/original/common.css" >


    <title>新規登録</title>
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


			<p><b><font size="6">ユーザ新規登録</font></b></p>

			<form action="NewUser" method="post">
				<table class="table-css" style="WIDTH: 50%">

					<tr>
						<td class="td-css13"><b>ログインID</b><span class="hissu">必須&emsp;</span></td>
						<td class="td-css13"><p><input type="text" name="newUsLoginId" value="${form.login_id}" style="WIDTH: 150px"/></p></td>
					</tr>
					<tr>
						<td class="td-css13"><b>パスワード</b><span class="hissu">必須&emsp;</span></td>
						<td class="td-css13">
							<p id="pass1-error" class="alert-error"></p>
	            			<p id="pass1-error2" class="alert-error"></p>
							<p><input type="password" name="newUsPassword" class="span2" maxlength="12" style="WIDTH: 150px"></p>
						</td>
					</tr>
					<tr>
						<td class="td-css13"><b>パスワード(確認)</b><span class="hissu">必須&emsp;</span></td>
						<td class="td-css13">
							<p id="pass2-error" class="alert-error"></p>
							<p><input type="password" name="newUsPasswordCheck" class="span2" maxlength="12" style="WIDTH: 150px"></p>
						</td>
					</tr>
					<tr>
						<td class="td-css13"><b>ユーザ名</b><span class="hissu">必須&emsp;</span></td>
						<td class="td-css13"><p><input type="text" name="newUsName" value="${form.name}" style="WIDTH: 150px"/></p></td>
					</tr>
					<tr>
						<td class="td-css13"><b>生年月日</b><span class="hissu">必須&emsp;</span></td>
						<td class="td-css13"><input type="date" name="newUsBirthDate" value="${form.birth_date}" style="WIDTH: 150px">
					</tr>
				</table>
			<font color=red>${errMsg}</font>
			<br>
			<p><input type="submit" value="登録" class="btn btn-primary btn-sm" style="WIDTH: 70px"></p>
			</form>


		</div>
		<a href="javascript:history.back();">戻る</a>
	</div>
  </body>
</html>