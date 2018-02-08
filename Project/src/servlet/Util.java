package servlet;

import javax.servlet.http.HttpSession;

public class Util {

	public void isLogin() {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") == null) {
			response.sendRedirect("Login");
			return;
	}
	
}
