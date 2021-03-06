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
 * Servlet implementation class UserDetail
 */
@WebServlet("/UserDetail")
public class UserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetail() {
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

		//ユーザ詳細画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDetail.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
