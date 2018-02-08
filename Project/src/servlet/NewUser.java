package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDao;

/**
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") == null) {
			response.sendRedirect("Login");
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("newUsLoginId");
		String password = request.getParameter("newUsPassword");
		String passwordCheck = request.getParameter("newUsPasswordCheck");
		String name = request.getParameter("newUsName");
		String birthDate = request.getParameter("newUsBirthDate");

		System.out.println(loginId);
		System.out.println(password);
		System.out.println(passwordCheck);
		System.out.println(name);
		System.out.println(birthDate);

		UserDao userDao = new UserDao();
		boolean create = userDao.createUser(loginId,password,passwordCheck,name,birthDate);

		if(!create) {
			request.setAttribute("errMsg", "登録に失敗しました。");
			User form = new User(loginId, name, birthDate);
			request.setAttribute("form", form);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newUser.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("UserList");

		}
	}

}
