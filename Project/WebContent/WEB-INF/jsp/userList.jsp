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


    <title>ユーザ一覧</title>
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


			<p><b><font size="6">ユーザ一覧</font></b></p>
			<a href="NewUser?id=${userInfo.id}"><div align="right">新規登録</div></a>

			<form action="UserList" method="post">
				<table class="table-css" width="50%">
					<tr>
						<td class="td-css13"><b>ログインID</b></td>
						<td class="td-css13"><p><input type="text" name="loginId" /></p></td>
					</tr>
					<tr>
						<td class="td-css13"><b>ユーザ名</b></td>
						<td class="td-css13"><p><input type="text" name="userName" /></p></td>
					</tr>
					<tr>
						<td class="td-css13"><b>生年月日</b></td>
						<td class="td-css13"><input type="date" name="birthDate1" value="">&emsp;～&emsp;<input type="date" name="birthDate2" value="">
					</tr>
				</table>
				<br>
				<p><input type="submit" value="検索" class="btn btn-light"></p>
			</form>

			<!-- 水平線 -->
			<hr width="95%">

			<!-- 表 -->
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">ログインID</th>
						<th scope="col">ユーザ名</th>
						<th scope="col">生年月日</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="user" items="${users}">
						<tr>
							<th scope="row"><c:out value="${user.id}"/></th>
							<td colspan="1"><c:out value="${user.login_id}"/></td>
							<td><c:out value="${user.name}"/></td>
							<td><c:out value="${user.birth_date}"/></td>
							<td>
								<%-- すべてのユーザに詳細ボタンを表示 --%>
								<a href="UserDetail?id=${user.id}"><button type="button" class="btn btn-primary">詳細</button></a>

								<%-- 条件付きで更新ボタン表示 --%>
								<c:choose>

									<%-- ログインユーザ自身の更新ボタン表示 --%>
									<c:when test="${userInfo.id == user.id}">
										<a href="UserUpdate?id=${user.id}"><button type="button" class="btn btn-success">更新</button></a>
									</c:when>

									<%-- 管理者に表示 --%>
									<c:when test="${userInfo.login_id == 'admin'}">
										<a href="UserUpdate?id=${user.id}"><button type="button" class="btn btn-success">更新</button></a>
									</c:when>
								</c:choose>

								<%-- 管理者のみに削除ボタンを表示 --%>
								<c:if test="${userInfo.login_id == 'admin'}">
									<a href="UserDelete?id=${user.id}"><button type="button" class="btn btn-danger">削除</button></a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 表ここまで -->


		</div>
	</div>
  </body>
</html>