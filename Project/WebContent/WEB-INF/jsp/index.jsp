<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./css/bootstrap.min.css" >

    <title>login</title>
  </head>

  <body>


  	<div align="center">
		<form action="Login" method="post">
		  	<p><b><font size="6">ログイン画面</font></b></p>
		  	<p><font color=red>${errMsg}</font><p/>
			<p>ログインID&emsp;&emsp;<input type="text" name="loginId" /></p>
			<p>パスワード&emsp;&emsp;<input type="text" name="password"/></p>
			<input type="submit" value="ログイン" class="btn btn-primary btn-sm">
		</form>
	</div>
  </body>
</html>