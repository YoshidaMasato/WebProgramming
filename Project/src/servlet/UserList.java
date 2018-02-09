package servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UserList
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList() {
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

		//全ユーザ情報を取得してリクエストスコープにセット
		UserDao userDao = new UserDao();
		List<User> users = userDao.findAll();
		request.setAttribute("users", users);

		//ユーザ一覧にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォームの値を変数に代入
		request.setCharacterEncoding("UTF-8");
		String login_id = request.getParameter("loginId");
		String name = request.getParameter("userName");
		String birth_date1 = request.getParameter("birthDate1");
		String birth_date2 = request.getParameter("birthDate2");

		//フォームの値を出力
		System.out.println(login_id);
		System.out.println(name);
		System.out.println(birth_date1);
		System.out.println(birth_date2);

		//入力された値からユーザを検索
		UserDao userDao = new UserDao();
		List<User> users = userDao.retrieveUsers(login_id, name, birth_date1, birth_date2);
		request.setAttribute("users", users);

		//ユーザ一覧にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);
	}

}
