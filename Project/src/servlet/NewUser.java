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

		//セッションが空の場合、ログイン画面に変遷
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") == null) {
			response.sendRedirect("Login");
			return;
		}

		//jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォームから値を受け取る
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("newUsLoginId");
		String name = request.getParameter("newUsName");
		String birthDate = request.getParameter("newUsBirthDate");
		String pass = request.getParameter("newUsPassword");
		String passCheck = request.getParameter("newUsPasswordCheck");

		//パスワードを暗号化
		String password = Util.convertToMD5(pass);
		String passwordCheck = Util.convertToMD5(passCheck);

		//受け取った値を出力
		System.out.println(loginId);
		System.out.println(password);
		System.out.println(passwordCheck);
		System.out.println(name);
		System.out.println(birthDate);

		//値をDAOに渡す
		UserDao userDao = new UserDao();
		boolean create = userDao.createUser(loginId,password,passwordCheck,name,birthDate);

		if(!create) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			//フォームに入力された値をUserインスタンスにセット
			User form = new User(loginId, name, birthDate);

			//Userインスタンスの値をリクエストスコープにセットし、元の画面にフォワード
			request.setAttribute("form", form);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newUser.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("UserList");

		}
	}

}
