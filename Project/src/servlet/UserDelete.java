package servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelete() {
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

		//リクエストスコープからid情報を変数に代入
		String id = request.getParameter("id");

		//id情報を元にユーザを検索してユーザ情報を取り出し、リクエストスコープにセット
		UserDao userDao = new UserDao();
		User user = userDao.findById(id);
		request.setAttribute("user", user);

		//ユーザ削除画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォームから受け取った値を変数に代入
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");

		//DAOに値を渡してユーザ削除処理
		UserDao userDao = new UserDao();
		userDao.userDelete(Integer.parseInt(id));

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userInfo");

		//管理者はユーザリストへ、一般ユーザはログアウト処理
		if(user.getLogin_id().equals("admin")) {
			response.sendRedirect("UserList");
		}else {

			//ログアウト処理
			response.setContentType("text/html; charset=Shift_JIS");
	        PrintWriter out = response.getWriter();

	        session = request.getSession(true);
	        session.invalidate();

	        response.sendRedirect("Login");
		}

	}

}
